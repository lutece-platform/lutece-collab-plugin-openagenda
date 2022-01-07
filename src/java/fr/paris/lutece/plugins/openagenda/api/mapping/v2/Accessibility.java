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
 * This is the business class for the Accessibility
 *
 */
public class Accessibility
{
    @JsonProperty( "ii" )
    private boolean _bIi;

    @JsonProperty( "hi" )
    private boolean _bHi;

    @JsonProperty( "vi" )
    private boolean _bVi;

    @JsonProperty( "pi" )
    private boolean _bPi;

    @JsonProperty( "mi" )
    private boolean _bMi;

    /**
     * Handicap intellectuel
     * 
     * @return
     */
    public boolean isIi( )
    {
        return _bIi;
    }

    /**
     * 
     * @param bIi
     */
    public void setIi( boolean bIi )
    {
        this._bIi = bIi;
    }

    /**
     * Handicap auditif
     * 
     * @return
     */
    public boolean isHi( )
    {
        return _bHi;
    }

    public void setHi( boolean bHi )
    {
        this._bHi = bHi;
    }

    /**
     * Handicap visuel
     * 
     * @return
     */
    public boolean isVi( )
    {
        return _bVi;
    }

    public void setVi( boolean bVi )
    {
        this._bVi = bVi;
    }

    /**
     * Handicap psychique
     * 
     * @return
     */
    public boolean isPi( )
    {
        return _bPi;
    }

    public void setPi( boolean bPi )
    {
        this._bPi = bPi;
    }

    /**
     * Handicap moteur
     * 
     * @return
     */
    public boolean isMi( )
    {
        return _bMi;
    }

    public void setMi( boolean bMi )
    {
        this._bMi = bMi;
    }

}
