package com.kove.pcstore.rest;

import com.kove.pcstore.data.ComponentRepository;
import com.kove.pcstore.model.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(path = "/api/components", produces = "application/json")
@CrossOrigin
public class ComponentRestController {
    @Autowired
    ComponentRepository repository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping
    public Iterable<Component> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Component> find(@PathVariable Long id) {
        Optional<Component> component = repository.findById(id);

        if(component.isPresent()) {
            return new ResponseEntity<>(component.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Component) null, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public Component save(@RequestBody Component component) {

        jmsTemplate.convertAndSend("Component title: " + component.getTitle() + "component description:" + component.getDescription()  );

        return repository.save(component);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Component> update(@PathVariable Long id, @RequestBody Component componentData) {
        Optional<Component> component = repository.findById(id);

        if(component.isPresent()) {
            componentData.setId(id);
            repository.save(componentData);

            return new ResponseEntity<>(componentData, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Component) null, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
