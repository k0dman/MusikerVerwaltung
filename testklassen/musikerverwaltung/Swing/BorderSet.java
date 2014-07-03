package musikerverwaltung.Swing;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BorderSet {

	// Border
	private Border border;

	public Border setBorder(JPanel jpanel, String beschreibung) {

		// Border dem JPanel hinzufuegen
		border = jpanel.getBorder();
		// Farbe fuer Border
		Border margin = new LineBorder(Color.LIGHT_GRAY, 2);

		CompoundBorder border1 = new CompoundBorder(border, margin);
		jpanel.setBorder(new TitledBorder(border1, beschreibung));

		return border;
	}
}
