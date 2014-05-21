package testklassen;

import java.awt.*;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicLounge08 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 8L;

	// Felder:
	private Color bgheader;
	// Schriften:
	private Font fheader;

	// Instanzen f�r JPanels erzeugen
	private EingabeformularArtist02 jpmainartist = new EingabeformularArtist02();
	private EingabeformularBand02 jpmainband = new EingabeformularBand02();
	private Uebersichtstabelle00 jpmaintable = new Uebersichtstabelle00();

	// Farben

	// Contentpane
	private Container copa;

	//JMenuBar
	private JMenuBar jmbmenu;
	// JPanel
	private JPanel jpall, jpheader, jpheaderleft, jpheaderright, jpmain,
			jpinfo, jpselect, jpfooter;

	// JLabels
	private JLabel jlheader, jlsearch;

	// JTextField
	private RoundJTextField01 jtfsearch;

	// JButton
	private JButton jbmaintable, jbnewart, jbnewband, jbedit;

	// Konstruktor
	private MusicLounge08() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge08");

		// Sauberes Schlie�en ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		bgheader = new Color(214, 214, 214);
		// Farbverlaeufe aus der Klasse >GradientPanel<

		GradientJPanels01 gpright = new GradientJPanels01("gpheaderright");
		GradientJPanels01 gpleft = new GradientJPanels01("gpheaderleft");
		GradientJPanels01 gpnew = new GradientJPanels01("gpnew");
		GradientJPanels01 gpmain = new GradientJPanels01("gpmain");
		GradientJPanels01 gpinfo = new GradientJPanels01("gpinfo");
		GradientJPanels01 gpfooter = new GradientJPanels01("gpfooter");

		// Gibt ContentPane Objekt zurueck
		copa = getContentPane();

		// JPanel erzeugen mit BorderLayout
		jpall = new JPanel(new BorderLayout());
		jpall.setBackground(bgheader);

		jpheader = new JPanel(new BorderLayout());
		jpheader.setBackground(bgheader);
		jpheaderleft = new JPanel();
		jpheaderright = new JPanel();
		jpmain = new JPanel(new GridLayout(1, 2, 4, 4));
		jpinfo = new JPanel();
		jpselect = new JPanel(new GridLayout(3, 1, 6, 6));
		jpfooter = new JPanel();

		// >jpselect< durchsichtig machen, damit zwischen den JButtons, der
		// Hintergrund durchgemalt wird
		jpselect.setOpaque(false);
		jpfooter.setOpaque(false);
		// JPanels der >jpall< hinzufuegen
		jpall.add(jpheader, BorderLayout.NORTH);
		jpall.add(jpmain, BorderLayout.CENTER);
		jpall.add(gpinfo, BorderLayout.EAST);
		jpall.add(gpnew, BorderLayout.WEST);
		jpall.add(gpfooter, BorderLayout.SOUTH);

		// JPanels der >jpheader< hinzufuegen
		jpheader.add(gpleft);
		jpheader.add(gpright, BorderLayout.EAST);
		// jpheader.add(jpheaderright, BorderLayout.EAST);

		// JLabel erzeugen
		jlheader = new JLabel("MusicLounge");
		jlsearch = new JLabel("Suche");

		// JButton erzeugen
		jbmaintable = new JButton("�bersicht");
		jbmaintable.setPreferredSize(new Dimension(150, 35));
		jbnewart = new JButton("Neuer Artist");
		jbnewart.setPreferredSize(new Dimension(150, 35));
		jbnewband = new JButton("Neue Band");
		jbnewband.setPreferredSize(new Dimension(150, 35));
		jbedit = new JButton("Bearbeiten");
		jbedit.setPreferredSize(new Dimension(100, 35));

		// JTextField erzeugen
		jtfsearch = new RoundJTextField01(13);

		// JLabels der >jpheaderright< hinzufuegen
		gpleft.add(jpheaderleft.add(jlheader));
		gpright.add(jpheaderright.add(jlsearch));
		gpright.add(jpheaderright.add(jtfsearch));

		// gpmain

		// >jpmain< unsichtbar machen

		jpmain.setVisible(false);

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpinfo< hinzufuegen
		jpselect.add(jbmaintable);
		jpselect.add(jbnewart);
		jpselect.add(jbnewband);

		// der Instanz das JPanel >jpselect< hinzufuegen
		gpnew.add(jpselect);
		gpnew.setPreferredSize(new Dimension(200, 50));

		// JButton der >jpedit< hinzufuegen
		gpinfo.add(jpinfo.add(jbedit));
		gpinfo.setPreferredSize(new Dimension(200, 50));

		// jpfooter
		gpfooter.add(jpfooter);

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
		jbnewart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpmain.removeAll();
				jpmain.revalidate();
				jpmain.repaint();
				jpmain.add(jpmainartist.jpmaindesc());
				jpmain.add(jpmainartist.jpmaininput());
				jpmain.add(jpmainartist.jpmainrechts());
				jpmain.setVisible(true);

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
				jpmain.add(jpmainband.jpmainrechts());
				jpmain.setVisible(true);

			}
		});
		// Button
		jbmaintable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpmain.removeAll();
				jpmain.revalidate();
				jpmain.repaint();
				jpmain.add(jpmaintable.jpmaindesc());
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
				new MusicLounge08();

			}
		});

	}

}
