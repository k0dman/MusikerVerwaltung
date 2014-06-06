package musikerverwaltung.Methods;

// import java.util.*;

public class EintragenDaten {
	// Titel
	// jpmainInput.add(jtfvorsatz);
	// jpmainInput.add(jtfvorname);
	// jpmainInput.add(jtfzusatz);
	// jpmainInput.add(jtfname);
	// jpmainInput.add(jpdatum);
	// jpmainInput.add(geschlechtgruppe);
	// jpmainInput.add(dodjpdatum);
	// jpmainInput.add(jtfpseudonym);
	// jpmainInput.add(jtfinstrument);
	// jpmainInput.add(jtfsolostueck);
	// jpmainInput.add(jtfreferenz);
	// Klassen-Attribute / variablen mit denen in der KLasse gearbeitet wird
	private String nachname, vorname, geburtstag, geburtsmonat, geburtsjahr,
			todestag, todesmonat, todesjahr, geschlecht, titel, namensvorsatz,
			namenszusatz, pseudonym, instrument, solostueck, referenz;

	// Konstruktor, weisst die Parameter (aus Person) den Klassen-Attributen zu
	public EintragenDaten(String titel, String namensvorsatz, String vorname,
			String namenszusatz, String nachname, String geburtstag,
			String geburtsmonat, String geburtsjahr, String todestag,
			String todesmonat, String todesjahr, String geschlecht,
			String pseudonym, String instrument, String solostueck,
			String referenz) {

		this.titel = titel;
		this.nachname = nachname;
		this.vorname = vorname;
		this.geburtstag = geburtstag;
		this.geburtsmonat = geburtsmonat;
		this.geburtsjahr = geburtsjahr;
		this.todestag = todestag;
		this.todesmonat = todesmonat;
		this.todesjahr = todesjahr;
		this.geschlecht = geschlecht;
		this.titel = titel;
		this.namensvorsatz = namensvorsatz;
		this.namenszusatz = namenszusatz;
		this.pseudonym = pseudonym;
		this.instrument = instrument;
		this.solostueck = solostueck;
		this.referenz = referenz;

	}

	// Namen ausgeben
	public String getTitel() {
		return titel;
	}

	public String getNachname() {
		return nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getGeburtstag() {
		return geburtstag;
	}

	public String getGeburtsmonat() {
		return geburtsmonat;
	}

	public String getGeburtsjahr() {
		return geburtsjahr;
	}

	public String getTodestag() {
		return todestag;
	}

	public String getTodesmonat() {
		return todesmonat;
	}

	public String getTodesjahr() {
		return todesjahr;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public String getNamensvorsatz() {
		return namensvorsatz;
	}

	public String getNamenszusatz() {
		return namenszusatz;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public String getSolostueck() {
		return solostueck;
	}

	public String getInstrument() {
		return instrument;
	}

	public String getReferenz() {
		return referenz;
	}

	// Methode, um die Daten als String auszugeben
	public String toString() {
		return getTitel() + " " + getNamensvorsatz() + " " + getVorname() + " "
				+ getNamenszusatz() + " " + getNachname() + " "
				+ getGeburtstag() + " " + getGeburtsmonat() + " "
				+ getGeburtsjahr() + " " + getTodestag() + " "
				+ getTodesmonat() + " " + getTodesjahr() + " "
				+ getGeschlecht() + " " + getPseudonym() + " "
				+ getInstrument() + " " + getSolostueck() + " " + getReferenz();
	}

}