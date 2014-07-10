package musikerverwaltung.swing;

import javax.swing.*;

import musikerverwaltung.graphics.Icons01;

public final class AddTabs extends JTabbedPane {
	
	private static final EingabeformularArtist jpmainartist = new EingabeformularArtist();
	private static final EingabeformularBand jpmainband = new EingabeformularBand();
	private static final AnzeigeFormularArtist jpmainshowartist = new AnzeigeFormularArtist();
	private static final AnzeigeFormularBand jpmainshowband = new AnzeigeFormularBand();
	
	private static Icons01 tabicons = new Icons01();
	
	public static void showArtist(JTabbedPane jtpane, Object artist) {
		
		jtpane.addTab(String.valueOf(artist), tabicons.icons[2], jpmainshowartist.jpmainArtist(artist));
		
	}

	public static void showBand(JTabbedPane jtpane, Object band) {

		jtpane.addTab(String.valueOf(band), tabicons.icons[1], jpmainshowband.jpmainBand(band));

	}
	
	public static void insertArtist(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[2], jpmainartist.jpmainArtist());

	}

	public static void insertBand(JTabbedPane jtpane, String name) {

		jtpane.addTab(name, tabicons.icons[1], jpmainband.jpmainBand());

	}
	

}
