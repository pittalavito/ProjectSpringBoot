package com.example.demo.controller;
import com.example.demo.model.Job;
import com.example.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/job")
public class JobController {

    private final JobService jobService;
    @Autowired
    public JobController( JobService jobService){
        this.jobService = jobService;
    }
    // --- METHODS ---
    @GetMapping("")
    public List<Job> getAllJobs(){
        return jobService.getAllJobS();
    }

    //1. Creare un endpoint per l'inserimento di un nuovo Lavoro nella tabella lavori.
    @PostMapping
    public boolean insertJob(@NotNull @Valid @RequestBody Job job){
        return jobService.insertJob( job );
    }

    //2. Creare un endpoint per l'eliminazione di un Lavoro dalla tabella lavori.
    //@DeleteMapping("")
    @DeleteMapping
    public boolean deleteJob(@NotNull @Valid @RequestBody Job job){
        return jobService.deleteJob( job );
    }

    //3. Creare un endpoint che consenta di effettuare la modifica del nome di un lavoro*/
    @PutMapping
    public  boolean updateJob(@NonNull @Valid @RequestBody Job job){
        return jobService.updateJob( job );
    }

}
