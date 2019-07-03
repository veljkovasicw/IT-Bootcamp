package pak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class KorisnickiPanel {

	private String StrConn = "jdbc:sqlite:C:\\Users\\Veljko\\Desktop\\Agencija3.db";
	private Connection connection;
	private int idKor;

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
	
	
	public LinkedList<Ponuda> mojaPutovanja(){
		
		
		LinkedList<Ponuda> ponuda = new LinkedList<Ponuda>();
		
		connect();
		
		try(Statement stm = connection.createStatement()) {
			
			String upit = "SELECT Termin.IdTer , Skijaliste.Naziv , Skijaliste.Drzava , Termin.Od , Termin.Do , Termin.Cena , Termin.PreostaloMesta FROM Skijaliste , Termin ,Putuje ,Osoba where Skijaliste.IdSki = Termin.IdSki and Putuje.IdTer=Termin.IdTer and Osoba.IdOsobe=Putuje.IdOsobe and Putuje.IdOsobe="+this.idKor;
			ResultSet rezultat=stm.executeQuery(upit);
			while(rezultat.next()){
				int idTerm = rezultat.getInt(1);
				String nazi = rezultat.getString(2);
				String drz = rezultat.getString(3);
				int kretanje = rezultat.getInt(4);
				int vracanje = rezultat.getInt(5);
				int cen = rezultat.getInt(6);
				Ponuda mojaPut = new Ponuda(idTerm, nazi, drz, kretanje, vracanje, cen);
				ponuda.add(mojaPut);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect();
		return ponuda;
		
		
	}
	
	
	public void ukloni(Ponuda p) {
		
		connect();
		try (Statement stm = connection.createStatement()){
			// moze i samo Select Termin.idTer ali sam stavio ovako zbog svoje provere
			
			String upit ="Select termin.* , Putuje.* from Termin , Putuje where termin.IdTer=putuje.IdTer and putuje.IdOsobe="+this.idKor;
			ResultSet rezultat = stm.executeQuery(upit);
			while(rezultat.next()) {
				int aIdTer= rezultat.getInt(1);
				
				Statement stm1=connection.createStatement();
				String upit2="Update Termin set PreostaloMesta=PreostaloMesta+1 where Termin.IdTer="+aIdTer;
				stm1.executeUpdate(upit2);
				stm1.close();
				
				Statement stm2=connection.createStatement();
				String upit3="Delete from Putuje where IdOsobe="+this.idKor;
				stm2.executeUpdate(upit3);
				stm2.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		disconnect();
		
	}
	
	
}
