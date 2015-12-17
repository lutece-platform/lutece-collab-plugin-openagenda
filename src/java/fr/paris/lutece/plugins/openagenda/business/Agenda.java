/*
 * Copyright (c) 2002-2015, Mairie de Paris
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

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;


/**
 * This is the business class for the object Agenda
 */ 
public class Agenda
{
    // Variables declarations 
    private int _nId;
    
    private int _nUid;
    
    @NotEmpty( message = "#i18n{openagenda.validation.agenda.Name.notEmpty}" )
    @Size( max = 50 , message = "#i18n{openagenda.validation.agenda.Name.size}" ) 
    private String _strName;
    
    @Size( max = 255 , message = "#i18n{openagenda.validation.agenda.Description.size}" ) 
    private String _strDescription;
    
    @NotEmpty( message = "#i18n{openagenda.validation.agenda.EventsEmbeddingCode.notEmpty}" )
    private String _strEventsEmbeddingCode;
    
    private String _strMapEmbeddingCode;
    
    private String _strSearchEmbeddingCode;
    
    private String _strCategoriesEmbeddingCode;
    
    private String _strTagsEmbeddingCode;
    
    private String _strCalendarEmbeddingCode;

    /**
     * Returns the Id
     * @return The Id
     */
    public int getId( )
    {
        return _nId;
    }

    /**
     * Sets the Id
     * @param nId The Id
     */ 
    public void setId( int nId )
    {
        _nId = nId;
    }

    /**
     * Returns the Uid
     * @return The Uid
     */
    public int getUid( )
    {
        return _nUid;
    }

    /**
     * Sets the Uid
     * @param nUid The Uid
     */ 
    public void setUid( int nUid )
    {
        _nUid = nUid;
    }
    /**
     * Returns the Name
     * @return The Name
     */
    public String getName( )
    {
        return _strName;
    }

    /**
     * Sets the Name
     * @param strName The Name
     */ 
    public void setName( String strName )
    {
        _strName = strName;
    }
    /**
     * Returns the Description
     * @return The Description
     */
    public String getDescription( )
    {
        return _strDescription;
    }

    /**
     * Sets the Description
     * @param strDescription The Description
     */ 
    public void setDescription( String strDescription )
    {
        _strDescription = strDescription;
    }
    /**
     * Returns the EventsEmbeddingCode
     * @return The EventsEmbeddingCode
     */
    public String getEventsEmbeddingCode( )
    {
        return _strEventsEmbeddingCode;
    }

    /**
     * Sets the EventsEmbeddingCode
     * @param strEventsEmbeddingCode The EventsEmbeddingCode
     */ 
    public void setEventsEmbeddingCode( String strEventsEmbeddingCode )
    {
        _strEventsEmbeddingCode = strEventsEmbeddingCode;
    }
    /**
     * Returns the MapEmbeddingCode
     * @return The MapEmbeddingCode
     */
    public String getMapEmbeddingCode( )
    {
        return _strMapEmbeddingCode;
    }

    /**
     * Sets the MapEmbeddingCode
     * @param strMapEmbeddingCode The MapEmbeddingCode
     */ 
    public void setMapEmbeddingCode( String strMapEmbeddingCode )
    {
        _strMapEmbeddingCode = strMapEmbeddingCode;
    }
    /**
     * Returns the SearchEmbeddingCode
     * @return The SearchEmbeddingCode
     */
    public String getSearchEmbeddingCode( )
    {
        return _strSearchEmbeddingCode;
    }

    /**
     * Sets the SearchEmbeddingCode
     * @param strSearchEmbeddingCode The SearchEmbeddingCode
     */ 
    public void setSearchEmbeddingCode( String strSearchEmbeddingCode )
    {
        _strSearchEmbeddingCode = strSearchEmbeddingCode;
    }
    /**
     * Returns the CategoriesEmbeddingCode
     * @return The CategoriesEmbeddingCode
     */
    public String getCategoriesEmbeddingCode( )
    {
        return _strCategoriesEmbeddingCode;
    }

    /**
     * Sets the CategoriesEmbeddingCode
     * @param strCategoriesEmbeddingCode The CategoriesEmbeddingCode
     */ 
    public void setCategoriesEmbeddingCode( String strCategoriesEmbeddingCode )
    {
        _strCategoriesEmbeddingCode = strCategoriesEmbeddingCode;
    }
    /**
     * Returns the TagsEmbeddingCode
     * @return The TagsEmbeddingCode
     */
    public String getTagsEmbeddingCode( )
    {
        return _strTagsEmbeddingCode;
    }

    /**
     * Sets the TagsEmbeddingCode
     * @param strTagsEmbeddingCode The TagsEmbeddingCode
     */ 
    public void setTagsEmbeddingCode( String strTagsEmbeddingCode )
    {
        _strTagsEmbeddingCode = strTagsEmbeddingCode;
    }
    /**
     * Returns the CalendarEmbeddingCode
     * @return The CalendarEmbeddingCode
     */
    public String getCalendarEmbeddingCode( )
    {
        return _strCalendarEmbeddingCode;
    }

    /**
     * Sets the CalendarEmbeddingCode
     * @param strCalendarEmbeddingCode The CalendarEmbeddingCode
     */ 
    public void setCalendarEmbeddingCode( String strCalendarEmbeddingCode )
    {
        _strCalendarEmbeddingCode = strCalendarEmbeddingCode;
    }
}
