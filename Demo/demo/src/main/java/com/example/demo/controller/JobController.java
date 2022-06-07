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

    @PostMapping("{name}")
    public boolean insertJob( @PathVariable String name ){
        return jobService.insertJob( name );
    }

    @DeleteMapping( "{id}" )
    public boolean deleteJob( @PathVariable Long id ){
        return jobService.deleteJob( id );
    }

    @PutMapping()
    public  boolean updateJob( @NonNull @Valid @RequestBody Job job){
        return jobService.updateJob( job );
    }

}
