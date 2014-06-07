package musikerverwaltung.Swing;

import javax.swing.*;

import musikerverwaltung.Graphics.Icons;

public class AddTabs01 extends JTabbedPane {
	private EingabeformularArtist04 jpmainartist = new EingabeformularArtist04();
	private EingabeformularBand04 jpmainband = new EingabeformularBand04();
	private AnzeigeFormularArtist00 jpmainshowartist = new AnzeigeFormularArtist00();
	
	private Icons tabicons = new Icons();
	
	public void showArtist(Object artist, Object title, JTabbedPane jtpane) {
		
	
		jtpane.addTab(String.valueOf(artist), tabicons.icons[2], jpmainshowartist.jpmainArtist(artist));
		
	}

	public void insertArtist(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[2], jpmainartist.jpmainArtist());

	}

	public void insertBand(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[1], jpmainband.jpmainBand());

	}
}
