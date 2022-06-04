package com.example.demo.service;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(@Qualifier("Job") JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    // --- METHODS ---
    public List<Job> getAllJobS() {
        return jobRepository.findAll();
    }

}
