package musikerverwaltung.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MouseListenerTable {

	// Methode fuer AnzeigeFormularArtist - Tabellen
	public void mouseListenerArtistTables(final JTable jtable,
			final JTextField jtf) {

		jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtable.getSelectedRow();
					int column = jtable.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object titel = jtable.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtf.setText(String.valueOf(titel));
					}
				}
			}
		});

	}

	// Methode fuer AnzeigeFormularArtist - Tabellen
	public void mouseListenerArtistTableReferenz(final JTable jtable,
			final JTextField jtf) {

		jtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtable.getSelectedRow();
					int column = jtable.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object referenz = jtable.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtf.setText(String.valueOf(referenz));
					}
					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// Browseraufruf (für Windows):
						try {
							Runtime.getRuntime().exec(
									"cmd.exe /c start " + referenz);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			}
		});

	}

	// Methode fuer AnzeigeFormularBand
	public void mouseListenerBandMitglieder(final JTable jtable,
			final JTextField jtf, final JRadioButton jrb1,
			final JRadioButton jrb2) {

		jtable.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtable.getSelectedRow();
					int column = jtable.getSelectedColumn();
					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object mitglied = jtable.getValueAt(row, column);
					Object title = jtable.getValueAt(row, column);

					title = String.valueOf(title);
					if (column == 0) {
						if (e.getClickCount() == 1) {
							jtf.setText(String.valueOf(mitglied));
						}
						if (e.getClickCount() == 2 | e.getButton() == 2) {

						}
					} else if (column == 1) {
						if (e.getClickCount() == 1) {
							if (title.equals("j"))
								jrb1.setSelected(true);
							else
								jrb2.setSelected(true);
						}
					}

				}
			}

		});

	}

	public void mouseListenerBandReferenzen(final JTable jtable,
			final JTextField jtf) {
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtable.getSelectedRow();
					int column = jtable.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object referenz = jtable.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtf.setText(String.valueOf(referenz));
					}

					if (e.getClickCount() == 2 | e.getButton() == 2) {

						// Browseraufruf (für Windows):
						try {
							Runtime.getRuntime().exec(
									"cmd.exe /c start " + referenz);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}

		});
	}

	public void mouseListenerBandTitel(final JTable jtable, final JTextField jtf) {
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// wenn die mittlere Maustaste gedrueckt wird - ausfuehren
				if (e.getButton() == 1 || e.getButton() == 2) {

					// In Var die ausgewaehlten Zeilen und Spalten speichern
					int row = jtable.getSelectedRow();
					int column = jtable.getSelectedColumn();

					// Die Werte des ausgewaehlten Feldes in Objecte
					// ablegen
					Object titel = jtable.getValueAt(row, column);

					if (e.getClickCount() == 1) {
						jtf.setText(String.valueOf(titel));

					}
				}
			}
		});

	}
}
