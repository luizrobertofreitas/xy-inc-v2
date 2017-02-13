
package com.xyinc.v2.mapper;

import com.xyinc.v2.model.repository.document.ModelDocument;
import com.xyinc.v2.resource.v1.vo.ModelDeleteResponse;
import com.xyinc.v2.resource.v1.vo.ModelGetAllResponse;
import com.xyinc.v2.resource.v1.vo.ModelGetByIdResponse;
import com.xyinc.v2.resource.v1.vo.ModelPostResponse;
import com.xyinc.v2.resource.v1.vo.ModelPutResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Mapper class for ModelDocument and REST Endpoint responses.
 * 
 * @author luiz
 */
@Component
public class ModelMapper {
    
    /**
     * Create Model Get All Response.
     * 
     * @param modelDocuments
     * @param collectionName
     * @return ModelGetAllResponse
     */
    public ModelGetAllResponse createModelGetAllResponse(final List<ModelDocument> modelDocuments, final String collectionName) {

        ModelGetAllResponse modelGetAllResponse = new ModelGetAllResponse();
        modelGetAllResponse.setCollection(collectionName);
        
        List<Map> registries = new ArrayList<>();
        
        for (ModelDocument modelDocument : modelDocuments) {
            registries.add(createMapFromModelDocument(modelDocument));
        }
        
        modelGetAllResponse.setResults(registries);
        
        if (registries.isEmpty()) {
            modelGetAllResponse.setResultMessage("Nenhum registro encontrado");
        }
        else if (registries.size() == 1) {
            modelGetAllResponse.setResultMessage("1 Registro encontrado");
        }
        else  {
            modelGetAllResponse.setResultMessage(registries.size() + " Registros encontrados");
        }
        
        return modelGetAllResponse;
    }
    
    /**
     * Create Model Get By Id Response.
     * 
     * @param modelDocument
     * @param collecitonName
     * @return ModelGetByIdResponse
     */
    public ModelGetByIdResponse createModelGetByIdResponse(final ModelDocument modelDocument, final String collecitonName) {
        ModelGetByIdResponse modelGetByIdResponse = new ModelGetByIdResponse();
        
        modelGetByIdResponse.setCollection(collecitonName);
        
        modelGetByIdResponse.setResult(createMapFromModelDocument(modelDocument));
        
        if (modelGetByIdResponse.getResult().isEmpty()) {
            modelGetByIdResponse.setResultMessage("Registro não encontrado");
        }
        else {
            modelGetByIdResponse.setResultMessage("Registro encontrado");
        }
        
        return modelGetByIdResponse;
    }
    
    /**
     * Create Model Post Response.
     * 
     * @param result
     * @param collectionName
     * @return ModelPostResponse
     */
    public ModelPostResponse createModelPostResponse(final Boolean result, final String collectionName) {
        ModelPostResponse modelPostResponse = new ModelPostResponse();
        
        modelPostResponse.setCollection(collectionName);
        
        if (result) {
            modelPostResponse.setResultMessage("Inclusão realizada com sucesso");
        }
        else {
            modelPostResponse.setResultMessage("Inclusão não realizada");
        }
        
        return modelPostResponse;
    }
    
    /**
     * Create Model Put Response.
     * 
     * @param result
     * @param collectionName
     * @return ModelPutResponse
     */
    public ModelPutResponse createModelPutResponse(final Boolean result, final String collectionName) {
        ModelPutResponse modelPutResponse = new ModelPutResponse();
        modelPutResponse.setCollection(collectionName);
        
        if (result) {
            modelPutResponse.setResultMessage("Alteração realizada com sucesso");
        }
        else {
            modelPutResponse.setResultMessage("Alteração não realizada");
        }
        
        return modelPutResponse;
    }
    
    /**
     * Create Model Delete Response.
     * 
     * @param result
     * @param collectionName
     * @return ModelDeleteResponse
     */
    public ModelDeleteResponse createModelDeleteResponse(final Boolean result, final String collectionName) {
        
        ModelDeleteResponse modelDeleteResponse = new ModelDeleteResponse();
        modelDeleteResponse.setCollection(collectionName);
        
        if (result) {
            modelDeleteResponse.setResultMessage("Exclusão realizada com sucesso");
        }
        else {
            modelDeleteResponse.setResultMessage("Exclusão não realizada");
        }
        
        return modelDeleteResponse;
    }
    
    /**
     * Create ModelDocument from Map.
     * 
     * @param attributes
     * @return ModelDocument
     */
    public ModelDocument createModelDocumentFromMap(final Map attributes) {
        Assert.notEmpty(attributes);
        
        ModelDocument modelDocument = new ModelDocument();
        
        modelDocument.setId((String) attributes.get("id"));
        
        // Id doesnt need to be inside attribs collection for ModelDocument Class
        attributes.remove("id");
        modelDocument.setAttributes(attributes);
        
        return modelDocument;
    }
    
    /**
     * Create Map object from ModelDocument.
     * 
     * @param modelDocument
     * @return Map
     */
    public Map createMapFromModelDocument(final ModelDocument modelDocument) {
        
        Map attributes = new HashMap();
        
        if (modelDocument != null) {
            attributes.putAll(modelDocument.getAttributes());
            attributes.put("id", modelDocument.getId());
        }
        
        return attributes;
    }
}
