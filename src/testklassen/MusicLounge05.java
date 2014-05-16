package testklassen;

import musikerverwaltung.*;

import java.awt.*;

import javax.swing.*;

import musikerverwaltung.GradientJPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MusicLounge05 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 05L;

	// Felder:

	// Schriften:
	private Font fheader;

	Eingabeformular01 jpmainhead = new Eingabeformular01();
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

		GradientJPanels gpnew = new GradientJPanels("gpnew");
		GradientJPanels gpright = new GradientJPanels("gpheader");
		GradientJPanels gprcenter = new GradientJPanels("gpcenter");
		GradientJPanels gpleft = new GradientJPanels("gpheader");
		GradientJPanels gpinfo = new GradientJPanels("gpinfo");
		GradientJPanels gpfooter = new GradientJPanels("gpfooter");

		// bgheader = new Color(176, 176, 176);
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
		jpmain = new JPanel(new GridLayout(1, 3, 4, 4));
		jpinfo = new JPanel();
		jpnew = new JPanel();
		jpfooter = new JPanel();

		// JButton erzeugen
		jbnew = new JButton();
		jbedit = new JButton();

		// jpheader.setBackground(bgheader);
		// jpinfo.setBackground(bginfo);
		// jpmain.setBackground(bgmain);
		// jpnew.setBackground(bgnew);
		// jpfooter.setBackground(bgfooter);

		// JPanels der >jpall< hinzufuegen
		jpall.add(jpheader, BorderLayout.NORTH);
		jpall.add(jpmain, BorderLayout.CENTER);
		jpall.add(gpinfo, BorderLayout.EAST);
		jpall.add(gpnew, BorderLayout.WEST);
		jpall.add(jpfooter, BorderLayout.SOUTH);

		// JPanels der >jpheader< hinzufuegen
		jpheader.add(jpheaderleft.add(gpleft));
		jpheader.add(jpheaderright.add(gpright), BorderLayout.EAST);
		// jpheader.add(jpheaderright, BorderLayout.EAST);

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
		
		jpmain.add(jpmainhead.jpmaindesc());
		jpmain.add(jpmainhead.jpmaininput());
		jpmain.add(jpmainhead.jpmainrechts());
		jpmain.setVisible(false);

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpinfo< hinzufuegen
		gpnew.add(jpnew.add(jbnew));

		// JButton der >jpedit< hinzufuegen
		gpinfo.add(jpinfo.add(jbedit));

		// JPanel der ContentPane hinzufuegen
		copa.add(jpall);

		// ActionLister();
		actionListener();

		// Anfangsposition und -groesse festlegen
		setBounds(50, 50, 1280, 720);

		// Groesse nicht veraenderbar
		setResizable(false);

		// Frame sichtbar machen
		setVisible(true);

	}

	private void actionListener() {

		// Button
		jbnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				jpmain.setVisible(true);

			}
		});

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
