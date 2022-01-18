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
package fr.paris.lutece.plugins.openagenda.business.portlet;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.openagenda.client.v2.EventsFilters;
import fr.paris.lutece.plugins.openagenda.service.OpenagendaV2Service;
import fr.paris.lutece.portal.business.portlet.PortletHtmlContent;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.util.html.HtmlTemplate;

/**
 * This class represents business objects OpenagendaPortlet
 */
public class OpenagendaPortlet extends PortletHtmlContent
{

    public static final String RESOURCE_ID = "OPENAGENDA_PORTLET";
    // TEMPALTES
    private static final String TEMPLATE_PORTLET_OPENAGENDA = "skin/plugins/openagenda/portletopenagenda_content.html";

    // MARKS
    private static final String MARKS_EVENTS = "event_list";

    // Variables declarations
    private int _nIdPortlet;
    private String _strName;
    private int _nAgendaUid;

    @Override
    public String getHtmlContent( HttpServletRequest request )
    {
        Map<String, Object> model = new HashMap<>( );

        EventsFilters filters = new EventsFilters( );
        filters.setTimingsGte( LocalDate.now() );
        
        model.put( MARKS_EVENTS, OpenagendaV2Service.getService( ).getEvents( String.valueOf( _nAgendaUid ), filters ) );
        Locale locale = request != null ? request.getLocale() : Locale.FRENCH;
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_PORTLET_OPENAGENDA, locale, model );

        return template.getHtml( );
    }

    /**
     * Updates the current instance of the OpenagendaPortlet object
     */
    public void update( )
    {
        OpenagendaPortletHome.getInstance( ).update( this );
    }

    /**
     * Remove the current instance of the OpenagendaPortlet object
     */
    @Override
    public void remove( )
    {
        OpenagendaPortletHome.getInstance( ).remove( this );
    }

    /**
     * Returns the IdPortlet
     * 
     * @return The IdPortlet
     */
    public int getIdPortlet( )
    {
        return _nIdPortlet;
    }

    /**
     * Sets the IdPortlet
     * 
     * @param nIdPortlet
     *            The IdPortlet
     */
    public void setIdPortlet( int nIdPortlet )
    {
        _nIdPortlet = nIdPortlet;
    }

    /**
     * Returns the Name
     * 
     * @return The Name
     */
    @Override
    public String getName( )
    {
        return _strName;
    }

    /**
     * Sets the Name
     * 
     * @param strName
     *            The Name
     */
    @Override
    public void setName( String strName )
    {
        _strName = strName;
    }

    /**
     * Returns the AgendaUid
     * 
     * @return The AgendaUid
     */
    public int getAgendaUid( )
    {
        return _nAgendaUid;
    }

    /**
     * Sets the AgendaUid
     * 
     * @param nAgendaUid
     *            The AgendaUid
     */
    public void setAgendaUid( int nAgendaUid )
    {
        _nAgendaUid = nAgendaUid;
    }
}
