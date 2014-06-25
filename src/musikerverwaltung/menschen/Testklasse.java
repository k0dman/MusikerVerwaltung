package musikerverwaltung.menschen;

public class Testklasse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(Helfer01.pruefDatum(28,4,2014));
		

		String[] instrumente = new String[2];
		instrumente[0] = "Saxophon";
		instrumente[1] = "Floete";

		String[] stueck = new String[1];
		stueck[0] = "phil ist cool";

		String[] referenz = new String[0];

		Person1 Dieter = new Person1("Augustin", "Dieter", "m", "1,5,1950");
		
		
		Musiker01 Bert = new Musiker01("Wollersheim", "Bert", "M", "20.05.1943",
				"BertiBo", instrumente, stueck, referenz);
		
		System.out.println(Bert.toString());

		System.out.println(Dieter.toString());

		
		System.out.println();
	}

}
