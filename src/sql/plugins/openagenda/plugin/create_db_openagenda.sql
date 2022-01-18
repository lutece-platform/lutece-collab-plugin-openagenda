
--
-- Structure for table openagenda_agenda
--

DROP TABLE IF EXISTS openagenda_agenda;
CREATE TABLE openagenda_agenda (
id_agenda int(6) NOT NULL,
uid int(11) NOT NULL default '0',
name varchar(50) NOT NULL default '',
description varchar(255) NOT NULL default '',
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
	id_portlet int(11) NOT NULL default '0',
	name varchar(255) NOT NULL default '',
	agenda_uid int(11) NOT NULL,
	PRIMARY KEY (id_portlet)
);