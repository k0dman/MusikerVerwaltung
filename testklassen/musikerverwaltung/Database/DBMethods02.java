package musikerverwaltung.Database;

import java.util.*;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.mysql.jdbc.*;

import musikerverwaltung.Methods.*;

;

public final class DBMethods02 {
	
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

	public static final void insert(String titel, String namensvorsatz,
			String vorname, String namenszusatz, String nachname,
			int geburtstag, int geburtsmonat, int geburtsjahr,
			int todestag, int todesmonat, int todesjahr,
			String geschlecht, String pseudonym, String instrument,
			String solostueck, String referenz) {

		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call musikerErstellen(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen stmt =

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setString(1, vorname);
			callableStatement.setString(2, nachname);
			callableStatement.setString(3, titel);
			callableStatement.setString(4, namensvorsatz);
			callableStatement.setString(5, namenszusatz);
			callableStatement.setString(6, geschlecht);
			callableStatement.setInt(7, geburtsjahr);
			callableStatement.setInt(8, geburtsmonat);
			callableStatement.setInt(9, geburtsjahr);
			callableStatement.setInt(10, todestag);
			callableStatement.setInt(11, todesmonat);
			callableStatement.setInt(12, todesjahr);
			callableStatement.setString(13, pseudonym);
			callableStatement.setString(14, instrument);
			callableStatement.setString(15, solostueck);
			callableStatement.setString(16, referenz);
			callableStatement.setNull(17, java.sql.Types.INTEGER);

			callableStatement.executeUpdate();

			System.out.println("Record is inserted into DBUSER table!");

		}

		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

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
					.executeQuery("SELECT * FROM person INNER JOIN musiker ON person.idperson = musiker.idperson WHERE `person`.`name` ='"
							+ artist + "'");

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

	public static final String[] DBSelectPseudonym() {

		
		
		// Verbindung zur Datenbank herstellen mit Uebergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		String[] pseudonymsdata = new String[1000];
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// Fuer die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu ermoeglichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("SELECT pseudonym FROM musiker WHERE 1");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<
			int a = 0;
			while (rs.next()) {
				
				pseudonymsdata[a] = rs.getString("pseudonym");
				a++;
				
		}

		 

		rs.close();}
		
		
		
		
		// Moegliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pseudonymsdata;
	

	}	}

