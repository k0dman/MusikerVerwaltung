package musikerverwaltung.menschen;


import musikerverwaltung.Database.DBMethods03;

public class Musiker01 extends Person01 {

	// Instanzvariabeln
	private String pseudonym;
	private String[] instrument, stuecksolo, referenz;

	public Musiker01(String pseudonym) {	
		
		this.pseudonym = pseudonym;
		
	}

	// Konstruktor#1
	public Musiker01(String name, String vorname, String geschlecht,
			String geburtsdatum, String pseudonym, String[] instrument,
			String[] stuecksolo, String[] referenz) {

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, geschlecht, geburtsdatum);

		// Sets
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.stuecksolo = stuecksolo;
		this.referenz = referenz;

		// TODO Auto-generated constructor stub
	}

	// Konstuktor#2
	public Musiker01( String titel,String vorsatz, String vorname,String zusatz, String name,
			 String geburtsdatum, String geschlecht, 
			String todesdatum, String pseudonym, String[] instrument,
			String[] stuecksolo, String[] referenz) {

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, titel, vorsatz, zusatz, geschlecht, geburtsdatum,
				todesdatum);

		// Sets
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.stuecksolo = stuecksolo;
		this.referenz = referenz;
	}
	
	// Konstuktor#3
		public Musiker01( String titel,String vorsatz, String vorname,String zusatz, String name,
				int geburtstag, int geburtsmonat, int geburtsjahr, int todestag,
				 int todesmonat, int todesjahr, String geschlecht, String pseudonym, String[] instrument,
				String[] stuecksolo, String[] referenz) {

			// Aufruf des Konstruktors der Basis-Klasse
			super(name, vorname, titel, vorsatz, zusatz, geschlecht, geburtstag, geburtsmonat, geburtsjahr,
					 todestag, todesmonat, todesjahr);

			// Sets
			this.pseudonym = pseudonym;
			this.instrument = instrument;
			this.stuecksolo = stuecksolo;
			this.referenz = referenz;
		}
		
		// Gets

	public String getPseudonym() {
		return pseudonym;
	}

	public String[] getInstrument() {
		return instrument;
	}

	public String[] getStueckSolo() {
		return stuecksolo;
	}

	public String[] getReferenz() {
		return referenz;
	}

	public String toString() {
		String ausgabe = super.getName() + " akA: " + pseudonym
				+ " macht viele Dinge, wie: " + instrument[1]
				+ " in dem stuecksolo " + stuecksolo[0];

		return ausgabe;

	}

	public void insert() {
		DBMethods03.insert(super.getTitel(), super.getVorsatz(), super
				.getVorname(), super.getZusatz(), super.getName(), super
				.getGeburtsTag(), super.getGeburtsMonat(), super
				.getGeburtsJahr(), super.getTodesTag(), super.getTodesMonat(),
				super.getTodesJahr(), super.getGeschlecht(), getPseudonym(),
				getInstrument()[0], getStueckSolo()[0],
				getReferenz()[0]);
	}

	
	// GET - Methode um die Daten aus der Datenb
	public String getMusiker() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()));
	}
	public String getMusikerName() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(0));
	}
	public String getMusikerVorname() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(1));
	}
	public String getMusikerTitel() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(2));
	}
	public String getMusikerVorsatz() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(3));
	}
	public String getMusikerZusatz() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(4));
	}
	public String getMusikerGeschlecht() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(5));
	}
	public int getMusikerGTag() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(6));
	}
	public int getMusikerGMonat() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(7));
	}
	public int getMusikerGJahr() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(8));
	}
	public int getMusikerTTag() {
		return Integer.parseInt((DBMethods03.DBSelectArtist(getPseudonym()).get(9)));
	}
	public int getMusikerTMonat() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(10));
	}
	public int getMusikerTJahr() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(11));
	}
	public String getMusikerPseudonym() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(12));
	}
	public String getMusikerInstrument() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(13));
	}
	public String getMusikerStueckSolo() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(14));
	}
	public String getMusikerReferenz() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(15));
	}

}
