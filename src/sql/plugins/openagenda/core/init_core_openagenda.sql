
--
-- Data for table core_admin_right
--
DELETE FROM core_admin_right WHERE id_right = 'OPENAGENDA_MANAGEMENT';
INSERT INTO core_admin_right (id_right,name,level_right,admin_url,description,is_updatable,plugin_name,id_feature_group,icon_url,documentation_url, id_order ) VALUES 
('OPENAGENDA_MANAGEMENT','openagenda.adminFeature.ManageOpenagenda.name',1,'jsp/admin/plugins/openagenda/ManageAgendas.jsp','openagenda.adminFeature.ManageOpenagenda.description',0,'openagenda',NULL,NULL,NULL,4);


--
-- Data for table core_user_right
--
DELETE FROM core_user_right WHERE id_right = 'OPENAGENDA_MANAGEMENT';
INSERT INTO core_user_right (id_right,id_user) VALUES ('OPENAGENDA_MANAGEMENT',1);

