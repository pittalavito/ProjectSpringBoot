package com.example.demo.repository;
import com.example.demo.model.Job;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository("Person")
public interface PersonRepository extends JpaRepository<Person, Long > {
    List<Person> findByNameAndSurname(String name, String surname);
    @Query("select j from Job j join Person p on p.job = j.id where p.name like ?1 and p.surname like ?2")
    List<Job> findJobByPerson( String name , String surname );

}


