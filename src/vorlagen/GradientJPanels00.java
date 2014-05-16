package vorlagen;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public final class GradientJPanels00 extends JPanel {

	public String jpanel;

	public GradientJPanels00(String jpanel) {

		setOpaque(true);
		this.jpanel = jpanel;

	}

	public String getJpanel() {

		return jpanel;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		String jpanel = getJpanel();
		GradientPaint gp = null;
		switch (jpanel) {

		// vertikaler Verlauf
		case "gpheaderleft":
			gp = new GradientPaint(getWidth() / 2, 0, Color.DARK_GRAY,
					getWidth() / 2, getHeight(), Color.LIGHT_GRAY);
			g2d.setPaint(gp);
			g2d.fillOval(-10, -170, getWidth()+100, getHeight() * 9);
			break;
			
		case "gpheaderright":
			gp = new GradientPaint(getWidth() / 2, 0, Color.DARK_GRAY,
					getWidth() / 2, getHeight(), Color.LIGHT_GRAY);
			g2d.setPaint(gp);
			g2d.fillOval(-10, -180, getWidth()+20, getHeight() * 9);

			break;

		// diagonaler Verlauf von links oben nach rechts unten
		case "gpmain":
			gp = new GradientPaint(0, getHeight() / 2, Color.LIGHT_GRAY,
					getWidth(), getHeight() / 2, Color.DARK_GRAY);
			g2d.setPaint(gp);

			g2d.fillRect(0, 0, getWidth(), getHeight());

			break;

		// vertikaler Verlauf von rechts oben nach links unten
		case "gpinfo":
			gp = new GradientPaint(0, getHeight() / 2, Color.LIGHT_GRAY,
					getWidth(), getHeight() / 2, Color.DARK_GRAY);
			g2d.setPaint(gp);

			g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
			break;

		// horizontaler, wiederholter Verlauf
		case "gpnew":
			gp = new GradientPaint(0, getHeight() / 2, Color.DARK_GRAY,
					getWidth(), getHeight() / 2, Color.LIGHT_GRAY);
			g2d.setPaint(gp);

			g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
			break;

		case "gpfooter":
			gp = new GradientPaint(0, getHeight() / 2, Color.LIGHT_GRAY, 0,
					getHeight(), Color.DARK_GRAY);
			g2d.setPaint(gp);

			g2d.fillRect(0, 0, getWidth(), getHeight());
			break;
		}

	}
}
