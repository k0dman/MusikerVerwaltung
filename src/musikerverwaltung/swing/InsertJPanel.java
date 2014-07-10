package musikerverwaltung.swing;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import musikerverwaltung.menschen.Gruppe01;
import musikerverwaltung.menschen.Musiker01;

public class InsertJPanel {

	private JPanel jpmainleftinsert, jpmainleftinsertbg, jpmainleftehemalig;
	private JLabel jlfueller, jlehemalig;
	public JButton jbinsert;
	private JRadioButton jrbstueckgruppe, jrbreferenz, jrbmitglied,
			jrbehemalignein, jrbehemaligja;
	private ButtonGroup bginsert, bgehemalig;
	private JTextField jtfinsert;
	private BorderSet border;

	public JPanel insertJPanel(JComboBox<String> jcb, String band) {
		// jpmainleftinsert
		jpmainleftinsert = new JPanel(new GridLayout(5, 1, 1, 20));

		// Einf\u00FCgenbutton
		jbinsert = new JButton("Einf\u00FCgen");
		jbinsert.setPreferredSize(new Dimension(10, 20));

		// JRadioButton erzeugen

		jrbstueckgruppe = new JRadioButton("St\u00FCck");
		jrbstueckgruppe.setActionCommand("s");

		jrbreferenz = new JRadioButton("Referenz");
		jrbreferenz.setActionCommand("r");

		jrbmitglied = new JRadioButton("Mitglied");
		jrbmitglied.setActionCommand("m");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bginsert = new ButtonGroup();
		bginsert.add(jrbstueckgruppe);
		bginsert.add(jrbreferenz);
		bginsert.add(jrbmitglied);

		// JRadioButton erzeugen
		jrbehemaligja = new JRadioButton("Ja");
		jrbehemaligja.setActionCommand("j");

		jrbehemalignein = new JRadioButton("Nein");
		jrbehemalignein.setActionCommand("n");

		// JRadioButtons ButtonGroup hinzuf\u00FCgen
		bgehemalig = new ButtonGroup();
		bgehemalig.add(jrbehemaligja);
		bgehemalig.add(jrbehemalignein);
		jlehemalig = new JLabel("Ehemaliges Mitglied: ");
		// JPanel f\u00FCr die JRadioButtons
		jpmainleftehemalig = new JPanel(new GridLayout(1, 1, 0, 10));
		jpmainleftehemalig.add(jlehemalig);
		jpmainleftehemalig.add(jrbehemaligja);
		jpmainleftehemalig.add(jrbehemalignein);

		// JPanel f\u00FCr die JRadioButtons
		jpmainleftinsertbg = new JPanel(new GridLayout(1, 1, 0, 10));
		jpmainleftinsertbg.add(jrbstueckgruppe);
		jpmainleftinsertbg.add(jrbreferenz);
		jpmainleftinsertbg.add(jrbmitglied);

		// JTexTField erzeugen

		jtfinsert = new JTextField();
		// JTF dem jpmainleftinsert hinzuf\u00FCgen
		standardInhaltInsertJPanel();

		border = new BorderSet();
		border.setBorder(jpmainleftinsert, "Datensatz eintragen");

		actionListener(jcb, band);

		return jpmainleftinsert;
	}

	// Fuer die beiden JRB´s Referenz und Stueckgruppe
	public JPanel standardInhaltInsertJPanel() {
		jpmainleftinsert.repaint();
		jpmainleftinsert.revalidate();
		jpmainleftinsert.setLayout(new GridLayout(5, 1, 1, 20));
		jpmainleftinsert.removeAll();

		for (int i = 0; i < 2; i++) {
			jlfueller = new JLabel("");
			jpmainleftinsert.add(jlfueller);
		}
		jpmainleftinsert.add(jpmainleftinsertbg);
		jpmainleftinsert.add(jtfinsert);
		jpmainleftinsert.add(jbinsert);
		jtfinsert.setEnabled(true);

		return jpmainleftinsert;
	}

	public void actionListener(final JComboBox<String> jcb, final String band) {
		jrbmitglied.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbmitglied.isSelected()) {
					jpmainleftinsert.removeAll();
					jpmainleftinsert.repaint();
					jpmainleftinsert.revalidate();
					jpmainleftinsert.setLayout(new GridLayout(6, 1, 1, 10));
					for (int i = 0; i < 1; i++) {
						jlfueller = new JLabel("");
						jpmainleftinsert.add(jlfueller);
					}
					jpmainleftinsert.add(jpmainleftehemalig);
					jpmainleftinsert.add(jcb);
					jpmainleftinsert.add(jpmainleftinsertbg);
					jpmainleftinsert.add(jtfinsert);
					jpmainleftinsert.add(jbinsert);
					jtfinsert.setEnabled(false);

				}
			}
		});

		jrbstueckgruppe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbstueckgruppe.isSelected()) {
					standardInhaltInsertJPanel();

				}
			}
		});
		jrbreferenz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jrbreferenz.isSelected()) {
					standardInhaltInsertJPanel();
				}
			}
		});

		// ActionListener, setzt ausgew\u00E4hltes Textfeld nach Auswahl eines
		// Items aus JComboBox
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// Auswahl der aus der JComboBox in var speichern
				String mitglied = String.valueOf(jcb.getSelectedItem());

				// das ausgew\u00E4hlte Mitglied in das JTextfield einf\u00FCgen
				jtfinsert.setText(mitglied);

			}
		});
		// einf\u00FCgen-Button
		jbinsert.addActionListener(new ActionListener() {
			Gruppe01 gruppe = new Gruppe01(band);

			public void actionPerformed(ActionEvent ae)

			{
				String isleer = jtfinsert.getText();
				if (isleer.equals("")) {
					JOptionPane.showMessageDialog(null, "Nichts eingetragen !");
				} else {
					if (bginsert.getSelection().getActionCommand().equals("s")) {
						// Insert St\u00FCcksolo
						gruppe.insertStueckBand(jtfinsert.getText());
						jtfinsert.setText("");
					}

					if (bginsert.getSelection().getActionCommand().equals("r")) {
						// Insert Referenz

						gruppe.insertReferenzBand(jtfinsert.getText());
						jtfinsert.setText("");
					}

					if (bginsert.getSelection().getActionCommand().equals("m")) {
						// Insert Mitglied
						Musiker01 musiker = new Musiker01(String.valueOf(jcb
								.getSelectedItem()));
						gruppe.insertMitgliedBand(bgehemalig.getSelection()
								.getActionCommand(), musiker
								.getMusikerIDMusiker());
						jtfinsert.setText("");
						AnzeigeFormularBand afbrefresh = new AnzeigeFormularBand();
						afbrefresh.refresh();

					}
				}
			}
		});
	}
}
