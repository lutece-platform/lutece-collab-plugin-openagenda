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
 * This is the business class for the Keywords
 *
 */
public class Keywords
{
    @JsonProperty( "fr" )
    private List<String> _listFr;

    @JsonProperty( "en" )
    private List<String> _listEn;

    @JsonProperty( "es" )
    private List<String> _listEs;

    @JsonProperty( "de" )
    private List<String> _listDe;

    @JsonProperty( "it" )
    private List<String> _listIt;

    @JsonProperty( "ar" )
    private List<String> _listAr;

    /**
     * @return the listFr
     */
    public List<String> getListFr( )
    {
        return Collections.unmodifiableList( _listFr );
    }

    /**
     * @param listFr
     *            the listFr to set
     */
    public void setListFr( List<String> listFr )
    {
        this._listFr = Collections.unmodifiableList( listFr );
    }

    /**
     * @return the listEn
     */
    public List<String> getListEn( )
    {
        return Collections.unmodifiableList( _listEn );
    }

    /**
     * @param listEn
     *            the listEn to set
     */
    public void setListEn( List<String> listEn )
    {
        this._listEn = Collections.unmodifiableList( listEn );
    }

    /**
     * @return the listEs
     */
    public List<String> getListEs( )
    {
        return Collections.unmodifiableList( _listEs );
    }

    /**
     * @param listEs
     *            the listEs to set
     */
    public void setListEs( List<String> listEs )
    {
        this._listEs = Collections.unmodifiableList( listEs );
    }

    /**
     * @return the listDe
     */
    public List<String> getListDe( )
    {
        return Collections.unmodifiableList( _listDe );
    }

    /**
     * @param listDe
     *            the listDe to set
     */
    public void setListDe( List<String> listDe )
    {
        this._listDe = Collections.unmodifiableList( listDe );
    }

    /**
     * @return the listIt
     */
    public List<String> getListIt( )
    {
        return Collections.unmodifiableList( _listIt );
    }

    /**
     * @param listIt
     *            the listIt to set
     */
    public void setListIt( List<String> listIt )
    {
        this._listIt = Collections.unmodifiableList( listIt );
    }

    /**
     * @return the listAr
     */
    public List<String> getListAr( )
    {
        return Collections.unmodifiableList( _listAr );
    }

    /**
     * @param listAr
     *            the listAr to set
     */
    public void setListAr( List<String> listAr )
    {
        this._listAr = Collections.unmodifiableList( listAr );
    }

}
