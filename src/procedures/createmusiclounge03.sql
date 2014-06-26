Create database if not exists musiclounge
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

create table if not exists person
(
id_person int(11) not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht ENUM ('m','f','ns'),
lebt ENUM ('j','n'),
gtag int(2),
gmonat int(2),
gjahr int(4),
ttag int(2),
tmonat int(2),
tjahr int(4),
primary key (id_person)
);


create table if not exists instrument
(
id_instrument int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
instrument varchar(100),
primary key (id_instrument)


);

create table if not exists stuecksolo
(
id_stuecksolo int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
stuecksolo varchar(100),
primary key (id_stuecksolo)

);

create table if not exists referenz
(
id_referenz int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
referenz varchar(100),
primary key (id_referenz)


);

create table if not exists musiker
(
id_musiker int(11) not null auto_increment,
id_person int(11),
pseudonym varchar(100),
primary key (id_musiker),
foreign key (id_person) references person (id_person) on update cascade on delete cascade
);


create table if not exists gruppe
(
id_gruppe int(11) not null auto_increment,
name varchar(100),
primary key (id_gruppe)
);

create table if not exists mitglied
(
id_mitglied int(11) not null auto_increment,
id_musiker int(11),
id_gruppe int(11),
aktiv ENUM('j','n'),
primary key (id_mitglied)

);Create database if not exists musiclounge
Character set utf8
Collate utf8_general_ci;

Use musiclounge;

create table if not exists person
(
id_person int(11) not null auto_increment,
name varchar (100),
vorname varchar(100),
titel varchar(100),
vorsatz varchar(100),
zusatz varchar(100),
geschlecht ENUM ('m','f','ns'),
lebt ENUM ('j','n'),
gtag int(2),
gmonat int(2),
gjahr int(4),
ttag int(2),
tmonat int(2),
tjahr int(4),
primary key (id_person)
);


create table if not exists instrument
(
id_instrument int(11) not null auto_increment,
id_musiker int(11),
instrument varchar(100),
primary key (id_instrument)


);

create table if not exists stuecksolo
(
id_stuecksolo int(11) not null auto_increment,
id_musiker int(11),
stuecksolo varchar(100),
primary key (id_stuecksolo)

);

create table if not exists referenz
(
id_referenz int(11) not null auto_increment,
id_musiker int(11),
referenz varchar(100),
primary key (id_referenz)


);

create table if not exists musiker
(
id_musiker int(11) not null auto_increment,
id_person int(11),
pseudonym varchar(100),
id_instrument int(11),
id_stuecksolo int(11),
id_referenz int(11),
primary key (id_musiker),
foreign key (id_person) references person (id_person) on update cascade on delete cascade
);


create table if not exists gruppe
(
id_gruppe int(11) not null auto_increment,
name varchar(100),
primary key (id_gruppe)
);

create table if not exists mitglied
(
id_mitglied int(11) not null auto_increment,
id_musiker int(11) NOT NULL,
id_gruppe int(11) NOT NULL,
aktiv ENUM('j','n'),
primary key (id_mitglied)

);