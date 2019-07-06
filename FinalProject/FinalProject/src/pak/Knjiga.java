package pak;

import java.io.*;

import java.sql.*;

import java.util.*;

// u svakoj metodi u kojoj mi treba DB connection SAMO otvoram connection jer je u mainu zatvaram
public class Knjiga {

	private String putanjaDoKnjige; // ="knjiga";

	private Recnik recnik;

	private HashMap<String, Integer> noveReci;
	private HashMap<String, Integer> postojeceReci;
	private HashMap<String, Integer> sveReci;

	////////////////////////////////////////////////////////////////////////

	public Knjiga(String putanja, Recnik aRecnik) {
		this.putanjaDoKnjige = putanja;
		this.recnik = aRecnik;
		noveReci = new HashMap<String, Integer>();
		postojeceReci = new HashMap<String, Integer>();
	}

	public void procitajKnjiguINapraviHashMape() {

		try {
			BufferedReader bf = new BufferedReader(new FileReader(this.putanjaDoKnjige));

			while (bf.ready()) {
				String linija = bf.readLine();
				linija = linija.trim();
				linija = linija.toLowerCase();
				// idem kroz liniju i menjam(replace) sve karaktere koji nisu izmedju a i z sa
				// space da bi posle trimovao jos jendom
				for (int i = 0; i < linija.length(); i++) {
					if ((linija.charAt(i) < 'a' || linija.charAt(i) > 'z')) {
						linija = linija.replace(linija.charAt(i), ' ');
					}
				}
				linija = linija.trim();
				String[] red = linija.split(" ");

				// uporedjujem elemente niza sa kljucom Recnika i vidim da li ih ima i pravim
				// Hashmap reci (nepoznateReci i postojeceReci)

				for (int i = 0; i < red.length; i++) {
					red[i] = red[i].trim();

					if (!red[i].equals("")) {

						boolean imaJe = recnik.pretraziRecnik(red[i]);

						if (!imaJe) {
							if (!noveReci.containsKey(red[i])) {

								noveReci.put(red[i], 1);
							} else {

								int brojac = noveReci.get(red[i]) + 1;

								noveReci.put(red[i], brojac);
							}
						} else if (imaJe) {
							if (!postojeceReci.containsKey(red[i])) {

								postojeceReci.put(red[i], 1);
							} else {

								int brojac = postojeceReci.get(red[i]) + 1;

								postojeceReci.put(red[i], brojac);
							}
						}

					}
				}
			}
			bf.close();
		}

		catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		// od 2 Hashmape pravim jednu sveobuhvatnu

		this.sveReci = new HashMap<String, Integer>();

		for (String key : postojeceReci.keySet()) {
			sveReci.put(key, postojeceReci.get(key));
		}

		for (String key : noveReci.keySet()) {
			sveReci.put(key, noveReci.get(key));
		}

	}

	public void dodajNoveReciUDB2() throws SQLException {

		DBConnection.getConnection();
		recnik.napraviTabeluNovihReciUBazi();

		Statement stm = DBConnection.getConnection().createStatement();

		// prodji kroz HashMap i dodaj svaki key u bas tu tabelu u bazi

		StringBuilder upit = new StringBuilder("INSERT INTO reciKojeFale (recKojaFali,brojPonavljanja ) VALUES ");
		for (String key : noveReci.keySet()) {
			upit.append("(\"" + key + "\" ," + noveReci.get(key) + "),");

		}
		upit.deleteCharAt(upit.length() - 1);
		stm.executeUpdate(upit.toString());
		stm.close();
	}

	public void prebrojPostojeceReciUDB2() throws SQLException {
		// da bi videli koliko se svaka rec ponavlja u knjizi

		DBConnection.getConnection();
		recnik.napraviTabeluReciIzRecnikaUKnjizi();

		Statement stm = DBConnection.getConnection().createStatement();
		StringBuilder upit = new StringBuilder("INSERT INTO reciKnjigaRecnik (recUknjizi, brojPonavljanja) VALUES  ");
		for (String key : postojeceReci.keySet()) {
			upit.append("(\"" + key + "\" ," + postojeceReci.get(key) + "),");

		}
		upit.deleteCharAt(upit.length() - 1);
		stm.execute(upit.toString());
		stm.close();

	}

	public void sveReciUknjzi() throws SQLException {
		DBConnection.getConnection();
		recnik.napraviTabeluSvihReciUKnjizi();

		Statement stm = DBConnection.getConnection().createStatement();

		StringBuilder upit2 = new StringBuilder("INSERT INTO sveReciUKnjizi (rec, brojPonavljanja) VALUES  ");
		for (String key : sveReci.keySet()) {
			upit2.append("(\"" + key + "\" ," + sveReci.get(key) + "),");

		}
		upit2.deleteCharAt(upit2.length() - 1);
		stm.execute(upit2.toString());
		stm.close();
	}

	// metoda za prebacivanje liste u niz a zatim sortiranje i ispisivanje u fajl
	public void ispisiSveReciLeksikografskiUFajl() throws IOException {

		List<String> sveReciLista = new ArrayList<String>(sveReci.keySet());

		Collections.sort(sveReciLista);

		FileWriter fw = new FileWriter("sveReci");

		for (String rec : sveReciLista) {
			fw.write(rec + "\n");
			fw.flush();
		}
		fw.close();

	}

	// limit 20 group by brojPonavljanja
	public void najcesceKorisceneReci() throws SQLException {
		DBConnection.getConnection();
		Statement stm = DBConnection.getConnection().createStatement();
		String upit = "SELECT rec , brojPonavljanja FROM sveReciUKnjizi ORDER by brojPonavljanja DESC LIMIT 20";
		ResultSet rs = stm.executeQuery(upit);
		StringBuilder sb = new StringBuilder("");
		while (rs.next()) {
			String rec = rs.getString(1);
			int brojPonavljanja = rs.getInt(2);

			sb.append("rec-" + rec + " se ponavlja " + brojPonavljanja + " puta\n");

		}

		System.out.println(sb.toString());
	}

}
