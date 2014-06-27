package musikerverwaltung.Swing;

import musikerverwaltung.Graphics.*;
import musikerverwaltung.menschen.Musiker01;

import javax.swing.UIManager.*;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.InsetsUIResource;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MusicLounge14 extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 8L;

	// Felder:
	private Color bgheader;
	// Schriften:
	private Font fheader;

	// Instanzen erzeugen, die zur GUI hinzugefuegt werden
	private Uebersichtstabelle03 jtpmain = new Uebersichtstabelle03();

	// Farben

	// Contentpane
	private Container copa;

	// JMenuBar
	private JMenuBar jmbmenu;

	// JMenu
	private JMenu jmdatei;

	// JMenuItem
	private JMenuItem jmiimport, jmiexport, jmiexit;

	// JPanel
	private JPanel jpall, jpheader, jpheaderleft, jpheaderright, jpmain,
			jpinfo, jpselect, jpfooter;

	// JLabels
	private JLabel jlheader, jlsearch, jlmenudate;

	// JButton
	private JButton jbmaintable, jbnewart, jbnewband, jbedit;

	// GradientJPanels
	private GradientJPanels03 gpright, gpleft, gpnew, gpmain, gpfooter;

	// JTextField
	private RoundJTextField03 jtfsearch;

	// Konstruktor
	private MusicLounge14() {
		
		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge14");
		
		// Look And Feel - Nimbus
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					UIManager.put("TabbedPane.contentBorderInsets",new InsetsUIResource(0,
							0,0,0));
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
		

		// Sauberes Schlieﬂen ermoeglichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		bgheader = new Color(214, 214, 214);

		// Farbverlaeufe aus der Klasse >GradientPanel<
		gpright = new GradientJPanels03("gpheaderright");
		gpleft = new GradientJPanels03("gpheaderleft");
		// gpnew = new GradientJPanels03("gpnew");
		gpmain = new GradientJPanels03("gpmain");
		// GradientJPanels01 gpinfo = new GradientJPanels01("gpinfo");
		gpfooter = new GradientJPanels03("gpfooter");

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

		// Abstand setzen
		jmdatei.setMargin(new Insets(0, 10, 0, 100));

		// Items dem Menupunkt hinzufuegen
		jmdatei.add(jmiimport);
		jmdatei.add(jmiexport);
		jmdatei.add(jmiexit);

		jlmenudate = new JLabel("Datum");
		// Menupunkte der JMenubar hinzufuegen
		jmbmenu.add(jmdatei);
		jmbmenu.add(Box.createHorizontalStrut(1150));
		jmbmenu.add(jlmenudate);

		// JMenubar dem Frame hinzufuegen
		add(jmbmenu, BorderLayout.NORTH);

		// JPanel erzeugen mit BorderLayout
		jpall = new JPanel(new BorderLayout());
		jpall.setBackground(bgheader);

		jpheader = new JPanel(new BorderLayout());
		jpheader.setBackground(bgheader);
		jpheaderleft = new JPanel();
		jpheaderright = new JPanel();
		jpmain = new JPanel(new BorderLayout());
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
		// jpall.add(gpinfo, BorderLayout.EAST);
		// jpall.add(gpnew, BorderLayout.WEST);
		jpall.add(gpfooter, BorderLayout.SOUTH);

		// JPanels der >jpheader< hinzufuegen
		jpheader.add(gpleft);
		jpheader.add(gpright, BorderLayout.EAST);

		// JLabel erzeugen
		jlheader = new JLabel("MusicLounge");

		// Instanz der Klasse Incons erzeugen
		Icons01 searchicon = new Icons01();

		// JLabel Icon zuweisen
		jlsearch = new JLabel(searchicon.icons[3]);

		// JButton erzeugen
		jbmaintable = new JButton("‹bersicht");
		jbmaintable.setPreferredSize(new Dimension(150, 35));
		jbnewart = new JButton("Neuer Artist");
		jbnewart.setPreferredSize(new Dimension(150, 35));
		jbnewband = new JButton("Neue Band");
		jbnewband.setPreferredSize(new Dimension(150, 35));
		jbedit = new JButton("Bearbeiten");
		jbedit.setPreferredSize(new Dimension(100, 35));

		// JTextField erzeugen
		jtfsearch = new RoundJTextField03(13);

		// JLabels der >jpheaderright< hinzufuegen
		gpleft.add(jpheaderleft.add(jlheader));
		gpright.add(jpheaderright.add(jlsearch));
		gpright.add(jpheaderright.add(jtfsearch));

		// JTabbedPane einbinden
		// Pointer auf die Variable legen

		jtpmain.jtpmaindesc = jtpmain.jtpmaindesc(null);
		jpmain.add(jtpmain.jtpmaindesc, BorderLayout.CENTER);

		// Tabs hinzufuegen
		AddTabs02.insertArtist(jtpmain.jtpmaindesc, "Interpret eintragen");
		AddTabs02.insertBand(jtpmain.jtpmaindesc, "Band eintragen");

		// Schriftart hinzufuegen
		jlheader.setFont(fheader);

		// JButton der >jpselect< hinzufuegen
		jpselect.add(jbmaintable);
		jpselect.add(jbnewart);
		jpselect.add(jbnewband);

		// der Instanz von GradientPanel das JPanel >jpselect< hinzufuegen
		// gpnew.add(jpselect);
		// gpnew.setPreferredSize(new Dimension(200, 50));

		// JButton der >jpedit< hinzufuegen
		// gpinfo.add(jpinfo.add(jbedit));
		// gpinfo.setPreferredSize(new Dimension(200, 50));

		// jpfooter
		gpfooter.add(jpfooter);

		// JPanel der ContentPane hinzufuegen
		copa.add(jpall);

		// ActionLister();
		actionListenerJButton();
		actionListenerJMenuItems();
		mouseListenerJTP();
		searchKeyListener();

		// Anfangsposition und -groesse festlegen
		setBounds(50, 50, 1280, 720);

		// Groesse nicht veraenderbar
		setResizable(false);

		// Frame sichtbar machen
		setVisible(true);

	}

	private void actionListenerJButton() {

		// Button
		jbmaintable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpmain.removeAll();
				jpmain.revalidate();
				jpmain.repaint();
				// Pointer auf die Variable legen
				jtpmain.jtpmaindesc = jtpmain.jtpmaindesc(null);
				jpmain.add(jtpmain.jtpmaindesc);
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

	public void mouseListenerJTP() {

		jtpmain.jtpmaindesc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 3) {
					int zahl = jtpmain.jtpmaindesc.getSelectedIndex();
					int auswahl;
					if (zahl > 2) {
						auswahl = JOptionPane.showConfirmDialog(null,
								"Bist du sicher ? Alle Daten gehen verloren !",
								"Tab-Schlieﬂen", JOptionPane.YES_NO_OPTION);
						if (auswahl == JOptionPane.YES_OPTION) {
							jtpmain.jtpmaindesc.remove(zahl);
						}
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	
	public void searchKeyListener(){
		jtfsearch.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 30) JOptionPane.showMessageDialog(null, "message1");
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 30) JOptionPane.showMessageDialog(null, "message2");
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 10){
					JOptionPane.showMessageDialog(null, "wuuuu");
					
					jpmain.removeAll();
					jpmain.revalidate();
					jpmain.repaint();
					// Pointer auf die Variable legen
					jtpmain.jtpmaindesc = jtpmain.jtpmaindesc(jtfsearch.getText());
					jpmain.add(jtpmain.jtpmaindesc);
					jpmain.setVisible(true);	
					// Tabs hinzufuegen
					AddTabs02.insertArtist(jtpmain.jtpmaindesc, "Interpret eintragen");
					AddTabs02.insertBand(jtpmain.jtpmaindesc, "Band eintragen");
					//Text wieder leeren - muss am Ende stehen
					jtfsearch.setText("");
				}
				
				
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies spaeteres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge14();

			}
		});

	}

}
