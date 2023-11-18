package edu.dandaev_it.jdbc.jdbc_educational_project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DatabaseInitializer {
	private static String DATABASE_URL = null;

	private DatabaseInitializer () {
	}

	public static String databaseURLInitilizer () {
		Properties properties = new Properties ();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream ("src/main/resources/config.properties");
			properties.load (fis);
		
			DATABASE_URL = properties.getProperty ("db.host");
		} catch (FileNotFoundException e) {
			e.printStackTrace ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
		return DATABASE_URL;
	}
}
