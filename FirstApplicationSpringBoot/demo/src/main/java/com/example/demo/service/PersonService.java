package com.example.demo.service;
import com.example.demo.model.Person;
import com.example.demo.templateJDBC.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/*Lo strato Service funge da interfaccia tra gli strati Repository (privato)
e Web (API, pubblico). Un componente Service viene utilizzato per
la gestione e la trasformazione di un dato ottenuto dal database per la sua
rappresentazione all’esterno, oltre all’implementazione della logica di business.*/

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDB") PersonDao personDao ){
        this.personDao = personDao;
    }//@Qualifier("fakeDao") comunica con FakePersonDao

    public int addPerson( Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPerson(UUID id){
        return personDao.selectPerson( id );
    }

    public int deletePerson( UUID id){
        return personDao.deletePerson(id);
    }

    public int updatePerson( UUID id , Person person){
        return personDao.updatePerson( id , person);
    }
}
