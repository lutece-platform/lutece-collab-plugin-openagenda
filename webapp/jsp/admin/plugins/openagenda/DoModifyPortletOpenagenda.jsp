<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="OpenagendaPortlet" scope="session" class="fr.paris.lutece.plugins.openagenda.web.portlet.OpenagendaPortletJspBean" />

<%
    OpenagendaPortlet.init( request, OpenagendaPortlet.RIGHT_MANAGE_ADMIN_SITE );
    response.sendRedirect( OpenagendaPortlet.doModify( request ) );
%>
