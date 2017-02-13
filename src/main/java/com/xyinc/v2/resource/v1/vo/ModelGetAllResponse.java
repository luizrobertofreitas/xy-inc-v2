
package com.xyinc.v2.resource.v1.vo;

import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luiz
 */
@XmlRootElement
public class ModelGetAllResponse extends AbstractResponse {

    private List<Map> results;
    
    public List<Map> getResults() {
        return results;
    }

    public void setResults(List<Map> results) {
        this.results = results;
    }
}
