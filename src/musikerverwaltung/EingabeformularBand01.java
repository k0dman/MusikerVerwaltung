package musikerverwaltung;

import java.awt.*;

import javax.swing.*;

public class EingabeformularBand01 extends JPanel {

	// Felder:

	// Panels
	private JPanel jpmaindesc, jpmaininput;

	// Schriften:
	private Font ftfield;

	// Labels
	private JLabel ueschrift;

	private JLabel name;
	private JLabel mitglied;
	private JLabel ehemalig;
	private JLabel stueckgruppe;
	private JLabel referenz;
	private JLabel fueller;

	// JTextField
	private JTextField jtfueschrift;
	private JTextField jtfname;
	private JTextField jtfmitglied;
	private JTextField jtfehemalig;
	private JTextField jtfstueckgruppe;
	private JTextField jtfueller;
	private JTextField jtfreferenz;
	

	public JPanel jpmaindesc() {

		JPanel jpmaindesc = new JPanel(new GridLayout(13, 1, 10, 10));

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		ueschrift = new JLabel("Tragen Sie eine Band ein:");
		name = new JLabel("Name");
		mitglied = new JLabel("Mitglied");
		ehemalig = new JLabel("Ehemalig");
		stueckgruppe = new JLabel("Stueck");
		referenz = new JLabel("Referenz");


		jpmaindesc.add(ueschrift);
		jpmaindesc.add(name);
		jpmaindesc.add(mitglied);
		jpmaindesc.add(ehemalig);
		jpmaindesc.add(stueckgruppe);
		jpmaindesc.add(referenz);

		ueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		mitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		ehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		stueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		referenz.setHorizontalAlignment(SwingConstants.RIGHT);

		ueschrift.setFont(ftfield);

		return jpmaindesc;

	}

	public JPanel jpmaininput() {

		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

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

		JPanel jpmaininput = new JPanel(new GridLayout(13, 1, 1, 10));

		return jpmaininput;

	}

}
