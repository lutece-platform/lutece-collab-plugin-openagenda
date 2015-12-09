/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.service;

import fr.paris.lutece.plugins.openagenda.api.mapping.EventData;
import fr.paris.lutece.plugins.openagenda.api.mapping.Response;
import fr.paris.lutece.plugins.openagenda.client.FetchDataService;
import fr.paris.lutece.portal.service.util.AppLogService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author mha
 */
public class OpenagendaService {
    
    
    private ObjectMapper mapper = new ObjectMapper();
    private FetchDataService fds = new FetchDataService();
    
    public List<EventData> getEventsAgenda(String idAgenda) {
        
        List<EventData> events = new ArrayList<>();
        
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        String jsonResponse = fds.getEventsOfAgenda(idAgenda);
        
        Response response = null;
        
        try {
            response = mapper.readValue(jsonResponse, Response.class);
        } catch (IOException ex) {
            AppLogService.error( ex.getMessage(  ), ex );
        }
        
        if (response != null && response.isSuccess()) {
            events = response.getData();
        }
        
        return events;
    }
}
