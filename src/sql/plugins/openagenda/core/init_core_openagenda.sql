
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

--
-- Dumping data for table core_portlet_type
--
INSERT INTO core_portlet_type (id_portlet_type,name,url_creation,url_update,home_class,plugin_name,url_docreate,create_script,create_specific,create_specific_form,url_domodify,modify_script,modify_specific,modify_specific_form) VALUES 
('OPENAGENDA_PORTLET','openagenda.portlet.openagendaPortlet.name','plugins/openagenda/CreatePortletOpenagenda.jsp','plugins/openagenda/ModifyPortletOpenagenda.jsp','fr.paris.lutece.plugins.openagenda.business.portlet.OpenagendaPortletHome','openagenda','plugins/openagenda/DoCreatePortletOpenagenda.jsp','/admin/portlet/script_create_portlet.html','/admin/plugins/openagenda/portlet/create_portlet_openagenda.html','','plugins/openagenda/DoModifyPortletOpenagenda.jsp','/admin/portlet/script_modify_portlet.html','/admin/plugins/openagenda/portlet/modify_portlet_openagenda.html','');
