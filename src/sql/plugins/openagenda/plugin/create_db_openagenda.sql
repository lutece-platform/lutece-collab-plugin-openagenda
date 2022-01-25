
--
-- Structure for table openagenda_agenda
--

DROP TABLE IF EXISTS openagenda_agenda;
CREATE TABLE openagenda_agenda (
id_agenda int NOT NULL,
uid int default '0' NOT NULL,
name varchar(50) default '' NOT NULL,
description varchar(255) default '' NOT NULL,
eventsembeddingcode long varchar NULL ,
mapembeddingcode long varchar NULL ,
searchembeddingcode long varchar NULL ,
categoriesembeddingcode long varchar NULL ,
tagsembeddingcode long varchar NULL ,
calendarembeddingcode long varchar NULL ,
PRIMARY KEY (id_agenda)
);


--
-- Table structure for table openagenda_portlet
--
DROP TABLE IF EXISTS openagenda_portlet;
CREATE TABLE openagenda_portlet (
	id_portlet int default '0' NOT NULL,
	name varchar(255) default '' NOT NULL,
	agenda_uid int  default '0' NOT NULL,
	PRIMARY KEY (id_portlet)
);