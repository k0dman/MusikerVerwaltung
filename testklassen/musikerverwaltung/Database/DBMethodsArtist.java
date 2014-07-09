package musikerverwaltung.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import musikerverwaltung.menschen.Helfer01;

public class DBMethodsArtist {

	// Diese Eintr\u00E4ge werden zum Verbindungsaufbau ben\u00F6tigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr ver\u00E4ndert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen für die ganze Klasse
	private static DBConnection conn = new DBConnection();

	public static final Vector<Vector<String>> dbSelectStuecksolo(String artist) {

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
					.executeQuery("select stuecksolo from stuecksolo, musiker where stuecksolo.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("stuecksolo"));

				results.add(person);

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der dbSelectStueckSolo");
		}
		return results;
	}

	public static final Vector<Integer> dbSelectStuecksoloID(String artist) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Integer> results = new Vector<Integer>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select id_stuecksolo from stuecksolo, musiker where stuecksolo.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {

				results.add(rs.getInt("id_stuecksolo"));

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Fehler beim Ausführen der dbSelectStueckSoloID");
		}
		return results;
	}

	public static final Vector<Vector<String>> dbSelectReferenz(String artist) {

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
					.executeQuery("select referenz from referenz, musiker where referenz.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("referenz"));

				results.add(person);

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der dbSelectReferenz");
		}
		return results;
	}

	public static final Vector<Integer> dbSelectReferenzID(String artist) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Integer> results = new Vector<Integer>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select id_referenz from referenz, musiker where referenz.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {

				results.add(rs.getInt("id_referenz"));

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der dbSelectReferenzID");
		}
		return results;
	}

	public static final Vector<Vector<String>> dbSelectInstrument(String artist) {

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
					.executeQuery("select instrument from instrument, musiker where instrument.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> person = new Vector<String>();

				person.add(rs.getString("instrument"));

				results.add(person);

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der dbSelectInstrument");
		}
		return results;
	}

	public static final Vector<Integer> dbSelectInstrumentID(String artist) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<Integer> results = new Vector<Integer>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select id_instrument from instrument, musiker where instrument.id_musiker = musiker.id_musiker and pseudonym = '"
							+ artist + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {

				results.add(rs.getInt("id_instrument"));

			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out
					.println("Fehler beim Ausführen der dbSelectInstrumentID");
		}
		return results;
	}

	// Methode die Insert-Prozedur ausf\u00FChrt
	public static final void insertArtist(String titel, String namensvorsatz,
			String vorname, String namenszusatz, String nachname,
			int geburtstag, int geburtsmonat, int geburtsjahr, int todestag,
			int todesmonat, int todesjahr, String geschlecht, boolean istot,
			String pseudonym, String instrument, String solostueck,
			String referenz) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		// /17
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerErstellen(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		// Boolean f\u00FCr <istot> wird erneut umgewandelt mit Helfer-Methode
		String lebt = Helfer01.toStringLebt(istot);

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / F\u00FCr die Variable wird muss ein Statement erstellt werden
			// um
			// eine Kommunikation mit der DB zu erm\u00F6glichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setString(1, vorname);
			callableStatement.setString(2, nachname);
			callableStatement.setString(3, titel);
			callableStatement.setString(4, namensvorsatz);
			callableStatement.setString(5, namenszusatz);
			callableStatement.setString(6, geschlecht);
			callableStatement.setString(7, lebt);
			callableStatement.setInt(8, geburtstag);
			callableStatement.setInt(9, geburtsmonat);
			callableStatement.setInt(10, geburtsjahr);
			callableStatement.setInt(11, todestag);
			callableStatement.setInt(12, todesmonat);
			callableStatement.setInt(13, todesjahr);
			callableStatement.setString(14, pseudonym);
			callableStatement.setString(15, instrument);
			callableStatement.setString(16, solostueck);
			callableStatement.setString(17, referenz);
			callableStatement.setNull(18, java.sql.Types.INTEGER);
			callableStatement.setNull(19, java.sql.Types.INTEGER);
			callableStatement.setNull(20, java.sql.Types.INTEGER);
			callableStatement.setNull(21, java.sql.Types.INTEGER);

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausf\u00FChrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde eingetragen!");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der Insert-Prozedur");
		}

	}

	// Methode die Update-Prozedur f\u00FCr SoloK\u00FCnstler ausf\u00FChrt
	public static final void updateArtist(int idperson, int idmusiker,
			int idinstrument, int idstuecksolo, int idreferenz, String titel,
			String namensvorsatz, String vorname, String namenszusatz,
			String nachname, int geburtstag, int geburtsmonat, int geburtsjahr,
			int todestag, int todesmonat, int todesjahr, String geschlecht,
			boolean istot, String pseudonym, String instrument,
			String solostueck, String referenz) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		// /22
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerBearbeiten(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		// Boolean f\u00FCr <istot> wird erneut umgewandelt mit Helfer-Methode
		String lebt = Helfer01.toStringLebt(istot);

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / F\u00FCr die Variable wird muss ein Statement erstellt werden
			// um
			// eine Kommunikation mit der DB zu erm\u00F6glichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setString(1, vorname);
			callableStatement.setString(2, nachname);
			callableStatement.setString(3, titel);
			callableStatement.setString(4, namensvorsatz);
			callableStatement.setString(5, namenszusatz);
			callableStatement.setString(6, geschlecht);
			callableStatement.setString(7, lebt);
			callableStatement.setInt(8, geburtstag);
			callableStatement.setInt(9, geburtsmonat);
			callableStatement.setInt(10, geburtsjahr);
			callableStatement.setInt(11, todestag);
			callableStatement.setInt(12, todesmonat);
			callableStatement.setInt(13, todesjahr);
			callableStatement.setString(14, pseudonym);
			callableStatement.setString(15, instrument);
			callableStatement.setString(16, solostueck);
			callableStatement.setString(17, referenz);
			callableStatement.setInt(18, idperson);
			callableStatement.setInt(19, idmusiker);
			callableStatement.setInt(20, idinstrument);
			callableStatement.setInt(21, idreferenz);
			callableStatement.setInt(22, idstuecksolo);

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausf\u00FChrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde bearbeitet!");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der Insert-Prozedur");
		}

	}

	// Methode die Delete-Prozedur ausf\u00FChrt f\u00FChr Artist
	public static final void deleteArtist(int idperson, int idmusiker) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		// /21
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerLoeschen(?,?)}";

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / F\u00FCr die Variable wird muss ein Statement erstellt werden
			// um
			// eine Kommunikation mit der DB zu erm\u00F6glichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setInt(1, idmusiker); // musid_musiker
			callableStatement.setInt(2, idperson); // musid_person

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausf\u00FChrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde gel\u00F6scht!");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der delete-Prozedur");
		}

	}

	// Methode zum Select f\u00FCr Artisten
	public static final List<String> DBSelectArtist(Object artist) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		List<String> artistdata = new ArrayList<String>();
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT p.id_person, p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat, p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym, r.referenz, r.id_referenz, s.stuecksolo, s.id_stuecksolo, i.instrument, i.id_instrument, m.id_musiker FROM person p, musiker m, referenz r, stuecksolo s, instrument i WHERE p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker AND m.id_musiker = s.id_musiker AND m.pseudonym = '"
							+ artist + "'");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				artistdata.add(rs.getString("id_person"));// 0
				artistdata.add(rs.getString("name"));// 1
				artistdata.add(rs.getString("vorname"));// 2
				artistdata.add(rs.getString("titel"));// 3
				artistdata.add(rs.getString("vorsatz"));// 4
				artistdata.add(rs.getString("zusatz"));// 5
				artistdata.add(rs.getString("geschlecht"));// 6
				artistdata.add(rs.getString("lebt"));// 7
				artistdata.add(rs.getString("gtag"));// 8
				artistdata.add(rs.getString("gmonat"));// 9
				artistdata.add(rs.getString("gjahr"));// 10
				artistdata.add(rs.getString("ttag"));// 11
				artistdata.add(rs.getString("tmonat"));// 12
				artistdata.add(rs.getString("tjahr"));// 13
				artistdata.add(rs.getString("pseudonym"));// 14
				artistdata.add(rs.getString("referenz"));// 15
				artistdata.add(rs.getString("id_referenz"));// 16
				artistdata.add(rs.getString("stuecksolo"));// 17
				artistdata.add(rs.getString("id_stuecksolo"));// 18
				artistdata.add(rs.getString("instrument"));// 19
				artistdata.add(rs.getString("id_instrument"));// 20
				artistdata.add(rs.getString("id_musiker"));// 21
			}
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der DBSelectArtist");
		}
		return artistdata;
	}

	// Select nach Pseudonym um gezieltes Klicken in der Libary zu
	// erm\u00F6glichen
	public static final Vector<String> dbSelectPseudonym() {

		// Verbindung zur Datenbank herstellen mit \u00FCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<String> pseudonymsdata = new Vector<String>();

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt.executeQuery("SELECT pseudonym FROM musiker WHERE 1");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				pseudonymsdata.add(rs.getString("pseudonym"));
			}

			rs.close();
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Pseudonym-Suche");
		}
		return pseudonymsdata;

	}

	// Inserts f\u00FCr Artists

	public static final void insertStueckSolo(int id_musiker, String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`stuecksolo` (`id_stuecksolo`, `id_musiker`, `stuecksolo`) VALUES (NULL, '"
					+ id_musiker + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static final void insertReferenz(int id_musiker, String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`referenz` (`id_referenz`, `id_musiker`, `referenz`) VALUES (NULL, '"
					+ id_musiker + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static final void insertInstrument(int id_musiker, String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`instrument` (`id_instrument`, `id_musiker`, `instrument`) VALUES (NULL, '"
					+ id_musiker + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
