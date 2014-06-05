package diverse;
//
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
//
/**<h3>Datumseingabe.</h3>
 * In dieser Klasse <code>DatumEingabe02</code> wird im Dialog ein Datum
 * mit Hilfe dreier <code>JComboBox</code>en eingegeben. Dazu wird eine
 * &Uuml;berschrift und ein Schaltknopf zum Pr&uuml;fen der Eingabe auf
 * Korrektheit eingef&uuml;gt. Der Knopf hat die Funktion, die Pr&uuml;fung
 * des Datums anzusto&szlig;en.
 * @version 0006 Montag 31.03.2014 03:33:40
 * @author Dr. Gerd Wegener
 */
public class DatumsBeispiel extends JFrame
{
// Diese Nummer gibt die Nummer der serialisierten Version an. Sie sollte
// erhoeht werden, wenn wesentliche Aenderungen in der Klasse vorgenommen
// werden. Normalerweise betrifft das einfache Anwendungen nicht.
   private static final long serialVersionUID = 20;
//
// Deklaration der Auswahlvariablen
// In den eineckigen Klammern steht, von welchem Typ das Ausgewaehlte ist.
   private JComboBox<String> jcbmonat;
   private JComboBox<Integer> jcbtag, jcbjahr;
//
// Ueberschrift und Pruefbutton
   private JLabel jlueber;
   private JButton jbpruef;
//
// Panels dafuer
   private JPanel jpdatum, jpueber, jppruef, jpalles;
//
// Farben und Schriften
   private Color hinterfeld, hinterpanel, hinteralles, vorderfeld;
   private Font schrueber, schrift, schrknopf;
//
// moegliche Auswahlen
// Umlaute sollte man immer als Unicode schreiben, damit beim Wechsel von
// einem Editor zum anderen nichts Unvorhergesehenes passiert.
// Die Unicodes findet man im Netz unter http://unicode.org/ oder, was fuer
// die Hackerpraxis etwas leichter lesbar ist, auf der Seite
// http://www.utf8-zeichentabelle.de/. Das &auml; hei&szlig;t dort etwa
// "LATIN SMALL LETTER A WITH DIAERESIS" und hat den Code \u00E4.
   private String [] monatsname = {"Januar", "Februar", "M\u00E4rz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
//
// In Swing wird eine graphische Oberflaeche in einen Container gepackt, dem
// zur Laufzeit die vom System erzeugte Contentpane zugewiesen wird.
   private Container contentpane;
//
//
// Eine Instanz dieser Klasse kann nur aus der Hauptmethode geschaffen werden.
   private DatumsBeispiel()
   {
//    Ueberschrift auf den oberen Rand
      super("Datumseingabe");
//
//    diese Festlegung erspart die Definition des WindowListener
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    Zuweisen der Contentpane
      contentpane = getContentPane();
//
//    Farben und Schriften erzeugen
      hinterfeld = new Color(.8F,.8F,1F);   hinterpanel = new Color(.8F,1F,.6F);
      hinteralles = new Color(.8F,.6F,1F);   vorderfeld = new Color(.8F,0F,0F);
      schrueber = new Font(Font.SANS_SERIF,Font.BOLD,50);
      schrift = new Font(Font.SANS_SERIF,Font.PLAIN,30);
      schrknopf = new Font(Font.SANS_SERIF,Font.BOLD,30);
//
//    Erzeugen der Auswahlen
//    Das Jahr sollte editierbar sein, da die angebotene Liste unvollstaendig ist, Tag und Monat jedoch nicht.
      jcbmonat = new JComboBox<String>(monatsname);   jcbmonat.setEditable(false);
      jcbmonat.setFont(schrift);   jcbmonat.setBackground(hinterfeld);   jcbmonat.setForeground(vorderfeld);
//
      jcbtag = new JComboBox<Integer>();
      for (int t=1; t<32; t++) jcbtag.addItem(new Integer(t));   jcbtag.setEditable(false);
      jcbtag.setFont(schrift);   jcbtag.setBackground(hinterfeld);   jcbtag.setForeground(vorderfeld);
//
//    alle Jahre kann man/frau schlecht vorgeben
      jcbjahr = new JComboBox<Integer>();   jcbjahr.setEditable(true);
//    die letzten hundert Jahre rein
//    dazu aktuelles Jahr ermitteln
      int aktjahr = (new GregorianCalendar()).get(Calendar.YEAR);
      for (int j=0; j<=100; j++) jcbjahr.addItem(new Integer(aktjahr-j));
      jcbjahr.setFont(schrift);   jcbjahr.setBackground(hinterfeld);   jcbjahr.setForeground(vorderfeld);
//
//    alles in ein Panel
      jpdatum = new JPanel();   jpdatum.setBackground(hinterpanel);
      jpdatum.add(jcbtag);   jpdatum.add(jcbmonat);   jpdatum.add(jcbjahr);
//
//    Ueberschrift
      jlueber = new JLabel("Dein Geburtsdatum");   jlueber.setFont(schrueber);
      jlueber.setBackground(hinterpanel);   jlueber.setForeground(vorderfeld);
      jpueber = new JPanel();   jpueber.setBackground(hinterpanel);   jpueber.add(jlueber);
//
//    Pruefbutton
      jbpruef = new JButton("Datum pr\u00FCfen");   jbpruef.setFont(schrknopf);
      jbpruef.setBackground(vorderfeld);   jbpruef.setForeground(hinterfeld);
      jppruef = new JPanel();   jppruef.setBackground(hinterpanel);   jppruef.add(jbpruef);
//
//    Reaktion auf das Knopfdruecken festlegen
      jbpruef.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent ae) { datumOK(); } });
//
//    Panel fue alles
      jpalles = new JPanel(new GridLayout(3,1,10,10));
      jpalles.setBackground(hinteralles);   jpalles.add(jpueber);   jpalles.add(jpdatum);   jpalles.add(jppruef);
//
//    alles in die Content Pane
      contentpane.add(jpalles);
//
//    Anfangsposition und -groesse festlegen
      setBounds(300,200,800,250);
//
//    sichtbar machen
      setVisible(true);
   }
//
// Pruefmethode
   private void datumOK()
   {
//    Hier sind die vielen Klammern notwendig, weil zuerst
//    jcbtag.getSelectedItem(), was vom Typ Object ist, mit
//    (Integer)jcbtag.getSelectedItem() zu einem Integer gecastet werden muss.
//    Da die Objektreferenz mit dem . staerker bindet als der Cast mit (Typ),
//    muessen so nochmal Klammern her, damit gecastet wird,
//    bevor intValue() zur Anwendung kommt.
      int tag = ((Integer)jcbtag.getSelectedItem()).intValue(),
          monat = jcbmonat.getSelectedIndex()+1,
          jahr = ((Integer)jcbjahr.getSelectedItem()).intValue();
      boolean ok = true;
//
//    erste Pruefungen
//    nur die Monate 2, 4, 6, 9, 11 sind ein Problem
      if (tag==31 && (monat==4 || monat==6 || monat==9 || monat==11)) ok = false;
//    nur der Februar ist ein Problem
      else if (tag>29 && monat==2) ok = false;
      else if (tag==29 && monat==2 && jahr%4!=0) ok = false;
      else if (tag==29 && monat==2 && jahr%100==0 && jahr%400!=0) ok = false;
//
//    Meldung machen
      if (ok) JOptionPane.showMessageDialog(this,"Das Datum "+tag+"."+monat+"."+jahr+" ist in Ordnung.","Datumspr/u00FCfung",JOptionPane.INFORMATION_MESSAGE);
      else JOptionPane.showMessageDialog(this,"Den "+tag+"."+monat+"."+jahr+" gibt es nicht!","Datumspr/u00FCfung",JOptionPane.ERROR_MESSAGE);
   }
//
/**<h4>Hauptmethode.</h4>
 * Mit der Hauptmethode <code>main</code> kann diese Klasse als
 * Top-Level-Anwendung aufgerufen werden.
 * @param args Aufrufargumente
 * <pre>Aufruf: java DatumEingabe02</pre>
 */
   public static void main(String [] args)
   {
//    Konfliktfreies spaeteres paralleles Betreiben des Dialoges sicherstellen
      SwingUtilities.invokeLater
      (new Runnable()
       {
          public void run()
          {
             new DatumsBeispiel();
          }
      });
   }
// Die Hauptmethode fuer Swing-Anwendungen sieht fast immer genau so aus.
// Einfach abschreiben. Man/frau muss nicht verstehen, warum!
}
