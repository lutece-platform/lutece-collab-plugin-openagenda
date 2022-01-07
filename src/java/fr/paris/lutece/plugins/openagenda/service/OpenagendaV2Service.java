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
package fr.paris.lutece.plugins.openagenda.service;

import java.util.List;

import fr.paris.lutece.plugins.openagenda.api.mapping.v2.AgendaData;
import fr.paris.lutece.plugins.openagenda.api.mapping.v2.EventData;
import fr.paris.lutece.plugins.openagenda.api.mapping.v2.LocationData;
import fr.paris.lutece.plugins.openagenda.api.mapping.v2.Response;
import fr.paris.lutece.plugins.openagenda.client.v2.AgendasService;
import fr.paris.lutece.plugins.openagenda.client.v2.EventsFilters;
import fr.paris.lutece.plugins.openagenda.client.v2.EventsService;
import fr.paris.lutece.plugins.openagenda.client.v2.LocationsService;
import fr.paris.lutece.plugins.openagenda.utils.OpenagendaUtils;

/**
 * 
 * Use this service for Openagenda API V2
 *
 */
public class OpenagendaV2Service
{
    private AgendasService _agendasService = new AgendasService( );
    private EventsService _eventsService = new EventsService( );
    private LocationsService _locationsService = new LocationsService( );

    private static OpenagendaV2Service _instance;

    public static final OpenagendaV2Service getService( )
    {
        if ( _instance == null )
        {
            _instance = new OpenagendaV2Service( );
        }

        return _instance;
    }

    /**
     * Gets the list of "agendas"
     * 
     * @return List<AgendaData>
     */
    public List<AgendaData> getAgendas( )
    {
        String jsonData = _agendasService.getAgendas( );
        Response response = OpenagendaUtils.jsonStringToObject( jsonData, Response.class );

        return response.getAgendas( );
    }

    /**
     * Gets all events by agendaUid
     * 
     * @param agendaUid
     *            (Required)
     * @param filters
     *            (Optional See API V2 documentation)
     * @return List<EventData>
     */
    public List<EventData> getEvents( String agendaUid, EventsFilters filters )
    {
        String jsonData = _eventsService.getEvents( agendaUid, filters );
        Response response = OpenagendaUtils.jsonStringToObject( jsonData, Response.class );

        return response.getEvents( );
    }

    /**
     * Get the detail of an event
     * 
     * @param agendaUid
     *            (Required)
     * @param eventUid
     *            (Required)
     * @return EventData
     */
    public EventData getEvent( String agendaUid, String eventUid )
    {
        String jsonData = _eventsService.getEvent( agendaUid, eventUid );
        Response response = OpenagendaUtils.jsonStringToObject( jsonData, Response.class );

        return response.getEvent( );
    }

    /**
     * Gets locations by agendaUid
     * 
     * @param agendaUid
     * @return List<LocationData>
     */
    public List<LocationData> getLocations( String agendaUid )
    {
        String jsonData = _locationsService.getLocations( agendaUid );
        Response response = OpenagendaUtils.jsonStringToObject( jsonData, Response.class );

        return response.getLocations( );
    }

    /**
     * Get the detail of an location
     * 
     * @param agendaUid
     * @param locationUid
     * @return LocationData
     */
    public LocationData getLocation( String agendaUid, String locationUid )
    {
        String jsonData = _locationsService.getLocation( agendaUid, locationUid );
        Response response = OpenagendaUtils.jsonStringToObject( jsonData, Response.class );

        return response.getLocation( );
    }
}
