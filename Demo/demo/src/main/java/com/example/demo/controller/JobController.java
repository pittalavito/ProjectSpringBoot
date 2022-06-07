package com.example.demo.controller;
import com.example.demo.model.Job;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
public class JobController {

    private final JobService jobService;
    @Autowired
    public JobController( JobService jobService){
        this.jobService = jobService;
    }

    // --- METHODS -------------------
    @GetMapping("")
    public List<Job> getAllJobs(){
        return jobService.getAllJobS();
    }

    //1. Creare un endpoint per l'inserimento di un nuovo Lavoro nella tabella lavori.
    @PostMapping("{name}")
    public boolean insertJob( @PathVariable String name ){
        return jobService.insertJob( name );
    }

    //2. Creare un endpoint per l'eliminazione di un Lavoro dalla tabella lavori.
    //@DeleteMapping("")
    @DeleteMapping( "{id}" )
    public boolean deleteJob( @PathVariable Long id ){
        return jobService.deleteJob( id );
    }

    //3. Creare un endpoint che consenta di effettuare la modifica del nome di un lavoro*/
    @PutMapping()
    public  boolean updateJob( @NonNull @Valid @RequestBody Job job){
        return jobService.updateJob( job );
    }

}
