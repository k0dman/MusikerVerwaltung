package musikerverwaltung.Swing;

import musikerverwaltung.menschen.Musiker01;

public class MusikerIDs {
	
	private Musiker01 musiker;
	public int idreferenz;
	
	public int idReferenz(String referenz, String pseudonym){
		
		musiker = new Musiker01(pseudonym);
		idreferenz = musiker.getMusikerIDS(referenz);
		
		return idreferenz;
	}

}
