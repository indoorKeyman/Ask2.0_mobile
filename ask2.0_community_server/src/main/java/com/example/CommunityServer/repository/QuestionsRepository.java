package com.example.CommunityServer.repository;

import com.example.CommunityServer.dto.QuestionsDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class QuestionsRepository {

    private final SqlSessionTemplate sql;

    public List<QuestionsDTO> getAllQuestions(){
        return sql.selectList("Questions.questionsList");
    }

    public Integer makeQuestion(Map<String, Object> params){
        return sql.insert("Questions.makeQuestion", params);
    }

    public Integer deleteQuestion(Map<String, Object> params){
        return sql.delete("Questions.deleteQuestion", params);
    }

    public Integer updateQuestion(Map<String, Object> params){
        return sql.update("Questions.updateQuestion", params);
    }

}
