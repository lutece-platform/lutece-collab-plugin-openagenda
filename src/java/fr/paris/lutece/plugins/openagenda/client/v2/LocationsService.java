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

import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;

/**
 * 
 * This Service gets information about locations
 *
 */
public class LocationsService
{
	private static final String PROPERTY_ENDPOINT_ALL_LOCATIONS 	= "openagenda.api.v2.locations.all.endpoint";
	private static final String PROPERTY_ENDPOINT_LOCATION		 	= "openagenda.api.v2.locations.detail.endpoint";
	
    private static final String PROPERTY_API_OPENAGENDA_KEY 		= AppPropertiesService.getProperty( "openagenda.apiKey" );	
    
    /**
     * Gets locations by agendaUid
     * @param agendaUid
     * @return json data
     */
	public String getLocations ( String agendaUid )
	{
		String endpointAPI = MessageFormat.format(
				AppPropertiesService.getProperty( PROPERTY_ENDPOINT_ALL_LOCATIONS ),
				agendaUid,
				PROPERTY_API_OPENAGENDA_KEY );
		
        HttpAccess httpAccess = new HttpAccess();

        try
        {
            return httpAccess.doGet(endpointAPI);
        } 
        catch (HttpAccessException ex) 
        {
        	AppLogService.error( "Erreur lors de l'appel a l'API {}", endpointAPI , ex );
        }      
        
        return StringUtils.EMPTY;
	}
	
    /**
     * Get the detail of an location
     * @param agendaUid
     * @param locationUid
     * @return json data
     */
	public String getLocation ( String agendaUid, String locationUid)
	{
		String endpointAPI = MessageFormat.format(
				AppPropertiesService.getProperty( PROPERTY_ENDPOINT_LOCATION ),
				agendaUid,
				locationUid,
				PROPERTY_API_OPENAGENDA_KEY );
		
        HttpAccess httpAccess = new HttpAccess();

        try
        {
            return httpAccess.doGet( endpointAPI );
        } 
        catch (HttpAccessException ex) 
        {
        	AppLogService.error( "Erreur lors de l'appel a l'API {}", endpointAPI , ex );
        }      
        
        return StringUtils.EMPTY;
	}
}
