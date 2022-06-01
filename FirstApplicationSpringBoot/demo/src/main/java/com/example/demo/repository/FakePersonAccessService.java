package com.example.demo.repository;
import com.example.demo.model.Person;
import com.example.demo.templateJDBC.PersonDao;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.*;

@Repository("fakeDB")
public class FakePersonAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id , @NotNull Person person){
        DB.add( new Person( id , person.getName())) ;
        return 1;
    }
    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
        //chiarire il metodo stream
    }
    @Override
    public int deletePerson( UUID id){
        Optional <Person> personSearch = selectPerson(id);
        if( !personSearch.isPresent())return 0;

        DB.remove( personSearch.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
         return selectPerson(id)
                 .map( p-> {
                     int indexPerson = DB.indexOf(p);
                     if( indexPerson >= 0){
                         DB.set(indexPerson, new Person( id , person.getName() ));
                         return 1;
                     }
                     return 0;
                 }).orElse(0);
    }
}
