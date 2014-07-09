package musikerverwaltung.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DBMethodsBand {

	// Diese Eintr\u00E4ge werden zum Verbindungsaufbau ben\u00F6tigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr ver\u00E4ndert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";

	// Instanz-Objekt erzeugen für die ganze Klasse
	private static DBConnection conn = new DBConnection();

	// Methode die Insert-Prozedur für eine Band ausf\u00FChrt

	// id_musiker muss übergeben werden für die Prozedur
	public static final void insertBand(String grname, String stueckgruppe,
			String grreferenz, int id_musiker, String aktiv) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		// //
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call gruppeErstellen(?,?,?,?,?,?,?,?)}";

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / F\u00FCr die Variable wird muss ein Statement erstellt werden
			// um
			// eine Kommunikation mit der DB zu erm\u00F6glichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setString(1, grname); // Name Band
			callableStatement.setNull(2, java.sql.Types.INTEGER); // id_grreferenz
			callableStatement.setNull(3, java.sql.Types.INTEGER); // id_stueckgruppe
			callableStatement.setString(4, grreferenz); // Stueck der Gruppe
			callableStatement.setString(5, stueckgruppe); // Referenz
			callableStatement.setInt(6, id_musiker); // id_musiker
			callableStatement.setNull(7, java.sql.Types.INTEGER);// id_gruppe
			callableStatement.setString(8, aktiv); // Gruppenmitglied
													// aktiv/passiv

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
			System.out.println("Fehler beim Ausführen der InsertBand-Prozedur");
		}

	}

	// Methode die Delete-Prozedur ausf\u00FChrt f\u00FChr Artist
	public static final void deleteBand(int id_gruppe) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		// /21
		conn.connectionToDB(host, database, user, passwd);

		java.sql.CallableStatement callableStatement = null;
		String insertStoreProc = "{call gruppeLoeschen(?)}";

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// / F\u00FCr die Variable wird muss ein Statement erstellt werden
			// um
			// eine Kommunikation mit der DB zu erm\u00F6glichen

			callableStatement = conn.connection.prepareCall(insertStoreProc);

			callableStatement.setInt(1, id_gruppe); // id_gruppe

			// Abfrage Eintrag erfolgreich war und gleichzeitig Ausf\u00FChrung
			if (callableStatement.executeUpdate() == 0)
				JOptionPane.showMessageDialog(null, "Fehler beim Eintragen");
			else
				JOptionPane.showMessageDialog(null,
						"Die Gruppe wurde gel\u00F6scht!");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler beim Ausführen der delete-Prozedur");
		}

	}

	// Select f\u00FCr Abfrage Band
	public static final boolean selectIsBand(String band) {

		// Verbindung zur Datenbank herstellen mit \u00FCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;
		boolean isband = false;
		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt.executeQuery("SELECT * FROM gruppe WHERE grname = '"
					+ band + "'");

			// band null setzen damit die Abfrage funktioniert
			band = null;

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<
			while (rs.next()) {
				band = rs.getString("grname");
			}

			// Wenn band nicht "leer" ist, <isband> auf true setzen
			if (band != null) {
				isband = true;
			}

			rs.close();
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Band-Suche");
		}
		return isband;

	}

	// Select nach Pseudonym um gezieltes Klicken in der Libary zu
	// erm\u00F6glichen
	public static final Vector<Vector<String>> dbSelectMitglieder(String band) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;

		Vector<Vector<String>> result = new Vector<Vector<String>>();

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select pseudonym, aktiv from musiker mus, mitglied mg, gruppe gr where mus.id_musiker = mg.id_musiker and mg.id_gruppe = gr.id_gruppe and gr.grname = '"
							+ band + "'");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> pseudonymsdata = new Vector<String>();
				pseudonymsdata.add(rs.getString("pseudonym"));
				pseudonymsdata.add(rs.getString("aktiv"));

				result.add(pseudonymsdata);
			}

			rs.close();
		}
		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Mitglieder-Suche");
		}
		return result;

	}

	public static final Vector<Vector<String>> dbSelectStueckgruppe(String band) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;

		Vector<Vector<String>> result = new Vector<Vector<String>>();

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select stueckgruppe from stueckgruppe sg, gruppe g where sg.id_gruppe = g.id_gruppe and g.grname = '"
							+ band + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> pseudonymsdata = new Vector<String>();
				pseudonymsdata.add(rs.getString("stueckgruppe"));

				result.add(pseudonymsdata);
			}

			rs.close();
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Stueckgruppe-Suche");
		}
		return result;

	}

	public static final Vector<Vector<String>> dbSelectGrreferenz(String band) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		// Variablen deklarieren // Statement und ResultSet sind
		// Interface-Klassen
		Statement stmt = null;
		ResultSet rs = null;

		Vector<Vector<String>> result = new Vector<Vector<String>>();

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			rs = stmt
					.executeQuery("select grreferenz from grreferenz gr, gruppe g where gr.id_gruppe = g.id_gruppe and g.grname = '"
							+ band + "';");

			// Schleife um eine alle Zeile durchzuarbeiten mit der Methode
			// >next()<

			while (rs.next()) {
				Vector<String> pseudonymsdata = new Vector<String>();
				pseudonymsdata.add(rs.getString("grreferenz"));

				result.add(pseudonymsdata);
			}

			rs.close();
		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fehler bei Referenz-Suche");
		}
		return result;

	}

	// Inserts f\u00FCr Gruppen
	public static final void insertStueckGruppe(int id_gruppe, String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`stueckgruppe` (`id_stueckgruppe`, `id_gruppe`, `stueckgruppe`) VALUES (NULL, '"
					+ id_gruppe + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static final void insertGrRreferenz(int id_gruppe, String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`grreferenz` (`id_grreferenz`, `id_gruppe`, `grreferenz`) VALUES (NULL, '"
					+ id_gruppe + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static final void insertArtist(int id_gruppe, int id_musiker,
			String text) {

		// Verbindung zur Datenbank herstellen mit \u00DCbergabe der Parameter
		conn.connectionToDB(host, database, user, passwd);

		Statement stmt = null;

		// try / catch zum Abfangen, falls Fehler auftreten
		try {

			// F\u00FCr die Variable wird muss ein Statement erstellt werden um
			// eine Kommunikation mit der DB zu erm\u00F6glichen
			stmt = conn.connection.createStatement();

			// Methode aus Statement aufrufen und Ergebnis in Variable speichen
			stmt.executeUpdate("INSERT INTO `musiclounge`.`mitglied` (`id_mitglied`, `id_musiker`, `id_gruppe`, `aktiv`) VALUES (NULL, '"
					+ id_musiker + "', '" + id_gruppe + "', '" + text + "');");

		}

		// M\u00F6gliche Fehlerquellen: Falscher Tabellenname,
		// falsche Spaltennamen, falsche Datentypen
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
