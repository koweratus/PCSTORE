package com.kove.pcstore.service;

import com.kove.pcstore.data.ComponentRepository;
import com.kove.pcstore.model.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ComponentService {
    private final ComponentRepository componentRepository;

    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public Set<Component> findAll (){ return componentRepository.findAll();}

    public Optional<Component> save(Component component) {
        return componentRepository.save(component);
    }

}
