package vorlagen;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class MusicLounge00 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 00L;
	
	//Felder
	//Contentpane
	private Container copa;
	
	
	// Konstruktor
	private MusicLounge00() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge");

		// Sauberes Schlieﬂen ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		// Gibt ContentPane Objekt zurueck
		copa = getContentPane();
	
		
		
		// Automatische Groesse setzen
		pack();
		// Frame sichtbar machen
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies spaeteres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge00();

			}
		});

	}

}
