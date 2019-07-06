package pak;

import java.sql.*;

import java.util.HashMap;

//   u svakoj metodi SAMO otvoram connection jer je u mainu zatvaram

public class Recnik {

	// u nizu na indexu 0 je tip reci, a na indexu 1 je objasnjenje reci
	private HashMap<String, String[]> recIzRecnika;

	public Recnik() throws SQLException {

		recIzRecnika = new HashMap<String, String[]>();

		DBConnection.getConnection();

		try {
			Statement stm = DBConnection.getConnection().createStatement();
			// group by mi usporava i mogao sam sa distinct ali mi trebaju i ostale kolone
			// pored word kolone !!
			String upit = "SELECT  word, wordtype , definition FROM entries GROUP by word";
			ResultSet rezultat = stm.executeQuery(upit);

			while (rezultat.next()) {
				String kljuc = rezultat.getString(1).toLowerCase();
				String description = rezultat.getString(2);
				String tipReci = rezultat.getString(3);

				String[] nizDesctription = new String[2];
				nizDesctription[0] = description;
				nizDesctription[1] = tipReci;

				recIzRecnika.put(kljuc, nizDesctription);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public boolean pretraziRecnik(String rec) {

		return recIzRecnika.get(rec) != null;

	}

	public void napraviTabeluNovihReciUBazi() throws SQLException {

		DBConnection.getConnection();

		try {

			Statement stmDrop = DBConnection.getConnection().createStatement();
			String drop = "DROP TABLE if EXISTS  reciKojeFale";
			stmDrop.executeUpdate(drop);
			stmDrop.close();

			Statement stm = DBConnection.getConnection().createStatement();
			String upit = "CREATE TABLE reciKojeFale ( recKojaFali   VARCHAR(50), brojPonavljanja   INTEGER)";
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void napraviTabeluReciIzRecnikaUKnjizi() throws SQLException {

		DBConnection.getConnection();

		try {

			Statement stmDrop = DBConnection.getConnection().createStatement();
			String drop = "DROP TABLE if EXISTS  reciKnjigaRecnik";
			stmDrop.executeUpdate(drop);
			stmDrop.close();

			Statement stm = DBConnection.getConnection().createStatement();
			String upit = "CREATE TABLE reciKnjigaRecnik ( recUknjizi   VARCHAR(50), brojPonavljanja   INTEGER )";
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void napraviTabeluSvihReciUKnjizi() throws SQLException {

		DBConnection.getConnection();

		try {

			Statement stmDrop = DBConnection.getConnection().createStatement();
			String drop = "DROP TABLE if EXISTS  sveReciUKnjizi";
			stmDrop.executeUpdate(drop);
			stmDrop.close();

			Statement stm = DBConnection.getConnection().createStatement();
			String upit = "CREATE TABLE sveReciUKnjizi ( rec   VARCHAR(50), brojPonavljanja   INTEGER )";
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
