
package com.xyinc.v2.service.impl;

import com.xyinc.v2.XyIncV2ApplicationTests;
import com.xyinc.v2.model.repository.document.ModelDocument;
import com.xyinc.v2.service.ModelService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luiz
 */
public class ModelServiceImplTest extends XyIncV2ApplicationTests {
    
    @Autowired
    private ModelService modelService;
    
    /**
     * Test of findAll method, of class ModelServiceImpl.
     */
    @Test
    public void testFindAll() {
        
        ModelDocument modelDocument = createMockModelDocument();
        
        modelService.insert(modelDocument, COLLECTION_NAME);
        
        int expResult = 1;
        
        int result = modelService.findAll(COLLECTION_NAME).size();
        
        // Cleaning results
        modelService.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ModelServiceImpl.
     */
    @Test
    public void testUpdate() {
        ModelDocument modelDocument = createMockModelDocument();
        
        modelService.insert(modelDocument, COLLECTION_NAME);
        
        modelDocument.getAttributes().put("name", "test");
        
        Boolean result = modelService.update(modelDocument, COLLECTION_NAME);
        
        // Cleaning results
        modelService.dropCollection(COLLECTION_NAME);
        
        assertEquals(Boolean.TRUE, result);
    }

    /**
     * Test of insert method, of class ModelServiceImpl.
     */
    @Test
    public void testInsert() {
        ModelDocument modelDocument = createMockModelDocument();
        
        Boolean result = modelService.insert(modelDocument, COLLECTION_NAME);
        
        // Cleaning results
        modelService.dropCollection(COLLECTION_NAME);
        
        assertEquals(Boolean.TRUE, result);
    }

    /**
     * Test of remove method, of class ModelServiceImpl.
     */
    @Test
    public void testRemove() {
        ModelDocument modelDocument = createMockModelDocument();
        
        modelService.insert(modelDocument, COLLECTION_NAME);
        
        Boolean result = modelService.remove(modelDocument.getId(), COLLECTION_NAME);
        
        // Cleaning results
        modelService.dropCollection(COLLECTION_NAME);
        
        assertEquals(Boolean.TRUE, result);
    }

    /**
     * Test of findById method, of class ModelServiceImpl.
     */
    @Test
    public void testFindById() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelService.insert(modelDocument, COLLECTION_NAME);
        
        String modelDocumentId = modelDocument.getId();
        
        ModelDocument result = modelService.findById(modelDocumentId, COLLECTION_NAME);
        
        // Cleaning tests
        modelService.dropCollection(COLLECTION_NAME);
        
        assertEquals(modelDocumentId, result.getId());
    }
}
