package com.example.demo.controller;

import com.example.demo.model.Job;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;
    // --- CONSTRUCTOR ---
    @Autowired
    public PersonController( PersonService personService){
        this.personService = personService;
    }

    // --- METHODS GET---
    @GetMapping("")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping( path = "{name}/{surname}")
    public List<Job> getJobByPersonQuerySql(@PathVariable("name") String name , @PathVariable("surname") String surname){
        return personService.getJobByPerson( name ,surname);
    }

    // --- METHODS POST ---
    @PostMapping
    public boolean insertPerson(@Valid @NonNull @RequestBody Person person){
        return personService.insertPerson( person );
    }

    // --- METHODS DELETE ---
    @DeleteMapping( path = "{id}")
    public boolean
    deletePerson( @PathVariable("id") int id ){
        return personService.deletePerson(id);
    }

    // --- METHODS PUT ----
    @PutMapping( path = "{id}")
    public boolean updatePerson( @PathVariable("id") Integer id, @Valid @NonNull @RequestBody Person person){
        return personService.updatePerson( id , person);
    }


}
