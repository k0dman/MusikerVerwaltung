package musikerverwaltung;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Formular {

	// Felder:

	// JLabels
	private JLabel jlsearch;

	// JTextField
	private JTextField jtfsearch;

	public Formular() {
		
		// JLabel erzeugen

		jlsearch = new JLabel("Suche");

		// JTextField erzeugen
		jtfsearch = new JTextField("Suchtext");

	}

}
