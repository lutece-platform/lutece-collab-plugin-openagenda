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
package fr.paris.lutece.plugins.openagenda.client.v2;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventsFilters
{
    @JsonProperty( "city" )
    private String _strCity;

    @JsonProperty( "department" )
    private String _strDepartment;

    @JsonProperty( "region" )
    private String _strRegion;

    @JsonProperty( "timings[gte]" )
    private LocalDate _dateTimingsGte;

    @JsonProperty( "timings[lte]" )
    private LocalDate _dateTimingsLte;

    @JsonProperty( "updatedAt[gte]" )
    private LocalDate _dateUpdatedAtGte;

    @JsonProperty( "updatedAt[lte]" )
    private LocalDate _dateUpdatedAtLte;

    @JsonProperty( "search" )
    private String _strSearch;

    @JsonProperty( "slug" )
    private String _strSlug;

    @JsonProperty( "featured" )
    private String _strFeatured;

    @JsonProperty( "relative" )
    private String _strRelative;

    @JsonProperty( "state" )
    private String _strState;

    @JsonProperty( "uid" )
    private String _strUid;

    /**
     * @return the _strCity
     */
    public String getCity( )
    {
        return _strCity;
    }

    /**
     * @param strCity
     *            the _strCity to set
     */
    public void setCity( String strCity )
    {
        this._strCity = strCity;
    }

    /**
     * @return the _strDepartment
     */
    public String getDepartment( )
    {
        return _strDepartment;
    }

    /**
     * @param strDepartment
     *            the _strDepartment to set
     */
    public void setDepartment( String strDepartment )
    {
        this._strDepartment = strDepartment;
    }

    /**
     * @return the strRegion
     */
    public String getRegion( )
    {
        return _strRegion;
    }

    /**
     * @param strRegion
     *            the _strRegion to set
     */
    public void setRegion( String strRegion )
    {
        this._strRegion = strRegion;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @return the _dateTimingsGte
     */
    public LocalDate getTimingsGte( )
    {
        return _dateTimingsGte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @param dateTimingsGte
     *            the _dateTimingsGte to set
     */
    public void setTimingsGte( LocalDate dateTimingsGte )
    {
        this._dateTimingsGte = dateTimingsGte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @return the _dateTimingsLte
     */
    public LocalDate getTimingsLte( )
    {
        return _dateTimingsLte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @param dateTimingsLte
     *            the _dateTimingsLte to set
     */
    public void setTimingsLte( LocalDate dateTimingsLte )
    {
        this._dateTimingsLte = dateTimingsLte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @return the _dateUpdatedAtGte
     */
    public LocalDate getUpdatedAtGte( )
    {
        return _dateUpdatedAtGte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @param dateUpdatedAtGte
     *            the _dateUpdatedAtGte to set
     */
    public void setUpdatedAtGte( LocalDate dateUpdatedAtGte )
    {
        this._dateUpdatedAtGte = dateUpdatedAtGte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @return the _dateUpdatedAtLte
     */
    public LocalDate getUpdatedAtLte( )
    {
        return _dateUpdatedAtLte;
    }

    /**
     * Format API yyyy-MM-dd
     * 
     * @param dateUpdatedAtLte
     *            the _dateUpdatedAtLte to set
     */
    public void setUpdatedAtLte( LocalDate dateUpdatedAtLte )
    {
        this._dateUpdatedAtLte = dateUpdatedAtLte;
    }

    /**
     * @return the _strSearch
     */
    public String getSearch( )
    {
        return _strSearch;
    }

    /**
     * @param strSearch
     *            the _strSearch to set
     */
    public void setSearch( String strSearch )
    {
        this._strSearch = strSearch;
    }

    /**
     * @return the _strSlug
     */
    public String getSlug( )
    {
        return _strSlug;
    }

    /**
     * @param strSlug
     *            the _strSlug to set
     */
    public void setSlug( String strSlug )
    {
        this._strSlug = strSlug;
    }

    /**
     * @return the _strFeatured
     */
    public String getFeatured( )
    {
        return _strFeatured;
    }

    /**
     * @param strFeatured
     *            the _strFeatured to set
     */
    public void setFeatured( String strFeatured )
    {
        this._strFeatured = strFeatured;
    }

    /**
     * @return the _strRelative
     */
    public String getRelative( )
    {
        return _strRelative;
    }

    /**
     * @param strRelative
     *            the _strRelative to set
     */
    public void setRelative( String strRelative )
    {
        this._strRelative = strRelative;
    }

    /**
     * @return the _strState
     */
    public String getState( )
    {
        return _strState;
    }

    /**
     * @param strState
     *            the _strState to set
     */
    public void setState( String strState )
    {
        this._strState = strState;
    }

    /**
     * @return the _strUid
     */
    public String getUid( )
    {
        return _strUid;
    }

    /**
     * @param strUid
     *            the _strUid to set
     */
    public void setUid( String strUid )
    {
        this._strUid = strUid;
    }

}
