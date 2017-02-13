
package com.xyinc.v2.service.impl;

import com.xyinc.v2.model.repository.ModelRepository;
import com.xyinc.v2.model.repository.document.ModelDocument;
import com.xyinc.v2.service.ModelService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luiz
 */
@Service
public class ModelServiceImpl implements ModelService {
    
    @Autowired
    private ModelRepository modelRepository;
    
    /**
     * Lists All documents
     * 
     * @param collectionName
     * @return list of model documents
     */
    @Override
    public List<ModelDocument> findAll(final String collectionName) {
        return modelRepository.findAll(collectionName);
    }
    
    /**
     * Lists all collections.
     * 
     * @return set of collection names
     */
    @Override
    public Set<String> listCollections() {
        return modelRepository.listCollections();
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
        return modelRepository.update(modelDocument, collectionName);
    }
    
    /**
     * Inserts a model document.
     * 
     * @param modelDocument
     * @param collectionName
     * @return Boolean whether was successfully inserted
     */
    @Override
    public Boolean insert(final ModelDocument modelDocument, final String collectionName) {
        return modelRepository.insert(modelDocument, collectionName);
    }

    /**
     * Removes a model document by id.
     * 
     * @param id
     * @param collectionName
     * @return Boolean whether was successfully removed
     */
    @Override
    public Boolean remove(final String id, final String collectionName) {
        return modelRepository.remove(id, collectionName);
    }

    /**
     * Finds a model document by id.
     * 
     * @param id
     * @param collectionName
     * @return the model document
     */
    @Override
    public ModelDocument findById(final String id, final String collectionName) {
        return modelRepository.findById(id, collectionName);
    }

    /**
     * Creates a collection.
     * 
     * @param collectionName
     * @return Boolean whether the collection was successfully created
     */
    @Override
    public Boolean createCollection(final String collectionName) {
        return modelRepository.createCollection(collectionName);
    }

    /**
     * Drops / removes a collection by name.
     * 
     * @param collectionName
     * @return Boolean whether the collection was successfully dropped / removed
     */
    @Override
    public Boolean dropCollection(final String collectionName) {
        return modelRepository.dropCollection(collectionName);
    }
}
