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

	// Diese Eintraege werden zum Verbindungsaufbau benoetigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr veraendert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen für die ganze Klasse
	private static DBConnection conn = new DBConnection();

	public final static Vector<String> COLUMN_IDENTIFIERS = new Vector<String>() {
		{
			add("Interpret");
			add("Titel");
		}
	};

	public static final Vector<Vector<String>> dbSelectTable() {

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
					.executeQuery("SELECT mus.pseudonym, ss.stuecksolo FROM musiker mus, stuecksolo ss where mus.id_musiker = ss.id_musiker and ss.stuecksolo not like '' UNION SELECT gr.name, sg.stueckgruppe FROM musiker mus,mitglied mg, gruppe gr, stueckgruppe sg where gr.id_gruppe = sg.id_gruppe order by pseudonym");

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
			System.out.println("Fehler beim Ausführen der dbSelectTable");
		}
		return results;
	}

	public static final Vector<Vector<String>> dbSearch(String keyword) {

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
					.executeQuery("SELECT p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat, p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym, r.referenz, s.stuecksolo, i.instrument FROM person p, musiker m, referenz r, stuecksolo s, instrument i WHERE p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker AND m.id_musiker = s.id_musiker AND CONCAT (name, vorname, pseudonym, stuecksolo) like '%"
							+ keyword + "%' ORDER BY m.pseudonym");

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
			System.out
					.println("Fehler beim Ausführen der Methode zur DBSearch");
		}
		return results;
	}

	// Methode die Insert-Prozedur ausfuehrt
	public static final void insertArtist(String titel, String namensvorsatz,
			String vorname, String namenszusatz, String nachname,
			int geburtstag, int geburtsmonat, int geburtsjahr, int todestag,
			int todesmonat, int todesjahr, String geschlecht, boolean istot,
			String pseudonym, String instrument, String solostueck,
			String referenz) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter /17
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerErstellen(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		// Boolean fuer <istot> wird erneut umgewandelt mit Helfer-Methode
		String lebt = Helfer01.toStringLebt(istot);

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen

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

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausfuehrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde eingetragen!");

		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der Insert-Prozedur");
		}

	}

	// Methode die Update-Prozedur ausfuehrt
	public static final void updateArtist(int id, String titel,
			String namensvorsatz, String vorname, String namenszusatz,
			String nachname, int geburtstag, int geburtsmonat, int geburtsjahr,
			int todestag, int todesmonat, int todesjahr, String geschlecht,
			boolean istot, String pseudonym, String instrument,
			String solostueck, String referenz) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter /21
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerBearbeiten(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		// Boolean fuer <istot> wird erneut umgewandelt mit Helfer-Methode
		String lebt = Helfer01.toStringLebt(istot);

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen

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
			callableStatement.setInt(18, id);
			callableStatement.setNull(19, java.sql.Types.INTEGER);
			callableStatement.setNull(20, java.sql.Types.INTEGER);
			callableStatement.setNull(21, java.sql.Types.INTEGER);
			callableStatement.setNull(22, java.sql.Types.INTEGER);

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausfuehrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde bearbeitet!");

		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der Insert-Prozedur");
		}

	}

	// Methode die Insert-Prozedur für eine Band ausfuehrt

	// id_musiker muss übergeben werden für die Prozedur
	public static final void insertBand(String name, String stueckgruppe,
			String referenz, int id_musiker, boolean aktiv) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter /17
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call gruppeErstellen(?,?,?,?,?,?,?,?)}";

		// Frage ob wir hier mit boolean wieder arbeiten oder nicht.
		// Die Datenbank erwartet "j" / "n"
		// Boolean fuer <istaktiv> wird erneut umgewandelt mit Helfer-Methode

		// /String lebt = Helfer01.toStringLebt(istot);

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setString(1, name); // Name Band
			callableStatement.setNull(2, java.sql.Types.INTEGER); // id_grreferenz
			callableStatement.setNull(2, java.sql.Types.INTEGER); // id_stueckgruppe
			callableStatement.setString(4, stueckgruppe); // Stueck der Gruppe
			callableStatement.setString(5, grreferenz); // Referenz
			callableStatement.setInt(6, id_musiker); // id_musiker
			callableStatement.setNull(7, java.sql.Types.INTEGER);// id_gruppe
			callableStatement.setString(8, aktiv); // Gruppenmitglied
													// aktiv/passiv

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausfuehrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Der Interpret wurde eingetragen!");

		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der Insert-Prozedur");
		}

	}

	// Methode zum Select fuer Artisten
	public static final List<String> DBSelectArtist(Object artist) {

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
					.executeQuery("SELECT p.id_person, p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat, p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym, r.referenz, s.stuecksolo, i.instrument FROM person p, musiker m, referenz r, stuecksolo s, instrument i WHERE p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker AND m.id_musiker = s.id_musiker AND m.pseudonym = '"
							+ artist + "'");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				artistdata.add(rs.getString("id_person"));
				artistdata.add(rs.getString("name"));
				artistdata.add(rs.getString("vorname"));
				artistdata.add(rs.getString("titel"));
				artistdata.add(rs.getString("vorsatz"));
				artistdata.add(rs.getString("zusatz"));
				artistdata.add(rs.getString("geschlecht"));
				artistdata.add(rs.getString("lebt"));
				artistdata.add(rs.getString("gtag"));
				artistdata.add(rs.getString("gmonat"));
				artistdata.add(rs.getString("gjahr"));
				artistdata.add(rs.getString("ttag"));
				artistdata.add(rs.getString("tmonat"));
				artistdata.add(rs.getString("tjahr"));
				artistdata.add(rs.getString("pseudonym"));
				artistdata.add(rs.getString("instrument"));
				artistdata.add(rs.getString("stuecksolo"));
				artistdata.add(rs.getString("referenz"));
			}
		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der DBSelectArtist");
		}
		return artistdata;
	}

	// Select nach Pseudonym um gezieltes Klicken in der Libary zu ermoeglichen
	public static final Vector<String> dbSelectPseudonym() {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		Vector<String> pseudonymsdata = new Vector<String>();

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
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

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Pseudonym-Suche");
		}
		return pseudonymsdata;

	}

	// Select fuer Abfrage Band
	public static final boolean selectIsBand(String band) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		boolean isband = false;
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt.executeQuery("SELECT * FROM gruppe WHERE name = '" + band
					+ "'");

			// band null setzen damit die Abfrage funktioniert
			band = null;

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<
			while (rs.next()) {
				band = rs.getString("name");
			}

			// Wenn band nicht "leer" ist, <isband> auf true setzen
			if (band != null) {
				isband = true;
			}

			rs.close();
		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Band-Suche");
		}
		return isband;

	}
}
