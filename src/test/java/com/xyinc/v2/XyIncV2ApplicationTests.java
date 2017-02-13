package com.xyinc.v2;

import com.xyinc.v2.model.repository.document.ModelDocument;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring app config class.
 * 
 * @author luiz
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class XyIncV2ApplicationTests {

    public static final String COLLECTION_NAME = "catz";
    
    @Test
    public void contextLoads() {
    }

    protected ModelDocument createMockModelDocument() {
        
        ModelDocument modelDocument = new ModelDocument();
        
        Map attributes = new HashMap();

        attributes.put("name", "Yaowww");
        attributes.put("address", "St Test");
        
        modelDocument.setAttributes(attributes);

        return modelDocument;
    }
}
