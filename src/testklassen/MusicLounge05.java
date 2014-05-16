package testklassen;

import farbverlaeufe.*;
import java.awt.*;

import javax.swing.*;

import java.awt.Font;

public class MusicLounge05 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 05L;

	// Felder:

	// Schriften:
	private Font fheader;

	// Farben

	// statische Farben
	private Color bgheader, bginfo, bgmain, bgnew, bgfooter;

	// Contentpane
	private Container copa;

	// JPanel
	private JPanel jpall, jpheader, jpheaderleft, jpheaderright, jpmain,
			jpinfo, jpnew, jpfooter;

	// JLabels
	private JLabel jlheader, jlsearch;

	// JTextField
	private JTextField jtfsearch;

	// JButton
	private JButton jbnew;
	private JButton jbedit;

	// Konstruktor
	private MusicLounge05() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge");

		// Sauberes Schließen ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		// Farbverlaeufe aus der Klasse >GradientPanel<
		GradientJPHeaderLeft gpleft = new GradientJPHeaderLeft();
		GradientJPHeaderRight gpright = new GradientJPHeaderRight();
		GradientJPInfo gpinfo = new GradientJPInfo();
		gpinfo.paintComponent(getGraphics(), "b");
		//bgheader = new Color(176, 176, 176);
		bginfo = new Color(122, 139, 139);
		bgmain = new Color(217, 217, 217);
		bgnew = new Color(122, 139, 139);
		bgfooter = new Color(176, 176, 176);

		// Gibt ContentPane Objekt zurueck
		copa = getContentPane();

		// JPanel erzeugen mit BorderLayout
		jpall = new JPanel(new BorderLayout());
		jpheader = new JPanel(new BorderLayout());
		jpheaderleft = new JPanel();
		jpheaderright = new JPanel();
		jpmain = new JPanel();
		jpinfo = new JPanel();
		jpnew = new JPanel();
		jpfooter = new JPanel();

		// JButton erzeugen
		jbnew = new JButton();
		jbedit = new JButton();
	

		//jpheader.setBackground(bgheader);
		jpinfo.setBackground(bginfo);
		jpmain.setBackground(bgmain);
		//jpnew.setBackground(bgnew);
		jpfooter.setBackground(bgfooter);

		// JPanels der >jpall< hinzufuegen
		jpall.add(jpheader, BorderLayout.NORTH);
		jpall.add(jpmain, BorderLayout.CENTER);
		jpall.add(jpinfo, BorderLayout.EAST);
		jpall.add(gpinfo, BorderLayout.WEST);
		jpall.add(jpfooter, BorderLayout.SOUTH);

		// JPanels der >jpheader< hinzufuegen
		jpheader.add(jpheaderleft.add(gpleft));
		jpheader.add(jpheaderright.add(gpright), BorderLayout.EAST);
		//jpheader.add(jpheaderright, BorderLayout.EAST);

		// JLabel erzeugen
		jlheader = new JLabel("MusicLounge");
		jlsearch = new JLabel("Suche");

		// JButton erzeugen
		jbnew = new JButton("Neu");
		jbnew.setPreferredSize(new Dimension(100, 35));
		jbedit = new JButton("Bearbeiten");
		jbedit.setPreferredSize(new Dimension(100, 35));

		// JTextField erzeugen
		jtfsearch = new JTextField("Suchtext");

		// JTextfield vergrößern
		jtfsearch.setColumns(10);

		// JLabels der >jpheaderright< hinzufuegen
		gpleft.add(jpheaderleft.add(jlheader));
		gpright.add(jpheaderright.add(jlsearch));
		gpright.add(jpheaderright.add(jtfsearch));
	

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpinfo< hinzufuegen
		gpinfo.add(jpnew.add(jbnew));

		// JButton der >jpedit< hinzufuegen
		jpinfo.add(jbedit);

		// JPanel der ContentPane hinzufuegen
		copa.add(jpall);

		// Anfangsposition und -groesse festlegen
		setBounds(50, 50, 1280, 720);

		// Groesse nicht veraenderbar
		setResizable(false);

		// Frame sichtbar machen
		setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies spaeteres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge05();

			}
		});

	}

}
