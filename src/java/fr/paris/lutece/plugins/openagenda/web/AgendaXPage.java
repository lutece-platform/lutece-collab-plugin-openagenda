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
 
import fr.paris.lutece.plugins.openagenda.business.Agenda;
import fr.paris.lutece.plugins.openagenda.business.AgendaHome;
import fr.paris.lutece.portal.web.xpages.XPage;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest; 

/**
 * This class provides the user interface to list all Agendas and view an agenda
 */
 
@Controller( xpageName = "agenda" , pageTitleI18nKey = "openagenda.xpage.agenda.pageTitle" , pagePathI18nKey = "openagenda.xpage.agenda.pagePathLabel" )
public class AgendaXPage extends MVCApplication
{
    /**
     *
     */
    private static final long serialVersionUID = 2893092282766092854L;
    // Templates
    private static final String TEMPLATE_MANAGE_AGENDAS="/skin/plugins/openagenda/manage_agendas.html";
    private static final String TEMPLATE_AGENDA_EVENTS="/skin/plugins/openagenda/agenda_events.html";
    
    // Parameters
    private static final String PARAMETER_ID_AGENDA="id";
    
    // Markers
    private static final String MARK_AGENDA_LIST = "agenda_list";
    private static final String MARK_AGENDA = "agenda";
    
    // Views
    private static final String VIEW_MANAGE_AGENDAS = "manageAgendas";
    private static final String VIEW_AGENDA_EVENTS = "agendaEvents";
    
    
    @View( value = VIEW_MANAGE_AGENDAS, defaultView = true )
    public XPage getManageAgendas( HttpServletRequest request )
    {
        Map<String, Object> model = getModel(  );
        model.put( MARK_AGENDA_LIST, AgendaHome.getAgendasList(  ) );

        return getXPage( TEMPLATE_MANAGE_AGENDAS, request.getLocale(  ), model );
    }

    @View( value = VIEW_AGENDA_EVENTS )
    public XPage getAgendaEvents( HttpServletRequest request )
    {           
        int nId = Integer.parseInt( request.getParameter( PARAMETER_ID_AGENDA ) );

        Agenda agenda = AgendaHome.findByPrimaryKey( nId );

        Map<String, Object> model = getModel(  );
        model.put( MARK_AGENDA, agenda );
        return getXPage( TEMPLATE_AGENDA_EVENTS, request.getLocale(  ), model);
    }
}
