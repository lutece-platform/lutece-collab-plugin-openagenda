/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.client;

import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mha
 */
public class FetchDataService {
    
    private static final String urlBase = "https://api.openagenda.com/v1";
    private static final String urlPathAgenda = "/agendas";
    private static final String urlPathEvent = "/events";
    private static final String propertyKey = "openagenda.apiKey";
    private static final String key = AppPropertiesService.getProperty( propertyKey,
            "5c71c0bd2b998b34c16b2521c373674d");
    
    private static final String paramKey = "key";
    
    
    public String getAgendaData(int uid) {
        
        String data = "";
        
        HttpAccess ha = new HttpAccess();
        StringBuilder sb = new StringBuilder();
        sb.append(urlBase);
        sb.append(urlPathAgenda);
        sb.append("/");
        sb.append(uid);
        
        Map<String, String> params = new HashMap<>();
        params.put(paramKey, key);
        
        
        try {
            data = ha.doPost(sb.toString(), params);
        } catch (HttpAccessException ex) {
            AppLogService.error( ex.getMessage(  ), ex );
        }      
        
        return data;
    }
    
    
    public String getEventsOfAgenda(String uid) {
        
        String data = "";
        
        HttpAccess ha = new HttpAccess();
        StringBuilder sb = new StringBuilder();
        sb.append(urlBase);
        sb.append(urlPathAgenda);
        sb.append("/");
        sb.append(uid);
        sb.append(urlPathEvent);
        sb.append("?key=");
        sb.append(key);
        sb.append("&lang=fr");
        
        try {
            data = ha.doGet(sb.toString());
        } catch (HttpAccessException ex) {
            AppLogService.error( ex.getMessage(  ), ex );
        } 
        
        
        return data;
    }
}
