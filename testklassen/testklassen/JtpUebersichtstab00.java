package testklassen;

/*In dieser Klasse wird die Tabelle einer JTabbedPane hinzufuegt*/

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JtpUebersichtstab00 extends JPanel {

	// Instanzen fuer JPanel erzeugen
    //	private Uebersichtstabelle00 jpmaintable = new Uebersichtstabelle00();

	// Felder:

	// JPanel
	private JPanel jpmaindesc;

	//JLabel
	private JLabel jltest;
	
	public JPanel jpmaindesc() {

		// neue JPanel erzeugen
		jpmaindesc = new JPanel();

		// neue JLabel
		
		jltest = new JLabel("Hallo");
		
		// Tab hinzufuegen
		jpmaindesc.add(jltest);

		// JTP zurueckgeben
		return jpmaindesc;

	}

}