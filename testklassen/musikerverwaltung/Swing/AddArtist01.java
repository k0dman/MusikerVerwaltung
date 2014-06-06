package musikerverwaltung.Swing;

import javax.swing.*;

import musikerverwaltung.Graphics.Icons;

public class AddArtist01 extends JTabbedPane {
	private EingabeformularArtist04 jpmainartist = new EingabeformularArtist04();
	private EingabeformularBand04 jpmainband = new EingabeformularBand04();
	private Icons tabicons = new Icons();
	private JLabel jltest;
	private JPanel content;
	
	public void addArtist(Object artist, Object title, JTabbedPane jtpane) {
		String name = artist + " - " + title;
		content = new JPanel();
		jltest = new JLabel(name);
		content.add(jltest);

		jtpane.addTab(String.valueOf(artist), content);

	}

	public void insertArtist(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[2], jpmainartist.jpmainArtist());

	}

	public void insertBand(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[1], jpmainband.jpmainBand());

	}
}
