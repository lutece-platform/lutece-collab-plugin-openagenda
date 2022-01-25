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
package fr.paris.lutece.plugins.openagenda.business;

import fr.paris.lutece.portal.service.plugin.Plugin;
import fr.paris.lutece.portal.service.plugin.PluginService;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import java.util.Collection;

/**
 * This class provides instances management methods (create, find, ...) for Agenda objects
 */

public final class AgendaHome
{
    // Static variable pointed at the DAO instance

    private static IAgendaDAO _dao = SpringContextService.getBean( "openagenda.agendaDAO" );
    private static Plugin _plugin = PluginService.getPlugin( "openagenda" );

    /**
     * Private constructor - this class need not be instantiated
     */
    private AgendaHome( )
    {
    }

    /**
     * Create an instance of the agenda class
     * 
     * @param agenda
     *            The instance of the Agenda which contains the informations to store
     * @return The instance of agenda which has been created with its primary key.
     */
    public static Agenda create( Agenda agenda )
    {
        _dao.insert( agenda, _plugin );

        return agenda;
    }

    /**
     * Update of the agenda which is specified in parameter
     * 
     * @param agenda
     *            The instance of the Agenda which contains the data to store
     * @return The instance of the agenda which has been updated
     */
    public static Agenda update( Agenda agenda )
    {
        _dao.store( agenda, _plugin );

        return agenda;
    }

    /**
     * Remove the agenda whose identifier is specified in parameter
     * 
     * @param nKey
     *            The agenda Id
     */
    public static void remove( int nKey )
    {
        _dao.delete( nKey, _plugin );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of a agenda whose identifier is specified in parameter
     * 
     * @param nKey
     *            The agenda primary key
     * @return an instance of Agenda
     */
    public static Agenda findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey, _plugin );
    }

    /**
     * Load the data of all the agenda objects and returns them in form of a collection
     * 
     * @return the collection which contains the data of all the agenda objects
     */
    public static Collection<Agenda> getAgendasList( )
    {
        return _dao.selectAgendasList( _plugin );
    }

    /**
     * Load the id of all the agenda objects and returns them in form of a collection
     * 
     * @return the collection which contains the id of all the agenda objects
     */
    public static Collection<Integer> getIdAgendasList( )
    {
        return _dao.selectIdAgendasList( _plugin );
    }
}
