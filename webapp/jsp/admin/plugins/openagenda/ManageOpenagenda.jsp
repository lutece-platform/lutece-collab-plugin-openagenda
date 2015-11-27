<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="manageopenagenda" scope="session" class="fr.paris.lutece.plugins.openagenda.web.ManageOpenagendaJspBean" />

<% manageopenagenda.init( request, manageopenagenda.RIGHT_MANAGEOPENAGENDA ); %>
<%= manageopenagenda.getManageOpenagendaHome ( request ) %>

<%@ include file="../../AdminFooter.jsp" %>
