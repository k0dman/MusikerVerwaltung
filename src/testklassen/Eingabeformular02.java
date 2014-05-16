package testklassen;

import java.awt.*;

import javax.swing.*;

public class Eingabeformular02 extends JPanel {

	private JPanel jpmainhead, jpmaindesc, jpmaininput;
	private JLabel keks;

	public JPanel jpmainhead() {

		JPanel jpmainhead = new JPanel(new BorderLayout());
		jpmainhead.setBackground(Color.RED);

		keks = new JLabel("Hallo");
		jpmainhead.add(keks);
		return jpmainhead;

	}

	public JPanel jpmaindesc() {

		JPanel jpmaindesc = new JPanel();
		jpmaindesc.setBackground(Color.GREEN);

		keks = new JLabel("waztt");
		jpmaindesc.add(keks);
		return jpmaindesc;

	}

	public JPanel jpmaininput() {

		JPanel jpmaininput = new JPanel();
		jpmaininput.setBackground(Color.GRAY);

		keks = new JLabel("Hööö");
		jpmaininput.add(keks);
		return jpmaininput;

	}
	
	

}
