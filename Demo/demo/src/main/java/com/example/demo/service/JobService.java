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

    public boolean insertJob( Job job){
        if(jobRepository.findById( job.getId()).isEmpty() ) return  jobRepository.save( job ) != null;
        return false;
    }

    public boolean deleteJob( Job job){
        if(jobRepository.findById( job.getId()).isPresent() ){
            jobRepository.delete(( job ));
            return true;
        }
        return false;
    }
    public boolean updateJob( Job job){
        if( jobRepository.findById(job.getId()).isPresent() ){
            jobRepository.save( job );
            return true;
        }
        return false;
    }

}
