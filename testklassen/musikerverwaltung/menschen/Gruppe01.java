package musikerverwaltung.menschen;

import musikerverwaltung.Database.DBMethods03;

public class Gruppe01 {

	// Instanzvariabeln
	private String bandname;
	private String[] mitglied, ehemalig, bandstueck, bandreferenz;

	public Gruppe01(String bandname) {
		this.bandname = bandname;
	}

	// Konstruktor
	public Gruppe01(String bandname, String[] mitglied, String[] ehemalig,
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
	
	public boolean isBand(){
		boolean isband = DBMethods03.selectIsBand(getBandName());
		return isband;
	}
}
