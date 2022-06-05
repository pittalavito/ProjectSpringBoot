package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@Entity
@Table(name ="person")
public class Person {
    @Id
    private Integer id;
    @NotBlank @NotNull
    private String name;
    @NotBlank @NotNull
    private String surname;

    private int job;

    // --- CONSTRUCTORS ---

    public Person() {
    }
    public Person(Person person ){
        //id viene incrementato direttamente dal database
        this.name    = person.name;
        this.surname = person.surname;;
        this.job     = person.job;
    }

    // --- METHODS ---
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return  surname;
    }
    public int getJob(){
        return job;
    }
}
