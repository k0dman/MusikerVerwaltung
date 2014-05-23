package musikerverwaltung;

import java.awt.*;

import javax.swing.*;

public class EingabeformularArtist02 extends JPanel {

	// Felder:

	// Panels
	private JPanel jpmaindesc, jpmaininput;

	// Schriften:
	private Font ftfield;

	// Labels
	private JLabel ueschrift;
	private JLabel vorname;
	private JLabel name;
	private JLabel titel;
	private JLabel vorsatz;
	private JLabel zusatz;
	private JLabel geschlecht;
	private JPanel geschlechtgruppe;
	private JLabel dob;
	private JLabel dod;
	private JLabel pseudonym;
	private JLabel instrument;
	private JLabel solostueck;
	private JLabel referenz;
	private JLabel fueller;

	// JTextField
	private JTextField jtfueschrift;
	private JTextField jtfvorname;
	private JTextField jtfname;
	private JTextField jtftitel;
	private JTextField jtfvorsatz;
	private JTextField jtfzusatz;
	private JTextField jtfgeschlecht;
	private JTextField jtfdob;
	private JTextField jtfdod;
	private JTextField jtfpseudonym;
	private JTextField jtfinstrument;
	private JTextField jtfsolostueck;
	private JTextField jtfreferenz;

	// JJRadioButton

	private JRadioButton rbmann;
	private JRadioButton rbfrau;
	private JRadioButton rbkeineahnung;

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

		rbmann = new JRadioButton("Mann");
		rbfrau = new JRadioButton("Frau");
		rbkeineahnung = new JRadioButton("Keine Ahnung");

		// JRadioButtons ButtonGroup hinzufuegen

		auswahl = new ButtonGroup();
		auswahl.add(rbmann);
		auswahl.add(rbfrau);
		auswahl.add(rbkeineahnung);
		geschlechtgruppe.add(rbmann);
		geschlechtgruppe.add(rbfrau);
		geschlechtgruppe.add(rbkeineahnung);

		// JTextfields vergoesern

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

		// JTextfield schrift festlegen
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

		// JTextfields hinzufuegen

		jpmaininput.add(jtfname);
		jpmaininput.add(jtfvorname);
		jpmaininput.add(jtftitel);
		jpmaininput.add(jtfvorsatz);
		jpmaininput.add(jtfzusatz);
		jpmaininput.add(geschlechtgruppe);
		jpmaininput.add(jtfdob);
		jpmaininput.add(jtfdod);
		jpmaininput.add(jtfpseudonym);
		jpmaininput.add(jtfinstrument);
		jpmaininput.add(jtfsolostueck);
		jpmaininput.add(jtfreferenz);

		return jpmaininput;

	}

	public JPanel jpmainrechts() {

		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		return jpmaininput;

	}

}
