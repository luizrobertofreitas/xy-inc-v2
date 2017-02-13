
package com.xyinc.v2.model.repository.document;

import java.io.Serializable;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author luiz
 */
@Document
public class ModelDocument implements Serializable {
    
    @Id
    private String id;
    
    private Map attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }
    
    
    
}
