<jsp:useBean id="manageopenagendaAgenda" scope="session" class="fr.paris.lutece.plugins.openagenda.web.AgendaJspBean" />
<% String strContent = manageopenagendaAgenda.processController ( request , response ); %>

<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />

<%= strContent %>

<%@ include file="../../AdminFooter.jsp" %>
