/* Artisten eintragen */

SET @p0='Bruce'; SET @p1='Springsteen'; SET @p2=''; SET @p3=''; SET @p4=''; SET @p5='m'; SET @p6='j'; SET @p7='23'; SET @p8='08'; SET @p9='1949'; SET @p10=''; SET @p11=''; SET @p12=''; SET @p13='Bruce Springsteen'; SET @p14='Gitarre'; SET @p15='The River'; SET @p16='https://www.youtube.com/watch?v=t6R77eGx8xM'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);

SET @p0='James Paul '; SET @p1='McCartney'; SET @p2='Sir'; SET @p3=''; SET @p4=''; SET @p5='m'; SET @p6='j'; SET @p7='18'; SET @p8='06'; SET @p9='1942'; SET @p10=''; SET @p11=''; SET @p12=''; SET @p13='Paul McCartney'; SET @p14='E-Bass'; SET @p15='Appreciate'; SET @p16='https://www.youtube.com/watch?v=VpxdtWJAfSY'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);

SET @p0='Eithne Patricia Ní'; SET @p1='Bhraonáin'; SET @p2=''; SET @p3=''; SET @p4=''; SET @p5='w'; SET @p6='j'; SET @p7='17'; SET @p8='05'; SET @p9='1961'; SET @p10=''; SET @p11=''; SET @p12=''; SET @p13='Enya'; SET @p14='Sängerin'; SET @p15='Only Time'; SET @p16='https://www.youtube.com/watch?v=v0NoHN1TU5I'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);

SET @p0='James Douglas'; SET @p1='Morrison'; SET @p2=''; SET @p3=''; SET @p4=''; SET @p5='m'; SET @p6='n'; SET @p7='08'; SET @p8='12'; SET @p9='1943'; SET @p10='03'; SET @p11='07'; SET @p12='1971'; SET @p13='Jim Morrison'; SET @p14='Sänger'; SET @p15=''; SET @p16='http://de.wikipedia.org/wiki/Jim_Morrison'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);


/* Bandmitglied eintragen */

SET @p0='John'; SET @p1='Densmore'; SET @p2=''; SET @p3=''; SET @p4=''; SET @p5=''; SET @p6=''; SET @p7='01'; SET @p8='12'; SET @p9='1941'; SET @p10=''; SET @p11=''; SET @p12=''; SET @p13='John Densmore'; SET @p14='Schlagzeug'; SET @p15=''; SET @p16='http://de.wikipedia.org/wiki/John_Densmore'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);

SET @p0='James Douglas'; SET @p1='Morrison'; SET @p2=''; SET @p3=''; SET @p4=''; SET @p5='m'; SET @p6='n'; SET @p7='08'; SET @p8='12'; SET @p9='1943'; SET @p10='03'; SET @p11='07'; SET @p12='1971'; SET @p13='Jim Morrison'; SET @p14='Sänger'; SET @p15=''; SET @p16='http://de.wikipedia.org/wiki/Jim_Morrison'; SET @p17=''; SET @p18=''; SET @p19=''; SET @p20=''; CALL `musikerErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7, @p8, @p9, @p10, @p11, @p12, @p13, @p14, @p15, @p16, @p17, @p18, @p19, @p20);

/* Band Eintragen */

SET @p0='The Doors'; SET @p1=''; SET @p2=''; SET @p3='Riders on the Storm'; SET @p4='https://www.youtube.com/watch?v=5qRJIBtbc2c&feature=kp'; SET @p5='4'; SET @p6=''; SET @p7='j'; CALL `gruppeErstellen`(@p0, @p1, @p2, @p3, @p4, @p5, @p6, @p7);

/* Band Mitglied hinzufuegen */

INSERT INTO `musiclounge`.`mitglied` (`id_mitglied`, `id_musiker`, `id_gruppe`, `aktiv`) VALUES (NULL, '5', '1', 'j');