package musikerverwaltung.swing;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;


public class TableModel {

	private DefaultTableModel dtm;
	
	public DefaultTableModel dtm(int row, int column, Vector<String> columntitles, Vector<Vector<String>> results){
		dtm = new DefaultTableModel(row, column) {
			// Das Editieren der Zeilen Disablen
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		// Spaltenueberschriften aus der Methode-Klasse holen
		dtm.setColumnIdentifiers(columntitles);
		
		dtm.setDataVector(results, columntitles);

		// Methode
		dtm.fireTableDataChanged();
		
		
		return dtm;
	}
	
}
