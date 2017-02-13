
package com.xyinc.v2.model.repository.impl;

import com.xyinc.v2.XyIncV2ApplicationTests;
import com.xyinc.v2.model.repository.ModelRepository;
import com.xyinc.v2.model.repository.document.ModelDocument;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author luiz
 */
public class ModelRepositoryImplTest extends XyIncV2ApplicationTests {

    @Autowired
    private ModelRepository modelRepository;
    
    /**
     * Test of insert method, of class ModelRepositoryImpl.
     */
    @Test
    public void testInsert() {
        ModelDocument modelDocument = createMockModelDocument();
        Boolean expResult = Boolean.TRUE;
        Boolean result = modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class ModelRepositoryImpl.
     */
    @Test
    public void testUpdate() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        modelDocument.getAttributes().put("name", "Informática");
        
        Boolean expResult = Boolean.TRUE;
        Boolean result = modelRepository.update(modelDocument, COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test error of update method, of class ModelRepositoryImpl.
     */
    @Test
    public void testUpdateError() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        modelDocument.getAttributes().put("name", "Informática");
        modelDocument.setId("error");
        
        Boolean expResult = Boolean.FALSE;
        Boolean result = modelRepository.update(modelDocument, COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class ModelRepositoryImpl.
     */
    @Test
    public void testRemove() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        Boolean expResult = Boolean.TRUE;
        Boolean result = modelRepository.remove(modelDocument.getId(), COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test error of remove method, of class ModelRepositoryImpl.
     */
    @Test
    public void testRemoveError() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        modelDocument.setId("error");
        
        Boolean expResult = Boolean.FALSE;
        Boolean result = modelRepository.remove(modelDocument.getId(), COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of findById method, of class ModelRepositoryImpl.
     */
    @Test
    public void testFindById() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        String modelDocumentId = modelDocument.getId();
        
        ModelDocument result = modelRepository.findById(modelDocumentId, COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(modelDocumentId, result.getId());
    }
    
    /**
     * Test error of findById method, of class ModelRepositoryImpl.
     */
    @Test
    public void testFindByIdError() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        String modelDocumentId = "error";
        
        ModelDocument result = modelRepository.findById(modelDocumentId, COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertNull(result);
    }

    /**
     * Test of findAll method, of class ModelRepositoryImpl.
     */
    @Test
    public void testFindAll() {
        // Inserting first
        ModelDocument modelDocument = createMockModelDocument();
        modelRepository.insert(modelDocument, COLLECTION_NAME);
        
        int modelListSizeExpResult = 1;
        
        List<ModelDocument> result = modelRepository.findAll(COLLECTION_NAME);
        
        // Cleaning tests
        modelRepository.dropCollection(COLLECTION_NAME);
        
        assertEquals(modelListSizeExpResult, result.size());
    }
}
