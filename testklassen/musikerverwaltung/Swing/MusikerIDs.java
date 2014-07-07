package musikerverwaltung.Swing;

import musikerverwaltung.menschen.Musiker01;

public class MusikerIDs {
	
	private Musiker01 musiker;
	public int idReferenz(String referenz){
		
		musiker = new Musiker01();
		int idreferenz = musiker.getMusikerIDS(referenz);
		
		return idreferenz;
	}

}
