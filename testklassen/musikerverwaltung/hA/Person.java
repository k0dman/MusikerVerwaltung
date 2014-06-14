package musikerverwaltung.hA;

// import java.util.*;

public class Person extends Mensch {

	// Klassen-Attribute / variablen mit denen in der KLasse gearbeitet wird
	private String nachname, vorname, geburtsjahr, geburtsdatum, geschlecht,
			titel, namensvorsatz, namenszusatz, todesjahr, todesdatum, lebt;
	
	
	// Konstruktor#1, weisst die Parameter (aus Person) den Klassen-Attributen zu
	public Person(String nachname, String vorname, String geschlecht, String geburtsdatum) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
		}
	
	
	// Konstruktor#2, weisst die Parameter (aus Person) den Klassen-Attributen zu
	public Person(String nachname, String vorname, String titel, String vorsatz,
			String zusatz, String geschlecht, String geburtsdatum,
			String todesdatum) {

		this.titel = titel;
		this.namensvorsatz = namensvorsatz;
		this.vorname = vorname;
		this.namenszusatz = namenszusatz;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
		this.geburtsdatum = geburtsdatum;
		this.geschlecht = geschlecht;
		this.todesdatum = todesdatum;
		this.todesjahr = todesjahr;
		this.lebt = lebt;
	}



	// Namen ausgeben
	public String getTitel() {
		return titel;
	}

	public String getNamensvorsatz() {
		return namensvorsatz;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNamenszusatz() {
		return namenszusatz;
	}

	public String getNachname() {
		return nachname;
	}

	public String getGeburtsdatum() {
		if (geburtsdatum != null)
			return geburtsjahr;
		else
			return geburtsdatum;
	}

	public String getTodesdatum() {
		if (todesdatum != null)
			return todesjahr;
		else
			return todesdatum;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public String getLebt() {
		return lebt;
	}

	// Methode, um die Daten als String auszugeben
	public String toString() {
		return getTitel() + " " + getNamensvorsatz() + " " + getVorname() + " "
				+ getNamenszusatz() + " " + getNachname() + " "
				+ getGeburtsdatum() + " " + getGeschlecht() + " "
				+ getTodesdatum() + " " + getLebt();
	}

	public String anrede() {
		String g = geschlecht.toUpperCase();
		String anrede = null;
		if (g.charAt(0) == 'M' || g.charAt(0) == 'H')
			anrede = "r Herr ";

		else if (g.charAt(0) == 'W' || g.charAt(0) == 'F')
			anrede = " Frau ";
		else
			anrede = "?";

		return "Sehr geehrte" + anrede + getNachname();
	}

	public String alter() {
		int jahr = 2014;
		int geburt = Integer.parseInt(getGeburtsdatum());
		int alter = jahr - geburt;

		return "Alter: " + alter;
	}

}