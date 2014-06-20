package musikerverwaltung.hA;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 *ES SOLLEN ALLE STATISCHEN METHODEN ENTHALTEN TEXT / PRUEF / SCHALT
 **/
public final class Helfer {

	// METHODE ZUR UEBERPRUEFUN DES DATUMS AUF KORREKTHEIT
	public static final boolean pruefDatum(int tag, int monat, int jahr) {
		// VARS
		boolean pruefdatum = false;
		// REGULAERE AUSDRUECKE FUER PRUEFUNG ANZAHL DER TAGE
		String pruefpattern31 = "((0*[1-9])|([1-2][0-9])|(3[01]))";
		String pruefpattern30 = "((0*[1-9])|([1-2][0-9])|(30))";
		String pruefpattern28 = "((0*[1-9])|(1[0-9])|(2[0-8]))";

		// AKTUELLES JAHR ERMITTELN ZUR JAHRESPRUEFUNG
		Calendar cal = new GregorianCalendar();
		int aktuellesjahr = cal.get(Calendar.YEAR);

		// tag in String casten um RegEx anwenden zu koennen
		String tagpruef = String.valueOf(tag);

		if (jahr >= 1900 && jahr <= aktuellesjahr) {
			// MONATE MIT 31 TAGEN
			int[] a = { 1, 3, 5, 7, 8, 10, 12 };
			// MONATE MIT 30 TAGEN
			int[] b = { 4, 6, 9, 11 };
			// FEBRUAR
			int c = 2;
			// FOR-SCHLEIFE LAEUFT WIE a-ARRAY INHALT HAT
			for (int i = 0; i < a.length; i++) {
				// PRUEFUNG IN WELCHEM MONAT MAN SICH BEFINDET

				// 31 TAGE
				if (monat == a[i])
					pruefdatum = tagpruef.matches(pruefpattern31);

				// 30 TAGE
				else if (i < 4 && monat == b[i])
					pruefdatum = tagpruef.matches(pruefpattern30);

				// 28 TAGE // ZUSATZ : WIRD "ELSE"
				// STATT "ELSE IF" GESCHRIEBEN, GIBT
				// ES MELDUNG "DEAD CODE" FUER
				// "FOR-SCHLEIFE"
				else if (monat == c)
					pruefdatum = tagpruef.matches(pruefpattern28);
			}
		}
		return pruefdatum;
	}

	// METHODE ZUR PRUEFUNG OB SCHALTJAHR
	public static final boolean schaltJahr(int jahr) {

		boolean schaltjahr = false;

		// Eine Moeglichkeit
		// if (jahr % 4 == 0) schaltjahr = true;

		// Loesung nach Fragestellung
		if (new GregorianCalendar().isLeapYear(jahr))
			schaltjahr = true;

		return schaltjahr;

	}

	// HINZUFUEGEN EINER STELLE FALLS NUR EINE VORHANDEN
	public static final String textDatum(int tag, int monat, int jahr) {
		String datum;
		String tag1 = "";
		String monat1 = "";
		if (tag < 10) {
			tag1 = "0" + tag;
		}
		if (monat < 10) {
			monat1 = "0" + monat;
		}

		datum = (tag1 + "." + monat1 + "." + jahr);

		return datum;
	}
	
	// Switch Mehtode zum Ab�ndern von String to int bei Monaten

	public int monatUmwandlung (String monat){
		
	int monatzahl = 0;
	
	return monatzahl;
		
	}
	
}
