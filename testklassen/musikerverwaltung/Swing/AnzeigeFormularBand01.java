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
	private JPanel jpmainband, jpmainleft, jpmainmiddle, jpmainright,
			jpmainleftjl, jpmainleftjtf, jpmainleftehemalig,
			jpmainmiddlemitglieder, jpmainmiddletitel, jpmainrightreferenz,
			jpmainrightbuttons;

	// JLabel
	private JLabel jlueschrift, jlname, jlmitglied, jlehemalig, jlstueckgruppe,
			jlreferenz, jlfueller, jlauswahl;

	// JTextField
	private JTextField jtfname, jtfmitglied, jtfstueckgruppe, jtfreferenz;

	// Schrift:
	private Font ftfield;

	// JRadioButton
	private JRadioButton jrbehemaligja, jrbehemalignein;

	// ButtonGroup
	private ButtonGroup bgehemalig;

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
	private JButton jbsubmit, jbdelete;

	// HauptJPanel links
	private JPanel jpmainLeft() {

		// JPanel fuer JLabels
		jpmainleftjl = new JPanel(new GridLayout(12, 1, 1, 15));

		// JLabel erzeugen
		jlueschrift = new JLabel("Tragen Sie eine Band ein: ");
		jlname = new JLabel("Name: ");
		jlmitglied = new JLabel("Mitglied: ");
		jlehemalig = new JLabel("Ehemalig: ");
		jlstueckgruppe = new JLabel("St\u00FCck: ");
		jlreferenz = new JLabel("Referenz: ");
		jlauswahl = new JLabel("Mitglied-Auswahl: ");

		// Label Right anordnen
		jlueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		jlname.setHorizontalAlignment(SwingConstants.RIGHT);
		jlmitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		jlehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		jlstueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		jlreferenz.setHorizontalAlignment(SwingConstants.RIGHT);
		jlauswahl.setHorizontalAlignment(SwingConstants.RIGHT);

		// Label dem Panel hinzuf\u00FCgen
		jpmainleftjl.add(jlueschrift);
		jpmainleftjl.add(jlname);
		jpmainleftjl.add(jlstueckgruppe);
		jpmainleftjl.add(jlreferenz);
		jpmainleftjl.add(jlehemalig);
		jpmainleftjl.add(jlmitglied);
		jpmainleftjl.add(jlauswahl);

		// JPanel fuer JTF´s
		jpmainleftjtf = new JPanel(new GridLayout(12, 1, 1, 15));

		// JLabel erzeugen
		for (int i = 0; i < 1; i++) {
			jlfueller = new JLabel("");
			jpmainleftjtf.add(jlfueller);
		}

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfmitglied = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// JTextfield schrift festlegen
		jtfname.setFont(ftfield);
		jtfmitglied.setFont(ftfield);
		jtfstueckgruppe.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// JRadioButton erzeugen

		jrbehemaligja = new JRadioButton("Ja");
		jrbehemaligja.setActionCommand("j");

		jrbehemalignein = new JRadioButton("Nein");
		jrbehemalignein.setActionCommand("n");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgehemalig = new ButtonGroup();
		bgehemalig.add(jrbehemaligja);
		bgehemalig.add(jrbehemalignein);

		// JPanel fuer die JRadioButtons
		jpmainleftehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpmainleftehemalig.add(jrbehemaligja);
		jpmainleftehemalig.add(jrbehemalignein);

		// Instanz von Musiker erzeugen
		Musiker01 musiker = new Musiker01();

		// Vector-Var um JComboxBox zu fuellen
		Vector<String> selectmitglied = musiker.getMusikerArray();

		// Erzeugen der Combobox
		jcbmitgliedauswahl = new JComboBox<String>();
		jcbmitgliedauswahl.setModel(new DefaultComboBoxModel<String>(
				selectmitglied));

		// JTextfields und JRadioButtons hinzuf\u00FCgen
		jpmainleftjtf.add(jtfname);
		jpmainleftjtf.add(jtfstueckgruppe);
		jpmainleftjtf.add(jtfreferenz);
		jpmainleftjtf.add(jpmainleftehemalig);
		jpmainleftjtf.add(jtfmitglied);
		jpmainleftjtf.add(jcbmitgliedauswahl);

		// ToolTips hinzuf\u00FCgen
		jtfname.setToolTipText("Tragen Sie hier bitte den Namen der band ein");
		jtfmitglied
				.setToolTipText("Tragen Sie hier bitte die Bandmitglieder ein");
		jtfstueckgruppe
				.setToolTipText("Tragen Sie hier bitte ein Stueck der Gruppe ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einer Band eintragen");
		jcbmitgliedauswahl.setToolTipText("Bitte waehle einen Musiker aus");

		// HauptJPanel linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(1, 2, 1, 1));

		// JPanel mit JLabels der HauptPanel der linken Seite zurordnen
		jpmainleft.add(jpmainleftjl);

		// JPanel mit JTF´s der HauptPanel der linken Seite zurordnen
		jpmainleft.add(jpmainleftjtf);

		// Border setzen fuer das linke JPanel
		border = new BorderSet();
		border.setBorder(jpmainleft, "Band-Info's");

		return jpmainleft;
	}

	// HauptJPanel mitte
	private JPanel jpmainMiddle(Object band) {

		jpmainmiddlemitglieder = new JPanel(new GridLayout(1, 1, 1, 0));

		// Instanz des TablesModels erzeugen
		dtm = new TableModel();
		// Instanz der Gruppe erzeugen um Tabelle fuellen zu koennen
		gruppe = new Gruppe01(String.valueOf(band));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandmitglieder = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSMEMBERS,
				gruppe.dbSelectMitglieder()));

		// Spalten nicht mehr verschiebbar
		jtbandmitglieder.getTableHeader().setReorderingAllowed(false);

		jtbandmitglieder.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtbandmitglieder.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspmitglieder = new JScrollPane(jtbandmitglieder);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspmitglieder.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspmitglieder.setViewportView(jtbandmitglieder);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainmiddlemitglieder.add(jspmitglieder);

		// Border setzen
		border.setBorder(jpmainmiddlemitglieder, "Mitglieder-Liste");

		// ######################### Unteres JPanel fuer die //
		// Mitte#############################
		jpmainmiddletitel = new JPanel(new GridLayout(1, 1, 1, 0));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandtitles = new JTable(dtm.dtm(1, 2,
				DBMethods03.COLUMN_IDENTIFIERSTITLES, gruppe.dbSelectTitel()));

		// Spalten nicht mehr verschiebbar
		jtbandtitles.getTableHeader().setReorderingAllowed(false);

		jtbandtitles.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtbandtitles.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jsptitles = new JScrollPane(jtbandtitles);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jsptitles.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jsptitles.setViewportView(jtbandtitles);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainmiddletitel.add(jsptitles);

		// Border dem JPanel hinzufuegen
		border.setBorder(jpmainmiddletitel, "Titel-Liste");

		// HauptJPanel mitte
		jpmainmiddle = new JPanel(new GridLayout(2, 1, 1, 10));

		jpmainmiddle.add(jpmainmiddlemitglieder);
		jpmainmiddle.add(jpmainmiddletitel);

		return jpmainmiddle;
	}

	// HauptJPanel rechts
	private JPanel jpmainRight(Object band) {
		// JPanel für Tabelle mit Referenzen
		jpmainrightreferenz = new JPanel(new GridLayout(1, 1, 1, 1));

		// Erzeugung der Tabelle mit DefaultTableModel
		jtbandreferenzen = new JTable(dtm.dtm(1, 1,
				DBMethods03.COLUMN_IDENTIFIERSREFERENCES,
				gruppe.dbSelectReferenzen()));

		// Spalten nicht mehr verschiebbar
		jtbandreferenzen.getTableHeader().setReorderingAllowed(false);

		jtbandreferenzen.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile moeglich
		cellSelectionModel = jtbandreferenzen.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspreferenzen = new JScrollPane(jtbandreferenzen);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspreferenzen.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jspreferenzen.setViewportView(jtbandreferenzen);

		// JSP mit Mitgliedern und JLabel dem JPanel hinzufuegen
		jpmainrightreferenz.add(jspreferenzen);

		// Border dem JPanel hinzufuegen
		border.setBorder(jpmainrightreferenz, "Referenzen-Liste");

		// ##########################################//
		// JPanel fuer Buttons
		jpmainrightbuttons = new JPanel(new GridLayout(5, 1, 1, 10));

		// JButton erzeugen
		// Bestatigungsbutton
		jbsubmit = new JButton("Bearbeiten");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// Loeschbutton
		jbdelete = new JButton("Löschen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um die Band zubearbeiten");
		jbdelete.setToolTipText("Hier klicken, um die Band zu löschen");

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

		jpmainband.add(jpmainLeft());
		jpmainband.add(jpmainMiddle(band));
		jpmainband.add(jpmainRight(band));
		bandActionListener();
		mouseListenerTable();

		return jpmainband;

	}

	// ActionListener, setzt ausgewaehltes Textfeld nach Auswahl eines Items aus
	// JComboBox
	public void bandActionListener() {
		jcbmitgliedauswahl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Auswahl der aus der JComboBox in var speichern
				String mitglied = String.valueOf(jcbmitgliedauswahl
						.getSelectedItem());

				// das ausgewaehlte Mitglied in das JTextfield einfuegen
				jtfmitglied.setText(mitglied);

			}
		});

	}

	Uebersichtstabelle03 jtpmaindesc = new Uebersichtstabelle03();

	public void mouseListenerTable() {

		// Button fuer die Tabelle
		jtbandmitglieder.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtbandmitglieder.getSelectedRow();
					int column = jtbandmitglieder.getSelectedColumn();
					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object mitglied = jtbandmitglieder.getValueAt(row, column);
					Object title = jtbandmitglieder.getValueAt(row, column + 1);

					title = String.valueOf(title);

					if (e.getClickCount() == 1) {
						jtfmitglied.setText(String.valueOf(mitglied));

					}
					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// Wenn es sich um die erste Spalte handelt:
						if (column == 0) {

							JTabbedPane jtpane = new JTabbedPane();
							jtpmaindesc.jtpmaindesc = jtpmaindesc
									.jtpmaindesc(null);

							// Methodenaufruf um Tab zu adden
							AddTabs02.showArtist(jtpmaindesc.jtpmaindesc,
									mitglied);
						}

					}
				}
			}
		});

		jtbandreferenzen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtbandreferenzen.getSelectedRow();
					int column = jtbandreferenzen.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object referenz = jtbandreferenzen.getValueAt(row, column);

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
		jtbandtitles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtbandtitles.getSelectedRow();
					int column = jtbandtitles.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object titel = jtbandtitles.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtfstueckgruppe.setText(String.valueOf(titel));

					}
				}
			}
		});
	}
}
