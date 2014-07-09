package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.*;

public class AnzeigeFormularArtist02 extends JPanel {

	// Felder:

	// JPanel
	private JPanel jpmainleft, jpmainmiddle, jpmainright, jpmainlefttop,
			jpmainleftmiddle, jpmainleftbottom, jpmainmiddleinstrument,
			jpmainmiddlestueck, jpmainrightreferenz, jpmainrightinsert, jpmainrightinsertbg,
			jpmainrightjb, jpmainartist, jpdatum, dodjpdatum,
			jpgeschlechtgruppe;

	// Schriften:
	private Font ftfield;

	// Labels
	private JLabel jlvorname, jlname, jltitel, jlvorsatz, jlzusatz,
			jlgeschlecht, jldob, jldod, jlpseudonym, jlinstrument,
			jlsolostueck, jlreferenz, jlfueller;

	// JTextField
	private JTextField jtfvorname, jtfname, jtftitel, jtfvorsatz, jtfzusatz,
			jtfpseudonym, jtfinstrument, jtfsolostueck, jtfreferenz, jtfinsert;

	// JComoboxBox
	private JComboBox<String> jcbmonat, dodjcbmonat;
	private JComboBox<Integer> jcbtag, jcbjahr, dodjcbtag, dodjcbjahr;

	// String Array f\u00FCr die Monatsnamen
	private String[] monatsname = { "Januar", "Februar", "M\u00E4rz", "April",
			"Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };
	private String[] dodmonatsname = { "Januar", "Februar", "M\u00E4rz",
			"April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
			"November", "Dezember" };

	// JButton
	private JButton jbsubmit, jbdelete, jbinsert;

	// JRadioButton
	private JRadioButton rbmann, rbfrau, rbkeineahnung, jrblebt, jrbinstrument,
			jrbstuecksolo, jrbreferenz;

	// Button Group
	private ButtonGroup auswahl, bgrinsert;

	// Instanz der Klasse Musiker erzeugen und Pseudonym \u00FCbergeben um
	// entsprechenden >SELECT< ausf\u00FChren zu k\u00F6nnen in DB-Methoden
	private Musiker01 musiker;

	// Border
	private BorderSet border;

	// DefaultTableModel
	private TableModel dtm;

	// JTable
	private JTable jtinstrument, jtstueck, jtreferenz;

	// JScrollPane
	private JScrollPane jspinstrument, jspstueck, jspreferenz;

	// ListeSelectionModel
	private ListSelectionModel cellSelectionModel;

	// String
	private String pseudonym, instrument, solostueck, referenz, instrument1,
			solostueck1, referenz1;

	// int
	private int idinstrument, idinstrument1, idsolostueck, idsolostueck1,
			idreferenz, idreferenz1;

	// MouseListener f\u00FCr Tabellen
	private MouseListenerTable mlt;

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
		jpgeschlechtgruppe = new JPanel(new GridLayout(1, 3, 1, 1));

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

		// Pr\u00FCfung ob m oder w oder ns
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
		rbkeineahnung = new JRadioButton("k.A.", ns);
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

		boolean tot = false;
		if (musiker.getMusikerLebt().equals("n")) {
			tot = true;
		}

		// JRadio Button ob Musiker gestorben ist
		jrblebt = new JRadioButton("tot", tot);

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

		// in ein JPanel einf\u00FCgen
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

		// JTextfield erzeugen und mit Inhalt f\u00FCllen
		jtfpseudonym = new JTextField(musiker.getMusikerPseudonym());
		jtfinstrument = new JTextField(musiker.getMusikerInstrument());
		jtfsolostueck = new JTextField(musiker.getMusikerStueckSolo());
		jtfreferenz = new JTextField(musiker.getMusikerReferenz());

		// Pseudonym
		jpmainleftbottom.add(jlpseudonym);
		jpmainleftbottom.add(jtfpseudonym);
		// Instrument
		jpmainleftbottom.add(jlinstrument);
		jpmainleftbottom.add(jtfinstrument);
		// Solost\u00FCck
		jpmainleftbottom.add(jlsolostueck);
		jpmainleftbottom.add(jtfsolostueck);
		// Referenz
		jpmainleftbottom.add(jlreferenz);
		jpmainleftbottom.add(jtfreferenz);

		pseudonym = jtfpseudonym.getText();

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

		// Hauptpanel f\u00FCr die Linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(3, 1, 1, 1));

		// Zurordnen der beiden JPanel jl und jtf
		jpmainleft.add(jpmainlefttop);
		jpmainleft.add(jpmainleftmiddle);
		jpmainleft.add(jpmainleftbottom);

		// Border setzen
		border.setBorder(jpmainleft, "Info's zum Interpreten");

		return jpmainleft;

	}

	// R\u00FCckgabe-Methode f\u00FCr das Mittlere JPanel
	public JPanel jpmainMiddle(Object artist) {

		jpmainmiddleinstrument = new JPanel(new GridLayout(1, 1, 1, 0));

		// Instanz des TablesModels erzeugen
		dtm = new TableModel();

		// Erzeugung der Tabelle mit DefaultTableModel
		jtinstrument = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSINSTRUMENT,
				musiker.dbSelectInstrument()));

		// Spalten nicht mehr verschiebbar
		jtinstrument.getTableHeader().setReorderingAllowed(false);

		jtinstrument.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtinstrument.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jspinstrument = new JScrollPane(jtinstrument);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, außerdem sch\u00F6ner:) //860 , 600
		jspinstrument.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspinstrument.setViewportView(jtinstrument);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainmiddleinstrument.add(jspinstrument);

		// Border setzen
		border.setBorder(jpmainmiddleinstrument, "Instrumenten-Liste");

		// #### JPANEL f\u00FCr die 2. Tabelle ####//
		jpmainmiddlestueck = new JPanel(new GridLayout(1, 1, 1, 0));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtstueck = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSTITLES,
				musiker.dbSelectStuecksolo()));

		// Spalten nicht mehr verschiebbar
		jtstueck.getTableHeader().setReorderingAllowed(false);

		jtstueck.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtstueck.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jspstueck = new JScrollPane(jtstueck);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, außerdem sch\u00F6ner:) //860 , 600
		jspstueck.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspstueck.setViewportView(jtstueck);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainmiddlestueck.add(jspstueck);

		// Border dem JPanel hinzuf\u00FCgen
		border.setBorder(jpmainmiddlestueck, "Titel-Liste");

		// HauptPanel f\u00FCr die Mitte erzeugen
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
				DBMethods03.COLUMN_IDENTIFIERSREFERENCES,
				musiker.dbSelectReferenz()));

		// Spalten nicht mehr verschiebbar
		jtreferenz.getTableHeader().setReorderingAllowed(false);

		jtreferenz.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtreferenz.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jspreferenz = new JScrollPane(jtreferenz);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, außerdem sch\u00F6ner:) //860 , 600
		jspreferenz.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspreferenz.setViewportView(jtreferenz);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainrightreferenz.add(jspreferenz);

		// Border dem JPanel hinzuf\u00FCgen
		border.setBorder(jpmainrightreferenz, "Referenzen-Liste");

		// JPanel zum einf\u00FCgen f\u00FCr die Inserts
		jpmainrightinsert = new JPanel(new GridLayout(3, 1, 0, 10));
		
		
		// JPanel zum einf\u00FCgen f\u00FCr die Buttongroup
		jpmainrightinsertbg = new JPanel(new GridLayout(1,1,0,10));
		
		// Eingabefeld fuer den insert erzeugen
		
		jtfinsert = new JTextField();
				
		// JRadioButton erzeugen

		jrbstuecksolo = new JRadioButton("St\u00FCck");
		jrbstuecksolo.setActionCommand("ss");

		jrbreferenz = new JRadioButton("Referenz");
		jrbreferenz.setActionCommand("r");

		jrbinstrument = new JRadioButton("Instrument");
		jrbinstrument.setActionCommand("i");

		
		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgrinsert = new ButtonGroup();
		bgrinsert.add(jrbstuecksolo);
		bgrinsert.add(jrbreferenz);
		bgrinsert.add(jrbinstrument);
		
		// ButtonGroup dem JPanel hinzuf\u00FCgen
		jpmainrightinsertbg.add(jrbinstrument);
		jpmainrightinsertbg.add(jrbstuecksolo);
		jpmainrightinsertbg.add(jrbreferenz);

		

		// JButton
		jbinsert = new JButton("Einf\u00FCgen");

		// Alles dem jpmainrightinsert hinzuf\u00FCgen
		jpmainrightinsert.add(jpmainrightinsertbg);
		jpmainrightinsert.add(jtfinsert);
		jpmainrightinsert.add(jbinsert);

		// Border dem JPanel hinzuf\u00FCgen
		border.setBorder(jpmainrightinsert, "Instrument, St\u00FCck oder Referenz hinzuf\u00FCgen");
		
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
		jbdelete = new JButton("L\u00F6schen");

		// In Arbeit => Gr\u00F6sse des Eintragen-Buttons setzen
		jbsubmit.setPreferredSize(new Dimension(50, 100));

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainrightjb.add(jbsubmit);
		jpmainrightjb.add(jbdelete);

		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um den Interpreten zu editieren");

		// HauptPanel f\u00FCr die linke Seite erzeugen
		jpmainright = new JPanel(new GridLayout(3, 1, 1, 1));
		
		jpmainright.add(jpmainrightreferenz);
		jpmainright.add(jpmainrightinsert);
		jpmainright.add(jpmainrightjb);

		return jpmainright;

	}

	// Methode, die die drei JPanels zusammenf\u00FChrt
	public JPanel jpmainArtist(Object artist) {

		// JPanel erzeugen, dem drei JPanels hinzugef\u00FCgt werden
		jpmainartist = new JPanel(new GridLayout(1, 3, 4, 4));

		// hinzuf\u00FCgen der JPanels
		jpmainartist.add(jpmainLeft(artist));
		jpmainartist.add(jpmainMiddle(artist));
		jpmainartist.add(jpmainRight());

		// MouseListener hinzuf\u00FCgen
		mlt = new MouseListenerTable();
		mlt.mouseListenerArtistTables(jtinstrument, jtfinstrument);
		mlt.mouseListenerArtistTables(jtstueck, jtfsolostueck);
		mlt.mouseListenerArtistTableReferenz(jtreferenz, jtfreferenz);

		// Instrument+ID setzen
		instrument = musiker.getMusikerInstrument();
		idinstrument1 = musiker.getMusikerIDS(instrument);

		// Solost\u00FCck+ID setzen
		solostueck = musiker.getMusikerStueckSolo();
		idsolostueck1 = musiker.getMusikerIDS(solostueck);

		// Referenz+ID setzen
		referenz = musiker.getMusikerReferenz();
		idreferenz1 = musiker.getMusikerIDS(referenz);

		// ActionListener hinzuf\u00FCgen
		Listener();

		return jpmainartist;

	}

	private void Listener() {

		jtfinstrument.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				instrument = jtfinstrument.getText();
				idinstrument = musiker.getMusikerIDS(instrument);

				if (musiker.idProofInstrument(idinstrument)) {
					instrument1 = instrument;
					idinstrument1 = musiker.getMusikerIDS(instrument1);
				}

				if (idinstrument == 0)
					idinstrument = idinstrument1;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jtfsolostueck.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

				solostueck = jtfsolostueck.getText();
				idsolostueck = musiker.getMusikerIDS(solostueck);

				if (musiker.idProofSoloStueck(idsolostueck)) {
					solostueck1 = solostueck;
					idsolostueck1 = musiker.getMusikerIDS(solostueck1);
				}

				if (idsolostueck == 0)
					idsolostueck = idsolostueck1;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jtfreferenz.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				referenz = jtfreferenz.getText();

				idreferenz = musiker.getMusikerIDS(referenz);

				if (musiker.idProofReferenz(idreferenz)) {
					referenz1 = referenz;
					idreferenz1 = musiker.getMusikerIDS(referenz1);
				}

				if (idreferenz == 0)
					idreferenz = idreferenz1;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jrblebt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Wenn JRB ausgew\u00E4hlt, ist lebt != null
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

				int todestag = musiker.getMusikerTTag();
				int todesmonat = musiker.getMusikerTMonat();
				int todesjahr = musiker.getMusikerTJahr();

				if (jrblebt.isSelected()) {
					jrblebt.setActionCommand("n");
					todestag = Integer.parseInt(String.valueOf(dodjcbtag
							.getSelectedItem()));
					todesmonat = Helfer01.monatUmwandlung(dodjcbmonat
							.getSelectedItem().toString());
					todesjahr = Integer.parseInt(String.valueOf(dodjcbjahr
							.getSelectedItem()));
				} else {
					jrblebt.setActionCommand("j");
					todestag = 0;
					todesmonat = 0;
					todesjahr = 0;
				}

				if (idsolostueck == 0)
					idsolostueck = idsolostueck1;

				if (idreferenz == 0)
					idreferenz = idreferenz1;

				if (idinstrument == 0)
					idinstrument = idinstrument1;

				// Instanzvar erzeugen - \u00DCbergabe der Parameter/ jrblebt
				musiker = new Musiker01(jtftitel.getText(), jtfvorsatz
						.getText(), jtfvorname.getText(), jtfzusatz.getText(),
						jtfname.getText(), Integer.parseInt(String
								.valueOf(jcbtag.getSelectedItem())), Helfer01
								.monatUmwandlung(jcbmonat.getSelectedItem()
										.toString()), Integer.parseInt(String
								.valueOf(jcbjahr.getSelectedItem())), todestag,
						todesmonat, todesjahr, auswahl.getSelection()
								.getActionCommand(),
						jrblebt.getActionCommand(), pseudonym, idinstrument,
						idsolostueck, idreferenz);

				// Update-Methode aufrufen
				musiker.updateArtist(musiker.getMusikerIDPerson(),
						musiker.getMusikerIDMusiker(), idinstrument,
						idsolostueck, idreferenz, jtfpseudonym.getText(),
						jtfinstrument.getText(), jtfsolostueck.getText(),
						jtfreferenz.getText());
			}
		});

		// delete-Button
		jbdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)

			{
				int auswahl = JOptionPane.showConfirmDialog(null,
						"Willst du diesen Interpreten wirklich l\u00F6schen?",
						"L\u00F6schen", JOptionPane.YES_NO_OPTION);

				if (auswahl == JOptionPane.YES_OPTION) {
					// Delete-Methode aufrufen
					DBMethods03.deleteArtist(musiker.getMusikerIDPerson(),
							musiker.getMusikerIDMusiker());
				}

			}
		});

	}
}
