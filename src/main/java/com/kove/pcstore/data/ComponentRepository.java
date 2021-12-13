package com.kove.pcstore.data;

import com.kove.pcstore.model.Component;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ComponentRepository extends CrudRepository<Component, Long>  {
   List<Component> findByTitle(String title);

}
