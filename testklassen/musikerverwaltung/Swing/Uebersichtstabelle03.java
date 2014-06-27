package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import musikerverwaltung.Database.*;
import musikerverwaltung.Graphics.Icons01;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.InsetsUIResource;

import musikerverwaltung.menschen.*;

public class Uebersichtstabelle03 extends JTabbedPane {

	// Felder:

	// JTable
	public JTable jtmaintable;

	// DefaultTableModel
	private DefaultTableModel dtm;

	// JTabbedPane
	public JTabbedPane jtpmaindesc;

	// JScrollPane
	private JScrollPane jspmaintable;

	// Schrift:
	private Font ftfield;

	// String
	public String name;
	Musiker01 result = new Musiker01();

	public JTabbedPane jtpmaindesc() {

		// DefaultTableModel erzeugen und die Spaltenanzahl/Zeilenanzahl
		// festlegen
		dtm = new DefaultTableModel(1, 3) {
			// Das Editieren der Zeilen Disablen
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(DBMethods03.COLUMN_IDENTIFIERS);

		// #############################//
		// Methodenaufruf und in Variable abgelegt
		Vector<Vector<String>> results = result.dbSelect();
		//
		dtm.setDataVector(results, DBMethods03.COLUMN_IDENTIFIERS);

		// Methode
		dtm.fireTableDataChanged();
		// #############################//

		// JTable erzeugen
		jtmaintable = new JTable(dtm);
		System.out.println(jtmaintable.getRowCount());
		System.out.println(jtmaintable.getColumnCount());

		jtmaintable.getTableHeader().setReorderingAllowed(false);

		jtmaintable.setCellSelectionEnabled(true);

		ListSelectionModel cellSelectionModel = jtmaintable.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// JTable der JScrollPane hinzufuegen
		jspmaintable = new JScrollPane(jtmaintable);

		// JScrollPane der JTabbedPane hinzufuegen

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, auﬂerdem schoener:) //860 , 600
		jspmaintable.setPreferredSize(new Dimension(860, 600));

		// Viewport setzen
		jspmaintable.setViewportView(jtmaintable);

		// Icons aus Icon-Klasse holen
		Icons01 tabicons = new Icons01();

		// Panel erzeugen mit GridLayout
		jtpmaindesc = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);

		// Hinzufuegen der JScrollPane zur JTabbedPane
		jtpmaindesc.addTab("Libary", tabicons.icons[0], jspmaintable);
		jtpmaindesc.setBackground(new Color(201, 201, 201));

		UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(2,
				10, 3, 10));
		jtpmaindesc.updateUI();

		// Aufruf der MouseListener aus der JTable-Klasse (Evtl. wieder
		// zurueckpacken)
		mouseListenerTable();
		changeListenerTable();
		return jtpmaindesc;

	}

	// ChangeListener zur Aktualisierung der Tabelle beim Oeffnen des
	// Library-Tabs
	public void changeListenerTable() {
		jtpmaindesc.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Musiker01 result = new Musiker01();
				Vector<Vector<String>> results = result.dbSelect();
				//
				dtm.setDataVector(results, DBMethods03.COLUMN_IDENTIFIERS);

				// Methode
				dtm.fireTableDataChanged();
			}
		});

	}

	public void mouseListenerTable() {

		// Button fuer die Tabelle
		jtmaintable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {
					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// In Var die ausgewaehlten Zeilen und Spalten speichern
						int row = jtmaintable.getSelectedRow();
						int column = jtmaintable.getSelectedColumn();

						// Wenn es sich um die erste Spalte handelt:
						if (column == 0) {

							// Die Werte des ausgewaehlten Feldes in Objecte
							// ablegen
							Object artist = jtmaintable.getValueAt(row, column);
							Object title = jtmaintable.getValueAt(row,
									column + 1);

							// Die Objecte in Strings casten
							artist = String.valueOf(artist);
							title = String.valueOf(title);

							// Methodenaufruf um Tab zu adden
							AddTabs02.showArtist(artist, title, jtpmaindesc);
						}

						// Wenn es sich um die zweite Spalte handelt:
						else if (column == 1) {

							Object artist = jtmaintable.getValueAt(row,
									column - 1);
							Object title = jtmaintable.getValueAt(row, column);

							artist = String.valueOf(artist);
							title = String.valueOf(title);

							AddTabs02.showArtist(artist, title, jtpmaindesc);
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
