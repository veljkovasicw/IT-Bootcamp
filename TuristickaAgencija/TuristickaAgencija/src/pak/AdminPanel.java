package pak;

import java.sql.*;

public class AdminPanel {
	private String StrConn = "jdbc:sqlite:C:\\Users\\Veljko\\Desktop\\Agencija3.db";
	private Connection connection;
	
	
	public void connect() {
		disconnect();
		try {
			connection = DriverManager.getConnection(StrConn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void disconnect () {
		try {
			if ( connection !=null && !connection.isClosed() ) {
				connection.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void modifikujCene(double procenat) {
		
		connect();
		
		String upit = "update Termin set Cena=Cena+(Cena*"+procenat+")";
		try {
			Statement stm = connection.createStatement();
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		disconnect();
		
	}
	
	public void ukloni(int idTer) {
		
		connect();
		String upit = "DELETE FROM Termin WHERE IdTer="+idTer;
		Statement stm;
		try {
			stm = connection.createStatement();
			stm.executeUpdate(upit);
			stm.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		disconnect();
	
	}
	
	public void stampajOsobe(int idTer) {
		
		connect();
		String upit= "select osoba.IdOsobe , osoba.Ime , osoba.Prezime , osoba.Kontakt FROM Putuje , Osoba , Termin where Putuje.idTer=Termin.idTer and Osoba.IdOsobe=Putuje.IdOsobe";
		try {
			Statement stm7=connection.createStatement();
			ResultSet rezultat = stm7.executeQuery(upit);
			while(rezultat.next()) {
				int idOsobe = rezultat.getInt(1);
				String ime=rezultat.getString(2);
				String prezime=rezultat.getString(3);
				String kontakt=rezultat.getString(4);
				
				System.out.println("("+idOsobe+")" +" "+ ime +" "+prezime+" -  " + kontakt );
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
