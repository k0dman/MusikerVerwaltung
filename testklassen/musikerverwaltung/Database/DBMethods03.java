package musikerverwaltung.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import musikerverwaltung.menschen.*;

public final class DBMethods03 {

	// Diese Eintr\u00E4ge werden zum Verbindungsaufbau ben\u00F6tigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr ver\u00E4ndert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen für die ganze Klasse
	private static DBConnection conn = new DBConnection();

	public final static Vector<String> COLUMN_IDENTIFIERSMAINTABLE = new Vector<String>() {
		{
			add("Interpret");
			add("Titel");
		}
	};

	public final static Vector<String> COLUMN_IDENTIFIERSMEMBERS = new Vector<String>() {
		{
			add("Mitglied");
			add("Aktiv");
		}
	};

	public final static Vector<String> COLUMN_IDENTIFIERSTITLES = new Vector<String>() {
		{
			add("Titel");

		}
	};

	public final static Vector<String> COLUMN_IDENTIFIERSREFERENCES = new Vector<String>() {
		{
			add("Referenzen");

		}
	};

	public final static Vector<String> COLUMN_IDENTIFIERSINSTRUMENT = new Vector<String>() {
		{
			add("Instrumente");

		}
	};

	public static final Vector<Vector<String>> dbSelectTable() {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Vector<String>> results = new Vector<Vector<String>>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT mus.pseudonym, ss.stuecksolo FROM musiker mus, stuecksolo ss where mus.id_musiker = ss.id_musiker and ss.stuecksolo not like '' UNION SELECT gr.grname, sg.stueckgruppe FROM musiker mus,mitglied mg, gruppe gr, stueckgruppe sg where gr.id_gruppe = sg.id_gruppe order by pseudonym");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("pseudonym"));
				person.add(rs.getString("stuecksolo"));

				results.add(person);

			}
		}

		// M\u00F6gliche Fehlerq\u00FCllen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der dbSelectTable");
		}
		return results;
	}

	public static final Vector<Vector<String>> dbSearch(String keyword) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Vector<String>> results = new Vector<Vector<String>>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT mus.pseudonym, ss.stuecksolo FROM musiker mus, stuecksolo ss, person p where p.id_person = mus.id_person and mus.id_musiker = ss.id_musiker and ss.stuecksolo not like '' and concat(pseudonym, stuecksolo, name, vorname) like '%"
							+ keyword
							+ "%' UNION SELECT gr.grname, sg.stueckgruppe fROM musiker mus,mitglied mg, gruppe gr, stueckgruppe sg, person p where gr.id_gruppe = sg.id_gruppe and concat(grname, stueckgruppe) like '%"
							+ keyword + "%' order by pseudonym");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("pseudonym"));
				person.add(rs.getString("stuecksolo"));

				results.add(person);

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Fehler beim Ausführen der Methode zur DBSearch");
		}
		return results;
	}

}
