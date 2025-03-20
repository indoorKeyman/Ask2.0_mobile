package com.example.CommunityServer.service;

import com.example.CommunityServer.dto.QuestionsDTO;
import com.example.CommunityServer.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionsService {

    private final QuestionsRepository questionsRepository;

    public List<QuestionsDTO> getAllQuestions(){
        return questionsRepository.getAllQuestions();
    }

    public Boolean makeQuestion(
            Integer member_index,
            String title,
            String content
    ){
        Map<String, Object> params = new HashMap<>();
        params.put("member_index", member_index);
        params.put("title", title);
        params.put("content", content);

        return questionsRepository.makeQuestion(params) > 0 ? true : false;
    }

    public Boolean deleteQuestion(Integer question_index){

        Map<String, Object> params = new HashMap<>();
        params.put("question_index", question_index);

        return questionsRepository.deleteQuestion(params) > 0 ? true : false;
    }

    public Boolean updateQuestion(
            Integer question_index,
            String title,
            String content
    ){

        Map<String, Object> params = new HashMap<>();
        params.put("question_index", question_index);
        params.put("title", title);
        params.put("content", content);

        return questionsRepository.updateQuestion(params) > 0 ? true : false;
    }

}
