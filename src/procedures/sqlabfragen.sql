//Uebersichtstabelle

SELECT 
  mus.pseudonym, 
  ss.stuecksolo
  
FROM musiker mus JOIN stuecksolo ss ON mus.id_musiker = ss.id_musiker;

//Artistansicht

//ALT
SELECT * FROM person INNER JOIN musiker ON person.idperson = musiker.idperson
WHERE `musiker`.`pseudonym` = '"+artist+"' LIMIT 0 , 30

//NEU
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
