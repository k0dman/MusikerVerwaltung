package testklassen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Uebersichtstabelle00 extends JPanel {

	// Instanzen für JPanels erzeugen
	private EingabeformularArtist03 jtmaintableartist = new EingabeformularArtist03();

	// Felder:

	// JTabbedPane
	private JTabbedPane jtpmaindesc;

	// JPanel
	private JPanel jpmaindesc;

	// JTable

	private JTable jtmaintable;

	// DefaultTableModel

	private DefaultTableModel dtm;

	// JScrollPane

	private JScrollPane jspmaintable;

	// Schrift:
	private Font ftfield;

	// JLabel
	private JLabel test;

	public JPanel jpmaindesc() {

		// Panel erzeugen mit GridLayout
		JPanel jpmaindesc = new JPanel();

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// DefaultTableModel erzeugen und die Spaltenanzahl/Zeilenanzahl
		// festlegen
		dtm = new DefaultTableModel(1, 3);

		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(DBMethods00.COLUMN_IDENTIFIERS);

		// JTable erzeugen
		jtmaintable = new JTable(dtm);

		jtmaintable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = jtmaintable.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jspmaintable = new JScrollPane(jtmaintable);

		// JScrollPane dem JPanel hinzufuegem

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:) //860 , 600
		jspmaintable.setPreferredSize(new Dimension(860, 600));

		jspmaintable.setViewportView(jtmaintable);

		jpmaindesc.add(jspmaintable, BorderLayout.WEST);
		jpmaindesc.add(jspmaintable, BorderLayout.EAST);

		// #############################//
		// Methodenaufruf und in Variable abgelegt
		Vector<Vector<String>> results = DBMethods00.DBSelectVector();
		//
		dtm.setDataVector(results, DBMethods00.COLUMN_IDENTIFIERS);

		// Methode
		dtm.fireTableDataChanged();
		// #############################//

		mouseListenertable();
		return jpmaindesc;

	}

	private void mouseListenertable() {

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
					if (column == 1) {

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

					}
					// Wenn es sich um die zweite Spalte handelt:
					else if (column == 2) {

						Object artist = jtmaintable.getValueAt(row, column - 1);
						Object title = jtmaintable.getValueAt(row, column);

						artist = String.valueOf(artist);
						title = String.valueOf(title);

						String ausgabe = "Artist: " + artist + " " + "Titel: "
								+ title;
						JOptionPane.showMessageDialog(null, ausgabe);

					}
				}
			}
		});

	}
}
