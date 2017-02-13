
package com.xyinc.v2.resource.v1.vo;

/**
 * @author luiz
 */
public abstract class AbstractResponse {
    
    private String collection;
    
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    
}
