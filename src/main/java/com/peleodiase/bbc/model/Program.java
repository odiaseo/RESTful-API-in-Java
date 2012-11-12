package com.peleodiase.bbc.model;

 

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Program Entity Class
 * 
 * @author odiaseo
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name = "program")
public class Program {
    
    private String id;
    private String title;
    private String description;
    private String category;
    private Boolean isAvailable;
    
    @XmlElement
    public String getId() {
        return id;
    }
    
    public void setId(String programId) {
        this.id = programId;
    }
    
    @XmlElement
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @XmlElement
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
  
    @XmlElement
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description= description;
    }
    
    @XmlElement
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
