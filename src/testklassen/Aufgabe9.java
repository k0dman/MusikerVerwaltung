package testklassen;
import javax.swing.JOptionPane;
import java.util.*;

public class Aufgabe9 {
	// HINZUFUEGEN EINER STELLE FALLS NUR EINE VORHANDEN
	public static String textDatum(String tag, String monat, String jahr) {
		String datum;

		if (tag.length() != 2) {
			tag = "0" + tag;
		}
		if (monat.length() != 2) {
			monat = "0" + monat;
		}

		datum = (tag + "." + monat + "." + jahr);

		return datum;
	}

	// METHODE ZUR UEBERPRUEFUN DES DATUMS AUF KORREKTHEIT
	public static boolean pruefDatum(String tag, String monat, String jahr) {
		// VARS
		boolean pruefdatum = false;
		// REGULAERE AUSDRUECKE FUER PRUEFUNG ANZAHL DER TAGE
		String pruefpattern31 = "((0*[1-9])|([1-2][1-9])|(3[01]))";
		String pruefpattern30 = "((0*[1-9])|([1-2][1-9])|(30))";
		String pruefpattern28 = "((0*[1-9])|(1[1-9])|(2[0-8]))";

		// AKTUELLES JAHR ERMITTELN ZUR JAHRESPRUEFUNG
		Calendar cal = new GregorianCalendar();
		int aktuellesjahr = cal.get(Calendar.YEAR);

		// STRING TO INT
		int monatpruefung = Integer.parseInt(monat);
		int jahrpruefung = Integer.parseInt(jahr);

		if (jahrpruefung >= 1900 && jahrpruefung <= aktuellesjahr) {
			// MONATE MIT 31 TAGEN
			int[] a = { 1, 3, 5, 7, 8, 10, 12 };
			// MONATE MIT 30 TAGEN
			int[] b = { 4, 6, 9, 11 };
			// FEBRUAR
			int c = 2;
			// FOR-SCHLEIFE LAEUFT WIE a-ARRAY INHALT HAT
			for (int i = 0; i < a.length; i++) {
				// PRUEFUNG IN WELCHEM MONTAG MAN SICH BEFINDET

				// 31 TAGE
				if (monatpruefung == a[i])
					pruefdatum = tag.matches(pruefpattern31);

				// 30 TAGE
				else if (i < 4 && monatpruefung == b[i])
					pruefdatum = tag.matches(pruefpattern30);

				// 28 TAGE // ZUSATZ : WIRD "ELSE"
				// STATT "ELSE IF" GESCHRIEBEN, GIBT
				// ES MELDUNG "DEAD CODE" FUER
				// "FOR-SCHLEIFE"
				else if (monatpruefung == c)
					pruefdatum = tag.matches(pruefpattern28);
			}
		}
		return pruefdatum;
	}
	
	//METHODE ZUR PRUEFUNG OB SCHALTJAHR
	public static boolean schaltJahr(int jahr) {
		
		boolean schaltjahr = false;
		
		//Eine Moeglichkeit
		//if (jahr % 4 == 0) schaltjahr = true;
		
		//Loesung nach Fragestellung
		if (new GregorianCalendar().isLeapYear(jahr)) schaltjahr = true;
		
		return schaltjahr;
		
	}

	// MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tag = "", monat = "", jahr = "";
		do {
			// Eingabe des Datums
			String inputValue = JOptionPane.showInputDialog(null,
					"Datum eingeben bitte");

			// Splitten des Datums auf Tag Monat Jahr
			String[] datumTeil = inputValue.split("[.]");
			for (int i = 0; i < datumTeil.length; i++) {
				switch (i) {
				case 0:
					tag = datumTeil[i];
					break;
				case 1:
					monat = datumTeil[i];
					break;
				case 2:
					jahr = datumTeil[i];
				}

			}

			// Methoden-Aufrufe
			schaltJahr(Integer.parseInt(jahr));

			if (pruefDatum(tag, monat, jahr) == true) {

				JOptionPane
						.showMessageDialog(null, textDatum(tag, monat, jahr));
				if (schaltJahr(Integer.parseInt(jahr)))
				JOptionPane.showMessageDialog(null,
						"Es handelt sich um ein Schaltjahr! ;-)");

			} else
				JOptionPane
						.showConfirmDialog(null,
								"Nein Nein, du machst das jetzt so lange bis du es richtig machst !");

		} while (pruefDatum(tag, monat, jahr) == false);

	}
}
