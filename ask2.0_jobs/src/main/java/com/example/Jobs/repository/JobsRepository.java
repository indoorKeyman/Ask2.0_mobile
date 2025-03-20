package com.example.Jobs.repository;

import com.example.Jobs.dto.JobsDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class JobsRepository {

    private final SqlSessionTemplate sql;

    public List<JobsDTO> getEndJobs(){
        return sql.selectList("Jobs.getEndJobs");
    }

    public List<JobsDTO> getRecruitJobs(){
        return sql.selectList("Jobs.getRecruitJobs");
    }

    public JobsDTO getJobsById(Integer jobs_index){
        return sql.selectOne("Jobs.getJobsById", jobs_index);
    }

    public List<JobsDTO> getAllJobs(){
        return sql.selectList("Jobs.getAllJobs");
    }

    public Integer makeJobs(Map<String, Object> params){
        return sql.insert("Jobs.makeJobs", params);
    }

    public Integer deleteJobs(Map<String, Object> params){
        return sql.delete("Jobs.deleteJobs", params);
    }

    public Integer updateJobs(Map<String, Object> params){
        return sql.update("Jobs.updateJobs", params);
    }

}
