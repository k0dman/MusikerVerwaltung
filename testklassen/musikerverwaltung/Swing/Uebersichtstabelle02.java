package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import musikerverwaltung.Database.*;
import musikerverwaltung.Graphics.Icons;
import musikerverwaltung.Methods.*;
import diverse.*;


public class Uebersichtstabelle02 extends JTabbedPane {

	// Felder:

	// Instanz AddArtist
	private AddArtist01 addartist;
	public AnzeigeDaten artistdata;

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
	


	public JTabbedPane jtpmaindesc() {

		// DefaultTableModel erzeugen und die Spaltenanzahl/Zeilenanzahl
		// festlegen
		dtm = new DefaultTableModel(1, 3);

		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(DBMethods01.COLUMN_IDENTIFIERS);

		// JTable erzeugen
		jtmaintable = new JTable(dtm);

		jtmaintable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = jtmaintable.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// #############################//
		// Methodenaufruf und in Variable abgelegt
		Vector<Vector<String>> results = DBMethods01.DBSelectVector();
		//
		dtm.setDataVector(results, DBMethods01.COLUMN_IDENTIFIERS);

		// Methode
		dtm.fireTableDataChanged();
		// #############################//

		// Panel erzeugen mit GridLayout
		JTabbedPane jtpmaindesc = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);

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
		Icons tabicons = new Icons();
		
		// Hinzufuegen der JScrollPane zur JTabbedPane
		jtpmaindesc.addTab("Libary", tabicons.icons[0], jspmaintable);

		// Aufruf der MouseListener aus der JTable-Klasse (Evtl. wieder
		// zurueckpacken)
		mouseListenertable();

		return jtpmaindesc;

	}

	public void mouseListenertable() {

		// Button fuer die Tabelle
		jtmaintable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

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

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtmaintable.getSelectedRow();
					int column = jtmaintable.getSelectedColumn();

					// Wenn es sich um die erste Spalte handelt:
					if (column == 0) {

						// Die Werte des ausgewaehlten Feldes in Objecte ablegen
						Object artist = jtmaintable.getValueAt(row, column);
						Object title = jtmaintable.getValueAt(row, column + 1);

						// Die Objecte in Strings casten
						artist = String.valueOf(artist);
						title = String.valueOf(title);

						// Zusammenfassen in eine Var
						String ausgabe = "Artist: " + artist + " " + "Titel: "
								+ title;

						JOptionPane.showMessageDialog(null, ausgabe);
						addartist = new AddArtist01();
						//artistdata = new AnzeigeDaten(String.valueOf(artist));
						addartist.showArtist(artist, title, jtpmaindesc);

					}
					// Wenn es sich um die zweite Spalte handelt:
					else if (column == 1) {

						Object artist = jtmaintable.getValueAt(row, column - 1);
						Object title = jtmaintable.getValueAt(row, column);

						artist = String.valueOf(artist);
						title = String.valueOf(title);

						String ausgabe = "Artist: " + artist + " " + "Titel: "
								+ title;
						JOptionPane.showMessageDialog(null, ausgabe);
						addartist = new AddArtist01();
						AnzeigeDaten artistdata = new AnzeigeDaten(String.valueOf(artist));
						addartist.showArtist(artist, title, jtpmaindesc);

					}
				}
			}
		});
	}
}
