package com.example.demo.service;
import com.example.demo.model.Job;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public boolean insertPerson(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        if (p.isEmpty()) return personRepository.save(person) != null;
        return false;
    }

    public boolean deletePerson(Long id) {
        Optional<Person> p = personRepository.findById(id);
        if (p.isPresent()) {
            personRepository.delete(p.get());
            return true;
        }
        return false;
    }

    public boolean updatePerson(Person person) {
        Optional<Person> p = personRepository.findById(person.getId());
        if (p.isPresent()) return personRepository.save(person) != null;
        return false;
    }

    public List<Job> getJobByPerson(String name, String surname) {
        List<Person> listPerson = personRepository.findByNameAndSurname(name, surname);
        List<Job> listReturn;
        if (!listPerson.isEmpty()) {
            listReturn = new ArrayList< Job >();
            for (Person p : listPerson) listReturn.add(p.getJob());
            return listReturn;
        }
        return null;
    }

    public String getNameByChar(String letter){

        List<Person> personReturn;
        String stringReturn ="";

        try{
            if(!letter.matches("[a-z | A-Z]")) throw new Exception("input non valid");

            personReturn = personRepository.findByNameStartsWithIgnoreCase(letter);

            if( personReturn.isEmpty() )throw new Exception("nessun risultato trovato");

            for( Person p : personReturn) stringReturn+= p.getName() +",";

        }catch (Exception e){
            return e.getMessage();
        }

        return stringReturn.substring(0 ,stringReturn.length() -1);
    }
}