package musikerverwaltung.Swing;

import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class EingabeformularArtist04 extends JPanel {

	// Felder:

	// Schriften:
	private Font ftfield;

	// Labels
	private JLabel ueschrift, vorname, name, titel, vorsatz, zusatz,
			geschlecht, dob, dod, pseudonym, instrument, solostueck, referenz,
			fueller;

	// JTextField
	private JTextField jtfueschrift, jtfvorname, jtfname, jtftitel, jtfvorsatz,
			jtfzusatz, jtfgeschlecht, jtfdob, jtfdod, jtfpseudonym,
			jtfinstrument, jtfsolostueck, jtfreferenz;

	// JPanel f\u00FCr jpmainartist
	
	private JPanel jpmainartist;
	
	// JPanel f\u00FCr Button
	private JPanel jpmainrechts;

	// Deklaration der Auswahlvariablen
	// In den eineckigen Klammern steht, von welchem Typ das Ausgew\u00E4hlte
	// ist.
	private JComboBox<String> jcbmonat, dodjcbmonat;
	private JComboBox<Integer> jcbtag, jcbjahr, dodjcbtag, dodjcbjahr;

	// Panels daf\u00FCr
	private JPanel jpdatum, dodjpdatum, geschlechtgruppe;

	private String[] monatsname = { "Januar", "Februar", "M\u00E4rz", "April",
			"Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };
	private String[] dodmonatsname = { "Januar", "Februar", "M\u00E4rz",
			"April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };

	// JButton

	private JButton jbsubmit;

	// JJRadioButton

	private JRadioButton rbmann, rbfrau, rbkeineahnung;

	private ButtonGroup auswahl;

	public JPanel jpmaindesc() {

		JPanel jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		ueschrift = new JLabel("Tragen Sie einen Musiker ein:");
		vorname = new JLabel("Vorname");
		name = new JLabel("Name");
		titel = new JLabel("Titel");
		vorsatz = new JLabel("Vorsatz");
		zusatz = new JLabel("Zusatz");
		geschlecht = new JLabel("Geschlecht");
		dob = new JLabel("Geburstdatum");
		dod = new JLabel("Todesdatum");
		pseudonym = new JLabel("Pseudonym");
		instrument = new JLabel("Instrument");
		solostueck = new JLabel("Stueck");
		referenz = new JLabel("Referenz");

		jpmaindesc.add(ueschrift);
		jpmaindesc.add(name);
		jpmaindesc.add(vorname);
		jpmaindesc.add(titel);
		jpmaindesc.add(vorsatz);
		jpmaindesc.add(zusatz);
		jpmaindesc.add(geschlecht);
		jpmaindesc.add(dob);
		jpmaindesc.add(dod);
		jpmaindesc.add(pseudonym);
		jpmaindesc.add(instrument);
		jpmaindesc.add(solostueck);
		jpmaindesc.add(referenz);

		ueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		vorname.setHorizontalAlignment(SwingConstants.RIGHT);
		titel.setHorizontalAlignment(SwingConstants.RIGHT);
		vorsatz.setHorizontalAlignment(SwingConstants.RIGHT);
		zusatz.setHorizontalAlignment(SwingConstants.RIGHT);
		geschlecht.setHorizontalAlignment(SwingConstants.RIGHT);
		dob.setHorizontalAlignment(SwingConstants.RIGHT);
		dod.setHorizontalAlignment(SwingConstants.RIGHT);
		pseudonym.setHorizontalAlignment(SwingConstants.RIGHT);
		instrument.setHorizontalAlignment(SwingConstants.RIGHT);
		solostueck.setHorizontalAlignment(SwingConstants.RIGHT);
		referenz.setHorizontalAlignment(SwingConstants.RIGHT);

		ueschrift.setFont(ftfield);

		return jpmaindesc;

	}

	public JPanel jpmaininput() {

		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		fueller = new JLabel("");
		jpmaininput.add(fueller);

		// JTextFields erzeugen

		jtfvorname = new JTextField();
		jtfname = new JTextField();
		jtftitel = new JTextField();
		jtfvorsatz = new JTextField();
		jtfzusatz = new JTextField();
		jtfgeschlecht = new JTextField();
		geschlechtgruppe = new JPanel();
		jtfdob = new JTextField();
		jtfdod = new JTextField();
		jtfpseudonym = new JTextField();
		jtfinstrument = new JTextField();
		jtfsolostueck = new JTextField();
		jtfreferenz = new JTextField();

		// Button erzeugen

		// Erzeugen der Auswahlen
		// Das Jahr sollte editierbar sein, da die angebotene Liste
		// unvollst\u00E4ndig ist, Tag und Monat jedoch nicht.
		jcbmonat = new JComboBox<String>(monatsname);
		jcbmonat.setEditable(false);
		dodjcbmonat = new JComboBox<String>(dodmonatsname);
		dodjcbmonat.setEditable(false);

		//
		jcbtag = new JComboBox<Integer>();
		for (int t = 1; t < 32; t++)
			jcbtag.addItem(new Integer(t));
		jcbtag.setEditable(false);

		dodjcbtag = new JComboBox<Integer>();
		for (int t = 1; t < 32; t++)
			dodjcbtag.addItem(new Integer(t));
		dodjcbtag.setEditable(false);

		//
		// alle Jahre kann man/frau schlecht vorgeben
		jcbjahr = new JComboBox<Integer>();
		jcbjahr.setEditable(true);
		dodjcbjahr = new JComboBox<Integer>();
		dodjcbjahr.setEditable(true);
		// die letzten hundert Jahre rein
		// dazu aktuelles Jahr ermitteln
		int aktjahr = (new GregorianCalendar()).get(Calendar.YEAR);
		for (int j = 0; j <= 100; j++)
			jcbjahr.addItem(new Integer(aktjahr - j));
		int dodaktjahr = (new GregorianCalendar()).get(Calendar.YEAR);
		for (int j = 0; j <= 100; j++)
			dodjcbjahr.addItem(new Integer(dodaktjahr - j));
		//

		// Alles in ein Panel
		jpdatum = new JPanel();
		jpdatum.add(jcbtag);
		jpdatum.add(jcbmonat);
		jpdatum.add(jcbjahr);
		dodjpdatum = new JPanel();
		dodjpdatum.add(dodjcbtag);
		dodjpdatum.add(dodjcbmonat);
		dodjpdatum.add(dodjcbjahr);

		rbmann = new JRadioButton("Mann");
		rbfrau = new JRadioButton("Frau");
		rbkeineahnung = new JRadioButton("Keine Ahnung");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen

		auswahl = new ButtonGroup();
		auswahl.add(rbmann);
		auswahl.add(rbfrau);
		auswahl.add(rbkeineahnung);
		geschlechtgruppe.add(rbmann);
		geschlechtgruppe.add(rbfrau);
		geschlechtgruppe.add(rbkeineahnung);

		// JTextfields verg\u00F6sern

		jtfname.setColumns(10);
		jtfvorname.setColumns(10);
		jtftitel.setColumns(10);
		jtfvorsatz.setColumns(10);
		jtfzusatz.setColumns(10);

		jtfdob.setColumns(10);
		jtfdod.setColumns(10);
		jtfpseudonym.setColumns(10);
		jtfinstrument.setColumns(10);
		jtfsolostueck.setColumns(10);
		jtfreferenz.setColumns(10);

		// JTextfield Schrift festlegen
		jtfvorname.setFont(ftfield);
		jtfname.setFont(ftfield);
		jtfvorname.setFont(ftfield);
		jtftitel.setFont(ftfield);
		jtfvorsatz.setFont(ftfield);
		jtfzusatz.setFont(ftfield);

		jtfdob.setFont(ftfield);
		jtfdod.setFont(ftfield);
		jtfpseudonym.setFont(ftfield);
		jtfinstrument.setFont(ftfield);
		jtfsolostueck.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// JTextfields hinzuf\u00FCgen

		jpmaininput.add(jtfname);
		jpmaininput.add(jtfvorname);
		jpmaininput.add(jtftitel);
		jpmaininput.add(jtfvorsatz);
		jpmaininput.add(jtfzusatz);
		jpmaininput.add(geschlechtgruppe);
		jpmaininput.add(jpdatum);
		jpmaininput.add(dodjpdatum);
		jpmaininput.add(jtfpseudonym);
		jpmaininput.add(jtfinstrument);
		jpmaininput.add(jtfsolostueck);
		jpmaininput.add(jtfreferenz);

		return jpmaininput;

	}

	public JPanel jpmainrechts() {

		// JPanel erzeugen
		jpmainrechts = new JPanel(new GridLayout(13, 1, 1, 10));

		// JButton erzeugen
		jbsubmit = new JButton("Eintragen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00FCenf\u00FCller einf\u00FCgen
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);
		fueller = new JLabel("");
		jpmainrechts.add(fueller);

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainrechts.add(jbsubmit, BorderLayout.SOUTH);

		// In Arbeit
		jbsubmit.setPreferredSize(new Dimension(0, 0));
		return jpmainrechts;

	}



		public JPanel jpmainartist() {
			
		jpmainartist = new JPanel();
		
		
		jpmainartist.add(jpmaindesc());
		jpmainartist.add(jpmaininput());
		jpmainartist.add(jpmainrechts());
			
		return jpmainartist;
			
			
			
			
			
		}
}