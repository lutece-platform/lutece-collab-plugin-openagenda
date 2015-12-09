/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.api.mapping;

import java.util.List;

/**
 *
 * @author mha
 */
public class Response {
    
    
    private boolean success;
    private String code;
    private List<EventData> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<EventData> getData() {
        return data;
    }

    public void setData(List<EventData> data) {
        this.data = data;
    }
    
}
