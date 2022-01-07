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

import fr.paris.lutece.test.LuteceTestCase;

public class AgendaBusinessTest extends LuteceTestCase
{
    private static final int UID1 = 1;
    private static final int UID2 = 2;
    private static final String NAME1 = "Name1";
    private static final String NAME2 = "Name2";
    private static final String DESCRIPTION1 = "Description1";
    private static final String DESCRIPTION2 = "Description2";
    private static final String EVENTSEMBEDDINGCODE1 = "EventsEmbeddingCode1";
    private static final String EVENTSEMBEDDINGCODE2 = "EventsEmbeddingCode2";
    private static final String MAPEMBEDDINGCODE1 = "MapEmbeddingCode1";
    private static final String MAPEMBEDDINGCODE2 = "MapEmbeddingCode2";
    private static final String SEARCHEMBEDDINGCODE1 = "SearchEmbeddingCode1";
    private static final String SEARCHEMBEDDINGCODE2 = "SearchEmbeddingCode2";
    private static final String CATEGORIESEMBEDDINGCODE1 = "CategoriesEmbeddingCode1";
    private static final String CATEGORIESEMBEDDINGCODE2 = "CategoriesEmbeddingCode2";
    private static final String TAGSEMBEDDINGCODE1 = "TagsEmbeddingCode1";
    private static final String TAGSEMBEDDINGCODE2 = "TagsEmbeddingCode2";
    private static final String CALENDAREMBEDDINGCODE1 = "CalendarEmbeddingCode1";
    private static final String CALENDAREMBEDDINGCODE2 = "CalendarEmbeddingCode2";

    public void testBusiness( )
    {
        // Initialize an object
        Agenda agenda = new Agenda( );
        agenda.setUid( UID1 );
        agenda.setName( NAME1 );
        agenda.setDescription( DESCRIPTION1 );
        agenda.setEventsEmbeddingCode( EVENTSEMBEDDINGCODE1 );
        agenda.setMapEmbeddingCode( MAPEMBEDDINGCODE1 );
        agenda.setSearchEmbeddingCode( SEARCHEMBEDDINGCODE1 );
        agenda.setCategoriesEmbeddingCode( CATEGORIESEMBEDDINGCODE1 );
        agenda.setTagsEmbeddingCode( TAGSEMBEDDINGCODE1 );
        agenda.setCalendarEmbeddingCode( CALENDAREMBEDDINGCODE1 );

        // Create test
        AgendaHome.create( agenda );
        Agenda agendaStored = AgendaHome.findByPrimaryKey( agenda.getId( ) );
        assertEquals( agendaStored.getUid( ), agenda.getUid( ) );
        assertEquals( agendaStored.getName( ), agenda.getName( ) );
        assertEquals( agendaStored.getDescription( ), agenda.getDescription( ) );
        assertEquals( agendaStored.getEventsEmbeddingCode( ), agenda.getEventsEmbeddingCode( ) );
        assertEquals( agendaStored.getMapEmbeddingCode( ), agenda.getMapEmbeddingCode( ) );
        assertEquals( agendaStored.getSearchEmbeddingCode( ), agenda.getSearchEmbeddingCode( ) );
        assertEquals( agendaStored.getCategoriesEmbeddingCode( ), agenda.getCategoriesEmbeddingCode( ) );
        assertEquals( agendaStored.getTagsEmbeddingCode( ), agenda.getTagsEmbeddingCode( ) );
        assertEquals( agendaStored.getCalendarEmbeddingCode( ), agenda.getCalendarEmbeddingCode( ) );

        // Update test
        agenda.setUid( UID2 );
        agenda.setName( NAME2 );
        agenda.setDescription( DESCRIPTION2 );
        agenda.setEventsEmbeddingCode( EVENTSEMBEDDINGCODE2 );
        agenda.setMapEmbeddingCode( MAPEMBEDDINGCODE2 );
        agenda.setSearchEmbeddingCode( SEARCHEMBEDDINGCODE2 );
        agenda.setCategoriesEmbeddingCode( CATEGORIESEMBEDDINGCODE2 );
        agenda.setTagsEmbeddingCode( TAGSEMBEDDINGCODE2 );
        agenda.setCalendarEmbeddingCode( CALENDAREMBEDDINGCODE2 );
        AgendaHome.update( agenda );
        agendaStored = AgendaHome.findByPrimaryKey( agenda.getId( ) );
        assertEquals( agendaStored.getUid( ), agenda.getUid( ) );
        assertEquals( agendaStored.getName( ), agenda.getName( ) );
        assertEquals( agendaStored.getDescription( ), agenda.getDescription( ) );
        assertEquals( agendaStored.getEventsEmbeddingCode( ), agenda.getEventsEmbeddingCode( ) );
        assertEquals( agendaStored.getMapEmbeddingCode( ), agenda.getMapEmbeddingCode( ) );
        assertEquals( agendaStored.getSearchEmbeddingCode( ), agenda.getSearchEmbeddingCode( ) );
        assertEquals( agendaStored.getCategoriesEmbeddingCode( ), agenda.getCategoriesEmbeddingCode( ) );
        assertEquals( agendaStored.getTagsEmbeddingCode( ), agenda.getTagsEmbeddingCode( ) );
        assertEquals( agendaStored.getCalendarEmbeddingCode( ), agenda.getCalendarEmbeddingCode( ) );

        // List test
        AgendaHome.getAgendasList( );

        // Delete test
        AgendaHome.remove( agenda.getId( ) );
        agendaStored = AgendaHome.findByPrimaryKey( agenda.getId( ) );
        assertNull( agendaStored );

    }

}
