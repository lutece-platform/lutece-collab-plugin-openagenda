/*
 * Copyright (c) 2002-2022, City of Paris
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

import fr.paris.lutece.plugins.openagenda.business.Agenda;
import fr.paris.lutece.plugins.openagenda.business.AgendaHome;
import fr.paris.lutece.portal.service.message.AdminMessage;
import fr.paris.lutece.portal.service.message.AdminMessageService;
import fr.paris.lutece.portal.util.mvc.admin.annotations.Controller;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.util.url.UrlItem;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides the user interface to manage Agenda features ( manage, create, modify, remove )
 */
@Controller( controllerJsp = "ManageAgendas.jsp", controllerPath = "jsp/admin/plugins/openagenda/", right = "OPENAGENDA_MANAGEMENT" )
public class AgendaJspBean extends ManageOpenagendaJspBean
{

    ////////////////////////////////////////////////////////////////////////////
    // Constants

    /**
	 * 
	 */
	private static final long serialVersionUID = 2551533407078479229L;
	// templates
    private static final String TEMPLATE_MANAGE_AGENDAS = "/admin/plugins/openagenda/manage_agendas.html";
    private static final String TEMPLATE_CREATE_AGENDA = "/admin/plugins/openagenda/create_agenda.html";
    private static final String TEMPLATE_MODIFY_AGENDA = "/admin/plugins/openagenda/modify_agenda.html";

    // Parameters
    private static final String PARAMETER_ID_AGENDA = "id";

    // Properties for page titles
    private static final String PROPERTY_PAGE_TITLE_MANAGE_AGENDAS = "openagenda.manage_agendas.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_MODIFY_AGENDA = "openagenda.modify_agenda.pageTitle";
    private static final String PROPERTY_PAGE_TITLE_CREATE_AGENDA = "openagenda.create_agenda.pageTitle";

    // Markers
    private static final String MARK_AGENDA_LIST = "agenda_list";
    private static final String MARK_AGENDA = "agenda";

    private static final String JSP_MANAGE_AGENDAS = "jsp/admin/plugins/openagenda/ManageAgendas.jsp";

    // Properties
    private static final String MESSAGE_CONFIRM_REMOVE_AGENDA = "openagenda.message.confirmRemoveAgenda";

    private static final String VALIDATION_ATTRIBUTES_PREFIX = "openagenda.model.entity.agenda.attribute.";

    // Views
    private static final String VIEW_MANAGE_AGENDAS = "manageAgendas";
    private static final String VIEW_CREATE_AGENDA = "createAgenda";
    private static final String VIEW_MODIFY_AGENDA = "modifyAgenda";

    // Actions
    private static final String ACTION_CREATE_AGENDA = "createAgenda";
    private static final String ACTION_MODIFY_AGENDA = "modifyAgenda";
    private static final String ACTION_REMOVE_AGENDA = "removeAgenda";
    private static final String ACTION_CONFIRM_REMOVE_AGENDA = "confirmRemoveAgenda";

    // Infos
    private static final String INFO_AGENDA_CREATED = "openagenda.info.agenda.created";
    private static final String INFO_AGENDA_UPDATED = "openagenda.info.agenda.updated";
    private static final String INFO_AGENDA_REMOVED = "openagenda.info.agenda.removed";

    // Session variable to store working values
    private Agenda _agenda;

    @View( value = VIEW_MANAGE_AGENDAS, defaultView = true )
    public String getManageAgendas( HttpServletRequest request )
    {
        _agenda = null;
        List<Agenda> listAgendas = (List<Agenda>) AgendaHome.getAgendasList( );
        Map<String, Object> model = getPaginatedListModel( request, MARK_AGENDA_LIST, listAgendas, JSP_MANAGE_AGENDAS );

        return getPage( PROPERTY_PAGE_TITLE_MANAGE_AGENDAS, TEMPLATE_MANAGE_AGENDAS, model );
    }

    /**
     * Returns the form to create a agenda
     *
     * @param request
     *            The Http request
     * @return the html code of the agenda form
     */
    @View( VIEW_CREATE_AGENDA )
    public String getCreateAgenda( HttpServletRequest request )
    {
        _agenda = ( _agenda != null ) ? _agenda : new Agenda( );

        Map<String, Object> model = getModel( );
        model.put( MARK_AGENDA, _agenda );

        return getPage( PROPERTY_PAGE_TITLE_CREATE_AGENDA, TEMPLATE_CREATE_AGENDA, model );
    }

    /**
     * Process the data capture form of a new agenda
     *
     * @param request
     *            The Http Request
     * @return The Jsp URL of the process result
     */
    @Action( ACTION_CREATE_AGENDA )
    public String doCreateAgenda( HttpServletRequest request )
    {
        populate( _agenda, request );

        // Check constraints
        if ( !validateBean( _agenda, VALIDATION_ATTRIBUTES_PREFIX ) )
        {
            return redirectView( request, VIEW_CREATE_AGENDA );
        }

        AgendaHome.create( _agenda );
        addInfo( INFO_AGENDA_CREATED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }

    /**
     * Manages the removal form of a agenda whose identifier is in the http request
     *
     * @param request
     *            The Http request
     * @return the html code to confirm
     */
    @Action( ACTION_CONFIRM_REMOVE_AGENDA )
    public String getConfirmRemoveAgenda( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );
        UrlItem url = new UrlItem( getActionUrl( ACTION_REMOVE_AGENDA ) );
        url.addParameter( PARAMETER_ID_AGENDA, nId );

        String strMessageUrl = AdminMessageService.getMessageUrl( request, MESSAGE_CONFIRM_REMOVE_AGENDA, url.getUrl( ), AdminMessage.TYPE_CONFIRMATION );

        return redirect( request, strMessageUrl );
    }

    /**
     * Handles the removal form of a agenda
     *
     * @param request
     *            The Http request
     * @return the jsp URL to display the form to manage agendas
     */
    @Action( ACTION_REMOVE_AGENDA )
    public String doRemoveAgenda( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );
        AgendaHome.remove( nId );
        addInfo( INFO_AGENDA_REMOVED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }

    /**
     * Returns the form to update info about a agenda
     *
     * @param request
     *            The Http request
     * @return The HTML form to update info
     */
    @View( VIEW_MODIFY_AGENDA )
    public String getModifyAgenda( HttpServletRequest request )
    {
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );

        if ( _agenda == null || ( _agenda.getId( ) != nId ) )
        {
            _agenda = AgendaHome.findByPrimaryKey( nId );
        }

        Map<String, Object> model = getModel( );
        model.put( MARK_AGENDA, _agenda );

        return getPage( PROPERTY_PAGE_TITLE_MODIFY_AGENDA, TEMPLATE_MODIFY_AGENDA, model );
    }

    /**
     * Process the change form of a agenda
     *
     * @param request
     *            The Http request
     * @return The Jsp URL of the process result
     */
    @Action( ACTION_MODIFY_AGENDA )
    public String doModifyAgenda( HttpServletRequest request )
    {
        populate( _agenda, request );

        // Check constraints
        if ( !validateBean( _agenda, VALIDATION_ATTRIBUTES_PREFIX ) )
        {
            return redirect( request, VIEW_MODIFY_AGENDA, PARAMETER_ID_AGENDA, _agenda.getId( ) );
        }

        AgendaHome.update( _agenda );
        addInfo( INFO_AGENDA_UPDATED, getLocale( ) );

        return redirectView( request, VIEW_MANAGE_AGENDAS );
    }
}
