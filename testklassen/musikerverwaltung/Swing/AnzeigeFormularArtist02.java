package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.*;

public class AnzeigeFormularArtist02 extends JPanel {

	// Felder:

	// JPanel
	private JPanel jpmainleft, jpmainmiddle, jpmainright, jpmainlefttop,
			jpmainleftmiddle, jpmainleftbottom, jpmainmiddleinstrument,
			jpmainmiddlestueck, jpmainrightreferenz, jpmainrightjb,
			jpmainartist, jpdatum, dodjpdatum, jpgeschlechtgruppe,
			jpmainleftperson;

	// Schriften:
	private Font ftfield;

	// Labels
	private JLabel jlueschrift, jlvorname, jlname, jltitel, jlvorsatz,
			jlzusatz, jlgeschlecht, jldob, jldod, jlpseudonym, jlinstrument,
			jlsolostueck, jlreferenz, jlfueller;

	// JTextField
	private JTextField jtfueschrift, jtfvorname, jtfname, jtftitel, jtfvorsatz,
			jtfzusatz, jtfgeschlecht, jtfdob, jtfdod, jtfpseudonym,
			jtfinstrument, jtfsolostueck, jtfreferenz;

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
	private JButton jbsubmit, jbdelete;

	// JRadioButton
	private JRadioButton rbmann, rbfrau, rbkeineahnung, jrblebt;

	// Button Group
	private ButtonGroup auswahl;

	// Instanz der Klasse Musiker erzeugen und Pseudonym uebergeben um
	// entsprechenden >SELECT< ausfuehren zu koennen in DB-Methoden
	private Musiker01 musiker;

	// Border
	private BorderSet border;

	// DefaultTableModel
	private TableModel dtm;

	// JTable
	private JTable jtinstrument, jtstueck, jtreferenz;

	// JScrollPane
	private JScrollPane jspinstrument, jspstueck, jspreferenz;

	private ListSelectionModel cellSelectionModel;

	public JPanel jpmainLeft(Object artist) {

		jpmainlefttop = new JPanel(new GridLayout(6, 2, 1, 1));

		// JLabels erzeugen
		jlvorname = new JLabel("Vorname");
		jlname = new JLabel("Name");
		jltitel = new JLabel("Titel");
		jlvorsatz = new JLabel("Vorsatz");
		jlzusatz = new JLabel("Zusatz");
		jlgeschlecht = new JLabel("Geschlecht");

		// JTextFields erzeugen
		jtfvorname = new JTextField();
		jtfname = new JTextField();
		jtftitel = new JTextField();
		jtfvorsatz = new JTextField();
		jtfzusatz = new JTextField();
		jtfgeschlecht = new JTextField();
		jpgeschlechtgruppe = new JPanel();

		// Vorname
		jpmainlefttop.add(jlvorname);
		jpmainlefttop.add(jtfvorname);
		// Name
		jpmainlefttop.add(jlname);
		jpmainlefttop.add(jtfname);
		// Titel
		jpmainlefttop.add(jltitel);
		jpmainlefttop.add(jtftitel);
		// Vorsatz
		jpmainlefttop.add(jlvorsatz);
		jpmainlefttop.add(jtfvorsatz);
		// Zusatz
		jpmainlefttop.add(jlzusatz);
		jpmainlefttop.add(jtfzusatz);
		// Geschlecht
		jpmainlefttop.add(jlgeschlecht);
		jpmainlefttop.add(jpgeschlechtgruppe);

		// Instanz eines Musikers erzeugen
		musiker = new Musiker01(String.valueOf(artist));

		// Texte setzen die aus der MusikerKlasse-DBKlasse kommen
		jtfvorname.setText(musiker.getMusikerVorname());
		jtfname.setText(musiker.getMusikerName());
		jtftitel.setText(musiker.getMusikerTitel());
		jtfvorsatz.setText(musiker.getMusikerVorsatz());
		jtfzusatz.setText(musiker.getMusikerZusatz());

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
		jpgeschlechtgruppe.add(rbmann);
		jpgeschlechtgruppe.add(rbfrau);
		jpgeschlechtgruppe.add(rbkeineahnung);

		// Border-Instanz erzeugen
		border = new BorderSet();
		border.setBorder(jpmainlefttop, "Personen-Daten");

		// ### Mittleres JPanel der linken Seite ###//
		jpmainleftmiddle = new JPanel();

		// JLabel erzeugen
		jldob = new JLabel("Geburstdatum");
		jldod = new JLabel("Todesdatum");

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

		// Alles in ein Panel
		jpdatum = new JPanel(new GridLayout(1, 3, 2, 2));
		jpdatum.add(jcbtag);
		jpdatum.add(jcbmonat);
		jpdatum.add(jcbjahr);

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
		dodjpdatum = new JPanel(new GridLayout(1, 3, 2, 2));
		dodjpdatum.add(dodjcbtag);
		dodjpdatum.add(dodjcbmonat);
		dodjpdatum.add(dodjcbjahr);

		// Zuordnung zum mittleren Panel der linken Seite
		jpmainleftmiddle.add(jldob);
		jpmainleftmiddle.add(jpdatum);
		jpmainleftmiddle.add(jldod);
		jpmainleftmiddle.add(dodjpdatum);
		jpmainleftmiddle.add(jrblebt);

		// Border setzen
		border.setBorder(jpmainleftmiddle, "Datums-Angaben");

		// ### Unteres JPanel der linken Seite ###//
		jpmainleftbottom = new JPanel(new GridLayout(4, 2, 1, 1));

		// JLabel erzeugen
		jlpseudonym = new JLabel("Pseudonym");
		jlinstrument = new JLabel("Instrument");
		jlsolostueck = new JLabel("Stueck");
		jlreferenz = new JLabel("Referenz");

		// JTextfield erzeugen
		jtfpseudonym = new JTextField();
		jtfinstrument = new JTextField();
		jtfsolostueck = new JTextField();
		jtfreferenz = new JTextField();

		// Pseudonym
		jpmainleftbottom.add(jlpseudonym);
		jpmainleftbottom.add(jtfpseudonym);
		// Instrument
		jpmainleftbottom.add(jlinstrument);
		jpmainleftbottom.add(jtfinstrument);
		// Solostueck
		jpmainleftbottom.add(jlsolostueck);
		jpmainleftbottom.add(jtfsolostueck);
		// Referenz
		jpmainleftbottom.add(jlreferenz);
		jpmainleftbottom.add(jtfreferenz);

		// Texte setzen
		jtfpseudonym.setText(musiker.getMusikerPseudonym());
		jtfinstrument.setText(musiker.getMusikerInstrument());
		jtfreferenz.setText(musiker.getMusikerReferenz());
		jtfsolostueck.setText(musiker.getMusikerStueckSolo());

		// Border setzen
		border.setBorder(jpmainleftbottom, "Interpreten-Daten");

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

		// Hauptpanel fuer die Linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(3, 1, 1, 1));

		// Zurordnen der beiden JPanel jl und jtf
		jpmainleft.add(jpmainlefttop);
		jpmainleft.add(jpmainleftmiddle);
		jpmainleft.add(jpmainleftbottom);

		// Border setzen
		border.setBorder(jpmainleft, "Info's zum Interpreten");

		return jpmainleft;

	}

	// Rueckgabe-Methode fuer das Mittlere JPanel
	public JPanel jpmainMiddle(Object artist) {

		jpmainmiddleinstrument = new JPanel(new GridLayout(1, 1, 1, 0));

		// Instanz des TablesModels erzeugen
		dtm = new TableModel();

		// Erzeugung der Tabelle mit DefaultTableModel
		jtinstrument = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSINSTRUMENT, musiker.dbSelectInstrument()));

		// Spalten nicht mehr verschiebbar
		jtinstrument.getTableHeader().setReorderingAllowed(false);

		jtinstrument.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtinstrument.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspinstrument = new JScrollPane(jtinstrument);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspinstrument.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspinstrument.setViewportView(jtinstrument);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainmiddleinstrument.add(jspinstrument);

		// Border setzen
		border.setBorder(jpmainmiddleinstrument, "Instrumenten-Liste");

		// #### JPANEL fuer die 2. Tabelle ####//
		jpmainmiddlestueck = new JPanel(new GridLayout(1, 1, 1, 0));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtstueck = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSTITLES, musiker.dbSelectStuecksolo()));

		// Spalten nicht mehr verschiebbar
		jtstueck.getTableHeader().setReorderingAllowed(false);

		jtstueck.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtstueck.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspstueck = new JScrollPane(jtstueck);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspstueck.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspstueck.setViewportView(jtstueck);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainmiddlestueck.add(jspstueck);

		// Border dem JPanel hinzufuegen
		border.setBorder(jpmainmiddlestueck, "Titel-Liste");

		// HauptPanel fuer die Mitte erzeugen
		jpmainmiddle = new JPanel(new GridLayout(2, 1, 1, 1));

		// Dem Hauptpanel die JSP zuordnen
		jpmainmiddle.add(jpmainmiddleinstrument);
		jpmainmiddle.add(jpmainmiddlestueck);

		return jpmainmiddle;

	}

	public JPanel jpmainRight() {
		jpmainrightreferenz = new JPanel(new GridLayout(1, 1, 1, 0));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtreferenz = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSREFERENCES, musiker.dbSelectReferenz()));

		// Spalten nicht mehr verschiebbar
		jtreferenz.getTableHeader().setReorderingAllowed(false);

		jtreferenz.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtreferenz.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspreferenz = new JScrollPane(jtreferenz);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspreferenz.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspreferenz.setViewportView(jtreferenz);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainrightreferenz.add(jspreferenz);

		// Border dem JPanel hinzufuegen
		border.setBorder(jpmainrightreferenz, "Referenzen-Liste");

		// ###Unteres JPanel rechts### //
		// JPanel erzeugen
		jpmainrightjb = new JPanel(new GridLayout(5, 1, 1, 10));

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 3; i++) {
			jlfueller = new JLabel("");
			jpmainrightjb.add(jlfueller);
		}

		// JButtons
		jbsubmit = new JButton("Bearbeiten");
		jbdelete = new JButton("Löschen");

		// In Arbeit => Groesse des Eintragen-Buttons setzen
		jbsubmit.setPreferredSize(new Dimension(50, 100));

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainrightjb.add(jbdelete);
		jpmainrightjb.add(jbsubmit);

		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um den Interpreten zu editieren");

		// HauptPanel fuer die linke Seite erzeugen
		jpmainright = new JPanel(new GridLayout(2, 1, 1, 1));
		jpmainright.add(jpmainrightreferenz);
		jpmainright.add(jpmainrightjb);

		return jpmainright;

	}

	// Methode, die die drei JPanels zusammenfuehrt
	public JPanel jpmainArtist(Object artist) {

		// JPanel erzeugen, dem drei JPanels hinzugefuegt werden
		jpmainartist = new JPanel(new GridLayout(1, 3, 4, 4));

		// hinzufuegen der JPanels
		jpmainartist.add(jpmainLeft(artist));
		jpmainartist.add(jpmainMiddle(artist));
		jpmainartist.add(jpmainRight());

		// Listener hinzufuegen
		actionListenerJButton();
		
		

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
		
		jtreferenz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtreferenz.getSelectedRow();
					int column = jtreferenz.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object referenz = jtreferenz.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtfreferenz.setText(String.valueOf(referenz));
					}

					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// Browseraufruf (für Windows):
						try {
							Runtime.getRuntime().exec(
									"cmd.exe /c start " + referenz);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}
		});
		jtstueck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtstueck.getSelectedRow();
					int column = jtstueck.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object titel = jtstueck.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtfsolostueck.setText(String.valueOf(titel));

					}
				}
			}
		});
		jtinstrument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtinstrument.getSelectedRow();
					int column = jtinstrument.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object titel = jtinstrument.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtfinstrument.setText(String.valueOf(titel));

					}
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
				musikerbearbeiten.updateArtist(musiker.getMusikerID());
			}
		});

	}
}
