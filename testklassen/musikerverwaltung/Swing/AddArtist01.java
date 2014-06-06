package musikerverwaltung.Swing;

import javax.swing.*;

public class AddArtist01 extends JTabbedPane {
	private EingabeformularArtist04 jpmainartist = new EingabeformularArtist04();
	private EingabeformularBand04 jpmainband = new EingabeformularBand04();

	private JLabel jltest;
	private JPanel content;
	private String iconpath = "/progis";
	private Icon[] tabicons = {
			// EINS [0-2]
			new ImageIcon(
					iconpath+"/git/MusikerVerwaltung/pics/chorus-icon.png"),
			new ImageIcon(
					iconpath+"/git/MusikerVerwaltung/pics/Performer-SH-icon.png") };

	public void addArtist(Object artist, Object title, JTabbedPane jtpane) {
		String name = artist + " - " + title;
		content = new JPanel();
		jltest = new JLabel(name);
		content.add(jltest);

		jtpane.addTab(String.valueOf(artist), content);

	}

	public void insertArtist(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons[1], jpmainartist.jpmainArtist());

	}

	public void insertBand(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons[0], jpmainband.jpmainBand());

	}
}
