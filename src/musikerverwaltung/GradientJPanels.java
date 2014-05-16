package musikerverwaltung;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public final class GradientJPanels extends JPanel {

	public int zahl;

	public GradientJPanels(int zahl) {

		setOpaque(true);
		this.zahl = zahl;

	}

	public int getZahl() {

		return zahl;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		int zahl = getZahl();
		GradientPaint gp = null;
		switch (zahl) {

		// vertikaler Verlauf von rechts oben nach links unten
		case 1:
			gp = new GradientPaint(getWidth(), 0, Color.DARK_GRAY, 0, getHeight(),
					Color.LIGHT_GRAY);
			break;

		// horizontaler, wiederholter Verlauf
		case 2:
			gp = new GradientPaint(getWidth() / 2, getHeight() / 2, Color.DARK_GRAY,
					getWidth(), getHeight() / 2, Color.LIGHT_GRAY, true);
			break;
		// diagonaler Verlauf von links oben nach rechts unten
		case 3:
			gp = new GradientPaint(0, 0, Color.BLUE, getWidth(), getHeight(),
					Color.YELLOW);
			break;

		// vertikaler Verlauf
		case 4:
			gp = new GradientPaint(getWidth() / 2, 0, Color.DARK_GRAY,
					getWidth() / 2, getHeight(), Color.LIGHT_GRAY);
			break;
		}
		
		g2d.setPaint(gp);

		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
}
