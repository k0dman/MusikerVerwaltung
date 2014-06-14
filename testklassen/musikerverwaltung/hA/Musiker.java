package musikerverwaltung.hA;

public class Musiker extends Person {

	// Instanzvariabeln
	private String pseudonym;
	private String[] instrument, stueck, referenz;

	// Konstruktor#1
	public Musiker(String name, String vorname, String geschlecht,
			String geburtsdatum, String pseudonym, String[] instrument,
			String[] stueck, String[] referenz) {

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, geschlecht, geburtsdatum);

		// Sets
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.stueck = stueck;
		this.referenz = referenz;

		// TODO Auto-generated constructor stub
	}

	// Konstuktor#2
	public Musiker(String name, String vorname, String titel, String vorsatz,
			String zusatz, String geschlecht, String geburtsdatum,
			String todesdatum, String pseudonym, String[] instrument,
			String[] stueck, String[] referenz) {

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, titel, vorsatz, zusatz, geschlecht, geburtsdatum,
				todesdatum);

		// Sets
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.stueck = stueck;
		this.referenz = referenz;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public String[] instrument() {
		return instrument;
	}

	public String[] stueck() {
		return stueck;
	}

	public String[] referenz() {
		return referenz;
	}

	public String toString() {
		String ausgabe = super.getName() + " akA: " + pseudonym
				+ " macht viele Dinge, wie: " + instrument[1]
				+ " in dem stueck " + stueck[0];

		return ausgabe;

	}

}
