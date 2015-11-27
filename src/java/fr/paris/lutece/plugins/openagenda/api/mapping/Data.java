/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.paris.lutece.plugins.openagenda.api.mapping;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author mha
 */
public class Data {
    
    public String uid;
    public String link;
    public String updatedAt;
    public String spacetimeinfo;
    public String image;
    public String imageThumb;
    public Title title;
    @JsonIgnore
    public String description;
    @JsonIgnore
    public String freeText;
    @JsonIgnore
    public String tags;
    @JsonIgnore
    public String locations;
    @JsonIgnore
    public String thirdParties;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getThirdParties() {
        return thirdParties;
    }

    public void setThirdParties(String thirdParties) {
        this.thirdParties = thirdParties;
    }
    
    
}
