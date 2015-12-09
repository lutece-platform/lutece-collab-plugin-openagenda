/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.openagenda.web;
 
import fr.paris.lutece.plugins.openagenda.api.mapping.Response;
import fr.paris.lutece.plugins.openagenda.business.Agenda;
import fr.paris.lutece.plugins.openagenda.business.AgendaHome;
import fr.paris.lutece.plugins.openagenda.client.FetchDataService;
import fr.paris.lutece.plugins.openagenda.service.OpenagendaService;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import fr.paris.lutece.util.url.UrlItem;
import java.util.Map;
import fr.paris.lutece.portal.service.message.SiteMessageService;
import fr.paris.lutece.portal.service.message.SiteMessage;
import fr.paris.lutece.portal.service.message.SiteMessageException;
import fr.paris.lutece.portal.service.util.AppLogService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest; 
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This class provides the user interface to manage Agenda xpages ( manage, create, modify, remove )
 */
 
@Controller( xpageName = "agenda" , pageTitleI18nKey = "openagenda.xpage.agenda.pageTitle" , pagePathI18nKey = "openagenda.xpage.agenda.pagePathLabel" )
public class AgendaXPage extends MVCApplication
{
    // Templates
    private static final String TEMPLATE_MANAGE_AGENDAS="/skin/plugins/openagenda/manage_agendas.html";
    private static final String TEMPLATE_CREATE_AGENDA="/skin/plugins/openagenda/create_agenda.html";
    private static final String TEMPLATE_MODIFY_AGENDA="/skin/plugins/openagenda/modify_agenda.html";
    private static final String TEMPLATE_LIST_EVENTS="/skin/plugins/openagenda/list_events.html";
    private static final String TEMPLATE_AGENDA_EVENTS="/skin/plugins/openagenda/agenda_events.html";
    private static final String TEMPLATE_AGENDA_EVENTS_PERIOD="/skin/plugins/openagenda/agenda_events_period.html";
    
    // JSP
    private static final String JSP_PAGE_PORTAL = "jsp/site/Portal.jsp";
    
    // Parameters
    private static final String PARAMETER_ID_AGENDA="id";
    private static final String PARAM_ACTION = "action";
    private static final String PARAM_PAGE = "page";
    
    // Markers
    private static final String MARK_AGENDA_LIST = "agenda_list";
    private static final String MARK_AGENDA = "agenda";
    private static final String MARK_EVENT_LIST = "event_list";
    
    // Message
    private static final String MESSAGE_CONFIRM_REMOVE_AGENDA = "openagenda.message.confirmRemoveAgenda";
    
    // Views
    private static final String VIEW_MANAGE_AGENDAS = "manageAgendas";
    private static final String VIEW_CREATE_AGENDA = "createAgenda";
    private static final String VIEW_MODIFY_AGENDA = "modifyAgenda";
    private static final String VIEW_LISTEVENT_AGENDA = "listEventAgenda";
    private static final String VIEW_AGENDA_EVENTS = "agendaEvents";
    private static final String VIEW_AGENDA_EVENTS_PERIOD = "agendaEventsPeriod";

    // Actions
    private static final String ACTION_CREATE_AGENDA = "createAgenda";
    private static final String ACTION_MODIFY_AGENDA= "modifyAgenda";
    private static final String ACTION_REMOVE_AGENDA = "removeAgenda";
    private static final String ACTION_CONFIRM_REMOVE_AGENDA = "confirmRemoveAgenda";

    // Infos
    private static final String INFO_AGENDA_CREATED = "openagenda.info.agenda.created";
    private static final String INFO_AGENDA_UPDATED = "openagenda.info.agenda.updated";
    private static final String INFO_AGENDA_REMOVED = "openagenda.info.agenda.removed";
    
    // Session variable to store working values
    private Agenda _agenda;
    
    @View( value = VIEW_MANAGE_AGENDAS )
    public XPage getManageAgendas( HttpServletRequest request )
    {
        _agenda = null;
        Map<String, Object> model = getModel(  );
        model.put( MARK_AGENDA_LIST, AgendaHome.getAgendasList(  ) );

        return getXPage( TEMPLATE_MANAGE_AGENDAS, request.getLocale(  ), model );
    }

    /**
     * Returns the form to create a agenda
     *
     * @param request The Http request
     * @return the html code of the agenda form
     */
    @View( VIEW_CREATE_AGENDA )
    public XPage getCreateAgenda( HttpServletRequest request )
    {
        _agenda = ( _agenda != null ) ? _agenda : new Agenda(  );

        Map<String, Object> model = getModel(  );
        model.put( MARK_AGENDA, _agenda );
           
        return getXPage( TEMPLATE_CREATE_AGENDA, request.getLocale(  ), model );
    }

    /**
     * Process the data capture form of a new agenda
     *
     * @param request The Http Request
     * @return The Jsp URL of the process result
     */
    @Action( ACTION_CREATE_AGENDA )
    public XPage doCreateAgenda( HttpServletRequest request )
    {
        populate( _agenda, request );

        // Check constraints
        if ( !validateBean( _agenda, getLocale( request ) ) )
        {
            return redirectView( request, VIEW_CREATE_AGENDA );
        }

        AgendaHome.create( _agenda );
        addInfo( INFO_AGENDA_CREATED, getLocale( request ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }

    /**
     * Manages the removal form of a agenda whose identifier is in the http
     * request
     *
     * @param request The Http request
     * @return the html code to confirm
     */
    @Action( ACTION_CONFIRM_REMOVE_AGENDA )
    public XPage getConfirmRemoveAgenda( HttpServletRequest request ) throws SiteMessageException
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );
        UrlItem url = new UrlItem( JSP_PAGE_PORTAL );
        url.addParameter( PARAM_PAGE, MARK_AGENDA );
        url.addParameter( PARAM_ACTION, ACTION_REMOVE_AGENDA );
        url.addParameter( PARAMETER_ID_AGENDA, nId );
        
        SiteMessageService.setMessage(request, MESSAGE_CONFIRM_REMOVE_AGENDA, SiteMessage.TYPE_CONFIRMATION, url.getUrl(  ));
        return null;
    }

    /**
     * Handles the removal form of a agenda
     *
     * @param request The Http request
     * @return the jsp URL to display the form to manage agendas
     */
    @Action( ACTION_REMOVE_AGENDA )
    public XPage doRemoveAgenda( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );
        AgendaHome.remove( nId );
        addInfo( INFO_AGENDA_REMOVED, getLocale( request ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }

    /**
     * Returns the form to update info about a agenda
     *
     * @param request The Http request
     * @return The HTML form to update info
     */
    @View( VIEW_MODIFY_AGENDA )
    public XPage getModifyAgenda( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );

        if ( _agenda == null  || ( _agenda.getId( ) != nId ))
        {
            _agenda = AgendaHome.findByPrimaryKey( nId );
        }

        Map<String, Object> model = getModel(  );
        model.put( MARK_AGENDA, _agenda );
        
        return getXPage( TEMPLATE_MODIFY_AGENDA, request.getLocale(  ), model );
    }

    /**
     * Process the change form of a agenda
     *
     * @param request The Http request
     * @return The Jsp URL of the process result
     */
    @Action( ACTION_MODIFY_AGENDA )
    public XPage doModifyAgenda( HttpServletRequest request )
    {
        populate( _agenda, request );

        // Check constraints
        if ( !validateBean( _agenda, getLocale( request ) ) )
        {
            return redirect( request, VIEW_MODIFY_AGENDA, PARAMETER_ID_AGENDA, _agenda.getId( ) );
        }

        AgendaHome.update( _agenda );
        addInfo( INFO_AGENDA_UPDATED, getLocale( request ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }
    
    
    @View( value = VIEW_LISTEVENT_AGENDA, defaultView = true )
    public XPage getListEvents( HttpServletRequest request )
    {
        
        OpenagendaService oas = new OpenagendaService();
        
        Map<String, Object> model = getModel(  );
        model.put( MARK_EVENT_LIST, oas.getEventsAgenda("53528128"));

        return getXPage( TEMPLATE_LIST_EVENTS, request.getLocale(  ), model );
    }
    
    
    
    @View( value = VIEW_AGENDA_EVENTS )
    public XPage getAgendaEvents( HttpServletRequest request )
    {

        return getXPage( TEMPLATE_AGENDA_EVENTS, request.getLocale(  ));
    }
    
    @View( value = VIEW_AGENDA_EVENTS_PERIOD )
    public XPage getAgendaEventsByPeriod( HttpServletRequest request )
    {

        return getXPage( TEMPLATE_AGENDA_EVENTS_PERIOD, request.getLocale(  ));
    }
}
