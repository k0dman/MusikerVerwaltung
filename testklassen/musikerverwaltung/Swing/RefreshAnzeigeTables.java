package musikerverwaltung.Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RefreshAnzeigeTables extends JPanel {

	public JPanel refreshAnzeigeTables(JPanel jpmain, JPanel jptop,
			JPanel jpbottom) {
		// Inhalte aus HauptJPanel entfernen
		jpmain.removeAll();
		// Neu Zeichnen
		jpmain.repaint();
		// Neu Validieren
		jpmain.revalidate();

		// JPanels hinzufuegen
		jpmain.add(jptop);
		jpmain.add(jpbottom);

		return jpmain;
	}
	
	public JPanel refreshAnzeigeTables(JPanel jpmain, JPanel jptop, JPanel jpmiddle,
			JPanel jpbottom) {
		// Inhalte aus HauptJPanel entfernen
		jpmain.removeAll();
		// Neu Zeichnen
		jpmain.repaint();
		// Neu Validieren
		jpmain.revalidate();

		// JPanels hinzufuegen
		jpmain.add(jptop);
		jpmain.add(jpmiddle);
		jpmain.add(jpbottom);

		return jpmain;
	}
	

}
