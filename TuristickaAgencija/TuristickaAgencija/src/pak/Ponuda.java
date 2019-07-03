package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Ponuda {

	int idTerm;
	private String naziv;
	private String drzava;
	private int datumOd;
	private int datumDo;
	private int preostaloMesta;
	private int cena;
	private Connection connection;
	private String StrConn = "jdbc:sqlite:C:\\Users\\Veljko\\Desktop\\Agencija3.db";

	public Ponuda(int idTerm, String naziv, String drzava, int datumOd, int datumDo, int preostaloMesta, int cena) {

		this.idTerm = idTerm;
		this.naziv = naziv;
		this.drzava = drzava;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.preostaloMesta = preostaloMesta;
		this.cena = cena;

	}
	public Ponuda(int idTerm, String naziv, String drzava, int datumOd, int datumDo, int cena) {

		this.idTerm = idTerm;
		this.naziv = naziv;
		this.drzava = drzava;
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.cena = cena;

	}

	public void connect() throws SQLException {
		disconnect();
		connection = DriverManager.getConnection(StrConn);

	}

	public void disconnect() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

	
	
	public boolean zakupi() {

		try {
			connect();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		if (this.preostaloMesta != 0) {

			String upit = "UPDATE Termin set PreostaloMesta= termin.PreostaloMesta -1 WHERE IdTer=+?";

			PreparedStatement stm;
			try {
				stm = connection.prepareStatement(upit);
				stm.setInt(1, this.idTerm);
				stm.execute();
				stm.close();
				disconnect();
				return true;
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		try {
			disconnect();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;

	}

	public boolean zakupi(String ime, String prezime, String tel) {

		try {
			connect();
			if (this.preostaloMesta != 0) {

				String upitDodajOsobu = "INSERT INTO Osoba VALUES ( NULL,'" + ime + "' , '" + prezime + "' , '" + tel
						+ "')";
				Statement stm2 = connection.createStatement();
				stm2.executeUpdate(upitDodajOsobu);
				stm2.close();
				String izlistajOsobe = "SELECT max (osoba.IdOsobe) from Osoba ";
				Statement stm3 = connection.createStatement();
				ResultSet rezultat = stm3.executeQuery(izlistajOsobe);
				while (rezultat.next()) {
					int idOsobe1 = rezultat.getInt(1);
					String dodajUPutuj = "INSERT INTO Putuje VALUES (" + idOsobe1 + " , " + this.idTerm + ")";
					Statement stm4 = connection.createStatement();
					stm4.executeUpdate(dodajUPutuj);
					stm4.close();

				}
			}

			zakupi();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean zakupi(int idOsobe) {

		try {
			connect();
			if (this.preostaloMesta != 0) {

				String upitDodajUPutujNaOsnovuID = "INSERT INTO Putuje VALUES (" + idOsobe + " , " + this.idTerm + " )";
				Statement stm5 = connection.createStatement();
				stm5.executeUpdate(upitDodajUPutujNaOsnovuID);
				stm5.close();

				zakupi();
				return true;

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			disconnect();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	public String toString() {
		String bb = "(" + idTerm + ") " + naziv + "(" + drzava + ")" + " " + datumOd + "-" + datumDo + "/" + cena
				+ "€ : " + preostaloMesta;
		return bb;

	}

}
