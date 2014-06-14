package musikerverwaltung.hA;

public class Gruppe {

	// Instanzvariabeln
	private String bandname;
	private String[] mitglied, ehemalig, bandstueck, bandreferenz;

	// Konstruktor
	public Gruppe(String bandname, String[] mitglied, String[] ehemalig,
			String[] bandstueck, String[] bandreferenz) {

		// Sets
		this.bandname = bandname;
		this.mitglied = mitglied;
		this.ehemalig = ehemalig;
		this.bandstueck = bandstueck;
		this.bandreferenz = bandreferenz;

	}

	// Getter //
	public String getBandName() {
		return bandname;
	}

	public String[] getMitglied() {
		return mitglied;
	}

	public String[] getEhemalig() {
		return ehemalig;
	}

	public String[] getBandStueck() {
		return bandstueck;
	}

	public String[] getBandReferenz() {
		return bandreferenz;
	}
}
