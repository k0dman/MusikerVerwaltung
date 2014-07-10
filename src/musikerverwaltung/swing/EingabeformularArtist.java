package musikerverwaltung.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import musikerverwaltung.menschen.*;
import javax.swing.*;

public class EingabeformularArtist extends JPanel {

	// Felder:

	// Schriften:
	private Font ftfield;

	// JLabels
	private JLabel ueschrift, vorname, name, titel, vorsatz, zusatz,
			geschlecht, dob, dod, pseudonym, instrument, solostueck, referenz,
			fueller, pflichtfeld;

	// JTextField
	private JTextField jtfvorname, jtfname, jtftitel, jtfvorsatz,
			jtfzusatz, jtfgeschlecht, jtfdob, jtfdod, jtfpseudonym,
			jtfinstrument, jtfsolostueck, jtfreferenz;

	// Deklaration der Auswahlvariablen
	// In den eineckigen Klammern steht, von welchem Typ das Ausgew\u00E4hlte
	// ist.
	private JComboBox<String> jcbmonat, dodjcbmonat;
	private JComboBox<Integer> jcbtag, jcbjahr, dodjcbtag, dodjcbjahr;

	// JPanels daf\u00FCr
	private JPanel jpdatum, dodjpdatum, geschlechtgruppe, jpmainright,
			jpmainartist, jpmaininput;

	// String deklarieren und initialisieren
	private String[] monatsname = { "Januar", "Februar", "M\u00E4rz", "April",
			"Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };
	private String[] dodmonatsname = { "Januar", "Februar", "M\u00E4rz",
			"April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };

	// JButton
	private JButton jbsubmit;

	// Border
	private BorderSet border;

	// JJRadioButton
	private JRadioButton rbmann, rbfrau, rbkeineahnung, jrblebt;

	// ButtonGroup
	private ButtonGroup auswahl;

	public JPanel jpmainDesc() {

		JPanel jpmainDesc = new JPanel(new GridLayout(13, 1, 10, 10));

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
		pseudonym = new JLabel("Pseudonym *");
		instrument = new JLabel("Instrument *");
		solostueck = new JLabel("Stueck **");
		referenz = new JLabel("Referenz *");

		jpmainDesc.add(ueschrift);

		jpmainDesc.add(titel);
		jpmainDesc.add(name);
		jpmainDesc.add(vorname);
		jpmainDesc.add(vorsatz);
		jpmainDesc.add(zusatz);
		jpmainDesc.add(geschlecht);
		jpmainDesc.add(dob);
		jpmainDesc.add(dod);
		jpmainDesc.add(pseudonym);
		jpmainDesc.add(instrument);
		jpmainDesc.add(solostueck);
		jpmainDesc.add(referenz);

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

		return jpmainDesc;

	}

	public JPanel jpmainInput() {

		// JPanel fuer gesamt
		jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		// LueckenFueller
		fueller = new JLabel("");
		jpmaininput.add(fueller);

		// JTextFields erzeugen
		jtftitel = new JTextField();
		jtfname = new JTextField();
		jtfvorname = new JTextField();
		jtfvorsatz = new JTextField();
		jtfzusatz = new JTextField();
		jtfgeschlecht = new JTextField();
		jtfdob = new JTextField();
		jtfdod = new JTextField();
		jtfpseudonym = new JTextField();
		jtfinstrument = new JTextField();
		jtfsolostueck = new JTextField();
		jtfreferenz = new JTextField();

		// Jpanel erzeugen fuer geschlechtgruppe
		geschlechtgruppe = new JPanel();

		// Button erzeugen

		// Erzeugen der Auswahlen
		// Das Jahr sollte editierbar sein, da die angebotene Liste
		// unvollst\u00E4ndig ist, Tag und Monat jedoch nicht.
		jcbmonat = new JComboBox<String>(monatsname);
		jcbmonat.setEditable(false);
		dodjcbmonat = new JComboBox<String>(dodmonatsname);
		dodjcbmonat.setEditable(false);

		// JCB fuer Geburtstag
		jcbtag = new JComboBox<Integer>();
		for (int t = 1; t < 32; t++)
			jcbtag.addItem(new Integer(t));
		jcbtag.setEditable(false);

		// JCB fuer Todestag
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

		// RButton - Lebt oder nicht
		jrblebt = new JRadioButton("lebt");
		jrblebt.setActionCommand("j");

		// LueckenFueller
		fueller = new JLabel("");

		// Alles in ein JPanel
		// GebDatum
		jpdatum = new JPanel(new GridLayout(1, 5, 2, 2));
		jpdatum.add(jcbtag);
		jpdatum.add(jcbmonat);
		jpdatum.add(jcbjahr);
		jpdatum.add(fueller);

		// TodesDatum
		dodjpdatum = new JPanel(new GridLayout(1, 5, 2, 2));
		dodjpdatum.add(dodjcbtag);
		dodjpdatum.add(dodjcbmonat);
		dodjpdatum.add(dodjcbjahr);
		dodjpdatum.add(jrblebt);

		// RButton - Mann
		rbmann = new JRadioButton("Mann");
		rbmann.setActionCommand("m");


		// RButton - Frau
		rbfrau = new JRadioButton("Frau");
		rbfrau.setActionCommand("f");

		// RButton - Keine Ahnung
		rbkeineahnung = new JRadioButton("Keine Ahnung");
		rbkeineahnung.setActionCommand("ns");
		rbkeineahnung.setSelected(true);

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
		jpmaininput.add(jtftitel);
		jpmaininput.add(jtfname);
		jpmaininput.add(jtfvorname);
		jpmaininput.add(jtfvorsatz);
		jpmaininput.add(jtfzusatz);
		jpmaininput.add(geschlechtgruppe);
		jpmaininput.add(jpdatum);
		jpmaininput.add(dodjpdatum);
		jpmaininput.add(jtfpseudonym);
		jpmaininput.add(jtfinstrument);
		jpmaininput.add(jtfsolostueck);
		jpmaininput.add(jtfreferenz);

		// ToolTips hinzuf\u00FCgen
		rbmann.setToolTipText("Ist ihr Interpret ein Mann?");
		rbfrau.setToolTipText("Ist ihr Interpret eine Frau?");
		rbkeineahnung
				.setToolTipText("Ich habe keine Ahnung welches Geschlecht mein K\u00FCnstler hat");
		jcbtag.setToolTipText("W\u00E4hlen Sie den Tag an dem der Interpret geboren wurde!");
		jcbmonat.setToolTipText("W\u00E4hlen Sie den Monat an dem der Interpret geboren wurde!");
		jcbjahr.setToolTipText("W\u00E4hlen Sie das Jahr in dem der Interpret geboren wurde?");
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

		// Border der Mitte hinzufuegen
		border = new BorderSet();
		border.setBorder(jpmaininput, " ");

		return jpmaininput;

	}

	public JPanel jpmainRight() {

		// JPanel erzeugen
		jpmainright = new JPanel(new GridLayout(13, 1, 1, 10));

		// JButton erzeugen
		jbsubmit = new JButton("Eintragen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00FCenf\u00FCller einf\u00FCgen

		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		pflichtfeld = new JLabel("* Pflichtfelder");
		jpmainright.add(pflichtfeld);
		fueller = new JLabel("** Pflichtfeld bei Solok\u00FCnstler");
		jpmainright.add(fueller);


		// JButton dem JPanel hinzuf\u00FCgen
		jpmainright.add(jbsubmit, BorderLayout.SOUTH);
		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um den Interpreten anzulegen");

		// In Arbeit
		jbsubmit.setPreferredSize(new Dimension(0, 0));

		// ActionLister();
		actionListenerJButton();

		return jpmainright;

	}

	public JPanel jpmainArtist() {

		// JPanel, dass alle JPanels zusammenfasst
		jpmainartist = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainartist.add(jpmainDesc());
		jpmainartist.add(jpmainInput());
		jpmainartist.add(jpmainRight());

		// Border hinzufuegen
		border.setBorder(jpmainartist, "");

		return jpmainartist;

	}

	private void actionListenerJButton() {

		// Listener auf JRButton - Wenn ausgewaehlt, wird Auswahl fuer
		// Todesdatum disabled
		jrblebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				// Wenn JRB ausgewaehlt, ist lebt != null
				Object lebt = jrblebt.getSelectedObjects();

				if (lebt != null) {
					dodjcbtag.setEnabled(false);
					dodjcbmonat.setEnabled(false);
					dodjcbjahr.setEnabled(false);
				} else {
					dodjcbtag.setEnabled(true);
					dodjcbmonat.setEnabled(true);
					dodjcbjahr.setEnabled(true);
				}
			}
		});

		// Speicher-Button
		jbsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				String tfpseudonym = jtfpseudonym.getText();
				String tfstuecksolo = jtfsolostueck.getText();
				String tfinstrument = jtfinstrument.getText();
				String tfreferenz = jtfreferenz.getText();
				
				
	
				if (tfreferenz.equals("") ||tfinstrument.equals("") ||tfpseudonym.equals("")) {
					String fehltpseudonym = "";
					
					String fehltreferenz = "";
					String fehltinstrument = "";
						
					if (tfpseudonym.equals("")) {
						fehltpseudonym = "Tragen Sie ein Pseudonym ein! \n\r";

					}

					

					if (tfreferenz.equals("")) {

						fehltreferenz = "Tragen Sie eine Referenz ein! \n\r";
					}

					if (tfinstrument.equals("")) {

						fehltinstrument = "Tragen Sie ein Instrument ein! \n\r";
					}
					
					JOptionPane
							.showMessageDialog(null, fehltpseudonym
									+ fehltreferenz
									+ fehltinstrument);
				}

				else

				{
					// Arrays erzeugen
					String[] instrument = new String[10];
					instrument[0] = jtfinstrument.getText();
					String[] solostueck = new String[10];
					solostueck[0] = jtfsolostueck.getText();
					String[] referenz = new String[10];
					referenz[0] = jtfreferenz.getText();

					// Instanzvar erzeugen - Uebergabe der Parameter/ jrblebt
					Musiker01 musikereintragen = new Musiker01(jtftitel
							.getText(), jtfvorsatz.getText(), jtfvorname
							.getText(), jtfzusatz.getText(), jtfname.getText(),
							Integer.parseInt(String.valueOf(jcbtag
									.getSelectedItem())), Helfer01
									.monatUmwandlung(jcbmonat.getSelectedItem()
											.toString()), Integer
									.parseInt(String.valueOf(jcbjahr
											.getSelectedItem())), Integer
									.parseInt(String.valueOf(dodjcbtag
											.getSelectedItem())), Helfer01
									.monatUmwandlung(dodjcbmonat
											.getSelectedItem().toString()),
							Integer.parseInt(String.valueOf(dodjcbjahr
									.getSelectedItem())), auswahl
									.getSelection().getActionCommand(), jrblebt
									.getActionCommand(),
							jtfpseudonym.getText(), instrument, solostueck,
							referenz);

					// Insert-Methode aufrufen
					musikereintragen.insertArtist();
					jtftitel.setText("");
					jtfname.setText("");
					jtfvorname.setText("");
					jtfvorsatz.setText("");
					jtfzusatz.setText("");
					jtfgeschlecht.setText("");
					jtfdob.setText("");
					jtfdod.setText("");
					jtfpseudonym.setText("");
					jtfinstrument.setText("");
					jtfsolostueck.setText("");
					jtfreferenz.setText("");
				}
			}
		});

	}
}