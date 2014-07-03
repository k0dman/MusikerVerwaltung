package musikerverwaltung.menschen;

import java.util.Vector;

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

	public boolean isBand() {
		boolean isband = DBMethods03.selectIsBand(getBandName());
		return isband;
	}

	// Aufruf des Selects aus der Datenbank fuer Mitglieder-Liste
	public Vector<Vector<String>> dbSelectMitglieder() {
		Vector<Vector<String>> result = DBMethods03.dbSelectMitglieder(getBandName());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer Titel-Liste
	public Vector<Vector<String>> dbSelectTitel() {
		Vector<Vector<String>> result = DBMethods03.dbSelectStueckgruppe(getBandName());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer Titel-Liste
	public Vector<Vector<String>> dbSelectReferenzen() {
		Vector<Vector<String>> result = DBMethods03.dbSelectGrreferenz(getBandName());
		return result;
	}

}
