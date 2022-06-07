package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "job")

    private Set<Person> persons;

    // --- CONSTRUCTOR --------------------------------------------------
    public Job() {
    }
    public  Job( @JsonProperty("name") String name){
        this.name = name;
    }

    // --- METHODS ------------------------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
