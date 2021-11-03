package com.kove.pcstore.data;

import com.kove.pcstore.model.Component;
import com.kove.pcstore.model.Manafacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManafacturerRepository  {
    List<Manafacturer> findByFirstname(String name);

}
