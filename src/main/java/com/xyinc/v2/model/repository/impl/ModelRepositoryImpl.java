
package com.xyinc.v2.model.repository.impl;

import com.xyinc.v2.model.repository.ModelRepository;
import com.xyinc.v2.model.repository.document.ModelDocument;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author luiz
 */
@Repository
public class ModelRepositoryImpl implements ModelRepository {
    
    @Autowired
    private MongoTemplate template;

    /**
     * Inserts a model document.
     * @param modelDocument
     * @param collectionName
     * @return Boolean whether was successfully inserted
     */
    @Override
    public Boolean insert(final ModelDocument modelDocument, final String collectionName) {
        template.insert(modelDocument, collectionName);
        return !modelDocument.getId().isEmpty();
    }
    
    /**
     * Updates a model document.
     * 
     * @param modelDocument
     * @param collectionName
     * @return Boolean whether was successfully updated
     */
    @Override
    public Boolean update(final ModelDocument modelDocument, final String collectionName) {
        
        ModelDocument checkModelDocument = findById(modelDocument.getId(), collectionName);
        
        Boolean result = Boolean.FALSE;
        
        if (checkModelDocument != null) {
            template.save(modelDocument, collectionName);
            result = Boolean.TRUE;
        }
        
        return result;
    }

    /**
     * Removes a model document.
     * 
     * @param id
     * @param collectionName
     * @return Boolean whether was successfully removed
     */
    @Override
    public Boolean remove(final String id, final String collectionName) {
        ModelDocument modelDocumentToRemove = findById(id, collectionName);
        
        int nRemoved = 0;
        
        if (modelDocumentToRemove != null) {
            nRemoved = template.remove(modelDocumentToRemove, collectionName).getN();
        }
        
        return nRemoved > 0;
    }

    /**
     * Finds a model document by id.
     * @param id
     * @param collectionName
     * @return the model document
     */
    @Override
    public ModelDocument findById(final String id, final String collectionName) {
        return template.findById(id, ModelDocument.class, collectionName);
    }

    /**
     * Finds all model documents.
     * @param collectionName
     * @return List of model documents
     */
    @Override
    public List<ModelDocument> findAll(final String collectionName) {
        return template.findAll(ModelDocument.class, collectionName);
    }

    /**
     * Lists all collections.
     * @return set of collection names
     */
    @Override
    public Set<String> listCollections() {
        return template.getCollectionNames();
    }
    
    /**
     * Creates a collection.
     * @param collectionName
     * @return Boolean whether the collection was successfully created
     */
    @Override
    public Boolean createCollection(final String collectionName) {
        
        Boolean result = Boolean.FALSE;
        
        if (!template.collectionExists(collectionName)) {
            template.createCollection(collectionName);
            
            result = template.collectionExists(collectionName);
        }
        
        return result;
    }

    /**
     * Drops a collection by name.
     * @param collectionName
     * @return Boolean whether the collection was successfully dropped
     */
    @Override
    public Boolean dropCollection(final String collectionName) {
        
        Boolean result = Boolean.FALSE;
        
        if (template.collectionExists(collectionName)) {
            template.dropCollection(collectionName);
            
            result = !template.collectionExists(collectionName);
        }
        
        return result;
    }
}
