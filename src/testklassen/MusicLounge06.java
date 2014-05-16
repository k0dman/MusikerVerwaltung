package testklassen;

import musikerverwaltung.*;

import java.awt.*;

import javax.swing.*;

import musikerverwaltung.GradientJPanels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MusicLounge06 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 06L;

	// Felder:

	private boolean var, var1;
	// Schriften:
	private Font fheader;
	// Instanzen für JPanels erzeugen
	EingabeformularArtist01 jpmainartist = new EingabeformularArtist01();
	EingabeformularBand01 jpmainband = new EingabeformularBand01();

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
	private JButton jbnewart, jbnewband, jbedit;

	// Konstruktor
	private MusicLounge06() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge");

		// Sauberes Schließen ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		// Farbverlaeufe aus der Klasse >GradientPanel<

		GradientJPanels gpnew = new GradientJPanels(2);
		GradientJPanels gpright = new GradientJPanels(4);
		GradientJPanels gprcenter = new GradientJPanels(4);
		GradientJPanels gpleft = new GradientJPanels(4);
		GradientJPanels gpinfo = new GradientJPanels(3);
		GradientJPanels gpfooter = new GradientJPanels(4);

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
		jpmain = new JPanel(new GridLayout(1, 2, 4, 4));
		jpinfo = new JPanel();
		jpnew = new JPanel(new GridLayout(2, 1, 6, 6));
		jpfooter = new JPanel();

		jpnew.setOpaque(false);

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
		jbnewart = new JButton("Neuer Artist");
		jbnewart.setPreferredSize(new Dimension(200, 35));
		jbnewband = new JButton("Neue Band");
		jbnewband.setPreferredSize(new Dimension(100, 35));
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

		// >jpmain< unsichtbar machen
		jpmain.setVisible(false);

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpinfo< hinzufuegen
		jpnew.add(jbnewart);
		jpnew.add(jbnewband);

		gpnew.add(jpnew);

		// JButton der >jpedit< hinzufuegen
		gpinfo.add(jpinfo.add(jbedit));

		// JPanel der ContentPane hinzufuegen
		copa.add(jpall);

		// ActionLister();
		actionListener();
		System.out.println(var);

		// Anfangsposition und -groesse festlegen
		setBounds(50, 50, 1280, 720);

		// Groesse nicht veraenderbar
		setResizable(false);

		// Frame sichtbar machen
		setVisible(true);

	}

	private void actionListener() {

		// Button
		jbnewart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpmain.removeAll();
				jpmain.revalidate();
				jpmain.repaint();

				jpmain.add(jpmainartist.jpmaindesc());
				jpmain.add(jpmainartist.jpmaininput());
				jpmain.setVisible(true);
				var = true;
				System.out.println(var);

			}
		});
		// Button
		jbnewband.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpmain.removeAll();
				jpmain.revalidate();
				jpmain.repaint();

				jpmain.add(jpmainband.jpmaindesc());
				jpmain.add(jpmainband.jpmaininput());

				jpmain.setVisible(true);
				var1 = true;

			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies spaeteres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge06();

			}
		});

	}

}
