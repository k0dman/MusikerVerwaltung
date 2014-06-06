package musikerverwaltung.Database;

import java.sql.*;

//Notice, do not import org.gjt.mm.mysql.* 
//or you will have problems! 

public class DBConnection01 {
	// Erzeugen eines Connection-Objektes (Bei Connection handelt es sich um
	// eine Interface-Klasse)
	public Connection connection;

	public DBConnection01() {

	}

	public boolean connectionToDB(String host, String database, String user,
			String passwd) {

		// try / catch zum Abfangen einer Exception bzgl. des Treibers
		try {
			// Laden des Treibers
			// Der Treiber ist eine >jar< Datei
			// Sie ist zwingend notwendig
			// Download unter ==> http://dev.mysql.com/downloads/connector/j/
			// Der Name der Datei lautet: >mysql_connector_java_5.1.30_bin<
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Deklaration eines Strings in dem hostname, port und dbname
			// abgelegt werden
			String connectionCommand = "jdbc:mysql://" + host + "/" + database
					+ "?user=" + user + "&password=" + passwd;

			// Aus der Klasse DriverManager wird die Methode getConnection
			// aufgerufen und der entsprechende Parameter
			// uebergeben um eine Verbindung herzustellen
			connection = DriverManager.getConnection(connectionCommand);

			return true;

		}
		// Abfangen falls ein Fehler auftritt
		// Bsp.: Kein Treiber
		// vorhanden oder nicht eingebunden :P
		// Falsche Daten zur DB
		catch (Exception ex) {
			System.out.println("false");

			return false;
		}
	}
}
