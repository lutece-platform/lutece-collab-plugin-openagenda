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
 * This is the business class for the AgendaData
 *
 */
public class AgendaData
{
    @JsonProperty( "uid" )
    private int _nUid;

    @JsonProperty( "slug" )
    private String _strSlug;

    @JsonProperty( "title" )
    private String _strTitle;

    @JsonProperty( "member" )
    private Member _member;

    /**
     * @return the uid
     */
    public int getUid( )
    {
        return _nUid;
    }

    /**
     * @param nUid
     *            the uid to set
     */
    public void setUid( int nUid )
    {
        this._nUid = nUid;
    }

    /**
     * @return the slug
     */
    public String getSlug( )
    {
        return _strSlug;
    }

    /**
     * @param strSlug
     *            the slug to set
     */
    public void setSlug( String strSlug )
    {
        this._strSlug = strSlug;
    }

    /**
     * @return the title
     */
    public String getTitle( )
    {
        return _strTitle;
    }

    /**
     * @param strTitle
     *            the title to set
     */
    public void setTitle( String strTitle )
    {
        this._strTitle = strTitle;
    }

    /**
     * @return the member
     */
    public Member getMember( )
    {
        return _member;
    }

    /**
     * @param member
     *            the member to set
     */
    public void setMember( Member member )
    {
        this._member = member;
    }
}
