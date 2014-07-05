package musikerverwaltung.Swing;

import javax.swing.*;
import java.awt.*;

import musikerverwaltung.Graphics.Icons01;

public final class AddTabs02 extends JTabbedPane {
	
	private static final EingabeformularArtist05 jpmainartist = new EingabeformularArtist05();
	private static final EingabeformularBand06 jpmainband = new EingabeformularBand06();
	private static final AnzeigeFormularArtist02 jpmainshowartist = new AnzeigeFormularArtist02();
	private static final AnzeigeFormularBand01 jpmainshowband = new AnzeigeFormularBand01();
	
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
