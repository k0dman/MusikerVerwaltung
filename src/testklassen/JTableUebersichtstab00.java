package testklassen;

/*In dieser Klasse wird die Tabelle einer JTabbedPane hinzufuegt*/

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableUebersichtstab00 extends JTable {

	// Instanzen fuer JPanel erzeugen

	private JtpUebersichtstab00 jpaddpanel = new JtpUebersichtstab00();

	// Felder:

	// JTable

	public JTable jtmaintable;

	// DefaultTableModel

	private DefaultTableModel dtm;

	public JTable jtmaintable() {

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

		// #############################//
		// Methodenaufruf und in Variable abgelegt
		Vector<Vector<String>> results = DBMethods00.DBSelectVector();
		//
		dtm.setDataVector(results, DBMethods00.COLUMN_IDENTIFIERS);

		// Methode
		dtm.fireTableDataChanged();
		// #############################//

		

		return jtmaintable;
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