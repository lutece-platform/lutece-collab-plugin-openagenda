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
package fr.paris.lutece.plugins.openagenda.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;

/**
 * 
 * OpenagendaUtils
 *
 */
public class OpenagendaUtils
{
	
    // Properties
    private static final String PROPERTY_ENCODING_URL = "lutece.encoding.url";

    private OpenagendaUtils( )
    {
        throw new IllegalStateException( "Utility class" );
    }

    /**
     * This method convert object to string Request
     * 
     * @param object
     * @param clazz
     * @return
     */
    public static String getRequestString( Object object, Class clazz )
    {
        StringBuilder sb = new StringBuilder( );

	    if( object == null )
	    {
	    	return StringUtils.EMPTY;
	    }
	    
        try
        {
            for ( Field f : clazz.getDeclaredFields( ) )
            {
                f.setAccessible( true );

                if ( f.get( object ) != null )
                {
                    if ( f.getDeclaredAnnotation( JsonProperty.class ) != null )
                    {
                        sb.append( "&" + encodeUrl( f.getDeclaredAnnotation( JsonProperty.class ).value( ) ) + "="
                                + encodeUrl( String.valueOf( f.get( object ) ) ) );
                    }
                    else
                    {
                        sb.append( "&" + encodeUrl( f.getName( ) ) + "=" + encodeUrl( String.valueOf( f.get( object ) ) ) );
                    }
                }
            }
        }
        catch( IllegalAccessException | IllegalArgumentException | SecurityException e )
        {
            AppLogService.error( "Erreur lors de la formation de la request", e );
        }

        return sb.toString( );
    }

    /**
     * Encode url
     * 
     * @param strUrl
     * @return url encoded
     */
    public static String encodeUrl( String strUrl )
    {
        try
        {

            return URLEncoder.encode( strUrl, AppPropertiesService.getProperty( PROPERTY_ENCODING_URL ) );
        }
        catch( UnsupportedEncodingException e )
        {
            AppLogService.error( "Error encoding de l'url {}", strUrl, e );
        }
        return strUrl;
    }

    /**
     * Generic method for mapping json to object
     * 
     * @param jsonData
     * @param type
     * @return object
     */
    public static <T> T jsonStringToObject( String jsonData, Class<T> type )
    {
        ObjectMapper mapper = new ObjectMapper( );
        mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
        try
        {
            return mapper.readValue( jsonData, type );
        }
        catch( IOException ex )
        {
            AppLogService.error( "Erreur de mapping", ex );
        }

        return null;
    }

}
