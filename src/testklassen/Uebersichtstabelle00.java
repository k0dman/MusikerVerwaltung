package testklassen;

import java.awt.*;
import java.util.*;

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

		jtmaintable.setCellSelectionEnabled(true);
		ListSelectionModel cellSelectionModel = jtmaintable.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		/*
		 * cellSelectionModel .addListSelectionListener(new
		 * ListSelectionListener() { public void valueChanged(ListSelectionEvent
		 * e) { String selectedData = null;
		 * 
		 * int[] selectedRow = jtmaintable.getSelectedRows(); int[]
		 * selectedColumns = jtmaintable .getSelectedColumns();
		 * 
		 * for (int i = 0; i < selectedRow.length; i++) { for (int j = 0; j <
		 * selectedColumns.length; j++) { selectedData = (String)
		 * jtmaintable.getValueAt( selectedRow[i], selectedColumns[j]); } }
		 * System.out.println("Selected: " + selectedData); }
		 * 
		 * });
		 */

		// JScrollPane erstellen
		jtmaintable.setAutoResizeMode(HEIGHT);
		
		jspmaintable = new JScrollPane(jtmaintable);

		// JScrollPane dem JPanel hinzufuegem

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, außerdem schoener:)
		jspmaintable.setPreferredSize(new Dimension(260, 150));

		jspmaintable.setViewportView(jtmaintable);

		jpmaindesc.add(jspmaintable);

		return jpmaindesc;

	}

}
