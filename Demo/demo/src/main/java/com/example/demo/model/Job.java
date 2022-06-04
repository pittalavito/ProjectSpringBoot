package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="jobs")
public class Job {
    @Id
    private int id;
    @NotBlank @NotNull
    private String name;
    // --- CONSTRUCTORS ---

    // --- METHODS ---
    public int getId(){return id;}
    public String getName(){return  name;}
}
