package musikerverwaltung.menschen;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/*
 *ES SOLLEN ALLE STATISCHEN METHODEN ENTHALTEN TEXT / PRUEF / SCHALT
 **/
public final class Helfer01 {

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

	public static int searchID(List<String> inputlist, String search) {

		String[] list = inputlist.toArray(new String[inputlist.size()]);

		int id = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i].equals(search))
				id = Integer.parseInt(list[i+1]);
		}

		return id;
	}

	public static boolean toBoolLebt(String lebt) {

		boolean lebendig = false;
		if (lebt.equals("j")) {
			lebendig = false;
		}
		if (lebt.equals("n")) {
			lebendig = true;
		}

		return lebendig;
	}

	public static String toStringLebt(boolean lebt) {

		String lebendig = "";
		if (lebt == true) {
			lebendig = "n";
		}
		if (lebt == false) {
			lebendig = "j";
		}

		return lebendig;
	}

	public static int monatUmwandlung(String monat) {

		int monatszahl = 0;

		switch (monat) {

		case "Januar":
			monatszahl = 1;
			break;
		case "Februar":
			monatszahl = 2;
			break;
		case "M\u00E4rz":
			monatszahl = 3;
			break;
		case "April":
			monatszahl = 4;
			break;
		case "Mai":
			monatszahl = 5;
			break;
		case "Juni":
			monatszahl = 6;
			break;
		case "Juli":
			monatszahl = 7;
			break;
		case "August":
			monatszahl = 8;
			break;
		case "September":
			monatszahl = 9;
			break;
		case "Oktober":
			monatszahl = 10;
			break;
		case "November":
			monatszahl = 11;
			break;
		case "Dezember":
			monatszahl = 12;

		}
		return monatszahl;
	}
}
