package musikerverwaltung.menschen;

public class Person01 extends Mensch {

	// Klassen-Attribute / variablen mit denen in der KLasse gearbeitet wird
	private String name, vorname, geburtsdatum, geschlecht, titel, vorsatz,
			zusatz, todesdatum, lebt;

	private int geburtstag, geburtsmonat, geburtsjahr, todesjahr, todestag, todesmonat;

	// Konstruktor#1, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person01() {
	}

	public Person01(String name, String vorname, String geschlecht,
			String geburtsdatum) {
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.geburtsdatum = geburtsdatum;
	}

	// Konstruktor#2, weisst die Parameter (aus Person) den Klassen-Attributen
	// zu
	public Person01(String name, String vorname, String titel, String vorsatz,
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
	
	// Konstruktor#3, weisst die Parameter (aus Person) den Klassen-Attributen
		// zu
		public Person01(String name, String vorname, String titel, String vorsatz,
				String zusatz, String geschlecht, String lebt, int geburtstag, int geburtsmonat, int geburtsjahr,
				int todestag, int todesmonat, int todesjahr) {

			this.name = name;
			this.vorname = vorname;
			this.titel = titel;
			this.vorsatz = vorsatz;
			this.zusatz = zusatz;
			this.geburtstag = geburtstag;
			this.geburtsmonat = geburtsmonat;
			this.geburtsjahr = geburtsjahr;
			this.todestag = todestag;
			this.todesmonat = todesmonat;
			this.todesjahr =  todesjahr;
			this.geschlecht = geschlecht;
			this.lebt = lebt;
		}

	public String getTitel() {
		return titel;
	}

	public String getVorsatz() {
		return vorsatz;
	}

	public String getZusatz() {
		return zusatz;
	}

	public String getGeschlecht() {
		return geschlecht;
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
		return geburtstag;
	}

	@Override
	public int getGeburtsMonat() {
		// TODO Auto-generated method stub
		return geburtsmonat;
	}

	@Override
	public int getGeburtsJahr() {
		// TODO Auto-generated method stub
		return geburtsjahr;
	}

	@Override
	public int getTodesTag() {
		// TODO Auto-generated method stub
		return todestag;
	}

	@Override
	public int getTodesMonat() {
		// TODO Auto-generated method stub
		return todesmonat;
	}

	@Override
	public int getTodesJahr() {
		// TODO Auto-generated method stub
		return todesjahr;
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
		return Helfer01.toBoolLebt(lebt);
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
