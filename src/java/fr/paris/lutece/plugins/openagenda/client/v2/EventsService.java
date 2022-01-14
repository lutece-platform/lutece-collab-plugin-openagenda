/*
 * Copyright (c) 2002-2022, Mairie de Paris
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
package fr.paris.lutece.plugins.openagenda.client.v2;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import fr.paris.lutece.plugins.openagenda.utils.OpenagendaUtils;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;

/**
 * 
 *  This Service gets information about events
 *
 */
public class EventsService
{
	private static final String PROPERTY_ENDPOINT_ALL_EVENTS 		= "openagenda.api.v2.events.all.endpoint";
	private static final String PROPERTY_ENDPOINT_EVENT		 		= "openagenda.api.v2.events.detail.endpoint";
    private static final String PROPERTY_API_OPENAGENDA_KEY 		= AppPropertiesService.getProperty( "openagenda.apiKey" );	
    

    /**
     * Gets all events by agendaUid
     * @param agendaUid (Required)
     * @param filters (Optional See API V2 documentation)
     * @return json data
     */
	public String getEvents ( String agendaUid, EventsFilters filters )
	{
		String strUrl = MessageFormat.format(
				AppPropertiesService.getProperty( PROPERTY_ENDPOINT_ALL_EVENTS ),
				agendaUid,
				PROPERTY_API_OPENAGENDA_KEY );
		
		strUrl += OpenagendaUtils.getRequestString( filters, EventsFilters.class ) ;
        HttpAccess httpAccess = new HttpAccess();

        try
        {
            return httpAccess.doGet(strUrl);
        } 
        catch (HttpAccessException ex) 
        {
        	AppLogService.error( "Erreur lors de l'appel a l'API {}", strUrl , ex );
        }      
        
        return StringUtils.EMPTY;
	}

    /**
     * Get the detail of an event 
     * @param agendaUid (Required)
     * @param eventUid (Required)
     * @return json data
     */
	public String getEvent ( String agendaUid, String eventUid )
	{
		String strUrl = MessageFormat.format(
				AppPropertiesService.getProperty( PROPERTY_ENDPOINT_EVENT ),
				agendaUid,
				eventUid,
				PROPERTY_API_OPENAGENDA_KEY );
		
        HttpAccess httpAccess = new HttpAccess();

        try
        {
            return httpAccess.doGet(strUrl);
        } 
        catch (HttpAccessException ex) 
        {
        	AppLogService.error( "Erreur lors de l'appel a l'API {}", strUrl , ex );
        }      
        
        return StringUtils.EMPTY;
	}
}
