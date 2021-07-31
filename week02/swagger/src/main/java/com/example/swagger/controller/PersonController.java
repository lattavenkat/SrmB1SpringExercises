package com.example.swagger.controller;

/**
 * Spring Exception
 * Logger
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.swagger.exception.ResourceNotFoundException;
import com.example.swagger.model.Person;
import com.example.swagger.repository.PersonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    private Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> getAllpersons() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getpersonById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + personId));
        log.info("Data's fetched: " + person.toString());
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/person")
    public Person createperson(@Valid @RequestBody Person person) throws ResourceNotFoundException {
        log.info("Inserted!...");
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updateperson(@PathVariable(value = "id") Long personId,
            @Valid @RequestBody Person workDetails) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new ResourceNotFoundException("Employee cannot be found for this id :: " + personId));

        person.setEmail(workDetails.getEmail());
        person.setLname(workDetails.getLname());
        person.setFname(workDetails.getFname());
        final Person updatedperson = personRepository.save(person);
        log.info("Updated!...");
        return ResponseEntity.ok(updatedperson);
    }

    @DeleteMapping("/person/{id}")
    public Map<String, Boolean> deleteperson(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + personId));

        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        log.info("Deleted!....");
        return response;
    }
}