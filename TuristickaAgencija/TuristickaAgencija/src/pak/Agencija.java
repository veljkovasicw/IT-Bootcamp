package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Agencija {

	private String naziv;
	private Connection connection;
	private String StrConn = "jdbc:sqlite:C:\\Users\\Veljko\\Desktop\\Agencija3.db";

	public Agencija(String aNaziv) {

		naziv = aNaziv;

	}

	public void connect() {
		disconnect();
		try {
			connection = DriverManager.getConnection(StrConn);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void disconnect() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public LinkedList<Ponuda> pretrazi(String drzava) {

		LinkedList<Ponuda> ponuda = new LinkedList<Ponuda>();

		connect();

		try (Statement stm = connection.createStatement()) {

			String upit = "SELECT Termin.IdTer , Skijaliste.Naziv , Skijaliste.Drzava , Termin.Od , Termin.Do , Termin.Cena , Termin.PreostaloMesta FROM Skijaliste , Termin where Skijaliste.IdSki = Termin.IdSki and Skijaliste.Drzava="
					+ "'" + drzava + "'" + " order by termin.Cena ASC";
			ResultSet rezultat = stm.executeQuery(upit);

			while (rezultat.next()) {
				int idTerm = rezultat.getInt(1);
				String nazi = rezultat.getString(2);
				String drz = rezultat.getString(3);
				int kretanje = rezultat.getInt(4);
				int vracanje = rezultat.getInt(5);
				int cen = rezultat.getInt(6);
				int preost = rezultat.getInt(7);

				Ponuda ponu = new Ponuda(idTerm, nazi, drz, kretanje, vracanje, preost, cen);

				ponuda.add(ponu);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		disconnect();
		return ponuda;

	}

	public LinkedList<Ponuda> pretrazi(int maxCena) {

		LinkedList<Ponuda> ponuda = new LinkedList<Ponuda>();

		connect();

		try {
			Statement stm = connection.createStatement();

			String upit = "SELECT Termin.IdTer , Skijaliste.Naziv , Skijaliste.Drzava , Termin.Od , Termin.Do , Termin.Cena , Termin.PreostaloMesta FROM Skijaliste , Termin where Skijaliste.IdSki = Termin.IdSki and Termin.Cena<"
					+ maxCena + " order by termin.Cena ASC";
			ResultSet rezultat = stm.executeQuery(upit);

			while (rezultat.next()) {
				int idTerm = rezultat.getInt(1);
				String nazi = rezultat.getString(2);
				String drz = rezultat.getString(3);
				int kretanje = rezultat.getInt(4);
				int vracanje = rezultat.getInt(5);
				int cen = rezultat.getInt(6);
				int preost = rezultat.getInt(7);

				Ponuda ponu = new Ponuda(idTerm, nazi, drz, kretanje, vracanje, preost, cen);
				ponuda.add(ponu);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		disconnect();
		return ponuda;
	}

	public String getNaziv() {
		return naziv;

	}

	public AdminPanel loginAdmin(String username, String pass) {
		connect();

		String upit = "SELECT IdOsobe FROM Administrator WHERE Administrator.KorIme=" + "'" + username + "'"
				+ " and Administrator.Lozinka=" + "'" + pass + "'";
		try {
			Statement stm = connection.createStatement();
			ResultSet rezultat = stm.executeQuery(upit);

			while (rezultat.next()) {
				int idOsob = rezultat.getInt(1);
				if (idOsob == 1) {
					AdminPanel panel = new AdminPanel();
					disconnect();
					return panel;
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		disconnect();

		return null;

	}

	public KorisnickiPanel loginKorisnik(String username, String pass) {
		connect();

		String upit = "Select Osoba.IdOsobe FROM Osoba WHERE osoba.Ime='" + username + "' and osoba.Prezime='" + pass
				+ "'";

		try (Statement stm1 = connection.createStatement()) {

			ResultSet rezultat = stm1.executeQuery(upit);
			while (rezultat.next()) {
				int idOsobe = rezultat.getInt(1);
				if (idOsobe != 1) {
					KorisnickiPanel koris = new KorisnickiPanel();

					disconnect();
					return koris;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();
		return null;
	}

}
