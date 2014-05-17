package testklassen;

import java.awt.*;

import javax.swing.*;

public class EingabeformularBand02 extends JPanel {

	// Felder:

	// Panel
	private JPanel jpmaindesc, jpmaininput;

	// Schrift:
	private Font ftfield;

	// Label
	private JLabel ueschrift;
	private JLabel name;
	private JLabel mitglied;
	private JLabel ehemalig;
	private JLabel stueckgruppe;
	private JLabel referenz;
	private JLabel fueller;

	// JTextField

	private JTextField jtfname;
	private JTextField jtfmitglied;
	private JTextField jtfehemalig;
	private JTextField jtfstueckgruppe;
	private JTextField jtfreferenz;

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
		stueckgruppe = new JLabel("Stueck");
		referenz = new JLabel("Referenz");

		// Label dem Panel hinzuefuegen
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

		// Schrift dem gewuenschten Label hinzufuegen
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

		// JTextfields vergoesern
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

		// JTextfields hinzufuegen
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
