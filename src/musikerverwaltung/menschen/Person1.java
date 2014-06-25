package musikerverwaltung.menschen;

// import java.util.*;

public class Person1 extends Mensch01 {

	// Klassen-Attribute / variablen mit denen in der KLasse gearbeitet wird
	private String name, vorname, geburtsjahr, geburtsdatum, geschlecht,
			titel, namensvorsatz, namenszusatz, todesjahr, todesdatum, lebt;

	// Konstruktor#1, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person1(String name, String vorname, String geschlecht,
			String geburtsdatum) {
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
	}

	// Konstruktor#2, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person1(String name, String vorname, String titel,
			String vorsatz, String zusatz, String geschlecht,
			String geburtsdatum, String todesdatum) {

		this.titel = titel;
		this.namensvorsatz = namensvorsatz;
		this.vorname = vorname;
		this.namenszusatz = namenszusatz;
		this.name = name;
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
				+ getNamenszusatz() + " " + getName() + " "
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

		return "Sehr geehrte" + anrede + getName();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getGeburtsTag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGeburtsMonat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGeburtsJahr() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTodesTag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTodesMonat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTodesJahr() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTodesDatum(int tag, int monat, int jahr) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMann() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFrau() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String nameKomplett() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double alter() {
		// TODO Auto-generated method stub
		return 0;
	}

}