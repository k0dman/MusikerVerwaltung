// Abfrage von Künstlern sortier
SELECT idgruppe,idmusikerh as Mitglied, GROUP_CONCAT(idehemalig SEPARATOR ', ')
AS Ehemalige
FROM gruppehelp
GROUP BY idgruppe


// Suche

"SELECT * FROM person INNER JOIN musiker ON person.idperson"
							+ " = musiker.idperson WHERE CONCAT(name, vorname, pseudonym, stuecksolo) like '"
							+ Suchterm + "'"