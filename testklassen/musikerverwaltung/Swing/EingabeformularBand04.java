package musikerverwaltung.Swing;

import java.awt.*;

import javax.swing.*;

public class EingabeformularBand04 extends JPanel {

	// Felder:

	// Panel
	private JPanel jpmainDesc, jpmainInput, jpmainband;

	// Schrift:
	private Font ftfield;

	// Label
	private JLabel ueschrift, name, mitglied, ehemalig, stueckgruppe, referenz, fueller;

	// JTextField

	private JTextField jtfname, jtfmitglied, jtfehemalig, jtfstueckgruppe, jtfreferenz;

	public JPanel jpmainDesc() {

		// Panel erzeugen mit GridLayout
		JPanel jpmainDesc = new JPanel(new GridLayout(13, 1, 10, 10));

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
		jpmainDesc.add(ueschrift);
		jpmainDesc.add(name);
		jpmainDesc.add(mitglied);
		jpmainDesc.add(ehemalig);
		jpmainDesc.add(stueckgruppe);
		jpmainDesc.add(referenz);

		// Label Right anordnen
		ueschrift.setHorizontalAlignment(SwingConstants.RIGHT);
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		mitglied.setHorizontalAlignment(SwingConstants.RIGHT);
		ehemalig.setHorizontalAlignment(SwingConstants.RIGHT);
		stueckgruppe.setHorizontalAlignment(SwingConstants.RIGHT);
		referenz.setHorizontalAlignment(SwingConstants.RIGHT);

		// Schrift dem gew\u00FCnschten Label hinzuf\u00FCgen
		ueschrift.setFont(ftfield);

		return jpmainDesc;

	}

	public JPanel jpmainInput() {

		// Panel erzeugen mit Gridlayout
		JPanel jpmainInput = new JPanel(new GridLayout(13, 1, 1, 10));

		// Label erzeugen
		fueller = new JLabel("");
		jpmainInput.add(fueller);

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
		jpmainInput.add(jtfname);
		jpmainInput.add(jtfmitglied);
		jpmainInput.add(jtfehemalig);
		jpmainInput.add(jtfstueckgruppe);
		jpmainInput.add(jtfreferenz);

		return jpmainInput;

	}

	public JPanel jpmainRight() {

		//Panel erzeugen mit Gridlayout
		JPanel jpmainInput = new JPanel(new GridLayout(13, 1, 1, 10));

		return jpmainInput;

	}
	
	public JPanel jpmainBand() {
		
	jpmainband = new JPanel(new GridLayout(1, 2, 4, 4));
	
	
	jpmainband.add(jpmainDesc());
	jpmainband.add(jpmainInput());
	jpmainband.add(jpmainRight());
		
	return jpmainband;
		
		
		
		
		
	}

}
