package com.example.demo.service;
import com.example.demo.model.Job;
import com.example.demo.model.Person;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final JobRepository jobRepository;// non mi sembra un ottima idea

    @Autowired
    public PersonService(
            @Qualifier("Person") PersonRepository personRepository ,
            @Qualifier("Job")    JobRepository jobRepository
    ){
        this.personRepository = personRepository;
        this.jobRepository = jobRepository;
    }

    // --- METHODS ---
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }
    public boolean insertPerson(Person person){
         return personRepository.save( person ) != null;
    }

    public boolean deletePerson(int id){
         Person p = personRepository.findById(id);
         if( p != null) {
             personRepository.delete(p);
             return true;
         }
         return false;
    }

    public boolean updatePerson(int id , Person person){
        Person p = personRepository.findById(id);
        if( p != null) return insertPerson( person);
        return false;
    }

    public List<Job> getJobByPerson( String name , String surname){
        List<Person> listPerson = personRepository.findByNameAndSurname(name , surname);
        if(!listPerson.isEmpty()){
            List<Job> listJob    = jobRepository.findAll();
            List<Job> listReturn = new ArrayList<Job>();

            for(Person p : listPerson){
                for(Job j : listJob){
                    if(p.getJob() == (j.getId())) {
                        listReturn.add(j);
                        break;
                    }
                }
            }
            return  listReturn;
        }else return null;
    }

    /*public List<Job> getJobByPerson( String name , String surname){
        return personRepository.findJobByPerson( name , surname);
    }*/
}
