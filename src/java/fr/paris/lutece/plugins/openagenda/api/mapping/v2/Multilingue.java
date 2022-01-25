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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * This is the business class for the Multilingue
 *
 */
public class Multilingue
{
    @JsonProperty( "fr" )
    private String _strFr;

    @JsonProperty( "en" )
    private String _strEn;

    @JsonProperty( "es" )
    private String _strEs;

    @JsonProperty( "de" )
    private String _strDe;

    @JsonProperty( "it" )
    private String _strIt;

    @JsonProperty( "ar" )
    private String _strAr;

    /**
     * @return the _strFr
     */
    public String getFr( )
    {
        return _strFr;
    }

    /**
     * @param strFr
     *            the _strFr to set
     */
    public void setFr( String strFr )
    {
        this._strFr = strFr;
    }

    /**
     * @return the _strEn
     */
    public String getEn( )
    {
        return _strEn;
    }

    /**
     * @param strEn
     *            the _strEn to set
     */
    public void setEn( String strEn )
    {
        this._strEn = strEn;
    }

    /**
     * @return the _strEs
     */
    public String getEs( )
    {
        return _strEs;
    }

    /**
     * @param strEs
     *            the _strEs to set
     */
    public void setEs( String strEs )
    {
        this._strEs = strEs;
    }

    /**
     * @return the _strDe
     */
    public String getDe( )
    {
        return _strDe;
    }

    /**
     * @param strDe
     *            the _strDe to set
     */
    public void setDe( String strDe )
    {
        this._strDe = strDe;
    }

    /**
     * @return the _strIt
     */
    public String getIt( )
    {
        return _strIt;
    }

    /**
     * @param strIt
     *            the _strIt to set
     */
    public void setIt( String strIt )
    {
        this._strIt = strIt;
    }

    /**
     * @return the _strAr
     */
    public String getAr( )
    {
        return _strAr;
    }

    /**
     * @param strAr
     *            the _strAr to set
     */
    public void setAr( String strAr )
    {
        this._strAr = strAr;
    }

}
