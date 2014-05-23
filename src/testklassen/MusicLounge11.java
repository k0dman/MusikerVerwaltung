package testklassen;

import java.awt.*;

import javax.swing.*;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicLounge11 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 8L;

	// Felder:
	private Color bgheader;
	// Schriften:
	private Font fheader;

	// Instanzen für JPanels erzeugen
	private EingabeformularArtist03 jpmainartist = new EingabeformularArtist03();
	private EingabeformularBand03 jpmainband = new EingabeformularBand03();
	private Uebersichtstabelle00 jpmaintable = new Uebersichtstabelle00();

	// Farben

	// Contentpane
	private Container copa;

	// JMenuBar
	private JMenuBar jmbmenu;

	// JMenu
	private JMenu jmdatei;

	// JMenuItem
	private JMenuItem jmiimport, jmiexport, jmiexit;

	//JTabbedPanre
	private JTabbedPane jtpsample;
	
	// JPanel
	private JPanel jpall, jpheader, jpheaderleft, jpheaderright, jpmain,
			jpinfo, jpselect, jpfooter;

	// JLabels
	private JLabel jlheader, jlsearch, jlmenudate;

	// JTextField
	private RoundJTextField01 jtfsearch;

	// JButton
	private JButton jbmaintable, jbnewart, jbnewband, jbedit;

	// Konstruktor
	private MusicLounge11() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge11");

		// Sauberes Schließen ermoeglichen
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

		// JMenuBar erzeugen
		jmbmenu = new JMenuBar();

		// JMenu erzeugen
		jmdatei = new JMenu("Datei");

		// JMenuItems erzeugen
		jmiimport = new JMenuItem("Importieren");
		jmiexport = new JMenuItem("Exportieren");
		jmiexit = new JMenuItem("Beenden");

		jmdatei.setMargin(new Insets(0,10,0,100));
		// Items dem Menupunkt hinzufuegen
		jmdatei.add(jmiimport);
		jmdatei.add(jmiexport);
		jmdatei.add(jmiexit);

		
		
		jlmenudate = new JLabel("Datum");
		// Menupunkte der JMenubar hinzufuegen
		jmbmenu.add(jmdatei);
		jmbmenu.add(Box.createHorizontalStrut(1150));
		jmbmenu.add(jlmenudate);

		
		//JMenubar dem Frame hinzufuegen
		add(jmbmenu, BorderLayout.NORTH);

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
	

		// JLabel erzeugen
		jlheader = new JLabel("MusicLounge");
		jlsearch = new JLabel("Suche");
		

		// JButton erzeugen
		jbmaintable = new JButton("Übersicht");
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

		jtpsample = new JTabbedPane();
		
		/*jtpsample.setCellSelectionEnabled(true);
		    ListSelectionModel cellSelectionModel = table.getSelectionModel();
		    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		    cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        String selectedData = null;

		        int[] selectedRow = table.getSelectedRows();
		        int[] selectedColumns = table.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) {
		          for (int j = 0; j < selectedColumns.length; j++) {
		            selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
		          }
		        }
		        System.out.println("Selected: " + selectedData);
		      }

		    });*/
		
		
		
		

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
		actionListenerJButton();
		actionListenerJMenuItems();

		// Anfangsposition und -groesse festlegen
		setBounds(50, 50, 1280, 720);

		// Groesse nicht veraenderbar
		setResizable(false);

		// Frame sichtbar machen
		setVisible(true);

	}

	private void actionListenerJButton() {

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

	private void actionListenerJMenuItems() {

		// Button
		jmiexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			System.exit(0);

			}
		});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies spaeteres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge11();

			}
		});

	}

}
