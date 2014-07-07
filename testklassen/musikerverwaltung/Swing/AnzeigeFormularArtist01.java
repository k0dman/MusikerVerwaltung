package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import musikerverwaltung.menschen.*;

public class AnzeigeFormularArtist01 extends JPanel {

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

	// JPanel
	private JPanel jpmainartist, jpmainright, jpdatum, dodjpdatum,
			geschlechtgruppe;

	// JComoboxBox
	private JComboBox<String> jcbmonat, dodjcbmonat;
	private JComboBox<Integer> jcbtag, jcbjahr, dodjcbtag, dodjcbjahr;

	// String Array fuer die Monatsnamen
	private String[] monatsname = { "Januar", "Februar", "M\u00E4rz", "April",
			"Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };
	private String[] dodmonatsname = { "Januar", "Februar", "M\u00E4rz",
			"April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };

	// JButton
	private JButton jbsubmit;

	// JRadioButton
	private JRadioButton rbmann, rbfrau, rbkeineahnung, jrblebt;

	// Button Group
	private ButtonGroup auswahl;

	// Instanz der Klasse Musiker erzeugen und Pseudonym uebergeben um
	// entsprechenden >SELECT< ausfuehren zu koennen in DB-Methoden
	private Musiker01 musiker;

	public JPanel jpmainDesc(Object artist) {

		// JPanel für linke Seite des JTabbedPane
		JPanel jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// JLabels erzeugen
		ueschrift = new JLabel("Info´s zum Musiker:");
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

		// Instanz erzeugen mit Parameteruebergabe
		musiker = new Musiker01(String.valueOf(artist));

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

		// Ueberschrift setzen
		ueschrift.setFont(ftfield);

		return jpmaindesc;

	}

	public JPanel jpmainInput(Object artist) {

		// Neues JPanel erzeugen, dass mittig angezeigt wird in der JTabbedPane
		JPanel jpmainInput = new JPanel(new GridLayout(13, 1, 1, 10));

		// Lueckenfueller
		fueller = new JLabel("");
		jpmainInput.add(fueller);

		// JTextFields erzeugen
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
		jtfvorname = new JTextField();

		// Instanz erzeugen mit Parameteruebergabe
		musiker = new Musiker01(String.valueOf(artist));

		// Texte setzen die aus der MusikerKlasse-DBKlasse kommen
		jtfvorname.setText(musiker.getMusikerVorname());
		jtfname.setText(musiker.getMusikerName());
		jtftitel.setText(musiker.getMusikerTitel());
		jtfvorsatz.setText(musiker.getMusikerVorsatz());
		jtfzusatz.setText(musiker.getMusikerZusatz());
		jtfpseudonym.setText(musiker.getMusikerPseudonym());
		jtfinstrument.setText(musiker.getMusikerInstrument());
		jtfreferenz.setText(musiker.getMusikerReferenz());
		jtfsolostueck.setText(musiker.getMusikerStueckSolo());

		// JComboBox- Geburtstag - Tag
		jcbtag = new JComboBox<Integer>();
		for (int t = 1; t < 32; t++)
			jcbtag.addItem(new Integer(t));
		jcbtag.setSelectedIndex(musiker.getMusikerGTag() - 1);
		jcbtag.setEditable(false);

		// JComboBox - Geburtstag - Monat
		jcbmonat = new JComboBox<String>(monatsname);
		jcbmonat.setSelectedIndex(musiker.getMusikerGMonat() - 1);
		jcbmonat.setEditable(false);

		// JComboBox - Geburtstag - Jahr
		jcbjahr = new JComboBox<Integer>();
		jcbjahr.setEditable(true);
		int aktjahr = (new GregorianCalendar()).get(Calendar.YEAR);
		for (int j = 0; j <= 100; j++)
			jcbjahr.addItem(new Integer(aktjahr - j));
		jcbjahr.setSelectedIndex(aktjahr - musiker.getMusikerGJahr());

		// JRadio Button ob Musiker gestorben ist
		jrblebt = new JRadioButton("tot");
		jrblebt.setActionCommand("n");

		// LueckenFueller
		fueller = new JLabel("");
		
		// Alles in ein Panel
		jpdatum = new JPanel(new GridLayout(1, 5, 2, 2));
		jpdatum.add(jcbtag);
		jpdatum.add(jcbmonat);
		jpdatum.add(jcbjahr);
		jpdatum.add(fueller);

		// #### Hier if-Abfrage einbauen ob lebt oder nicht ### //

		// JComboBox- Todes - Tag
		dodjcbtag = new JComboBox<Integer>();
		for (int t = 1; t < 32; t++)
			dodjcbtag.addItem(new Integer(t));
		if (musiker.getMusikerLebt().equals("n")) {
			dodjcbtag.setSelectedIndex(musiker.getMusikerTTag() - 1);
		} else {
			dodjcbtag.setSelectedIndex(0);
			dodjcbtag.setEnabled(false);
		}
		dodjcbtag.setEditable(false);

		// JComboBox - Todes - Monat
		dodjcbmonat = new JComboBox<String>(dodmonatsname);
		if (musiker.getMusikerLebt().equals("n")) {
			dodjcbmonat.setSelectedIndex(musiker.getMusikerTMonat() - 1);
		} else {
			dodjcbmonat.setSelectedIndex(0);
			dodjcbmonat.setEnabled(false);
		}
		dodjcbmonat.setEditable(false);

		// JComboBox - Todes - Monat
		dodjcbjahr = new JComboBox<Integer>();
		dodjcbjahr.setEditable(true);
		int dodaktjahr = (new GregorianCalendar()).get(Calendar.YEAR);
		for (int j = 0; j <= 100; j++)
			dodjcbjahr.addItem(new Integer(dodaktjahr - j));
		if (musiker.getMusikerLebt().equals("n")) {
			dodjcbjahr.setSelectedIndex(aktjahr - musiker.getMusikerTJahr());
		} else {
			dodjcbjahr.setSelectedIndex(0);
			dodjcbjahr.setEnabled(false);
		}

		// in ein JPanel einfuegen
		dodjpdatum = new JPanel(new GridLayout(1, 5, 2, 2));
		dodjpdatum.add(dodjcbtag);
		dodjpdatum.add(dodjcbmonat);
		dodjpdatum.add(dodjcbjahr);
		dodjpdatum.add(jrblebt);

		// Pruefung ob m oder w oder ns
		boolean m = false;
		boolean w = false;
		boolean ns = false;

		if (musiker.getMusikerGeschlecht().equals("m"))
			m = true;
		if (musiker.getMusikerGeschlecht().equals("f"))
			w = true;
		if (musiker.getMusikerGeschlecht().equals("ns"))
			ns = true;

		// // JRadioButtons erzeugen und die richtigen RadioButtons
		// vorselektieren
		rbmann = new JRadioButton("Mann", m);
		rbmann.setActionCommand("m");
		rbfrau = new JRadioButton("Frau", w);
		rbfrau.setActionCommand("f");
		rbkeineahnung = new JRadioButton("Keine Ahnung", ns);
		rbkeineahnung.setActionCommand("ns");

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
		jpmainInput.add(jtfname);
		jpmainInput.add(jtfvorname);
		jpmainInput.add(jtftitel);
		jpmainInput.add(jtfvorsatz);
		jpmainInput.add(jtfzusatz);
		jpmainInput.add(geschlechtgruppe);
		jpmainInput.add(jpdatum);

		jpmainInput.add(dodjpdatum);
		jpmainInput.add(jtfpseudonym);
		jpmainInput.add(jtfinstrument);
		jpmainInput.add(jtfsolostueck);
		jpmainInput.add(jtfreferenz);

		// ToolTips hinzuf\u00FCgen
		rbmann.setToolTipText("Ist ihr Interpret ein Mann?");
		rbfrau.setToolTipText("Ist ihr Interpret eine Frau?");
		rbkeineahnung
				.setToolTipText("Ich habe keine Ahnung welches Geschlecht mein K\u00FCnstler hat");
		jcbtag.setToolTipText("W\u00E4hlen Sie den Tag an dem der Interpret geboren wurde!");
		jcbmonat.setToolTipText("W\u00E4hlen Sie den Monat an dem der Interpret geboren wurde!");
		jcbjahr.setToolTipText("W\u00E4hlen Sie das Jahr in dem der Interpret geboren wurde?");

		// Pruefung ob Musiker noch lebt

		dodjcbtag
				.setToolTipText("W\u00E4hlen Sie den Tag an dem der Interpret gestorben ist!");
		dodjcbmonat
				.setToolTipText("W\u00E4hlen Sie den Monat an dem der Interpret gestorben ist!");
		dodjcbjahr
				.setToolTipText("W\u00E4hlen Sie das Jahr in dem der Interpret gestorben ist!");

		jtfname.setToolTipText("Tragen Sie hier bitte den Nachnamen ein");
		jtfvorname.setToolTipText("Tragen Sie hier bitte den Vornamen ein");
		jtftitel.setToolTipText("Tragen Sie hier bitte den Titel ein");
		jtfvorsatz.setToolTipText("Tragen Sie hier bitte den Vorsatz ein");
		jtfzusatz.setToolTipText("Tragen Sie hier bitte den Zusatz ein");
		jtfpseudonym
				.setToolTipText("Tragen Sie hier bitte das Pseudonym/ den K\u00FCnstlernamen ein");
		jtfinstrument
				.setToolTipText("Tragen Sie hier bitte das Instrument ein");
		jtfsolostueck
				.setToolTipText("Tragen Sie hier bitte ein Solost\u00FCck ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einem K\u00FCnstler eintragen");

		return jpmainInput;

	}

	public JPanel jpmainRight() {

		// JPanel erzeugen
		jpmainright = new JPanel(new GridLayout(12, 1, 2, 2));
		jpmainright.setPreferredSize(new Dimension(50, 100));

		// JButton erzeugen
		jbsubmit = new JButton("Bearbeiten");

		// In Arbeit => Groesse des Eintragen-Buttons setzen
		jbsubmit.setPreferredSize(new Dimension(50, 100));

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 11; i++) {
			fueller = new JLabel("");
			jpmainright.add(fueller);
		}

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainright.add(jbsubmit);
		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um den Interpreten zu editieren");
		actionListenerJButton();
		return jpmainright;

	}

	// Methode, die die drei JPanels zusammenfuehrt
	public JPanel jpmainArtist(Object artist) {
		// JPanel erzeugen, dem drei JPanels hinzugefuegt werden
		jpmainartist = new JPanel(new GridLayout(1, 3, 4, 4));

		// hinzufuegen der JPanels
		jpmainartist.add(jpmainDesc(artist));
		jpmainartist.add(jpmainInput(artist));
		jpmainartist.add(jpmainRight());

		return jpmainartist;

	}

	private void actionListenerJButton() {

		jrblebt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Wenn JRB ausgewaehlt, ist lebt != null
				Object lebt = jrblebt.getSelectedObjects();

				if (lebt != null) {
					dodjcbtag.setEnabled(true);
					dodjcbmonat.setEnabled(true);
					dodjcbjahr.setEnabled(true);

				} else {
					dodjcbtag.setEnabled(false);
					dodjcbmonat.setEnabled(false);
					dodjcbjahr.setEnabled(false);
				}
			}
		});

		// Speicher-Button
		jbsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// Arrays erzeugen
				String[] instrument = new String[10];
				instrument[0] = jtfinstrument.getText();
				String[] solostueck = new String[10];
				solostueck[0] = jtfsolostueck.getText();
				String[] referenz = new String[10];
				referenz[0] = jtfreferenz.getText();

				int todestag = musiker.getMusikerTTag();
				int todesmonat = musiker.getMusikerTMonat();
				int todesjahr = musiker.getMusikerTJahr();
				if (jrblebt.getActionCommand() == "n") {
					todestag = Integer.parseInt(String.valueOf(dodjcbtag
							.getSelectedItem()));
					todesmonat = Helfer01.monatUmwandlung(dodjcbmonat
							.getSelectedItem().toString());
					todesjahr = Integer.parseInt(String.valueOf(dodjcbjahr
							.getSelectedItem()));
				}

				// Instanzvar erzeugen - Uebergabe der Parameter/ jrblebt
				Musiker01 musikerbearbeiten = new Musiker01(jtftitel.getText(),
						jtfvorsatz.getText(), jtfvorname.getText(), jtfzusatz
								.getText(), jtfname.getText(), Integer
								.parseInt(String.valueOf(jcbtag
										.getSelectedItem())), Helfer01
								.monatUmwandlung(jcbmonat.getSelectedItem()
										.toString()), Integer.parseInt(String
								.valueOf(jcbjahr.getSelectedItem())), todestag,
						todesmonat, todesjahr, auswahl.getSelection()
								.getActionCommand(),
						jrblebt.getActionCommand(), jtfpseudonym.getText(),
						instrument, solostueck, referenz);

				// Insert-Methode aufrufen
				//musikerbearbeiten.updateArtist(musiker.getMusikerIDPerson(),musiker.getMusikerIDMusiker(), musiker.getMusikerIDInstrument(), musiker.getMusikerIDReferenz(), musiker.getMusikerIDStueckSolo());
			}
		});

	}
}
