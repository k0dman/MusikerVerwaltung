package musikerverwaltung.hA;

import musikerverwaltung.Database.DBMethods01;
import musikerverwaltung.Database.DBMethods02;

public class Musiker extends Person {

	// Instanzvariabeln
	private String pseudonym;
	private String[] instrument, stuecksolo, referenz;

	public Musiker(String pseudonym) {	
		
		this.pseudonym = pseudonym;
		
	}

	// Konstruktor#1
	public Musiker(String name, String vorname, String geschlecht,
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
	public Musiker(String name, String vorname, String titel, String vorsatz,
			String zusatz, String geschlecht, String geburtsdatum,
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
		DBMethods02.insert(super.getTitel(), super.getVorsatz(), super
				.getVorname(), super.getZusatz(), super.getName(), super
				.getGeburtsTag(), super.getGeburtsMonat(), super
				.getGeburtsJahr(), super.getTodesTag(), super.getTodesMonat(),
				super.getTodesJahr(), super.getGeschlecht(), getPseudonym(),
				getInstrument().toString(), getStueckSolo().toString(),
				getReferenz().toString());
	}

	
	// GET - Methode um die Daten aus der Datenb
	public String getMusiker() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()));
	}
	public String getMusikerName() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(0));
	}
	public String getMusikerVorname() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(1));
	}
	public String getMusikerTitel() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(2));
	}
	public String getMusikerVorsatz() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(3));
	}
	public String getMusikerZusatz() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(4));
	}
	public String getMusikerGeschlecht() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(5));
	}
	public String getMusikerGTag() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(6));
	}
	public String getMusikerGMonat() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(7));
	}
	public String getMusikerGJahr() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(8));
	}
	public String getMusikerTJahr() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(9));
	}
	public String getMusikerPseudonym() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(10));
	}
	public String getMusikerInstrument() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(11));
	}
	public String getMusikerStueckSolo() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(12));
	}
	public String getMusikerReferenz() {
		return String.valueOf(DBMethods01.DBSelectArtist(getPseudonym()).get(13));
	}

}