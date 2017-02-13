
package com.xyinc.v2.controllers;

import com.xyinc.v2.controllers.vo.ModelForm;
import com.xyinc.v2.service.ModelService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Model Controller for UI.
 * @author luiz
 */
@Controller
@RequestMapping("/models")
public class ModelController {
    
    @Autowired
    private ModelService modelService;
    
    /**
     * Index action.
     * @param model
     * @return the page reference
     */
    @GetMapping()
    public String index(final Model model) {
        model.addAttribute("models", modelService.listCollections());
        return "models/index";
    }

    /**
     * Model detail.
     * @param modelName
     * @param model
     * @return the page reference
     */
    @GetMapping("/{model}/detail")
    public String findOne(@PathVariable("model") final String modelName, final Model model) {
        model.addAttribute("model", modelName);
        model.addAttribute("modelResult", modelService.findAll(modelName));
        return "models/detail";
    }
    
    /**
     * New Model.
     * @param model
     * @return the page reference
     */
    @GetMapping("/new")
    public String newModel(final Model model) {
        model.addAttribute("modelForm", new ModelForm());
        return "models/new";
    }
    
    /**
     * Create a model.
     * @param modelForm
     * @param model
     * @param bindingResult
     * @return the redirection to index
     */
    @PostMapping
    public String create(@Valid @ModelAttribute("modelForm") final ModelForm modelForm, 
            final Model model, final BindingResult bindingResult) {
        
        if (!bindingResult.hasErrors()) {
            modelService.createCollection(modelForm.getName());
        }
        
        return "redirect:/models";
    }
    
    /**
     * Delete a model.
     * @param modelName
     * @return the redirection to index
     */
    @GetMapping("/{model}/remove")
    public String delete(@PathVariable("model") String modelName) {
        modelService.dropCollection(modelName);
        
        return "redirect:/models";
    }
}
