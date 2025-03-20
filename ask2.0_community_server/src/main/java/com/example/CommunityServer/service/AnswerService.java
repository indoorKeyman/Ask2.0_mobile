package com.example.CommunityServer.service;

import com.example.CommunityServer.dto.AnswerDTO;
import com.example.CommunityServer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public List<AnswerDTO> getAllAnswer(Integer question_index){

        Map<String, Object> params = new HashMap<>();
        params.put("question_index", question_index);

        return answerRepository.getAllAnswer(params);
    }

    public Boolean makeAnswer(
            Integer member_index,
            Integer question_index,
            String comment
            ){

        Map<String, Object> params = new HashMap<>();
        params.put("member_index", member_index);
        params.put("question_index", question_index);
        params.put("comment", comment);

        return answerRepository.makeAnswer(params) > 0 ? true : false;
    }

    public Boolean deleteAnswer(Integer answer_index){

        Map<String, Object> params = new HashMap<>();
        params.put("answer_index", answer_index);

        return answerRepository.deleteAnswer(params) > 0 ? true : false;
    }

    public Boolean updateAnswer(
            Integer answer_index,
            String comment
            ){

        Map<String, Object> params = new HashMap<>();
        params.put("answer_index", answer_index);
        params.put("comment", comment);

        return answerRepository.updateAnswer(params) > 0 ? true : false;
    }

}
