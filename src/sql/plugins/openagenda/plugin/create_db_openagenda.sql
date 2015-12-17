
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
