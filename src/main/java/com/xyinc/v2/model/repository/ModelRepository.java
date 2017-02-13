
package com.xyinc.v2.model.repository;

import com.xyinc.v2.model.repository.document.ModelDocument;
import java.util.List;
import java.util.Set;

/**
 * @author luiz
 */
public interface ModelRepository {
    
    /**
     * Inserts a model document.
     * @param modelDocument
     * @param collectionName
     * @return Boolean whether was successfully inserted
     */
    public Boolean insert(final ModelDocument modelDocument, final String collectionName);
    
    /**
     * Updates a model document.
     * 
     * @param modelDocument
     * @param collectionName
     * @return Boolean whether was successfully updated
     */
    public Boolean update(final ModelDocument modelDocument, final String collectionName);
    
    /**
     * Removes a model document.
     * 
     * @param id
     * @param collectionName
     * @return Boolean whether was successfully removed
     */
    public Boolean remove(final String id, final String collectionName);
    
    /**
     * Finds a model document by id.
     * @param id
     * @param collectionName
     * @return the model document
     */
    public ModelDocument findById(final String id, final String collectionName);
    
    /**
     * Finds all model documents.
     * @param collectionName
     * @return List of model documents
     */
    public List<ModelDocument> findAll(final String collectionName);
    
    /**
     * Lists all collections.
     * @return set of collection names
     */
    public Set<String> listCollections();
    
    /**
     * Creates a collection.
     * @param collectionName
     * @return Boolean whether the collection was successfully created
     */
    public Boolean createCollection(final String collectionName);
    
    /**
     * Drops a collection by name.
     * @param collectionName
     * @return Boolean whether the collection was successfully dropped
     */
    public Boolean dropCollection(final String collectionName);
}
