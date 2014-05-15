package musikerverwaltung;

import java.awt.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class MusicLounge01 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 01L;

	// Felder:

	// Contentpane
	private Container copa;

	// JPanel
	private JPanel jpall, jpheader, jpmain, jpinfo, jpnew, jpfooter;

	// Farben
	private Color bgheader, bginfo, bgmain, bgnew, bgfooter;
	// Konstruktor
	private MusicLounge01() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge");

		// Sauberes Schließen ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Farben erzeugen
		bgheader = new Color(176,176,176);
		bginfo = new Color(122,139,139);
		bgmain = new Color(217,217,217);
		bgnew = new Color(122,139,139);
		bgfooter = new Color(176,176,176);

		// Gibt ContentPane Objekt zurueck
		copa = getContentPane();

		// JPanel erzeugen mit BorderLayout
		jpall = new JPanel(new BorderLayout());
		jpheader = new JPanel();
		jpmain = new JPanel();
		jpinfo = new JPanel();
		jpnew = new JPanel();
		jpfooter = new JPanel();

		//Farben hinzufuegen
		jpheader.setBackground(bgheader);
		jpinfo.setBackground(bginfo);
		jpmain.setBackground(bgmain);
		jpnew.setBackground(bgnew);
		jpfooter.setBackground(bgfooter);
		
		// JPanels der >jpall< hinzufuegen
		jpall.add(jpheader, BorderLayout.NORTH);
		jpall.add(jpmain, BorderLayout.CENTER);
		jpall.add(jpinfo, BorderLayout.EAST);
		jpall.add(jpnew, BorderLayout.WEST);
		jpall.add(jpfooter, BorderLayout.SOUTH);

		// JPanel der ContentPane hinzufuegen
		copa.add(jpall);

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
				new MusicLounge01();

			}
		});

	}

}
