/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.client;

import fr.paris.lutece.portal.service.util.AppLogService;
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
    private static final String key = "597f2f0f0000755f8b03f39707f807ed";
    
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
