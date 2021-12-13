package com.kove.pcstore.data;

import com.kove.pcstore.model.Component;
import com.kove.pcstore.model.Manafacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManafacturerRepository  extends CrudRepository<Manafacturer, Long>{
    List<Manafacturer> findByCompany(String company);

}
