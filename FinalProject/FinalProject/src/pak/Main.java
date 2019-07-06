package pak;

import java.io.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {

		Recnik recnik = null;
		try {
			recnik = new Recnik();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		Knjiga ivo = new Knjiga("knjiga", recnik);
		ivo.procitajKnjiguINapraviHashMape();

		try {
			ivo.dodajNoveReciUDB2();
			ivo.prebrojPostojeceReciUDB2();
			ivo.sveReciUknjzi();
			ivo.najcesceKorisceneReci();
		} catch (SQLException e) {

		}

		try {
			ivo.ispisiSveReciLeksikografskiUFajl();
		} catch (IOException e) {

			e.printStackTrace();
		}

		DBConnection.closeQuietly();

	}
}
