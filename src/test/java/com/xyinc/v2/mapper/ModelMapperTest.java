
package com.xyinc.v2.mapper;

import com.xyinc.v2.XyIncV2ApplicationTests;
import com.xyinc.v2.model.repository.document.ModelDocument;
import com.xyinc.v2.resource.v1.vo.ModelGetAllResponse;
import com.xyinc.v2.resource.v1.vo.ModelGetByIdResponse;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luiz
 */
public class ModelMapperTest extends XyIncV2ApplicationTests {
    
    @Autowired
    private ModelMapper modelMapper;
    
    /**
     * Test of createModelGetAllResponse method, of class ModelMapper.
     */
    @Test
    public void testCreateModelGetAllResponse() {
        List<ModelDocument> list = new ArrayList<>();
        list.add(createMockModelDocument());
        list.add(createMockModelDocument());
        
        ModelGetAllResponse modelResponse = modelMapper.createModelGetAllResponse(list, COLLECTION_NAME);
        
        assertTrue(modelResponse.getResults().size() == list.size());
    }

    /**
     * Test of createModelGetByIdResponse method, of class ModelMapper.
     */
    @Test
    public void testCreateModelGetByIdResponse() {
        ModelDocument modelDocument = createMockModelDocument();
        modelDocument.setId("123");
        
        ModelGetByIdResponse modelResponse = modelMapper.createModelGetByIdResponse(modelDocument, COLLECTION_NAME);
        
        assertTrue(modelDocument.getId().equals(modelResponse.getResult().get("id")));
    }
}
