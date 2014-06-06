package diverse;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Icons {

	// Pfad fuer Icon - zum schnellen Anpassen
	private String iconpath = "/progis";

	public Icon[] icons = {
			// [0] - Icon fuer Libary
			new ImageIcon(iconpath
					+ "/git/MusikerVerwaltung/pics/notes-SH-icon.png"),
			// [1] - Icon fuer Band
			new ImageIcon(iconpath
					+ "/git/MusikerVerwaltung/pics/chorus-icon.png"),
			// [2] - Icon fuer Interpret
			new ImageIcon(iconpath
					+ "/git/MusikerVerwaltung/pics/Performer-SH-icon.png"),
			// [3] - Icon fuer Suche (Lupe)
			new ImageIcon(iconpath
					+ "/git/MusikerVerwaltung/pics/Zoom-icon.png")

	};

}
