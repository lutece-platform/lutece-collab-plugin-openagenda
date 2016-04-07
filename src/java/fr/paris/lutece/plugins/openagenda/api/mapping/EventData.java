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
public class EventData {
    
    private String uid;
    private String link;
    private String updatedAt;
    private String spacetimeinfo;
    private String image;
    private String imageThumb;
    private Title title;
    private Description description;
    private Freetext freeText;
    private Tags tags;
    private List<locations> locations;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSpacetimeinfo() {
        return spacetimeinfo;
    }

    public void setSpacetimeinfo(String spacetimeinfo) {
        this.spacetimeinfo = spacetimeinfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Freetext getFreeText() {
        return freeText;
    }

    public void setFreeText(Freetext freeText) {
        this.freeText = freeText;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
    
    public List<locations> getLocations() {
        return locations;
    }

    public void setLocations(List<locations> locations) {
        this.locations = locations;
    }
    
    
}
