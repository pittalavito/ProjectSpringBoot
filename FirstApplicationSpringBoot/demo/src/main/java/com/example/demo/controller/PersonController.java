package com.example.demo.controller;
import com.example.demo.service.PersonService;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

@RequestMapping("api/v1/person") // localhost:8080/api/v1/person <- this is endpoint
@RestController                  //the transmission methods in a REST Controller Spring are GET, POST, PUT and DELETE.
public class PersonController {

    private final PersonService personService;

    @Autowired//ask Alessandro Le Mura
    public PersonController( PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson( person );
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")//@PathVariable allows you to retrieve the value present in the URL and assign it to the string parameter id
    public Person getPersonById( @PathVariable("id") UUID id){
        return personService.getPerson( id )
                .orElse( null );
    }

    @DeleteMapping( path = "{id}")
    public void deletePerson( @PathVariable("id") UUID id ){
        personService.deletePerson(id);
    }

    @PutMapping( path = "{id}")
    public int updatePerson( @PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person){
        return personService.updatePerson( id , person);
    }
}
