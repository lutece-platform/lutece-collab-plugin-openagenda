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
package fr.paris.lutece.plugins.openagenda.web.portlet;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.openagenda.business.portlet.OpenagendaPortlet;
import fr.paris.lutece.plugins.openagenda.business.portlet.OpenagendaPortletHome;
import fr.paris.lutece.portal.business.portlet.PortletHome;
import fr.paris.lutece.portal.web.portlet.PortletJspBean;
import fr.paris.lutece.util.html.HtmlTemplate;

/**
 * This class provides the user interface to manage OpenagendaPortletJspBean features
 */
public class OpenagendaPortletJspBean extends PortletJspBean
{

    /**
     * 
     */
    private static final long serialVersionUID = 4096345110079566513L;

    // PARAMETERS
    private static final String PARAMETER_AGENDA_UID = "agenda_uid";
    private static final String PARAMETER_NAME = "name";

    /**
     * Treats the creation form of a new OpenagendaPortlet portlet
     * 
     * @param request
     *            The Http request
     * @return The jsp URL which displays the view of the created OpenagendaPortlet portlet
     */
    @Override
    public String doCreate( HttpServletRequest request )
    {
        OpenagendaPortlet portlet = new OpenagendaPortlet( );
        String strIdPage = request.getParameter( PARAMETER_PAGE_ID );
        int nIdPage = Integer.parseInt( strIdPage );

        // get portlet common attributes
        String strErrorUrl = setPortletCommonData( request, portlet );

        if ( strErrorUrl != null )
        {
            return strErrorUrl;
        }

        portlet.setAgendaUid( Integer.parseInt( request.getParameter( PARAMETER_AGENDA_UID ) ) );
        portlet.setName( request.getParameter( PARAMETER_NAME ) );

        portlet.setPageId( nIdPage );

        // Portlet creation
        OpenagendaPortletHome.getInstance( ).create( portlet );

        // Displays the page with the new Portlet
        return getPageUrl( nIdPage );
    }

    /**
     * Treats the update form of the OpenagendaPortlet portlet whose identifier is in the http request
     * 
     * @param request
     *            The Http request
     * @return The jsp URL which displays the view of the updated portlet
     */
    @Override
    public String doModify( HttpServletRequest request )
    {
        // recovers portlet attributes
        String strPortletId = request.getParameter( PARAMETER_PORTLET_ID );
        int nPortletId = Integer.parseInt( strPortletId );
        OpenagendaPortlet portlet = (OpenagendaPortlet) PortletHome.findByPrimaryKey( nPortletId );

        // retrieve portlet common attributes
        portlet.setAgendaUid( Integer.parseInt( request.getParameter( PARAMETER_AGENDA_UID ) ) );
        portlet.setName( request.getParameter( PARAMETER_NAME ) );

        // updates the portlet
        portlet.update( );

        // displays the page with the potlet updated
        return getPageUrl( portlet.getPageId( ) );
    }

    /**
     * Returns the OpenagendaPortlet form of creation
     * 
     * @param request
     *            The Http rquest
     * @return the html code of the OpenagendaPortlet portlet form
     */
    @Override
    public String getCreate( HttpServletRequest request )
    {
        String strIdPage = request.getParameter( PARAMETER_PAGE_ID );
        String strIdPortletType = request.getParameter( PARAMETER_PORTLET_TYPE_ID );

        HtmlTemplate template = getCreateTemplate( strIdPage, strIdPortletType );

        return template.getHtml( );
    }

    /**
     * Returns the OpenagendaPortlet form for update
     * 
     * @param request
     *            The Http request
     * @return the html code of the OpenagendaPortlet form
     */
    @Override
    public String getModify( HttpServletRequest request )
    {
        String strPortletId = request.getParameter( PARAMETER_PORTLET_ID );
        int nPortletId = Integer.parseInt( strPortletId );
        OpenagendaPortlet portlet = (OpenagendaPortlet) PortletHome.findByPrimaryKey( nPortletId );

        HtmlTemplate template = getModifyTemplate( portlet );

        return template.getHtml( );
    }

}
