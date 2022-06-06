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
import java.util.Optional;


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

    public boolean deletePerson(Integer id){
         Optional<Person> p = personRepository.findById( id );
         if( p.isPresent()) {
             personRepository.delete(p.get());
             return true;
         }
         return false;
    }

    public boolean updatePerson(Integer id , Person person){
        Optional<Person> p = personRepository.findById(id);
        if( p.isPresent()) return insertPerson( person );
        return false;
    }

    /*public String getNameByChar( String letter ){
        String result ="";
        List<Person> listPerson = personRepository.findAll();

        for( Person p : listPerson) {
            if (p.getName().toLowerCase().charAt(0) == letter.toLowerCase().charAt(0)) {
                result+= p.getName() + ",";
            }
        }
        if( result.equals("") )return "Nessun record trovato";

        return  result.substring(0, result.length()-1);
    }*/

   /* public List<Job> getJobByPerson( String name , String surname){
        List<Person> listPerson = personRepository.findByNameAndSurname(name , surname);
        if(!listPerson.isEmpty()){
            List<Job> listJob    = jobRepository.findAll();
            List<Job> listReturn = new ArrayList<Job>();

            for(Person p : listPerson){
                for(Job j : listJob){
                    if(p.getJob() == j.getId() ) {
                        listReturn.add(j);
                        break;
                    }
                }
            }
            return  listReturn;
        }else return null;
    }
    */

    /*
    public List<Job> getJobByPerson( String name , String surname){
        return personRepository.findJobByPerson( name , surname);
    }*/

    public List<Job> getJobByPerson( String name , String surname){
        List<Person> listPerson = personRepository.findByNameAndSurname(name , surname);
        List<Job> listReturn;
        if( !listPerson.isEmpty()){
            listReturn = new ArrayList<Job>();
            for( Person p: listPerson)listReturn.add( p.getJob());
            return listReturn;
        }
        return null;
    }
}
