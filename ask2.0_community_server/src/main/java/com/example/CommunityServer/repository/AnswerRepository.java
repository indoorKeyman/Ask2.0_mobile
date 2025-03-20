package com.example.CommunityServer.repository;

import com.example.CommunityServer.dto.AnswerDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class AnswerRepository {

    private final SqlSessionTemplate sql;

    public List<AnswerDTO> getAllAnswer(Map<String, Object> params){
        return sql.selectList("Answer.answerList", params);
    }

    public Integer makeAnswer(Map<String, Object> params){
        return sql.insert("Answer.makeAnswer", params);
    }

    public Integer deleteAnswer(Map<String, Object> params){
        return sql.delete("Answer.deleteAnswer", params);
    }

    public Integer updateAnswer(Map<String, Object> params){
        return sql.delete("Answer.updateAnswer", params);
    }
}
