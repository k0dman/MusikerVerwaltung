package vorlagen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import testklassen.JTableUebersichtstab00;
import testklassen.JtpUebersichtstab00;

public class Uebersichtstabelle00 extends JTabbedPane {

	private JtpUebersichtstab00 jpaddpanel = new JtpUebersichtstab00();
	private JTableUebersichtstab00 jtmaintable = new JTableUebersichtstab00();
	// Felder:

	// JTabbedPane
	private JTabbedPane jtpmaindesc;

	// JScrollPane

	private JScrollPane jspmaintable;

	// Schrift:
	private Font ftfield;

	public JTabbedPane jtpmaindesc() {

		// Panel erzeugen mit GridLayout
		JTabbedPane jtpmaindesc = new JTabbedPane(JTabbedPane.TOP,
				JTabbedPane.SCROLL_TAB_LAYOUT);

		// Schriften erzeugen
		ftfield = new Font(Font.SANS_SERIF, Font.BOLD + Font.ITALIC, 15);

		jspmaintable = new JScrollPane(jtmaintable.jtmaintable());

		// JScrollPane dem JTabbedPane hinzufuegem

		// Groesse der Tabelle festlegen, das sonst keinen Scrollen vorhanden
		// ist, auﬂerdem schoener:) //860 , 600
		jspmaintable.setPreferredSize(new Dimension(860, 600));

		jspmaintable.setViewportView(jtmaintable.jtmaintable);

		jtpmaindesc.addTab("Tabelle", jspmaintable);
		jtpmaindesc.addTab("222", jpaddpanel.jpmaindesc());

		// Aufruf der MouseListener aus der JTable-Klasse (Evtl. wieder
		// zurueckpacken)
		jtmaintable.mouseListenertable();

		return jtpmaindesc;

	}

}
