package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import musikerverwaltung.Database.DBMethods02;
import musikerverwaltung.Methods.*;
import musikerverwaltung.hA.*;

import javax.swing.*;
import javax.swing.border.*;

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
	private JPanel jpmainRight;

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

	private Border border;

	// JJRadioButton

	private JRadioButton rbmann, rbfrau, rbkeineahnung;

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
		pseudonym = new JLabel("Pseudonym");
		instrument = new JLabel("Instrument");
		solostueck = new JLabel("Stueck");
		referenz = new JLabel("Referenz");

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

		JPanel jpmainInput = new JPanel(new GridLayout(13, 1, 1, 10));

		border = jpmainInput.getBorder();
		Border margin = new LineBorder(Color.LIGHT_GRAY, 2);

		CompoundBorder border1 = new CompoundBorder(border, margin);
		jpmainInput.setBorder(new TitledBorder(border1, "hey"));

		fueller = new JLabel("");
		jpmainInput.add(fueller);

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

		// Jpanel erzeugen

		geschlechtgruppe = new JPanel();

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
		rbmann.setActionCommand("m");
		rbfrau = new JRadioButton("Frau");
		rbfrau.setActionCommand("f");
		rbkeineahnung = new JRadioButton("Keine Ahnung");
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

		jpmainInput.add(jtftitel);
		jpmainInput.add(jtfname);
		jpmainInput.add(jtfvorname);
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
		jpmainRight = new JPanel(new GridLayout(13, 1, 1, 10));

		// JButton erzeugen
		jbsubmit = new JButton("Eintragen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00FCenf\u00FCller einf\u00FCgen
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);
		fueller = new JLabel("");
		jpmainRight.add(fueller);

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainRight.add(jbsubmit, BorderLayout.SOUTH);
		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um den Interpreten anzulegen");

		// In Arbeit
		jbsubmit.setPreferredSize(new Dimension(0, 0));

		// ActionLister();
		actionListenerJButton();

		return jpmainRight;

	}

	public JPanel jpmainArtist() {

		jpmainartist = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainartist.add(jpmainDesc());
		jpmainartist.add(jpmainInput());
		jpmainartist.add(jpmainRight());

		return jpmainartist;

	}

	private void actionListenerJButton() {

		// Button
		jbsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				/*
				 * JOptionPane.showMessageDialog(null,
				 * jcbmonat.getSelectedItem() .toString(), "alert",
				 * JOptionPane.ERROR_MESSAGE);
				 */

				/*
				 * Musiker artistdata = new Musiker(jtftitel .getText(),
				 * jtfvorsatz.getText(), jtfvorname.getText(),
				 * jtfzusatz.getText(), jtfname.getText(), jcbtag
				 * .getSelectedItem().toString(), jcbmonat
				 * .getSelectedItem().toString(), jcbjahr
				 * .getSelectedItem().toString(), dodjcbtag
				 * .getSelectedItem().toString(), dodjcbmonat
				 * .getSelectedItem().toString(), dodjcbjahr
				 * .getSelectedItem().toString(), auswahl
				 * .getSelection().getActionCommand(), jtfpseudonym.getText(),
				 * jtfinstrument.getText(), jtfsolostueck.getText(),
				 * jtfreferenz.getText());
				 * System.out.println(artistdata.toString());
				 * artistdata.insert();
				 */

				/*
				 * // Konstuktor#3 public Musiker( String titel,String vorsatz,
				 * String vorname,String zusatz, String name, int geburtstag,
				 * int geburtsmonat, int geburtsjahr, int todestag, int
				 * todesmonat, int todesjahr, String geschlecht, String
				 * pseudonym, String[] instrument, String[] stuecksolo, String[]
				 * referenz)
				 */
				String[] instrument = new String[10];
				instrument[0] = jtfinstrument.getText();
				String[] solostueck = new String[10];
				solostueck[0] = jtfsolostueck.getText();
				String[] referenz = new String[10];
				referenz[0] = jtfreferenz.getText();
				
				
				Musiker musikereintragen = new Musiker(
						jtftitel.getText(),						
						jtfvorsatz.getText(),
						jtfvorname.getText(),
						jtfzusatz.getText(),
						jtfname.getText(),
						Integer.parseInt(String.valueOf(jcbtag.getSelectedItem())),
						Helfer.monatUmwandlung(jcbmonat.getSelectedItem().toString()),
						Integer.parseInt(String.valueOf(jcbjahr.getSelectedItem())),
						Integer.parseInt(String.valueOf(dodjcbtag.getSelectedItem())),
						Helfer.monatUmwandlung(dodjcbmonat.getSelectedItem().toString()),
						Integer.parseInt(String.valueOf(dodjcbjahr.getSelectedItem())),
						auswahl.getSelection().getActionCommand(),						
						jtfpseudonym.getText(),
						instrument,
						solostueck,
						referenz);

				musikereintragen.insert();
			}
		});

	}
}