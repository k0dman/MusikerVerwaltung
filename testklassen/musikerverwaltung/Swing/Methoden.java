package musikerverwaltung.Swing;

import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import musikerverwaltung.Database.*;
public final class Methoden {

	// Diese Eintraege werden zum Verbindungsaufbau benoetigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr veraendert werden sollen
	private final static String host = "localhost";
	private final static String database = "personen";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen für die ganze Klasse
	private static DBConnection01 conn = new DBConnection01();

	public static final void DBSelect() {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt.executeQuery("SELECT * FROM person where");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {

				// Ergebnisse aus den Spalten in Variablen mit entsprechendem
				// Datentyp speichern
				// Strings werden mit >getString< ausgelesen
				String first_name = rs.getString("forename");

				String last_name = rs.getString("surename");

				// Zusammenfuergen der beiden Strings zu Einem
				String name = last_name + ", " + first_name;

				// Ausgabe
				System.out.println(name);
			}
		}
		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static final void insert(String input1, String input2) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO person(ID, forename, surename) VALUES(NULL,'"
					+ input1 + "','" + input2 + "')");

		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public final static Vector<String> COLUMN_IDENTIFIERS = new Vector<String>() {
		{

			add("ID");
			add("Vorname");
			add("Nachname");
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
			rs = stmt.executeQuery("SELECT * FROM person");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(String.valueOf(rs.getInt("ID")));
				person.add(rs.getString("forename"));
				person.add(rs.getString("surename"));

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
}
