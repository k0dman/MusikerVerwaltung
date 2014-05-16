package farbverlaeufe;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GradientJPHeaderLeft extends JPanel {



    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        // vertikaler Verlauf von rechts oben nach links unten
      // GradientPaint gp = new GradientPaint(getWidth(), 0, Color.BLUE, 0,
          //    getHeight(), Color.YELLOW);
        // horizontaler, wiederholter Verlauf
        // GradientPaint gp = new GradientPaint(getWidth()/2, getHeight()/2,
        // Color.BLUE,
        // getWidth(), getHeight()/2, Color.YELLOW, true);
        // diagonaler Verlauf von links oben nach rechts unten
        // GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, getWidth(),
        // getHeight(), Color.YELLOW);
        // vertikaler Verlauf
        GradientPaint gp = new GradientPaint(getWidth()/2, 0, Color.DARK_GRAY,
                getWidth()/2, getHeight(), Color.LIGHT_GRAY);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
    }
}