package musikerverwaltung.hA;

import musikerverwaltung.Database.DBMethods02;

public class Musiker extends Person {

	// Instanzvariabeln
	private String pseudonym;
	private String[] instrument, stuecksolo, referenz;

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
		DBMethods02
				.insert(super.getTitel(), super.getVorsatz(), super.getVorname(),
						super.getZusatz(), super.getName(), super.getGeburtsTag(),
						super.getGeburtsMonat(), super.getGeburtsJahr(), super.getTodesTag(),
						super.getTodesMonat(), super.getTodesJahr(), super.getGeschlecht(),
						getPseudonym(), getInstrument().toString(), getStueckSolo().toString(),
						getReferenz().toString());
	}

}
