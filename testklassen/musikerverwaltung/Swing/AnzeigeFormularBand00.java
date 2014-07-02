package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.*;

public class AnzeigeFormularBand00 extends JPanel {

	// Felder:
	private JComboBox<String> jcbmitgliedauswahl;

	// Panel
	private JPanel jpmaininput, jpmaininputedit, jpmaininputtable, jpmainband,
			jpmaindesc, jpmainright, jpehemalig;

	// Schrift:
	private Font ftfield;

	// Label
	private JLabel ueschrift, name, mitglied, ehemalig, stueckgruppe, referenz,
			fueller;

	// JButton
	private JButton jbsubmit;

	// JTextField
	private JTextField jtfname, jtfmitglied, jtfstueckgruppe, jtfreferenz;

	// JRadioButton
	private JRadioButton jrbehemaligja, jrbehemalignein;

	// ButtonGroup
	private ButtonGroup bgehemalig;

	// DefaultTableModel
	private DefaultTableModel dtm;

	// JTable
	private JTable jtband;

	// JScrollPane
	private JScrollPane jsptableband;

	public JPanel jpmainDesc() {

		// Panel erzeugen mit GridLayout
		jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// Label erzeugen
		ueschrift = new JLabel("Tragen Sie eine Band ein:");
		name = new JLabel("Name");
		mitglied = new JLabel("Mitglied");
		ehemalig = new JLabel("Ehemalig");
		stueckgruppe = new JLabel("St\u00FCck");
		referenz = new JLabel("Referenz");

		// Label dem Panel hinzuf\u00FCgen
		jpmaindesc.add(ueschrift);
		jpmaindesc.add(name);
		jpmaindesc.add(stueckgruppe);
		jpmaindesc.add(referenz);
		jpmaindesc.add(ehemalig);
		jpmaindesc.add(mitglied);

		// Label Right anordnen
		ueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		mitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		ehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		stueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		referenz.setHorizontalAlignment(SwingConstants.RIGHT);

		// Schrift dem gew\u00FCnschten Label hinzuf\u00FCgen
		ueschrift.setFont(ftfield);

		return jpmaindesc;

	}

	public JPanel jpmainInput(Object band) {

		// Haupt-JPanel erzeugen mit Gridlayout
		jpmaininput = new JPanel(new GridLayout(2, 1, 1, 1));

		// Zwei UnterJPanels
		jpmaininputedit = new JPanel(new GridLayout(7, 1, 1, 10));
		jpmaininputtable = new JPanel(new GridLayout(1, 1, 1, 1));

		// JLabel erzeugen
		for (int i = 0; i < 1; i++) {
			fueller = new JLabel("");
			jpmaininputedit.add(fueller);
		}

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfmitglied = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();

		// JTextfields verg\u00F6sern
		jtfname.setColumns(10);
		jtfmitglied.setColumns(10);
		jtfstueckgruppe.setColumns(10);
		jtfreferenz.setColumns(10);

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
		jpehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpehemalig.add(jrbehemaligja);
		jpehemalig.add(jrbehemalignein);

		// JTextfields und JRadioButtons hinzuf\u00FCgen
		jpmaininputedit.add(jtfname);
		jpmaininputedit.add(jtfstueckgruppe);
		jpmaininputedit.add(jtfreferenz);
		jpmaininputedit.add(jpehemalig);
		jpmaininputedit.add(jtfmitglied);

		// ToolTips hinzuf\u00FCgen
		jtfname.setToolTipText("Tragen Sie hier bitte den Namen der band ein");
		jtfmitglied
				.setToolTipText("Tragen Sie hier bitte die Bandmitglieder ein");
		jtfstueckgruppe
				.setToolTipText("Tragen Sie hier bitte ein Stueck der Gruppe ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einer Band eintragen");

		// JTable
		// DefaultTableModel erzeugen und die Spaltenanzahl/Zeilenanzahl
		// festlegen
		dtm = new DefaultTableModel(1, 3) {
			// Das Editieren der Zeilen Disablen
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(DBMethods03.COLUMN_IDENTIFIERSTITLES);

		Gruppe01 mitglieder = new Gruppe01(String.valueOf(band));
		// Methodenaufruf und in Variable abgelegt
		Vector<Vector<String>> results;

		results = mitglieder.dbSelectMitglieder();

		dtm.setDataVector(results, DBMethods03.COLUMN_IDENTIFIERSTITLES);

		// Methode
		dtm.fireTableDataChanged();

		jtband = new JTable(dtm);

		jtband.getTableHeader().setReorderingAllowed(false);

		jtband.setCellSelectionEnabled(true);

		ListSelectionModel cellSelectionModel = jtband.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jsptableband = new JScrollPane(jtband);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, auﬂerdem schoener:) //860 , 600
		jsptableband.setPreferredSize(new Dimension(300, 300));

		// Viewport setzen
		jsptableband.setViewportView(jtband);

		jpmaininputtable.add(jsptableband);

		// Hauptpanel die TextFelder und die Table hinzufuegen
		jpmaininput.add(jpmaininputedit);
		jpmaininput.add(jpmaininputtable);

		return jpmaininput;

	}

	public JPanel jpmainRight() {

		// JPanel erzeugen
		jpmainright = new JPanel(new GridLayout(13, 1, 1, 10));

		// JButton erzeugen
		jbsubmit = new JButton("Eintragen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 5; i++) {
			fueller = new JLabel("");
			jpmainright.add(fueller);
		}

		Musiker01 musiker = new Musiker01();

		Vector<String> selectmitglied = musiker.getMusikerArray();

		// Erzeugen der Combobox
		jcbmitgliedauswahl = new JComboBox<String>();
		jcbmitgliedauswahl.setModel(new DefaultComboBoxModel<String>(
				selectmitglied));

		jpmainright.add(jcbmitgliedauswahl);

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 2; i++) {
			fueller = new JLabel("");
			jpmainright.add(fueller);
		}

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainright.add(jbsubmit, BorderLayout.SOUTH);

		// In Arbeit
		jbsubmit.setPreferredSize(new Dimension(0, 0));
		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um die Band anzulegen");

		return jpmainright;

	}

	public JPanel jpmainBand(Object band) {

		jpmainband = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainband.add(jpmainDesc());
		jpmainband.add(jpmainInput(band));
		jpmainband.add(jpmainRight());
		bandActionListener();
		mouseListenerTable();

		return jpmainband;

	}

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
		jtband.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {
					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// In Var die ausgewaehlten Zeilen und Spalten speichern
						int row = jtband.getSelectedRow();
						int column = jtband.getSelectedColumn();
						System.out.println(row);
						// Wenn es sich um die erste Spalte handelt:
						if (column == 0) {

							// Die Werte des ausgewaehlten Feldes in Objecte
							// ablegen
							Object artist = jtband.getValueAt(row, column);
							Object title = jtband.getValueAt(row, column + 1);

							// Die Objecte in Strings casten
							artist = String.valueOf(artist);
							title = String.valueOf(title);
							
							JTabbedPane jtpane = new JTabbedPane();
							jtpmaindesc.jtpmaindesc = jtpmaindesc.jtpmaindesc(null);
							
							// Methodenaufruf um Tab zu adden
							AddTabs02.showArtist(jtpmaindesc.jtpmaindesc, artist);
						}

					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
