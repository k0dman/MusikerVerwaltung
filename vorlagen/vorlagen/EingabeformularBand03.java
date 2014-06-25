package vorlagen;

import java.awt.*;

import javax.swing.*;

public class EingabeformularBand03 extends JPanel {

	// Felder:

	// Panel
	private JPanel jpmaindesc, jpmaininput;

	// Schrift:
	private Font ftfield;

	// Label
	private JLabel ueschrift, name, mitglied, ehemalig, stueckgruppe, referenz, fueller;

	// JTextField

	private JTextField jtfname, jtfmitglied, jtfehemalig, jtfstueckgruppe, jtfreferenz;

	public JPanel jpmaindesc() {

		// Panel erzeugen mit GridLayout
		JPanel jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

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

		// Label rechts anordnen
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

	public JPanel jpmaininput() {

		// Panel erzeugen mit Gridlayout
		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		// Label erzeugen
		fueller = new JLabel("");
		jpmaininput.add(fueller);

		// JTextFields erzeugen
		jtfname = new JTextField();
		jtfmitglied = new JTextField();
		jtfehemalig = new JTextField();
		jtfstueckgruppe = new JTextField();
		jtfreferenz = new JTextField();

		// JTextfields verg\u00F6sern
		jtfname.setColumns(10);
		jtfmitglied.setColumns(10);
		jtfehemalig.setColumns(10);
		jtfstueckgruppe.setColumns(10);
		jtfreferenz.setColumns(10);

		// JTextfield schrift festlegen
		jtfname.setFont(ftfield);
		jtfmitglied.setFont(ftfield);
		jtfehemalig.setFont(ftfield);
		jtfstueckgruppe.setFont(ftfield);
		jtfreferenz.setFont(ftfield);

		// JTextfields hinzuf\u00FCgen
		jpmaininput.add(jtfname);
		jpmaininput.add(jtfmitglied);
		jpmaininput.add(jtfehemalig);
		jpmaininput.add(jtfstueckgruppe);
		jpmaininput.add(jtfreferenz);

		return jpmaininput;

	}

	public JPanel jpmainrechts() {

		//Panel erzeugen mit Gridlayout
		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		return jpmaininput;

	}

}
