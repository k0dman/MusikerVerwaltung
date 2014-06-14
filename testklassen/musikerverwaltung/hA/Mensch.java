package musikerverwaltung.hA;

//
/**<h3>Vorgaben f&uuml;r die Klasse Person.</h3>
 * Diese Klasse <code>Mensch</code> gibt als abstrakte Klasse Funktionen
 * der Klasse <code>Person</code> vor.
 * @version 0003 Samstag 03.05.2014 09:56:53
 * @author Dr. Gerd Wegener
 */
public abstract class Mensch
{
/**<h4>Familienname.</h4>
 * @return Familienname
 */
   public abstract String getName();
//
/**<h4>Vorname.</h4>
 * @return Vorname
 */
   public abstract String getVorname();
//
/**<h4>Geburtstag.</h4>
 * @return Tag der Geburt
 */
   public abstract int getGeburtsTag();
//
/**<h4>Geburtsmonat.</h4>
 * @return Monat der Geburt
 */
   public abstract int getGeburtsMonat();
//
/**<h4>Geburtsjahr.</h4>
 * @return Jahr der Geburt
 */
   public abstract int getGeburtsJahr();
//
/**<h4>Geburtsdatum.</h4>
 * @return Geburtsdatum in der Form <code>tt.mm.jjjj</code>
 */
  // public String getGeburtsDatum() { return Helfer.textDatum(getGeburtsTag(),getGeburtsMonat(),getGeburtsJahr()); }
//
/**<h4>Todestag.</h4>
 * @return Tag des Todes
 */
   public abstract int getTodesTag();
//
/**<h4>Todesmonat.</h4>
 * @return Monat des Todes
 */
   public abstract int getTodesMonat();
//
/**<h4>Todesjahr.</h4>
 * @return Jahr des Todes
 */
   public abstract int getTodesJahr();
//
/**<h4>Todesdatum holen.</h4>
 * @return Todesdatum in der Form <code>tt.mm.jjjj</code>
 */
   //public String getTodesDatum() { return Helfer.textDatum(getTodesTag(),getTodesMonat(),getTodesJahr()); }
//
/**<h4>Todesdatum setzen.</h4>
 * @param tag Todestag
 * @param monat Todesmonat
 * @param jahr Todesjahr
 */
   public abstract void setTodesDatum(int tag, int monat, int jahr);
//
/**<h4>M&auml;nnlich.</h4>
 * @return <code>true</code>, wenn m&auml;nnlich, <code>false</code>, sonst
 */
   public abstract boolean isMann();
//
/**<h4>Weiblich.</h4>
 * @return <code>true</code>, wenn weiblich, <code>false</code>, sonst
 */
   public abstract boolean isFrau();
//
/**<h4>Verstorben.</h4>
 * @return <code>true</code>, wenn die Person verstorben ist, <code>false</code>, sonst
 */
   public abstract boolean isTot();
//
/**<h4>Alter in Jahren.</h4>
 * @return Sterbealter, wenn die Person verstorben ist, Alter heute, sonst, gerundet auf drei Dezimalstellen
 */
   public abstract double alter();
//
/**<h4>Kompletter Name.</h4>
 * @return kompletter Name ("Titel Vorsatz Vorname Zusatz Name")
 */
   public abstract String nameKomplett();
//
/**<h4>Anrede.</h4>
 * @return korrekte Anrede in Briefen ("Sehr geehrter Herr Titel Vorsatz Zusatz Name," bzw. "Sehr geehrte Frau Titel Vorsatz Zusatz Name,")
 * Beim Titel werden Dr. und Prof. ausgeschrieben, sind im Vorsatz "herr" oder "frau" bereits enthalten, f&auml;llt das "Herr" und "Frau" weg.
 */
   public abstract String anrede();
}

