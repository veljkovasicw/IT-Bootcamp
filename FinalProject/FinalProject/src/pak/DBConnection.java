package pak;

import java.sql.*;

public class DBConnection {
	// putanja do databaze
	private final static String konstring = "jdbc:sqlite:C:\\Users\\Veljko\\Desktop\\finalniprojekat\\Dictionary.db";
	private static Connection connection;

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed())
			connection = DriverManager.getConnection(konstring);
		return connection;
	}

	public static void close() throws SQLException {
		if (connection != null && !connection.isClosed())
			connection.close();
	}

	public static void closeQuietly() {
		try {
			close();
		} catch (SQLException e) {
			System.err.println("Nemoguce zatvoriti konekciju");
			e.printStackTrace();
		}
	}
}
