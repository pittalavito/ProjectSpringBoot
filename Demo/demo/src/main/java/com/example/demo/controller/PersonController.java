package com.example.demo.controller;

import com.example.demo.model.Job;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.example.demo.serviceutility.MyServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;
    // --- CONSTRUCTOR -------------------------------------------------------------------------------
    @Autowired
    public PersonController( PersonService personService){
        this.personService = personService;
    }

    // --- METHODS GET ---------------------------------------------------------------------------------
    @GetMapping("")
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping( path = "{name}/{surname}")
    public List<Job> getJobByPerson(@PathVariable("name") String name , @PathVariable("surname") String surname){
        return personService.getJobByPerson( name ,surname);
    }

    @GetMapping("{letter}")
    public ResponseEntity<String> getNameByChar (@PathVariable("letter") String letter){
        MyServiceResponse<String> serviceResponse = personService.getNameByChar( letter );
        return ResponseEntity.status( serviceResponse.codHttp ).body( serviceResponse.body );
    }

    // --- METHODS POST ------------------------------------------------------------------------------
    @PostMapping
    public boolean insertPerson(@Valid @NonNull @RequestBody Person person){
        return personService.insertPerson( person );
    }

    // --- METHODS DELETE -------------------------------------------------------------------------------
    @DeleteMapping( path = "{id}")
    public boolean deletePerson( @PathVariable("id") Long id ){
        return personService.deletePerson(id);
    }

    // --- METHODS PUT -------------------------------------------------------------------------------------
    @PutMapping
    public boolean updatePerson( @Valid @NonNull @RequestBody Person person){
        return personService.updatePerson( person );
    }
}
