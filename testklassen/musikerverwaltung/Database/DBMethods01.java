package musikerverwaltung.Database;

import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public final class DBMethods01 {

	// Diese Eintraege werden zum Verbindungsaufbau benoetigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr veraendert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen f�r die ganze Klasse
	private static DBConnection conn = new DBConnection();

	public final static Vector<String> COLUMN_IDENTIFIERS = new Vector<String>() {
		{
			add("Interpret");
			add("Titel");
		}
	};

	public static final Vector<Vector<String>> DBSelectVector() {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Vector<String>> results = new Vector<Vector<String>>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT idperson,pseudonym,stuecksolo FROM musiker WHERE 1");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("pseudonym"));
				person.add(rs.getString("stuecksolo"));

				results.add(person);

			}
		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public static final List<String> DBSelectArtist(String artist) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		List<String> artistdata = new ArrayList<String>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT * FROM person INNER JOIN musiker ON person.idperson = musiker.idperson WHERE `person`.`name` ='"+artist+"'");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				artistdata.add(rs.getString("name"));
				artistdata.add(rs.getString("vorname"));
				artistdata.add(rs.getString("titel"));
				artistdata.add(rs.getString("vorsatz"));
				artistdata.add(rs.getString("zusatz"));
				artistdata.add(rs.getString("geschlecht"));
				artistdata.add(rs.getString("gtag"));
				artistdata.add(rs.getString("gmonat"));
				artistdata.add(rs.getString("gjahr"));
				artistdata.add(rs.getString("tjahr"));
				artistdata.add(rs.getString("instrument"));
				artistdata.add(rs.getString("stuecksolo"));
			}
		}
		

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}
		return artistdata;
	}
}
