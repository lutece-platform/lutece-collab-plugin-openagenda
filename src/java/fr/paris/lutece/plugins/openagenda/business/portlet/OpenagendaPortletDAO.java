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

import java.util.ArrayList;
import java.util.List;

import fr.paris.lutece.portal.business.portlet.Portlet;
import fr.paris.lutece.util.sql.DAOUtil;

/**
 * This class provides Data Access methods for OpenagendaPortlet objects
 */
public class OpenagendaPortletDAO implements IOpenagendaPortletDAO
{

    // Constants
    private static final String SQL_QUERY_DELETE = "DELETE FROM openagenda_portlet WHERE id_portlet = ? ";
    private static final String SQL_QUERY_SELECT = "SELECT id_portlet, name, agenda_uid FROM openagenda_portlet WHERE id_portlet = ? ";
    private static final String SQL_QUERY_INSERT = "INSERT INTO openagenda_portlet (id_portlet, name, agenda_uid ) VALUES ( ?, ?, ? )";
    private static final String SQL_QUERY_UPDATE = "UPDATE openagenda_portlet SET name = ?, agenda_uid=? WHERE id_portlet = ? ";
    private static final String SQL_QUERY_SELECTALL = "SELECT id_portlet, name, agenda_uid FROM openagenda_portlet";

    /**
     * { @inheritDoc }
     */
    @Override
    public void delete( int nPortletId )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_DELETE ) )
        {
            daoUtil.setInt( 1, nPortletId );
            daoUtil.executeUpdate( );
        }
    }

    /**
     * { @inheritDoc }
     */
    @Override
    public void insert( Portlet portlet )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_INSERT ) )
        {
            OpenagendaPortlet openagendaPortel = (OpenagendaPortlet) portlet;
            int nIndex = 0;
            daoUtil.setInt( ++nIndex, openagendaPortel.getId( ) );
            daoUtil.setString( ++nIndex, openagendaPortel.getName( ) );
            daoUtil.setInt( ++nIndex, openagendaPortel.getAgendaUid( ) );

            daoUtil.executeUpdate( );
        }
    }

    /**
     * { @inheritDoc }
     */
    @Override
    public Portlet load( int nIdPortlet )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECT ) )
        {
            daoUtil.setInt( 1, nIdPortlet );
            daoUtil.executeQuery( );

            OpenagendaPortlet openagendaPortel = null;
            int nIndex = 0;
            if ( daoUtil.next( ) )
            {
                openagendaPortel = new OpenagendaPortlet( );

                openagendaPortel.setId( daoUtil.getInt( ++nIndex ));
                openagendaPortel.setName( daoUtil.getString( ++nIndex ) );
                openagendaPortel.setAgendaUid( daoUtil.getInt( ++nIndex ) );
            }

            return openagendaPortel;
        }
    }

    /**
     * { @inheritDoc }
     */
    @Override
    public void store( Portlet portlet )
    {
        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_UPDATE ) )
        {
            OpenagendaPortlet openagendaPortel = (OpenagendaPortlet) portlet;

            int nIndex = 0;
            daoUtil.setString( ++nIndex, openagendaPortel.getName( ) );
            daoUtil.setInt( ++nIndex, openagendaPortel.getAgendaUid( ) );
            daoUtil.setInt( ++nIndex, openagendaPortel.getId( ) );

            daoUtil.executeUpdate( );
        }
    }

    /**
     * {@inheritDoc }
     */
    public List<Portlet> selectOpenagendaPortletsList( )
    {
        List<Portlet> listMyObjects = new ArrayList<>( );

        try ( DAOUtil daoUtil = new DAOUtil( SQL_QUERY_SELECTALL ) )
        {
            daoUtil.executeQuery( );

            while ( daoUtil.next( ) )
            {
                OpenagendaPortlet openagendaPortlet = new OpenagendaPortlet( );

                int nIndex = 0;
                openagendaPortlet.setIdPortlet( daoUtil.getInt( ++nIndex ) );
                openagendaPortlet.setName( daoUtil.getString( ++nIndex ) );
                openagendaPortlet.setAgendaUid( daoUtil.getInt( ++nIndex ) );

                listMyObjects.add( openagendaPortlet );
            }

            return listMyObjects;
        }
    }

}
