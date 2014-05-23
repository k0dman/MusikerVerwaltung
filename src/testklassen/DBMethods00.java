package testklassen;

import java.util.Vector;

public final class DBMethods00 {
	
	// Diese Eintraege werden zum Verbindungsaufbau benoetigt
	// Die Variabeln werden als >final< deklariert, da es sich hier um
	// Konstanten handelt, die nicht mehr veraendert werden sollen
	private final static String host = "localhost";
	private final static String database = "musiclounge";
	private final static String user = "root";
	private final static String passwd = "";
	
	
	public final static Vector<String> COLUMN_IDENTIFIERS = new Vector<String>() {
		{

			add("Band");
			add("Künstler");
			add("Titel");
		}
	};
}
