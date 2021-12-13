package com.kove.pcstore.web;

import com.kove.pcstore.data.ComponentRepository;
import com.kove.pcstore.data.ManafacturerRepository;
import com.kove.pcstore.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/components")
@SessionAttributes({"types"})
public class ComponentController {

    private final ManafacturerRepository manafacturerRepository;
    private final ComponentRepository componentRepository;

    @Autowired
    public ComponentController(ComponentRepository componentRepository, ManafacturerRepository manafacturerRepository) {
        this.manafacturerRepository = manafacturerRepository;
        this.componentRepository = componentRepository;
    }

    @GetMapping("/all")
    public String allComponents(Model model) {
        Iterable<Component> components = null;
        components =  componentRepository.findAll();
        model.addAttribute("components", components);

        return "allComponents";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("component", new Component());
        model.addAttribute("manafacturers", manafacturerRepository.findAll());
        model.addAttribute("types", Component.Type.values());

        return "componentProposal";
    }


    @PostMapping("/new")
    public String processForm(@Valid @ModelAttribute Component component, Errors errors) {
        if (errors.hasErrors()) {
            return "componentProposal";
        }

        componentRepository.save(component);

        return "componentAccepted";
    }

    @GetMapping("/{id}}")
    public String getComponent(Model model, @PathVariable long id) {

        Optional<Component> component = componentRepository.findById(id);

        model.addAttribute("component", component);

        return "componentView";
    }
}
