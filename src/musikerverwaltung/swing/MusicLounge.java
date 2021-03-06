package musikerverwaltung.swing;

import musikerverwaltung.graphics.*;

import javax.swing.UIManager.*;

import java.awt.*;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MusicLounge extends JFrame {

	// VersionsNr. festlegen
	private static final long serialVersionUID = 8L;

	// Felder:
	private Color bgheader;
	// Schriften:
	private Font fheader;

	// Instanzen erzeugen, die zur GUI hinzugef\u00FCgt werden
	private Uebersichtstabelle jtpmain = new Uebersichtstabelle();

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
	private MusicLounge() {

		// Titel (Aufruf mit super aus der Basisklasse)
		super("MusicLounge14");

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		// Sauberes Schlie�en erm\u00F6glichen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Schriften erzeugen
		fheader = new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 25);

		// Farben erzeugen
		bgheader = new Color(214, 214, 214);

		// Farbverl\u00E4ufe aus der Klasse >GradientPanel<
		gpright = new GradientJPanels03("gpheaderright");
		gpleft = new GradientJPanels03("gpheaderleft");
		// gpnew = new GradientJPanels03("gpnew");
		gpmain = new GradientJPanels03("gpmain");
		// GradientJPanels01 gpinfo = new GradientJPanels01("gpinfo");
		gpfooter = new GradientJPanels03("gpfooter");

		// Gibt ContentPane Objekt zur\u00FCck
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

		// Items dem Menupunkt hinzuf\u00FCgen
		jmdatei.add(jmiimport);
		jmdatei.add(jmiexport);
		jmdatei.add(jmiexit);

		jlmenudate = new JLabel("Datum");
		// Menupunkte der JMenubar hinzuf\u00FCgen
		jmbmenu.add(jmdatei);
		jmbmenu.add(Box.createHorizontalStrut(1150));
		jmbmenu.add(jlmenudate);

		// JMenubar dem Frame hinzuf\u00FCgen
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

		// JPanels der >jpall< hinzuf\u00FCgen
		jpall.add(jpheader, BorderLayout.NORTH);
		jpall.add(jpmain, BorderLayout.CENTER);
		// jpall.add(gpinfo, BorderLayout.EAST);
		// jpall.add(gpnew, BorderLayout.WEST);
		jpall.add(gpfooter, BorderLayout.SOUTH);

		// JPanels der >jpheader< hinzuf\u00FCgen
		jpheader.add(gpleft);
		jpheader.add(gpright, BorderLayout.EAST);

		// JLabel erzeugen
		jlheader = new JLabel("MusicLounge");

		// Instanz der Klasse Incons erzeugen
		Icons01 searchicon = new Icons01();

		// JLabel Icon zuweisen
		jlsearch = new JLabel(searchicon.icons[3]);

		// JButton erzeugen
		jbmaintable = new JButton("\u00FCbersicht");
		jbmaintable.setPreferredSize(new Dimension(150, 35));
		jbnewart = new JButton("Neuer Artist");
		jbnewart.setPreferredSize(new Dimension(150, 35));
		jbnewband = new JButton("Neue Band");
		jbnewband.setPreferredSize(new Dimension(150, 35));
		jbedit = new JButton("Bearbeiten");
		jbedit.setPreferredSize(new Dimension(100, 35));

		// JTextField erzeugen
		jtfsearch = new RoundJTextField03(13);
		
		jtfsearch.setToolTipText("Suche nach einem Interpreten/ einer Band oder nach Musikst\u00FCcken");

		// JLabels der >jpheaderright< hinzuf\u00FCgen
		gpleft.add(jpheaderleft.add(jlheader));
		gpright.add(jpheaderright.add(jlsearch));
		gpright.add(jpheaderright.add(jtfsearch));

		// JTabbedPane einbinden
		// Pointer auf die Variable legen

		jtpmain.jtpmaindesc = jtpmain.jtpmaindesc(null);
		jpmain.add(jtpmain.jtpmaindesc, BorderLayout.CENTER);

		// Tabs hinzuf\u00FCgen
		AddTabs.insertArtist(jtpmain.jtpmaindesc, "Interpret eintragen");
		AddTabs.insertBand(jtpmain.jtpmaindesc, "Band eintragen");

		// Schriftart hinzuf\u00FCgen
		jlheader.setFont(fheader);

		// JButton der >jpselect< hinzuf\u00FCgen
		jpselect.add(jbmaintable);
		jpselect.add(jbnewart);
		jpselect.add(jbnewband);

		// der Instanz von GradientPanel das JPanel >jpselect< hinzuf\u00FCgen
		// gpnew.add(jpselect);
		// gpnew.setPreferredSize(new Dimension(200, 50));

		// JButton der >jpedit< hinzuf\u00FCgen
		// gpinfo.add(jpinfo.add(jbedit));
		// gpinfo.setPreferredSize(new Dimension(200, 50));

		// jpfooter
		gpfooter.add(jpfooter);

		// JPanel der ContentPane hinzuf\u00FCgen
		copa.add(jpall);

		// ActionLister();
		actionListenerJButton();
		actionListenerJMenuItems();
		searchKeyListener();
		mouseListenerJTP();

		// Anfangsposition und -gr\u00F6sse festlegen
		setBounds(50, 50, 1280, 720);

		// Gr\u00F6sse nicht ver\u00E4nderbar
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

		jtpmain.jtpmaindesc.addMouseListener(new MouseAdapter() {

			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getButton() == 3) {
					int zahl = jtpmain.jtpmaindesc.getSelectedIndex();
					int auswahl;
					if (zahl > 2) {
						auswahl = JOptionPane.showConfirmDialog(null,
								"Bist du sicher ? Alle Daten gehen verloren !",
								"Tab-Schlie�en", JOptionPane.YES_NO_OPTION);
						if (auswahl == JOptionPane.YES_OPTION) {
							jtpmain.jtpmaindesc.remove(zahl);
						}
					}
				}
			}
		});

	}

	// KeyListener f\u00FCr die Suchfunktion
	public void searchKeyListener() {
		jtfsearch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				// Abfrage ob "Enter" gedr\u00FCckt wurde (KeyCode = 10)
				if (e.getKeyCode() == 10) {

					// z\u00E4hlen der Tabs
					int tabindex = jtpmain.jtpmaindesc.getTabCount();

					// String-Array in dem die Title der Tabs gespeichert werden
					String[] title = new String[tabindex];

					// Speicher der Tab-Titel im Array
					for (int j = 0; j < tabindex; j++) {
						title[j] = jtpmain.jtpmaindesc.getTitleAt(j);
					}
					// Neu zeichnen lassen
					jpmain.removeAll();
					jpmain.revalidate();
					jpmain.repaint();

					// Pointer auf die Variable legen
					jtpmain.jtpmaindesc = jtpmain.jtpmaindesc(jtfsearch
							.getText());
					// Hinzuf\u00FCgen der TabbedPane zum Panel
					jpmain.add(jtpmain.jtpmaindesc);
					jpmain.setVisible(true);

					// Tabs hinzuf\u00FCgen
					AddTabs.insertArtist(jtpmain.jtpmaindesc,
							"Interpret eintragen");
					AddTabs.insertBand(jtpmain.jtpmaindesc, "Band eintragen");

					// Vorher bestehende Tabs wieder hinzuf\u00FCgen nach Suche
					for (int i = 0; i < tabindex; i++) {

						// Erst ab zweiten Tab ausf\u00FChren
						if (i > 2) {
							// \u00FCbergabe der Tab-Titel f\u00FCr Titel und
							// weiterleitung an die Suche
							AddTabs.showArtist(jtpmain.jtpmaindesc, title[i]);
						}
					}
					// Text wieder leeren - muss am Ende stehen
					jtfsearch.setText("");

					// MouseListener wieder hinzuf\u00FCgen
					mouseListenerJTP();
				}

			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Konfliktfreies sp\u00E4teres paralleles Betreiben des Dialoges
		// sicherstellen
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MusicLounge();

			}
		});

	}

}
