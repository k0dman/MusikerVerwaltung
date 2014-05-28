package testklassen;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JtpUebersichtstab00 extends JTabbedPane {

	// Instanzen für JPanels erzeugen
	private Uebersichtstabelle00 jpmaintable = new Uebersichtstabelle00();

	// Felder:

	// JTabbedPane
	private JTabbedPane jtpmaindesc;

	// JTable

	private JTable jtmaintable;

	// DefaultTableModel

	private DefaultTableModel dtm;

	// JScrollPane

	private JScrollPane jspmaintable;

	// Schrift:
	private Font ftfield;

	// JLabel
	private JLabel test;

	public JTabbedPane jtpmaindesc() {

		jtpmaindesc = new JTabbedPane();
		
		jtpmaindesc.addTab("Übersicht", jpmaintable.jpmaindesc());
		
				
		return jtpmaindesc;

	}
}