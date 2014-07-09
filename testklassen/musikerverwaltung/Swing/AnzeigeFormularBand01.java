package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import musikerverwaltung.Database.DBMethods03;
import musikerverwaltung.menschen.*;

public class AnzeigeFormularBand01 extends JPanel {

	// JPanel
	private JPanel jpmainband, jpmainleft, jpmainleftanzeige, jpmainmiddle,
			jpmainright, jpmainleftjl, jpmainleftjtf, jpmainleftehemalig,
			jpmainmiddlemitglieder, jpmainmiddletitel, jpmainrightreferenz,
			jpmainrightbuttons;

	// JLabel
	private JLabel jlname, jlmitglied, jlehemalig, jlstueckgruppe, jlreferenz,
			jlfueller;

	// JTextField
	private JTextField jtfname, jtfmitglied, jtfstueckgruppe, jtfreferenz;

	// Schrift:
	private Font ftfield;

	// JRadioButton
	private JRadioButton jrbehemaligja, jrbehemalignein;
	// ButtonGroup
	private ButtonGroup bgehemalig;

	// JComboBox
	private JComboBox<String> jcbmitgliedauswahl;

	// JTable
	private JTable jtbandmitglieder, jtbandtitles, jtbandreferenzen;

	// JScrollPane
	private JScrollPane jspmitglieder, jsptitles, jspreferenzen;

	// Instanz der Gruppe
	private Gruppe01 gruppe;

	// DefaultTableModel
	private TableModel dtm;

	// ListeSelcectionModel
	private ListSelectionModel cellSelectionModel;

	// Border
	private BorderSet border;

	// JButton
	private JButton jbsubmit, jbdelete;

	// InsertJPanel
	private InsertJPanel jpmainleftinsert;

	// String
	private String bandreferenz, bandstueck, bandmitglied, bandreferenz1,
			bandstueck1;

	// int
	private int idband, idbandreferenz, idbandstueck, idbandmitglied,
			idbandreferenz1, idbandstueck1, idbandmitglied1;

	// SelectTables
	private SelectTables selecttablesmitglieder, selecttablestitel,
			selecttablesreferenz;

	// HauptJPanel links
	private JPanel jpmainLeft(Object band) {

		// JPanel f\u00FCr JLabels
		jpmainleftjl = new JPanel(new GridLayout(5, 1, 1, 15));

		// JLabel erzeugen

		jlname = new JLabel("Name: ");
		jlmitglied = new JLabel("Mitglied: ");
		jlehemalig = new JLabel("Ehemalig: ");
		jlstueckgruppe = new JLabel("St\u00FCck: ");
		jlreferenz = new JLabel("Referenz: ");

		// Label Right anordnen

		jlname.setHorizontalAlignment(SwingConstants.RIGHT);
		jlmitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		jlehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		jlstueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		jlreferenz.setHorizontalAlignment(SwingConstants.RIGHT);

		// Label dem Panel hinzuf\u00FCgen

		jpmainleftjl.add(jlname);
		jpmainleftjl.add(jlstueckgruppe);
		jpmainleftjl.add(jlreferenz);
		jpmainleftjl.add(jlehemalig);
		jpmainleftjl.add(jlmitglied);

		// JPanel f\u00FCr JTF´s
		jpmainleftjtf = new JPanel(new GridLayout(5, 1, 1, 15));

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfname.setText(String.valueOf(band));
		jtfmitglied = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();

		// Instanz der Gruppe erzeugen um auf Daten aus der DB zugreifen zu
		// koennen
		gruppe = new Gruppe01(String.valueOf(band));

		bandmitglied = gruppe.dbSelectMitglieder().get(0).get(0);
		jtfmitglied.setText(bandmitglied);
		jtfstueckgruppe.setText(gruppe.getBandStueckDB());
		jtfreferenz.setText(gruppe.getBandReferenzDB());

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// JTextfield schrift festlegen
		jtfname.setFont(ftfield);
		jtfmitglied.setFont(ftfield);
		jtfstueckgruppe.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// Pr\u00FCfung ob m oder w oder ns
		boolean ja = false;
		boolean nein = false;

		if (gruppe.getBandAktivDB().equals("j"))
			ja = true;
		else
			nein = true;

		// JRadioButton erzeugen
		jrbehemaligja = new JRadioButton("Ja", ja);
		jrbehemaligja.setActionCommand("j");

		jrbehemalignein = new JRadioButton("Nein", nein);
		jrbehemalignein.setActionCommand("n");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgehemalig = new ButtonGroup();
		bgehemalig.add(jrbehemaligja);
		bgehemalig.add(jrbehemalignein);

		// JPanel f\u00FCr die JRadioButtons
		jpmainleftehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpmainleftehemalig.add(jrbehemaligja);
		jpmainleftehemalig.add(jrbehemalignein);

		// Instanz von Musiker erzeugen
		Musiker01 musiker = new Musiker01();

		// Vector-Var um JComboxBox zu f\u00FCllen
		Vector<String> selectmitglied = musiker.getMusikerArray();

		// Erzeugen der Combobox
		jcbmitgliedauswahl = new JComboBox<String>();
		jcbmitgliedauswahl.setModel(new DefaultComboBoxModel<String>(
				selectmitglied));
		jcbmitgliedauswahl.setToolTipText("Bitte w\u00E4hle einen Musiker aus");
		// JTextfields und JRadioButtons hinzuf\u00FCgen
		jpmainleftjtf.add(jtfname);
		jpmainleftjtf.add(jtfstueckgruppe);
		jpmainleftjtf.add(jtfreferenz);
		jpmainleftjtf.add(jpmainleftehemalig);
		jpmainleftjtf.add(jtfmitglied);

		// ToolTips hinzuf\u00FCgen
		jtfname.setToolTipText("Tragen Sie hier bitte den Namen der band ein");
		jtfmitglied
				.setToolTipText("Tragen Sie hier bitte die Bandmitglieder ein");
		jtfstueckgruppe
				.setToolTipText("Tragen Sie hier bitte ein St\u00FCck der Gruppe ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einer Band eintragen");

		jpmainleftanzeige = new JPanel(new GridLayout(1, 2, 1, 1));
		// HauptJPanel linke Seite erzeugen
		jpmainleft = new JPanel(new GridLayout(2, 1, 1, 1));

		// JPanel mit JLabels der HauptPanel der linken Seite zurordnen
		jpmainleftanzeige.add(jpmainleftjl);

		// JPanel mit JTF´s der HauptPanel der linken Seite zurordnen
		jpmainleftanzeige.add(jpmainleftjtf);
		jpmainleft.add(jpmainleftanzeige);
		jpmainleftinsert = new InsertJPanel();

		jpmainleft.add(jpmainleftinsert.insertJPanel(jcbmitgliedauswahl,
				gruppe.getBandName()));

		// Border setzen f\u00FCr das linke JPanel
		border = new BorderSet();
		border.setBorder(jpmainleftanzeige, "Band-Info's");

		return jpmainleft;
	}

	// HauptJPanel mitte
	private JPanel jpmainMiddle(Object band) {

		// JPanel mit Tabelle fuer Mitglieder
		jpmainmiddlemitglieder = new JPanel();

		// Instanz TableModel erzeugen
		dtm = new TableModel();

		// Instanz SelectTables
		selecttablesmitglieder = new SelectTables();

		// Zeiger setzen
		jpmainmiddlemitglieder = selecttablesmitglieder.selectTables(
				String.valueOf(band),
				"Mitglieder-Liste",
				dtm.dtm(1, 2, DBMethods03.COLUMN_IDENTIFIERSMEMBERS,
						gruppe.dbSelectMitglieder()));

		// ########### Unteres JPanel f\u00FCr die Mitte############
		// JPanel erzeugen
		jpmainmiddletitel = new JPanel();

		// Instanz SelectTables
		selecttablestitel = new SelectTables();

		// Zeiger setzen
		jpmainmiddletitel = selecttablestitel.selectTables(
				String.valueOf(band),
				"Mitglieder-Liste",
				dtm.dtm(1, 2, DBMethods03.COLUMN_IDENTIFIERSTITLES,
						gruppe.dbSelectTitel()));

		// HauptJPanel mitte
		jpmainmiddle = new JPanel(new GridLayout(2, 1, 1, 10));

		jpmainmiddle.add(jpmainmiddlemitglieder);
		jpmainmiddle.add(jpmainmiddletitel);

		return jpmainmiddle;
	}

	// HauptJPanel rechts
	private JPanel jpmainRight(Object band) {

		// JPanel mit Tabelle fuer die Referenzen
		jpmainrightreferenz = new JPanel();

		// Instanz SelectTables
		selecttablesreferenz = new SelectTables();

		// Zeiger setzen
		jpmainrightreferenz = selecttablesreferenz.selectTables(
				String.valueOf(band),
				"Referenzen-Liste",
				dtm.dtm(1, 1, DBMethods03.COLUMN_IDENTIFIERSREFERENCES,
						gruppe.dbSelectReferenzen()));

		// ##########################################//
		// JPanel f\u00FCr Buttons
		jpmainrightbuttons = new JPanel(new GridLayout(5, 1, 1, 5));

		// JButton erzeugen

		// Bestatigungsbutton
		jbsubmit = new JButton("Bearbeiten");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00F6schbutton
		jbdelete = new JButton("L\u00F6schen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um die Band zubearbeiten");
		jbdelete.setToolTipText("Hier klicken, um die Band zu l\u00F6schen");

		// L\u00FCenf\u00FCller einf\u00FCgen
		for (int i = 0; i < 3; i++) {
			jlfueller = new JLabel("");
			jpmainrightbuttons.add(jlfueller);
		}
		jpmainrightbuttons.add(jbsubmit);

		jpmainrightbuttons.add(jbdelete);

		jpmainright = new JPanel(new GridLayout(2, 1, 1, 1));
		jpmainright.add(jpmainrightreferenz);
		jpmainright.add(jpmainrightbuttons);

		return jpmainright;
	}

	// zusammenlegen der JPanels
	public JPanel jpmainBand(Object band) {

		jpmainband = new JPanel(new GridLayout(1, 3, 4, 4));

		jpmainband.add(jpmainLeft(band));
		jpmainband.add(jpmainMiddle(band));
		jpmainband.add(jpmainRight(band));

		// MouseListener hinzuf\u00FCgen
		MouseListenerTable mlt = new MouseListenerTable();
		mlt.mouseListenerBandMitglieder(selecttablesmitglieder.jt, jtfmitglied,
				jrbehemaligja, jrbehemalignein);
		mlt.mouseListenerBandReferenzen(selecttablesreferenz.jt, jtfreferenz);
		mlt.mouseListenerBandTitel(selecttablestitel.jt, jtfstueckgruppe);

		// Bandname
		idband = gruppe.getBandIDDB();
		// Bandmitglied
		idbandmitglied1 = gruppe.getBandIDS(bandmitglied);

		// BandReferenz
		bandreferenz = gruppe.getBandReferenzDB();
		idbandreferenz1 = gruppe.getBandIDS(bandreferenz);

		// BandStueck
		bandstueck = gruppe.getBandStueckDB();
		idbandstueck1 = gruppe.getBandIDS(bandstueck);

		listener();
		actionListener();

		return jpmainband;

	}

	public void listener() {

		jtfstueckgruppe.getDocument().addDocumentListener(
				new DocumentListener() {
					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub

						bandstueck = jtfstueckgruppe.getText();
						idbandstueck = gruppe.getBandIDS(bandstueck);

						if (gruppe.idProofBandStueck(idbandstueck)) {
							bandstueck1 = bandstueck;
							idbandstueck1 = gruppe.getBandIDS(bandstueck1);
						}

						if (idbandstueck == 0)

							idbandstueck = idbandstueck1;

					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub

					}
				});

		jtfreferenz.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				bandreferenz = jtfreferenz.getText();

				idbandreferenz = gruppe.getBandIDS(bandreferenz);

				if (gruppe.idProofBandReferenz(idbandreferenz)) {
					bandreferenz1 = bandreferenz;
					idbandreferenz1 = gruppe.getBandIDS(bandreferenz1);
				}

				if (idbandreferenz == 0)
					idbandreferenz = idbandreferenz1;
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void actionListener() {
		jbsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (idbandmitglied == 0)
					idbandmitglied = idbandmitglied1;

				if (idbandreferenz == 0)
					idbandreferenz = idbandreferenz1;

				if (idbandstueck == 0)
					idbandstueck = idbandstueck1;

				gruppe = new Gruppe01(jtfname.getText(), jtfmitglied.getText(),
						idband, idbandmitglied, idbandreferenz, idbandstueck,
						jtfstueckgruppe.getText(), jtfreferenz.getText(),
						bgehemalig.getSelection().getActionCommand());

				gruppe.updateBand();

			}
		});
		// delete-Button
		jbdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)

			{
				int auswahl = JOptionPane.showConfirmDialog(null,
						"Willst du diesen Interpreten wirklich l\u00F6schen?",
						"L\u00F6schen", JOptionPane.YES_NO_OPTION);

				if (auswahl == JOptionPane.YES_OPTION) {
					// Delete-Methode aufrufen
					gruppe.deleteBand();
				}

			}
		});

	}

}
