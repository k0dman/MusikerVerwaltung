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

public class AnzeigeFormularBand01 extends JPanel {

	// JPanel
	private JPanel jpmainband, jpmainleft, jpmainmiddle, jpmainright,
			jpmainleftjl, jpmainleftjtf, jpmainleftehemalig;

	// JLabel
	private JLabel jlueschrift, jlname, jlmitglied, jlehemalig, jlstueckgruppe, jlreferenz,
			jlfueller, jlauswahl;
	
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
		private JTable jtbandmitglieder, jtbandtitles;
		
		// JScrollPane
		private JScrollPane jspmitglieder, jsptitles;

	// HauptJPanel links
	private JPanel jpmainLeft() {

		// JPanel fuer JLabels
		jpmainleftjl = new JPanel(new GridLayout(12,1,1,15));

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
		
		
		// JPanel fuer JTF¥s
		jpmainleftjtf = new JPanel(new GridLayout(12,1,1,15));
		
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
		
		jtfname.setMaximumSize(new Dimension(10,10));

		// JTextfields verg\u00F6sern
		//jtfname.setColumns(7);
		//jtfmitglied.setColumns(7);
		//jtfstueckgruppe.setColumns(7);
		//jtfreferenz.setColumns(7);

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
				
				//Instanz von Musiker erzeugen
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
		
		
		//HauptJPanel linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(1,2,1,1));
		
		jpmainleft.add(jpmainleftjl);
		jpmainleft.add(jpmainleftjtf);
		
		return jpmainleft;
	}

	// HauptJPanel mitte
	private JPanel jpmainMiddle(Object band) {
		
		//Instanz des TablesModels erzeugen
		TableModel dtm = new TableModel();
		//Instanz der Gruppe erzeugen um Tabelle fuellen zu koennen
		Gruppe01 mitglieder = new Gruppe01(String.valueOf(band));
		
		//Erzeugung der Tabelle mit DefaultTableModel
		jtbandmitglieder = new JTable(dtm.dtm(1,2 , DBMethods03.COLUMN_IDENTIFIERSTITLES, mitglieder.dbSelectMitglieder()));
		
		//Spalten nicht mehr verschiebbar
		jtbandmitglieder.getTableHeader().setReorderingAllowed(false);

		jtbandmitglieder.setCellSelectionEnabled(true);
		
		//Nur auswahl einer Zeile moeglich
		ListSelectionModel cellSelectionModel = jtbandmitglieder.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzufuegen
		jspmitglieder = new JScrollPane(jtbandmitglieder);

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, auﬂerdem schoener:) //860 , 600
		jspmitglieder.setPreferredSize(new Dimension(300, 300));

		// Viewport setzen
		jspmitglieder.setViewportView(jtbandmitglieder);

		
		//HauptJPanel mitte
		jpmainmiddle = new JPanel();
		
		jpmainmiddle.add(jspmitglieder);
		
		return jpmainmiddle;
	}

	// HauptJPanel rechts
	private JPanel jpmainRight() {
		jpmainright = new JPanel();
		return jpmainright;
	}

	// zusammenlegen der JPanels
	public JPanel jpmainBand(Object band) {

		jpmainband = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainband.add(jpmainLeft());
		jpmainband.add(jpmainMiddle(band));
		jpmainband.add(jpmainRight());
		bandActionListener();
		//mouseListenerTable();

		return jpmainband;

	}
	
	// ActionListener, setzt ausgewaehltes Textfeld nach Auswahl eines Items aus JComboBox
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
	/*
	Uebersichtstabelle03 jtpmaindesc = new Uebersichtstabelle03();

	public void mouseListenerTable() {

		// Button fuer die Tabelle
		jtbandmitglieder.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {
					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// In Var die ausgewaehlten Zeilen und Spalten speichern
						int row = jtbandmitglieder.getSelectedRow();
						int column = jtbandmitglieder.getSelectedColumn();
						System.out.println(row);
						// Wenn es sich um die erste Spalte handelt:
						if (column == 0) {

							// Die Werte des ausgewaehlten Feldes in Objecte
							// ablegen
							Object artist = jtbandmitglieder.getValueAt(row, column);
							Object title = jtbandmitglieder.getValueAt(row, column + 1);

							// Die Objecte in Strings casten
							artist = String.valueOf(artist);
							title = String.valueOf(title);

							JTabbedPane jtpane = new JTabbedPane();
							jtpmaindesc.jtpmaindesc = jtpmaindesc
									.jtpmaindesc(null);

							// Methodenaufruf um Tab zu adden
							AddTabs02.showArtist(jtpmaindesc.jtpmaindesc,
									artist);
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
	}*/
}
