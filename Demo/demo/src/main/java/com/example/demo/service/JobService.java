package com.example.demo.service;
import com.example.demo.model.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(@Qualifier("Job") JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    // --- METHODS --------------------------------------------------
    public List<Job> getAllJobS() {
        return  jobRepository.findAll();
    }

    public boolean insertJob( String name ){
        Optional<Job> jobReturn = jobRepository.findByName( name );

        if( jobReturn.isPresent())return false;

        jobRepository.save( new Job( name ) );
        return true;
    }

    public boolean deleteJob( Long id ){
        Optional<Job> jobReturn = jobRepository.findById( id );
        if(jobReturn.isPresent()){
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateJob( Job job ){
        try{
            Optional<Job> jobById, jobByUniqueName;

            jobByUniqueName = jobRepository.findByName(job.getName());
            if(jobByUniqueName.isPresent()) throw new Exception();

            jobById = jobRepository.findById(job.getId());
            if(jobById.isEmpty()) throw new Exception();

        } catch (Exception e){
            return false;
        }
        jobRepository.save( job );
        return true;
    }

}
