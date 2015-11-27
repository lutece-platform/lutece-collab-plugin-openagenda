/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *	 and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *	 and the following disclaimer in the documentation and/or other materials
 *	 provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *	 contributors may be used to endorse or promote products derived from
 *	 this software without specific prior written permission.
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
import fr.paris.lutece.util.sql.DAOUtil;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class provides Data Access methods for Agenda objects
 */

public final class AgendaDAO implements IAgendaDAO
{
    // Constants
    private static final String SQL_QUERY_NEW_PK = "SELECT max( id_agenda ) FROM openagenda_agenda";
    private static final String SQL_QUERY_SELECT = "SELECT id_agenda, uid, Name, Description FROM openagenda_agenda WHERE id_agenda = ?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO openagenda_agenda ( id_agenda, uid, Name, Description ) VALUES ( ?, ?, ?, ? ) ";
    private static final String SQL_QUERY_DELETE = "DELETE FROM openagenda_agenda WHERE id_agenda = ? ";
    private static final String SQL_QUERY_UPDATE = "UPDATE openagenda_agenda SET id_agenda = ?, uid = ?, Name = ?, Description = ? WHERE id_agenda = ?";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_agenda, uid, Name, Description FROM openagenda_agenda";
    private static final String SQL_QUERY_SELECTALL_ID = "SELECT id_agenda FROM openagenda_agenda";

    /**
     * Generates a new primary key
     * @param plugin The Plugin
     * @return The new primary key
     */
    public int newPrimaryKey( Plugin plugin)
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_NEW_PK , plugin  );
        daoUtil.executeQuery( );

        int nKey = 1;

        if( daoUtil.next( ) )
        {
                nKey = daoUtil.getInt( 1 ) + 1;
        }

        daoUtil.free();

        return nKey;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void insert( Agenda agenda, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT, plugin );

        agenda.setId( newPrimaryKey( plugin ) );

        daoUtil.setInt( 1, agenda.getId( ) );
        daoUtil.setInt( 2, agenda.getUid( ) );
        daoUtil.setString( 3, agenda.getName( ) );
        daoUtil.setString( 4, agenda.getDescription( ) );

        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Agenda load( int nKey, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT, plugin );
        daoUtil.setInt( 1 , nKey );
        daoUtil.executeQuery( );

        Agenda agenda = null;

        if ( daoUtil.next( ) )
        {
            agenda = new Agenda();
            agenda.setId( daoUtil.getInt( 1 ) );
            agenda.setUid( daoUtil.getInt( 2 ) );
            agenda.setName( daoUtil.getString( 3 ) );
            agenda.setDescription( daoUtil.getString( 4 ) );
        }

        daoUtil.free( );
        return agenda;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void delete( int nKey, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE, plugin );
        daoUtil.setInt( 1 , nKey );
        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public void store( Agenda agenda, Plugin plugin )
    {
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE, plugin );
        
        daoUtil.setInt( 1, agenda.getId( ) );
        daoUtil.setInt( 2, agenda.getUid( ) );
        daoUtil.setString( 3, agenda.getName( ) );
        daoUtil.setString( 4, agenda.getDescription( ) );
        daoUtil.setInt( 5, agenda.getId( ) );

        daoUtil.executeUpdate( );
        daoUtil.free( );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public Collection<Agenda> selectAgendasList( Plugin plugin )
    {
        Collection<Agenda> agendaList = new ArrayList<Agenda>(  );
        DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL, plugin );
        daoUtil.executeQuery(  );

        while ( daoUtil.next(  ) )
        {
            Agenda agenda = new Agenda(  );
            
            agenda.setId( daoUtil.getInt( 1 ) );
                agenda.setUid( daoUtil.getInt( 2 ) );
                agenda.setName( daoUtil.getString( 3 ) );
                agenda.setDescription( daoUtil.getString( 4 ) );

            agendaList.add( agenda );
        }

        daoUtil.free( );
        return agendaList;
    }
    
    /**
     * {@inheritDoc }
     */
    @Override
    public Collection<Integer> selectIdAgendasList( Plugin plugin )
    {
            Collection<Integer> agendaList = new ArrayList<Integer>( );
            DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL_ID, plugin );
            daoUtil.executeQuery(  );

            while ( daoUtil.next(  ) )
            {
                agendaList.add( daoUtil.getInt( 1 ) );
            }

            daoUtil.free( );
            return agendaList;
    }
}