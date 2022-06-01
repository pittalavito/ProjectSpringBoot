package com.example.demo.templateJDBC;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import com.example.demo.model.Person;

public interface PersonDao {
    int insertPerson(UUID id , Person person);
    default int insertPerson( Person person){
        return insertPerson( UUID.randomUUID() , person);
    }

    List<Person> selectAllPeople();
    Optional<Person> selectPerson(UUID id); //Optional is a container with a single value, which may or may not be present
    int deletePerson( UUID id );
    int updatePerson( UUID id , Person person);
}
