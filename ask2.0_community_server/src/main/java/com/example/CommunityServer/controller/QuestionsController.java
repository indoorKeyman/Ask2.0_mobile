package com.example.CommunityServer.controller;

import com.example.CommunityServer.dto.QuestionsDTO;
import com.example.CommunityServer.service.QuestionsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/community/questions")
public class QuestionsController {

    private final QuestionsService questionsService;

    public QuestionsController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<QuestionsDTO>> getAllQuestions () {

        log.info("Request getAllQuestions received");

        List result = questionsService.getAllQuestions();

        if (!result.isEmpty()){
            log.info("Response getAllQuestions sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_question")
    public ResponseEntity<String> makeQuestion (
            @RequestBody QuestionsDTO request
    ) {

        log.info("Request makeQuestion received");

        Boolean result = questionsService.makeQuestion(
                request.getMember_index(),
                request.getTitle(),
                request.getContent()
        );

        if (result){
            log.info("Response getAllQuestions sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful makeQuestion" : "Failed makeQuestion" );
    }

    @DeleteMapping("/delete_question")
    public ResponseEntity<String> deleteQuestion (
            @RequestParam Integer question_index
    ) {

        log.info("Request deleteQuestion received");

        Boolean result = questionsService.deleteQuestion(question_index);

        if (result){
            log.info("Response getAllQuestions sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful deleteQuestion" : "Failed deleteQuestion" );
    }

    @PatchMapping("/update_question")
    public ResponseEntity<String> updateQuestion (
            @RequestParam Integer question_index,
            @RequestBody QuestionsDTO request
    ) {

        log.info("Request updateQuestion received");

        Boolean result = questionsService.updateQuestion(question_index, request.getTitle(), request.getContent());

        if (result){
            log.info("Response updateQuestion sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful updateQuestion" : "Failed updateQuestion" );
    }


}
