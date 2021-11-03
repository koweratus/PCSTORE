package com.kove.pcstore.web;

import com.kove.pcstore.data.ComponentRepository;
import com.kove.pcstore.data.ManafacturerRepository;
import com.kove.pcstore.model.Component;
import com.kove.pcstore.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/components")
@SessionAttributes({"types"})
public class ComponentController {
    private final ComponentService componentService;

    //private final ManafacturerRepository manafacturerRepository;

    @Autowired
    public ComponentController(ComponentService componentRepository) {
        this.componentService = componentRepository;
    }

    @GetMapping("/all")
    public String allComponents(Model model) {
        Iterable<Component> components = null;
        components =  componentService.findAll();
        model.addAttribute("components", components);

        return "allComponents";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("component", new Component());
       // model.addAttribute("manafacturer", manafacturerRepository.findAll());
        model.addAttribute("types", Component.Type.values());

        return "componentProposal";
    }


    @PostMapping("/new")
    public String processForm(@Valid @ModelAttribute Component component, Errors errors) {
        if (errors.hasErrors()) {
            return "componentProposal";
        }

        componentService.save(component);

        return "componentAccepted";
    }

    @GetMapping("/{id}}")
    public String getBook(Model model, @PathVariable long id) {

        //Set<Component> component = componentRepository.findAll();

        //model.addAttribute("component", component);

        return "componentView";
    }
}
