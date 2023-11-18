package edu.dandaev_it.jdbc.jdbc_educational_project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class establishes connection with database
 */
public class DatabaseConnector {
	private static String USER_NAME    = "sa";
	private static String PASSWORD     = "";
	private static String DATABASE_URL = DatabaseInitializer.databaseURLInitilizer ();			// initialization via
																									// .properties file

	public static Connection getConnection () {
		// establishing database connection
		Connection connection = null;
		try {
			connection = DriverManager.getConnection (DATABASE_URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace ();
		}
		System.out.println ("Databse connection was established successfully!");
		return connection;
	}
}
