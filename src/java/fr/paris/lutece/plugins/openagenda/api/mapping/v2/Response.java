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
package fr.paris.lutece.plugins.openagenda.api.mapping.v2;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the business class for the Response
 *
 */
public class Response
{
    @JsonProperty( "success" )
    private boolean _bSuccess;

    @JsonProperty( "events" )
    private List<EventData> _listEvents = Collections.emptyList( );

    @JsonProperty( "event" )
    private EventData _event;

    @JsonProperty( "locations" )
    private List<LocationData> _listLocations = Collections.emptyList( );

    @JsonProperty( "location" )
    private LocationData _location;

    @JsonProperty( "items" )
    private List<AgendaData> _listAgendas = Collections.emptyList( );

    /**
     * @return the success
     */
    public boolean isSuccess( )
    {
        return _bSuccess;
    }

    /**
     * @param bSuccess
     *            the success to set
     */
    public void setSuccess( boolean bSuccess )
    {
        this._bSuccess = bSuccess;
    }

    /**
     * @return the events
     */
    public List<EventData> getEvents( )
    {
        return Collections.unmodifiableList( _listEvents );
    }

    /**
     * @param listEvents
     *            the events to set
     */
    public void setEvents( List<EventData> listEvents )
    {
        this._listEvents = Collections.unmodifiableList( listEvents );
    }

    /**
     * @return the event
     */
    public EventData getEvent( )
    {
        return _event;
    }

    /**
     * @param event
     *            the event to set
     */
    public void setEvent( EventData event )
    {
        this._event = event;
    }

    /**
     * @return the locations
     */
    public List<LocationData> getLocations( )
    {
        return Collections.unmodifiableList( _listLocations );
    }

    /**
     * @param listLocations
     *            the locations to set
     */
    public void setLocations( List<LocationData> listLocations )
    {
        this._listLocations = Collections.unmodifiableList( listLocations );
    }

    /**
     * @return the location
     */
    public LocationData getLocation( )
    {
        return _location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation( LocationData location )
    {
        this._location = location;
    }

    /**
     * @return the agendas
     */
    public List<AgendaData> getAgendas( )
    {
        return Collections.unmodifiableList( _listAgendas );
    }

    /**
     * @param listAgendas
     *            the agendas to set
     */
    public void setAgendas( List<AgendaData> listAgendas )
    {
        this._listAgendas = Collections.unmodifiableList( listAgendas );
    }

}
