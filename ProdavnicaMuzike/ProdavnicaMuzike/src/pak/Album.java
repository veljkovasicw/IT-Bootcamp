package pak;

import java.util.Date;
import java.util.LinkedList;

public class Album {

	private String naziv;
	private String izvodjac;
	private Date datum;
	private LinkedList<Numera> listaPesama;

	public Album(String aNaziv, String aIzvodjac, Date aDatum) {
		setNaziv(aNaziv);
		setIzvodjac(aIzvodjac);
		setDatum(aDatum);
		listaPesama = new LinkedList<Numera>();

	}

	public void dodaj(Numera aNumera) {

		listaPesama.add(aNumera);

	}

	public void dodaj(String name, String trajanje) {

		Numera n = new Numera(name, this.izvodjac, trajanje);

		// listaPesama.add(n);

		this.dodaj(n);
	}

	public String getTrajanje() {
		int ukupnaDuzina = 0;
		for (int i = 0; i < listaPesama.size(); i++) {
			String[] duzina = listaPesama.get(i).getTrajanje().split(":");
			String duzina1 = duzina[0];
			String duzina2 = duzina[1];

			int trajanje = Integer.parseInt(duzina1) * 60 + Integer.parseInt(duzina2);

			ukupnaDuzina += trajanje;
			

		}
		int minuti = ukupnaDuzina / 60;
		int sekunde = ukupnaDuzina - minuti * 60;
		
		String ukupnoTrajanje = "" + minuti + ":" + sekunde;
		return ukupnoTrajanje;

	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(String izvodjac) {
		this.izvodjac = izvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Numera getNumera(int index) {
		Numera num = listaPesama.get(index);
		return num;
	}

	public Numera getNumera(String ime) {

		for (int i = 0; i < listaPesama.size(); i++) {
			if (listaPesama.get(i).getNaziv().equals(ime)) {
				return listaPesama.get(i);
			}

		}
		
		return null;
	}
	
	public String toString () {
		String albumStampanje=izvodjac+"-"+naziv + "("+datum+")"+ "[\n\t";
		for (int i =0 ; i<listaPesama.size(); i++) {
			albumStampanje+=listaPesama.get(i).toString()+",\n\t";
			
		}
		albumStampanje+="] :"+getTrajanje();
		
		return albumStampanje;
		
	}
}