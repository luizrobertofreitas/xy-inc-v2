
package com.xyinc.v2.resource.v1.vo;

import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luiz
 */
@XmlRootElement
public class ModelGetByIdResponse extends AbstractResponse {

    private Map result;
    
    public Map getResult() {
        return result;
    }

    public void setResult(Map result) {
        this.result = result;
    }
}
