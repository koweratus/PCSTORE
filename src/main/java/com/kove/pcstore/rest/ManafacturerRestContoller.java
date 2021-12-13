package com.kove.pcstore.rest;

import com.kove.pcstore.data.ManafacturerRepository;
import com.kove.pcstore.model.Manafacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(path = "/api/manafacturers", produces = "application/json")
@CrossOrigin
public class ManafacturerRestContoller {
    @Autowired
    ManafacturerRepository repository;

    @GetMapping
    public Iterable<Manafacturer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manafacturer> find(@PathVariable Long id) {
        Optional<Manafacturer> author = repository.findById(id);

        if(author.isPresent()) {
            return new ResponseEntity<>(author.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Manafacturer) null, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public Manafacturer save(@RequestBody Manafacturer manafacturer) {
        return repository.save(manafacturer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manafacturer> update(@PathVariable Long id, @RequestBody Manafacturer manafacturerData) {
        Optional<Manafacturer> manafacturer = repository.findById(id);

        if(manafacturer.isPresent()) {
            manafacturerData.setId(id);
            repository.save(manafacturerData);

            return new ResponseEntity<>(manafacturerData, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>((Manafacturer) null, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
