package musikerverwaltung.Swing;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.Gruppe01;
public class SelectTables extends JPanel{

	private JPanel jpmain;
	private TableModel dtm;
	public JTable jt;
	private JScrollPane jsp;
	private Gruppe01 gruppe;
	private BorderSet border;
	private ListSelectionModel cellSelectionModel;
	private MouseListenerTable mlt;
	
	public JPanel selectTables(String band, String beschreibung, DefaultTableModel dtm){
		
		// JPanel f\u00FCr Tabelle mit Referenzen
		jpmain = new JPanel(new GridLayout(1, 1, 1, 1));
	
		gruppe = new Gruppe01(band);
		// Erzeugung der Tabelle mit DefaultTableModel
		jt = new JTable(dtm);

		// Spalten nicht mehr verschiebbar
		jt.getTableHeader().setReorderingAllowed(false);

		jt.setCellSelectionEnabled(true);

		// Nur auswahl einer Zeile m\u00F6glich
		cellSelectionModel = jt.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// JTable der JScrollPane hinzuf\u00FCgen
		jsp = new JScrollPane(jt);

		// Gr\u00F6sse der Tabelle festlegen, das sonst keinen Scrollen
		// vorhanden
		// ist, auﬂerdem sch\u00F6ner:) //860 , 600
		jsp.setPreferredSize(new Dimension(300, 500));

		// Viewport setzen
		jsp.setViewportView(jt);
		
		// JSP mit Mitgliedern und JLabel dem JPanel hinzuf\u00FCgen
		jpmain.add(jsp);
		
		//Border setzen
		border = new BorderSet();
		border.setBorder(jpmain, beschreibung);
		
		return jpmain;
	}
	
}
