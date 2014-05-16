package vorlagen;

import java.awt.*;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicLounge05 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 05L;

	// Felder:

	// Schriften:
	private Font fheader;

	// Farben
	private Color bgheader, bgheaderleft, bgheaderright, bginfo, bgmain, bgnew,
			bgfooter;

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

		// Sauberes Schlie�en ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		bgheader = new Color(176, 176, 176);
		bgheaderleft = new Color(176, 176, 176);
		bgheaderright = new Color(176, 176, 176);
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

		// Farben hinzufuegen
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

		// JPanels der >jpheader< hinzufuegen
		jpheader.add(jpheaderleft);
		jpheader.add(jpheaderright, BorderLayout.EAST);

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

		// JTextfield vergr��ern
		jtfsearch.setColumns(10);

		// JLabels der >jpheaderright< hinzufuegen
		jpheaderright.add(jlsearch);
		jpheaderright.add(jtfsearch);
		jpheaderleft.add(jlheader);

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpnew< hinzufuegen
		jpnew.add(jbnew);

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