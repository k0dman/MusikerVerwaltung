package musikerverwaltung.hA;

public class Person extends Mensch {

	// Klassen-Attribute / variablen mit denen in der KLasse gearbeitet wird
	private String name, vorname, geburtsjahr, geburtsdatum, geschlecht, titel,
			vorsatz, zusatz, todesdatum, lebt;


	// Konstruktor#1, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person(String name, String vorname, String geschlecht,
			String geburtsdatum) {
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
	}

	// Konstruktor#2, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person(String name, String vorname, String titel, String vorsatz,
			String zusatz, String geschlecht, String geburtsdatum,
			String todesdatum) {

		this.name = name;
		this.vorname = vorname;
		this.titel = titel;
		this.vorsatz = vorsatz;
		this.zusatz = zusatz;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
		this.todesdatum = todesdatum;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getVorname() {
		// TODO Auto-generated method stub
		return vorname;
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
	public double alter() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String nameKomplett() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String anrede() {
		// TODO Auto-generated method stub
		return null;
	}

}
