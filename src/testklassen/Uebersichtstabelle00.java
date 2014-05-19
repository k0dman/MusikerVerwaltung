package testklassen;

import java.awt.*;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

public class Uebersichtstabelle00 extends JPanel {

	// Felder:

	// JPanel
	private JPanel jpmaindesc, jpmaininput;

	// JTable

	private JTable jtmaintable;

	// DefaultTableModel

	private DefaultTableModel dtm;

	// JScrollPane

	private JScrollPane jspmaintable;

	// Schrift:
	private Font ftfield;

	// JTextField

	public JPanel jpmaindesc() {

		// Panel erzeugen mit GridLayout
		JPanel jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// DefaultTableModel erzeugen und die Spaltenanzahl/Zeilenanzahl
		// festlegen
		dtm = new DefaultTableModel(1, 3);

		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(DBMethods00.COLUMN_IDENTIFIERS);

		// JTable erzeugen
		jtmaintable = new JTable(dtm);

		// JScrollPane erstellen
		jspmaintable = new JScrollPane(jtmaintable);

		// JScrollPane dem JPanel hinzufuegem

		jpmaindesc.add(jspmaintable);

		return jpmaindesc;

	}

}
