package musikerverwaltung.Swing;



import javax.swing.*;

public class AddArtist01 extends JTabbedPane{

	private JLabel jltest;
	private JPanel content;

	public void addArtist(Object artist, Object title, JTabbedPane jtpane) {
		String name = artist + " - " + title;
		content = new JPanel();
		jltest = new JLabel(name);
		content.add(jltest);

		jtpane.addTab(String.valueOf(artist), content);
		System.out.println("hall");
	}
}
