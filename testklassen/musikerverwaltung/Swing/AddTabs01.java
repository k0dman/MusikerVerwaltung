package musikerverwaltung.Swing;

import javax.swing.*;

import musikerverwaltung.Graphics.Icons;

public final class AddTabs01 extends JTabbedPane {
	private static final EingabeformularArtist04 jpmainartist = new EingabeformularArtist04();
	private static final EingabeformularBand05 jpmainband = new EingabeformularBand05();
	private static final AnzeigeFormularArtist00 jpmainshowartist = new AnzeigeFormularArtist00();
	
	private static Icons tabicons = new Icons();
	
	public static void showArtist(Object artist, Object title, JTabbedPane jtpane) {
		
	
		jtpane.addTab(String.valueOf(artist), tabicons.icons[2], jpmainshowartist.jpmainArtist(artist));
		
		
	}

	public static void insertArtist(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[2], jpmainartist.jpmainArtist());

	}

	public static void insertBand(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[1], jpmainband.jpmainBand());

	}
}
