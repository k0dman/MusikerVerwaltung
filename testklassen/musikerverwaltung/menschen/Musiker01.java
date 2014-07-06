package musikerverwaltung.menschen;

import java.util.Vector;

import musikerverwaltung.Database.DBMethods03;

public class Musiker01 extends Person01 {

	// Instanzvariabeln
	private String pseudonym;
	private String[] instrument, stuecksolo, referenz;

	public Musiker01() {

	}

	public Musiker01(String pseudonym) {

		this.pseudonym = pseudonym;

	}

	// Konstruktor#1
	public Musiker01(String name, String vorname, String geschlecht,
			String geburtsdatum, String pseudonym, String[] instrument,
			String[] stuecksolo, String[] referenz) {
		// TODO Auto-generated constructor stub

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, geschlecht, geburtsdatum);

		// Sets
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.stuecksolo = stuecksolo;
		this.referenz = referenz;

	}

	// Konstuktor#2
	public Musiker01(String titel, String vorsatz, String vorname,
			String zusatz, String name, String geburtsdatum, String geschlecht,
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
	public Musiker01(String titel, String vorsatz, String vorname,
			String zusatz, String name, int geburtstag, int geburtsmonat,
			int geburtsjahr, int todestag, int todesmonat, int todesjahr,
			String geschlecht, String lebt, String pseudonym,
			String[] instrument, String[] stuecksolo, String[] referenz) {

		// Aufruf des Konstruktors der Basis-Klasse
		super(name, vorname, titel, vorsatz, zusatz, geschlecht, lebt,
				geburtstag, geburtsmonat, geburtsjahr, todestag, todesmonat,
				todesjahr);

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

	public void insertArtist() {
		DBMethods03.insertArtist(super.getTitel(), super.getVorsatz(),
				super.getVorname(), super.getZusatz(), super.getName(),
				super.getGeburtsTag(), super.getGeburtsMonat(),
				super.getGeburtsJahr(), super.getTodesTag(),
				super.getTodesMonat(), super.getTodesJahr(),
				super.getGeschlecht(), super.isTot(), getPseudonym(),
				getInstrument()[0], getStueckSolo()[0], getReferenz()[0]);
	}

	public void updateArtist(int idperson, int idmusiker, int idinstrument,
			int idreferenz, int idstuecksolo) {
	
		DBMethods03.updateArtist(idperson, idmusiker, idinstrument,
				idreferenz, idstuecksolo, super.getTitel(),
				super.getVorsatz(), super.getVorname(), super.getZusatz(),
				super.getName(), super.getGeburtsTag(),
				super.getGeburtsMonat(), super.getGeburtsJahr(),
				super.getTodesTag(), super.getTodesMonat(),
				super.getTodesJahr(), super.getGeschlecht(), super.isTot(),
				getPseudonym(), getInstrument()[0], getStueckSolo()[0],
				getReferenz()[0]);
	}

	public Vector<Vector<String>> selectLibary(String keyword) {
		Vector<Vector<String>> result = DBMethods03.dbSearch(keyword);
		return result;

	}

	// Aufruf des Selects aus der Datenbank fuer Uebersichtstabelle
	public Vector<Vector<String>> dbSelect() {
		Vector<Vector<String>> result = DBMethods03.dbSelectTable();
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer stuecksolo
	public Vector<Vector<String>> dbSelectStuecksolo() {
		Vector<Vector<String>> result = DBMethods03
				.dbSelectStuecksolo(getPseudonym());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer refernz
	public Vector<Vector<String>> dbSelectReferenz() {
		Vector<Vector<String>> result = DBMethods03
				.dbSelectReferenz(getPseudonym());
		return result;
	}

	// Aufruf des Selects aus der Datenbank fuer refernz
	public Vector<Vector<String>> dbSelectInstrument() {
		Vector<Vector<String>> result = DBMethods03
				.dbSelectInstrument(getPseudonym());
		return result;
	}

	// Aufruf des Selects der Musiker mit Pseudonyme fuer Bandeintragen
	public Vector<String> getMusikerArray() {
		Vector<String> musiker = DBMethods03.dbSelectPseudonym();
		return musiker;
	}

	// GET - Methoden um die Daten aus der Datenbank zu holen
	public String getMusiker() {

		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym()));

	}

	public int getMusikerIDPerson() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				0));
	}

	public String getMusikerName() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(1));
	}

	public String getMusikerVorname() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(2));
	}

	public String getMusikerTitel() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(3));
	}

	public String getMusikerVorsatz() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(4));
	}

	public String getMusikerZusatz() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(5));
	}

	public String getMusikerGeschlecht() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(6));
	}

	public String getMusikerLebt() {
		return String
				.valueOf(DBMethods03.DBSelectArtist(getPseudonym()).get(7));
	}

	public int getMusikerGTag() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				8));
	}

	public int getMusikerGMonat() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				9));
	}

	public int getMusikerGJahr() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				10));
	}

	public int getMusikerTTag() {
		return Integer.parseInt((DBMethods03.DBSelectArtist(getPseudonym())
				.get(11)));
	}

	public int getMusikerTMonat() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				12));
	}

	public int getMusikerTJahr() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				13));
	}

	public String getMusikerPseudonym() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym())
				.get(14));
	}

	public String getMusikerReferenz() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym())
				.get(15));
	}

	public int getMusikerIDReferenz() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				16));
	}

	public String getMusikerStueckSolo() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym())
				.get(17));
	}

	public int getMusikerIDStueckSolo() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				18));
	}

	public String getMusikerInstrument() {
		return String.valueOf(DBMethods03.DBSelectArtist(getPseudonym())
				.get(19));
	}

	public int getMusikerIDInstrument() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				20));
	}

	public int getMusikerIDMusiker() {
		return Integer.parseInt(DBMethods03.DBSelectArtist(getPseudonym()).get(
				21));
	}

	public int getMusikerIDS(String search) {
		return Helfer01.searchID(DBMethods03.DBSelectArtist(getPseudonym()),
				search);

	}

}
