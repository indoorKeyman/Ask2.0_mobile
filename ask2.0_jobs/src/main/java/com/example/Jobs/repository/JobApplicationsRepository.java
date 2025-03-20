package com.example.Jobs.repository;


import com.example.Jobs.dto.JobApplicationsDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class JobApplicationsRepository {

    private final SqlSessionTemplate sql;

    public List<JobApplicationsDTO> getAllJobsApplications(){
        return sql.selectList("JobsApplications.getAllJobApplications");
    }

    public List<JobApplicationsDTO> getPendingJobApplications(){
        return sql.selectList("JobsApplications.getPendingJobApplications");
    }

    public List<JobApplicationsDTO> getApprovedJobApplications(){
        return sql.selectList("JobsApplications.getApprovedJobApplications");
    }

    public List<JobApplicationsDTO> getRejectedJobApplications(){
        return sql.selectList("JobsApplications.getRejectedJobApplications");
    }

    public List<JobApplicationsDTO> getByIdJobApplications(Map<String, Object> params){
        return sql.selectList("JobsApplications.getByIdJobApplications", params);
    }

    public Integer makeJobApplications(Map<String, Object> params){
        return sql.insert("JobsApplications.makeJobApplications", params);
    }

    public Integer updateJobApplications(Map<String, Object> params){
        return sql.update("JobsApplications.updateJobApplications", params);
    }
}
