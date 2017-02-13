
package com.xyinc.v2.resource.v1;

import com.xyinc.v2.resource.v1.vo.ModelDeleteResponse;
import com.xyinc.v2.mapper.ModelMapper;
import com.xyinc.v2.resource.v1.vo.ModelGetAllResponse;
import com.xyinc.v2.resource.v1.vo.ModelGetByIdResponse;
import com.xyinc.v2.resource.v1.vo.ModelPostResponse;
import com.xyinc.v2.resource.v1.vo.ModelPutResponse;
import com.xyinc.v2.service.ModelService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Model REST Resource.
 * 
 * @author luiz
 */
@RestController
@RequestMapping("/v1/{collectionName}")
public class ModelResource {
    
    @Autowired
    private ModelService modelService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    /**
     * GET all results.
     * @param collectionName
     * @return ModelGetAllResponse
     */
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ModelGetAllResponse getAll(@PathVariable("collectionName") final String collectionName) {

        return modelMapper.createModelGetAllResponse(modelService.findAll(collectionName), collectionName);
    }
    
    /**
     * GET by ID.
     * @param collectionName
     * @param id
     * @return ModelGetByIdResponse
     */
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ModelGetByIdResponse getById(@PathVariable("collectionName") final String collectionName, 
            @PathVariable("id") final String id) {
        
        return modelMapper.createModelGetByIdResponse(modelService.findById(id, collectionName), collectionName);
    }
    
    /**
     * POST document.
     * @param collectionName
     * @param attributes
     * @return ModelPostResponse
     */
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ModelPostResponse post(@PathVariable("collectionName") final String collectionName, 
            @RequestBody() final Map attributes) {
        
        return modelMapper.createModelPostResponse(modelService
                .insert(modelMapper.createModelDocumentFromMap(attributes), collectionName), collectionName);
    }
    
    /**
     * PUT document.
     * @param collectionName
     * @param attributes
     * @return ModelPutResponse
     */
    @PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ModelPutResponse put(@PathVariable("collectionName") final String collectionName,
            @RequestBody() final Map attributes) {
        
        return modelMapper.createModelPutResponse(modelService
                .update(modelMapper.createModelDocumentFromMap(attributes), collectionName), collectionName);
    }
    
    /**
     * DELETE document.
     * @param collectionName
     * @param id
     * @return ModelDeleteResponse
     */
    @DeleteMapping(value = "/{id}", 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ModelDeleteResponse delete(@PathVariable("collectionName") final String collectionName, 
            @PathVariable("id") final String id) {
        
            return modelMapper.createModelDeleteResponse(modelService.remove(id, collectionName), collectionName);
    }
    
}
