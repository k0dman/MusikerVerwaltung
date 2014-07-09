package musikerverwaltung.menschen;

import java.util.Vector;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.Database.DBMethodsArtist;
import musikerverwaltung.Database.DBMethodsBand;

public class Gruppe01 {

	// Instanzvariabeln
	private String bandname, aktiv;
	private String mitglied, ehemalig, bandstueck, bandreferenz;
	private int idband, idmitglied, idbandstueck, idbandreferenz;

	public Gruppe01(String bandname) {
		this.bandname = bandname;
	}

	// Konstruktor
	public Gruppe01(String bandname, String mitglied, String ehemalig,
			String bandstueck, String bandreferenz) {

		// Sets
		this.bandname = bandname;
		this.mitglied = mitglied;
		this.ehemalig = ehemalig;
		this.bandstueck = bandstueck;
		this.bandreferenz = bandreferenz;

	}

	// Konstruktor
	public Gruppe01(String bandname, String mitglied, int idmitglied,
			String bandstueck, String bandreferenz, String aktiv) {

		// Sets
		this.bandname = bandname;
		this.mitglied = mitglied;
		this.idmitglied = idmitglied;
		this.bandstueck = bandstueck;
		this.bandreferenz = bandreferenz;
		this.aktiv = aktiv;

	}

	// Konstruktor
	public Gruppe01(String bandname, String mitglied, int idband,
			int idmitglied, int idbandreferenz, int idbandstueck,
			String bandstueck, String bandreferenz, String aktiv) {

		// Sets
		this.bandname = bandname;
		this.mitglied = mitglied;
		this.idband = idband;
		this.idmitglied = idmitglied;
		this.idbandreferenz = idbandreferenz;
		this.idbandstueck = idbandstueck;
		this.bandstueck = bandstueck;
		this.bandreferenz = bandreferenz;
		this.aktiv = aktiv;

	}

	// Getter //
	public String getBandName() {
		return bandname;
	}

	public int getIDBand() {
		return idband;
	}

	public String getMitglied() {
		return mitglied;
	}

	public int getIDMitglied() {
		return idmitglied;
	}

	public String getEhemalig() {
		return ehemalig;
	}

	public String getBandStueck() {
		return bandstueck;
	}

	public int getIDBandStueckSolo() {
		return idbandstueck;
	}

	public String getBandReferenz() {
		return bandreferenz;
	}

	public int getIDBandReferenz() {
		return idbandreferenz;
	}

	public String getBandAktiv() {
		return aktiv;
	}

	public boolean isAktiv() {
		return Helfer01.toBoolLebt(aktiv);
	}

	public boolean isBand() {
		boolean isband = DBMethodsBand.selectIsBand(getBandName());
		return isband;
	}

	// Aufruf des Selects aus der Datenbank fuer Mitglieder-Liste
	public Vector<Vector<String>> dbSelectMitglieder() {
		Vector<Vector<String>> result = DBMethodsBand
				.dbSelectMitglieder(getBandName());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer Titel-Liste
	public Vector<Vector<String>> dbSelectTitel() {
		Vector<Vector<String>> result = DBMethodsBand
				.dbSelectStueckgruppe(getBandName());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer Titel-Liste
	public Vector<Vector<String>> dbSelectReferenzen() {
		Vector<Vector<String>> result = DBMethodsBand
				.dbSelectGrreferenz(getBandName());
		return result;
	}

	public void insertBand() {
		DBMethodsBand.insertBand(getBandName(), getBandStueck(),
				getBandReferenz(), getIDMitglied(),
				Helfer01.toStringLebt(isAktiv()));
	}

	public void updateBand() {
		DBMethodsBand.updateBand(getBandName(), getIDBandReferenz(),
				getIDBandStueckSolo(), getBandStueck(), getBandReferenz(),
				getIDMitglied(), getIDBand(), getBandAktiv());
	}

	// GET - Methoden um die Daten aus der Datenbank zu holen
	public String getBandAllList() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()));
	}

	public int getBandIDDB() {
		return Integer.parseInt(DBMethodsBand.DBSelectBand(getBandName())
				.get(0));
	}

	public String getBandNameDB() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()).get(1));
	}

	public String getBandMusikerPseudonym() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()).get(2));
	}

	public int getBandIDMusikerDB() {
		return Integer.parseInt(DBMethodsBand.DBSelectBand(getBandName())
				.get(3));
	}

	public String getBandAktivDB() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()).get(4));
	}

	public int getBandIDMitgliedDB() {
		return Integer.parseInt(DBMethodsBand.DBSelectBand(getBandName())
				.get(5));
	}

	public String getBandReferenzDB() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()).get(6));
	}

	public int getBandIDRefenzDB() {
		return Integer.parseInt(DBMethodsBand.DBSelectBand(getBandName())
				.get(7));
	}

	public String getBandStueckDB() {
		return String.valueOf(DBMethodsBand.DBSelectBand(getBandName()).get(8));
	}

	public int getBandIDStueckDB() {
		return Integer.parseInt(DBMethodsBand.DBSelectBand(getBandName())
				.get(9));
	}

	// ID aus der ArrayList ziehen
	public int getBandIDS(String search) {
		return Helfer01.searchID(DBMethodsBand.DBSelectBand(getBandName()),
				search);
	}
	
	//Pruefungsmethoden
	public boolean idProofBandStueck(int id) {
		return Helfer01.idToInt(
				DBMethodsBand.dbSelectStueckgruppeID(getBandName()), id);
	}
	public boolean idProofBandReferenz(int id) {
		return Helfer01.idToInt(
				DBMethodsBand.dbSelectGrReferenzID(getBandName()), id);
	}
}
