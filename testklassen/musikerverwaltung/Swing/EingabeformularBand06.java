package musikerverwaltung.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import musikerverwaltung.menschen.*;

public class EingabeformularBand06 extends JPanel {

	// Felder:
	private JComboBox<String> jcbmitgliedauswahl;

	// Panel
	private JPanel jpmaininput, jpmainband, jpmaindesc, jpmainright,
			jpehemalig;

	// Schrift:
	private Font ftfield;

	// Label
	private JLabel ueschrift, name, mitglied, ehemalig, stueckgruppe, referenz,
			fueller;

	// JButton
	private JButton jbsubmit;

	// JTextField
	private JTextField jtfname, jtfmitglied, jtfstueckgruppe, jtfreferenz;

	// JRadioButton
	private JRadioButton jrbehemaligja, jrbehemalignein;

	// ButtonGroup
	private ButtonGroup bgehemalig;

	public JPanel jpmainDesc() {

		// Panel erzeugen mit GridLayout
		jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		// Label erzeugen
		ueschrift = new JLabel("Tragen Sie eine Band ein:");
		name = new JLabel("Name");
		mitglied = new JLabel("Mitglied");
		ehemalig = new JLabel("Ehemalig");
		stueckgruppe = new JLabel("St\u00FCck");
		referenz = new JLabel("Referenz");

		// Label dem Panel hinzuf\u00FCgen
		jpmaindesc.add(ueschrift);
		jpmaindesc.add(name);
		jpmaindesc.add(mitglied);
		jpmaindesc.add(ehemalig);
		jpmaindesc.add(stueckgruppe);
		jpmaindesc.add(referenz);

		// Label Right anordnen
		ueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		mitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		ehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		stueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		referenz.setHorizontalAlignment(SwingConstants.RIGHT);

		// Schrift dem gew\u00FCnschten Label hinzuf\u00FCgen
		ueschrift.setFont(ftfield);

		return jpmaindesc;

	}

	public JPanel jpmainInput() {

		// Panel erzeugen mit Gridlayout
		jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		// Label erzeugen
		fueller = new JLabel("");
		jpmaininput.add(fueller);

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfmitglied = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();

		// JTextfields verg\u00F6sern
		jtfname.setColumns(10);
		jtfmitglied.setColumns(10);
		jtfstueckgruppe.setColumns(10);
		jtfreferenz.setColumns(10);

		// JTextfield schrift festlegen
		jtfname.setFont(ftfield);
		jtfmitglied.setFont(ftfield);
		jtfstueckgruppe.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// JRadioButton erzeugen

		jrbehemaligja = new JRadioButton("Ja");
		jrbehemaligja.setActionCommand("j");

		jrbehemalignein = new JRadioButton("Nein");
		jrbehemalignein.setActionCommand("n");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgehemalig = new ButtonGroup();
		bgehemalig.add(jrbehemaligja);
		bgehemalig.add(jrbehemalignein);

		// JPanel fuer die JRadioButtons
		jpehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpehemalig.add(jrbehemaligja);
		jpehemalig.add(jrbehemalignein);

		// JTextfields und JRadioButtons hinzuf\u00FCgen
		jpmaininput.add(jtfname);
		jpmaininput.add(jtfmitglied);
		jpmaininput.add(jpehemalig);
		jpmaininput.add(jtfstueckgruppe);
		jpmaininput.add(jtfreferenz);

		// ToolTips hinzuf\u00FCgen

		jtfname.setToolTipText("Tragen Sie hier bitte den Namen der band ein");
		jtfmitglied
				.setToolTipText("Tragen Sie hier bitte die Bandmitglieder ein");
		jtfstueckgruppe
				.setToolTipText("Tragen Sie hier bitte ein Stueck der Gruppe ein");
		jtfreferenz
				.setToolTipText("Hier k\u00F6nnen Sie eine Referenz zu einer Band eintragen");

		BorderSet border = new BorderSet();
		border.setBorder(jpmaininput, " ");
		
		return jpmaininput;

	}

	public JPanel jpmainRight() {

		// JPanel erzeugen
		jpmainright = new JPanel(new GridLayout(13, 1, 1, 10));

		// JButton erzeugen
		jbsubmit = new JButton("Eintragen");
		jbsubmit.setPreferredSize(new Dimension(10, 20));

		// L\u00FCenf\u00FCller einf\u00FCgen
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);

		Musiker01 musiker = new Musiker01();

		Vector<String> selectmitglied = musiker.getMusikerArray();

		// Erzeugen der Combobox
		jcbmitgliedauswahl = new JComboBox<String>();
		jcbmitgliedauswahl.setModel(new DefaultComboBoxModel<String>(
				selectmitglied));

		jpmainright.add(jcbmitgliedauswahl);

		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");
		jpmainright.add(fueller);
		fueller = new JLabel("");

		// JButton dem JPanel hinzuf\u00FCgen
		jpmainright.add(jbsubmit, BorderLayout.SOUTH);

		// In Arbeit
		jbsubmit.setPreferredSize(new Dimension(0, 0));
		// ToolTip hinzuf\u00FCgen
		jbsubmit.setToolTipText("Hier klicken, um die Band anzulegen");

		return jpmainright;

	}

	public JPanel jpmainBand() {

		jpmainband = new JPanel(new GridLayout(1, 2, 4, 4));
	
		jpmainband.add(jpmainDesc());
		jpmainband.add(jpmainInput());
		jpmainband.add(jpmainRight());
		bandActionListener();

		BorderSet border = new BorderSet();
		border.setBorder(jpmainband, "");
		
		
		return jpmainband;

	}

	public void bandActionListener() {
		jbsubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Instanz eines Musikers erzeugen um ID herauszubekommen
				Musiker01 musiker = new Musiker01(jtfmitglied.getText());
				System.out.println(jtfreferenz.getText());
				
				//Instanz einer Gruppe erzeugen um Insert-Methode aufrufen zu koennen
				Gruppe01 gruppe = new Gruppe01(jtfname.getText(), jtfmitglied.getText(), musiker.getMusikerIDPerson(), jtfstueckgruppe
						.getText(), jtfreferenz.getText(), bgehemalig.getSelection().getActionCommand());
	
				// Insert-Methode aufrufen
				gruppe.insertBand();

				//TextFelder wieder leeren
				jtfname.setText("");
				jtfmitglied.setText("");
				jtfstueckgruppe.setText("");
				jtfreferenz.setText("");

			}
		});
		jcbmitgliedauswahl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Auswahl der aus der JComboBox in var speichern
				String mitglied = String.valueOf(jcbmitgliedauswahl
						.getSelectedItem());

				// das ausgewaehlte Mitglied in das JTextfield einfuegen
				jtfmitglied.setText(mitglied);

			}
		});

	}

}
