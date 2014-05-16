package testklassen;

import java.awt.*;

import javax.swing.*;

public class EingabeformularBand01 extends JPanel {

	private JPanel jpmainhead, jpmaindesc, jpmaininput;
	private JLabel keks;

	public JPanel jpmainhead() {

		JPanel jpmainhead = new JPanel(new BorderLayout());
		jpmainhead.setBackground(Color.WHITE);

		keks = new JLabel("fawfwaf");
		jpmainhead.add(keks);
		return jpmainhead;

	}

	public JPanel jpmaindesc() {

		JPanel jpmaindesc = new JPanel();
		jpmaindesc.setBackground(Color.WHITE);

		keks = new JLabel("fwafawf");
		jpmaindesc.add(keks);
		jpmaindesc.setVisible(false);
		return jpmaindesc;

	}

	public JPanel jpmaininput() {

		JPanel jpmaininput = new JPanel();
		jpmaininput.setBackground(Color.GRAY);

		keks = new JLabel("fwaf");
		jpmaininput.add(keks);
		jpmaininput.setVisible(true);
		setOpaque(true);
		return jpmaininput;

	}
	
	

}
