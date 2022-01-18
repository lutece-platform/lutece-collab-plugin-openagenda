<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../PortletAdminHeader.jsp" />

<jsp:useBean id="OpenAgendaPortlet" scope="session" class="fr.paris.lutece.plugins.openagenda.web.portlet.OpenagendaPortletJspBean" />

<% OpenAgendaPortlet.init( request, OpenAgendaPortlet.RIGHT_MANAGE_ADMIN_SITE); %>
<%= OpenAgendaPortlet.getCreate ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>
