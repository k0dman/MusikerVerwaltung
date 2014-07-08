package musikerverwaltung.Swing;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import musikerverwaltung.menschen.Musiker01;

public class CaretListenerJTF {

	public void caretListenerJTF(final JTextField jtf) {
		
		jtf.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				Musiker01 musiker = new Musiker01();
				String content = jtf.getText();
				int id = musiker.getMusikerIDS(jtf.getText());
				System.out.println("#############################");
				System.out.println(id + " InstrumentID1");
				System.out.println(content);
				
				
			}
		});

	}
}
