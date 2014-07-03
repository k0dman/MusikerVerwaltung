//Uebersichtstabelle SUCHE

SELECT p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat, p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym, r.referenz, s.stuecksolo, i.instrument FROM person p, musiker m, referenz r, stuecksolo s, instrument i WHERE p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker AND m.id_musiker = s.id_musiker AND CONCAT (name, vorname, pseudonym, stuecksolo) like '%"
							+ keyword + "%' ORDER BY m.pseudonym

// Uebersichtstabelle Hauptansicht
SELECT mus.pseudonym, ss.stuecksolo FROM musiker mus, stuecksolo ss where mus.id_musiker = ss.id_musiker and ss.stuecksolo not like '' UNION SELECT gr.name, sg.stueckgruppe FROM musiker mus,mitglied mg, gruppe gr, stueckgruppe sg where gr.id_gruppe = sg.id_gruppe order by pseudonym);

SELECT mus.pseudonym, ss.stuecksolo FROM musiker mus, stuecksolo ss, person p where p.id_person = mus.id_person and mus.id_musiker = ss.id_musiker and ss.stuecksolo not like '' and concat(pseudonym, stuecksolo, name, vorname) like '%bruce%' UNION SELECT gr.name, sg.stueckgruppe fROM musiker mus,mitglied mg, gruppe gr, stueckgruppe sg, person p where gr.id_gruppe = sg.id_gruppe and concat(name, stueckgruppe) like '%bruce%' order by pseudonym

//Artistansicht
SELECT 
  p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat,
  p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym,
  r.referenz, s.stuecksolo, i.instrument
FROM
person p, musiker m, referenz r, stuecksolo s, instrument i
WHERE
p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker
AND m.id_musiker = s.id_musiker AND m.pseudonym = '"+artist+"';

SELECT p.name, p.vorname, p.titel, p.vorsatz, p.zusatz, p.geschlecht, p.lebt, p.gtag, p.gmonat, p.gjahr, p.ttag, p.tmonat, p.tjahr, m.pseudonym, r.referenz, s.stuecksolo, i.instrument FROM person p, musiker m, referenz r, stuecksolo s, instrument i WHERE p.id_person = m.id_person AND m.id_musiker = i.id_musiker AND m.id_musiker = r.id_musiker AND m.id_musiker = s.id_musiker AND m.pseudonym = 'Bruce Springsteen'

//testen ob band oder nicht
select * from gruppe where name = '"+pseudonym+"';

//Bandansicht
select name, grreferenz, stueckgruppe from gruppe gr, mitglied mg, grreferenz ref, stueckgruppe sg where gr.name = '"+name+"';

//mitglieder einer band
select pseudonym, aktiv from musiker mus, mitglied mg, gruppe gr where mus.id_musiker = mg.id_musiker and mg.id_gruppe = gr.id_gruppe and gr.name = '"+name+"';

// Alle Lieder eine Gruppe
select stueckgruppe from stueckgruppe sg, gruppe g where sg.id_gruppe = g.id_gruppe and g.grname = '"+name+"';