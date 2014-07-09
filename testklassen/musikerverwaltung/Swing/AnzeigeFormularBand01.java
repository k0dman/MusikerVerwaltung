package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.*;

public class AnzeigeFormularBand01 extends JPanel {

	// JPanel
	private JPanel jpmainband, jpmainleft, jpmainleftanzeige, jpmainmiddle,
			jpmainright, jpmainleftjl, jpmainleftjtf, jpmainleftehemalig,
			jpmainmiddlemitglieder, jpmainmiddletitel, jpmainrightreferenz,
			jpmainrightbuttons, jpmainleftinsertbg;

	// JLabel
	private JLabel jlname, jlmitglied, jlehemalig, jlstueckgruppe, jlreferenz,
			jlfueller;

	// JTextField
	private JTextField jtfname, jtfmitglied, jtfstueckgruppe, jtfreferenz,
			jtfinsert;

	// Schrift:
	private Font ftfield;

	// JRadioButton
	private JRadioButton jrbehemaligja, jrbehemalignein, jrbreferenz,
			jrbstueckgruppe, jrbmitglied;

	// ButtonGroup
	private ButtonGroup bgehemalig, bginsert;

	// JComboBox
	private JComboBox<String> jcbmitgliedauswahl;

	// JTable
	private JTable jtbandmitglieder, jtbandtitles, jtbandreferenzen;

	// JScrollPane
	private JScrollPane jspmitglieder, jsptitles, jspreferenzen;

	// Instanz der Gruppe
	private Gruppe01 gruppe;

	// DefaultTableModel
	private TableModel dtm;

	// ListeSelcectionModel
	private ListSelectionModel cellSelectionModel;

	// Border
	private BorderSet border;

	// JButton
	private JButton jbsubmit, jbdelete, jbinsert;

	// InsertJPanel
	private InsertJPanel jpmainleftinsert;

	// int
	private int idband, idbandreferenz, idbandstueck, idbandmitglied;

	// HauptJPanel links
	private JPanel jpmainLeft(Object band) {

		// JPanel f\u00FCr JLabels
		jpmainleftjl = new JPanel(new GridLayout(5, 1, 1, 15));

		// JLabel erzeugen

		jlname = new JLabel("Name: ");
		jlmitglied = new JLabel("Mitglied: ");
		jlehemalig = new JLabel("Ehemalig: ");
		jlstueckgruppe = new JLabel("St\u00FCck: ");
		jlreferenz = new JLabel("Referenz: ");

		// Label Right anordnen

		jlname.setHorizontalAlignment(SwingConstants.RIGHT);
		jlmitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		jlehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		jlstueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		jlreferenz.setHorizontalAlignment(SwingConstants.RIGHT);

		// Label dem Panel hinzuf\u00FCgen

		jpmainleftjl.add(jlname);
		jpmainleftjl.add(jlstueckgruppe);
		jpmainleftjl.add(jlreferenz);
		jpmainleftjl.add(jlehemalig);
		jpmainleftjl.add(jlmitglied);

		// JPanel f\u00FCr JTF¥s
		jpmainleftjtf = new JPanel(new GridLayout(5, 1, 1, 15));

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfname.setText(String.valueOf(band));
		jtfmitglied = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();
		
		//Instanz der Gruppe erzeugen um auf Daten aus der DB zugreifen zu koennen
		gruppe = new Gruppe01(String.valueOf(band));
		
		jtfmitglied.setText(gruppe.getBandNameDB());
		jtfstueckgruppe.setText(gruppe.getBandStueckDB());
		jtfreferenz.setText(gruppe.getBandReferenzDB());
	
		
		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// JTextfield schrift festlegen
		jtfname.setFont(ftfield);
		jtfmitglied.setFont(ftfield);
		jtfstueckgruppe.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// Pr\u00FCfung ob m oder w oder ns
		boolean ja = false;
		boolean nein = false;
		
		
		if (gruppe.isAktiv())
			ja = true;
		else
			nein = true;

		// JRadioButton erzeugen
		jrbehemaligja = new JRadioButton("Ja", ja);
		jrbehemaligja.setActionCommand("j");

		jrbehemalignein = new JRadioButton("Nein", nein);
		jrbehemalignein.setActionCommand("n");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgehemalig = new ButtonGroup();
		bgehemalig.add(jrbehemaligja);
		bgehemalig.add(jrbehemalignein);

		// JPanel f\u00FCr die JRadioButtons
		jpmainleftehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpmainleftehemalig.add(jrbehemaligja);
		jpmainleftehemalig.add(jrbehemalignein);

		// Instanz von Musiker erzeugen
		Musiker01 musiker = new Musiker01();

		// Vector-Var um JComboxBox zu f\u00FCllen
		Vector<String> selectmitglied = musiker.getMusikerArray();

		// Erzeugen der Combobox
		jcbmitgliedauswahl = new JComboBox<String>();
		jcbmitgliedauswahl.setModel(new DefaultComboBoxModel<String>(
				selectmitglied));
		jcbmitgliedauswahl.setToolTipText("Bitte w\u00E4hle einen Musiker aus");
		// JTextfields und JRadioButtons hinzuf\u00FCgen
		jpmainleftjtf.add(jtfname);
		jpmainleftjtf.add(jtfstueckgruppe);
		jpmainleftjtf.add(jtfreferenz);
		jpmainleftjtf.add(jpmainleftehemalig);
		jpmainleftjtf.add(jtfmitglied);

		// ToolTips hinzuf\u00FCgen
		jtfname.setToolTipText("Tragen Sie hier bitte den Namen der band ein");
		jtfmitglied
				.setToolTipText("Tragen Sie hier bitte die Bandmitglieder ein");
		jtfstueckgruppe
				.setToolTipText("Tragen Sie hier bitte ein St\u00FCck der Gruppe ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einer Band eintragen");

		jpmainleftanzeige = new JPanel(new GridLayout(1, 2, 1, 1));
		// HauptJPanel linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(2, 1, 1, 1));

		// JPanel mit JLabels der HauptPanel der linken Seite zurordnen
		jpmainleftanzeige.add(jpmainleftjl);

		// JPanel mit JTF¥s der HauptPanel der linken Seite zurordnen
		jpmainleftanzeige.add(jpmainleftjtf);
		jpmainleft.add(jpmainleftanzeige);
		jpmainleftinsert = new InsertJPanel();

		jpmainleft.add(jpmainleftinsert.insertJPanel(jcbmitgliedauswahl));

		// Border setzen f\u00FCr das linke JPanel
		border = new BorderSet();
		border.setBorder(jpmainleftanzeige, "Band-Info's");

		return jpmainleft;
	}

	// HauptJPanel mitte
	private JPanel jpmainMiddle(Object band) {

		jpmainmiddlemitglieder = new JPanel(new GridLayout(1, 1, 1, 0));

		// Instanz des TablesModels erzeugen
		dtm = new TableModel();
		// Instanz der Gruppe erzeugen um Tabelle f\u00FCllen zu k\u00F6nnen

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandmitglieder = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSMEMBERS,
				gruppe.dbSelectMitglieder()));

		// Spalten nicht mehr verschiebbar
		jtbandmitglieder.getTableHeader().setReorderingAllowed(false);

		jtbandmitglieder.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtbandmitglieder.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jspmitglieder = new JScrollPane(jtbandmitglieder);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, auﬂerdem sch\u00F6ner:) //860 , 600
		jspmitglieder.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspmitglieder.setViewportView(jtbandmitglieder);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainmiddlemitglieder.add(jspmitglieder);

		// Border setzen
		border.setBorder(jpmainmiddlemitglieder, "Mitglieder-Liste");

		// ########### Unteres JPanel f\u00FCr die Mitte############
		// JPanel erzeugen
		jpmainmiddletitel = new JPanel(new GridLayout(1, 1, 1, 0));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandtitles = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSTITLES, gruppe.dbSelectTitel()));

		// Spalten nicht mehr verschiebbar
		jtbandtitles.getTableHeader().setReorderingAllowed(false);

		jtbandtitles.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtbandtitles.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jsptitles = new JScrollPane(jtbandtitles);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, auﬂerdem sch\u00F6ner:) //860 , 600
		jsptitles.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jsptitles.setViewportView(jtbandtitles);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainmiddletitel.add(jsptitles);

		// Border dem JPanel hinzuf\u00FCgen
		border.setBorder(jpmainmiddletitel, "Titel-Liste");

		// HauptJPanel mitte
		jpmainmiddle = new JPanel(new GridLayout(2, 1, 1, 10));

		jpmainmiddle.add(jpmainmiddlemitglieder);
		jpmainmiddle.add(jpmainmiddletitel);

		return jpmainmiddle;
	}

	// HauptJPanel rechts
	private JPanel jpmainRight(Object band) {
		// JPanel f\u00FCr Tabelle mit Referenzen
		jpmainrightreferenz = new JPanel(new GridLayout(1, 1, 1, 1));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandreferenzen = new JTable(dtm.dtm(1, 1,
				DBMethods03.COLUMN_IDENTIFIERSREFERENCES,
				gruppe.dbSelectReferenzen()));

		// Spalten nicht mehr verschiebbar
		jtbandreferenzen.getTableHeader().setReorderingAllowed(false);

		jtbandreferenzen.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jtbandreferenzen.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jspreferenzen = new JScrollPane(jtbandreferenzen);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, auﬂerdem sch\u00F6ner:) //860 , 600
		jspreferenzen.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspreferenzen.setViewportView(jtbandreferenzen);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmainrightreferenz.add(jspreferenzen);

		// Border dem JPanel hinzuf\u00FCgen
		border.setBorder(jpmainrightreferenz, "Referenzen-Liste");

		// ##########################################//
		// JPanel f\u00FCr Buttons
		jpmainrightbuttons = new JPanel(new GridLayout(5, 1, 1, 5));

		// JButton erzeugen

		// Bestatigungsbutton
		jbsubmit = new JButton("Bearbeiten");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00F6schbutton
		jbdelete = new JButton("L\u00F6schen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um die Band zubearbeiten");
		jbdelete.setToolTipText("Hier klicken, um die Band zu l\u00F6schen");

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 3; i++) {
			jlfueller = new JLabel("");
			jpmainrightbuttons.add(jlfueller);
		}
		jpmainrightbuttons.add(jbsubmit);

		jpmainrightbuttons.add(jbdelete);

		jpmainright = new JPanel(new GridLayout(2, 1, 1, 1));
		jpmainright.add(jpmainrightreferenz);
		jpmainright.add(jpmainrightbuttons);

		return jpmainright;
	}

	// zusammenlegen der JPanels
	public JPanel jpmainBand(Object band) {

		jpmainband = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainband.add(jpmainLeft(band));
		jpmainband.add(jpmainMiddle(band));
		jpmainband.add(jpmainRight(band));

		// MouseListener hinzuf\u00FCgen
		MouseListenerTable mlt = new MouseListenerTable();
		mlt.mouseListenerBandMitglieder(jtbandmitglieder, jtfmitglied);
		mlt.mouseListenerBandReferenzen(jtbandreferenzen, jtfreferenz);
		mlt.mouseListenerBandTitel(jtbandtitles, jtfstueckgruppe);

		actionListener();

		return jpmainband;

	}

	public void actionListener() {
		jbsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				gruppe = new Gruppe01(jtfname.getText(), jtfmitglied.getText(),
						idband, idbandmitglied, idbandreferenz, idbandstueck,
						jtfstueckgruppe.getText(), jtfreferenz.getText(),
						bgehemalig.getSelection().getActionCommand());

				System.out.println(gruppe.getBandAllList());
				// gruppe.updateBand();

			}
		});
	}

}
