package com.example.demo.service;
import com.example.demo.model.Job;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.serviceutility.MyServiceException;
import com.example.demo.serviceutility.MyServiceResponse;
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

    public MyServiceResponse<String> getNameByChar(String letter){
        List<Person> personReturn;
        MyServiceResponse<String> serviceResponse = new MyServiceResponse<String>();

        try{
            if(!letter.matches("[a-z | A-Z]")){
                throw new MyServiceException( "NotValidLetter" );
            }

            personReturn = personRepository.findByNameStartsWithIgnoreCase(letter);
            if( personReturn.isEmpty() ){
                throw new MyServiceException( "personReturnIsEmpty" );
            }

            if( true ){
                serviceResponse.body = "";
                for (Person p : personReturn) serviceResponse.body += p.getName() + ",";
                throw new MyServiceException( "default" );
            }

        }catch (Exception e){
            switch (e.getMessage()){
                case "NotValidLetter":
                    serviceResponse.codHttp = 404;
                    serviceResponse.body = "input non valido";
                    break;
                case "personReturnIsEmpty":
                    serviceResponse.codHttp = 400;
                    serviceResponse.body = "nessun risultato trovato";
                    break;
                default:
                    serviceResponse.codHttp = 200;
                    break;
            }
        }
        return serviceResponse;
    }
}