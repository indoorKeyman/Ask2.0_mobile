package com.example.CommunityServer.controller;

import com.example.CommunityServer.dto.AnswerDTO;
import com.example.CommunityServer.dto.QuestionsDTO;
import com.example.CommunityServer.service.AnswerService;
import com.example.CommunityServer.service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/community/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<QuestionsDTO>> getAllAnswer (@RequestParam Integer question_index) {

        log.info("Request getAllAnswer received");

        List result = answerService.getAllAnswer(question_index);

        if (!result.isEmpty()){
            log.info("Response getAllQuestions sent: Success");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/make_answer")
    public ResponseEntity<String> makeAnswer (
            @RequestBody AnswerDTO request
    ) {

        log.info("Request makeAnswer received");

        Boolean result = answerService.makeAnswer(
                request.getMember_index(),
                request.getQuestion_index(),
                request.getComment()
        );

        if (result){
            log.info("Response makeAnswer sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful makeAnswer" : "Failed makeAnswer" );
    }

    @DeleteMapping("/delete_answer")
    public ResponseEntity<String> deleteAnswer (
            @RequestParam Integer answer_index
    ) {

        log.info("Request deleteAnswer received");

        Boolean result = answerService.deleteAnswer(answer_index);

        if (result){
            log.info("Response deleteAnswer sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful deleteAnswer" : "Failed deleteAnswer" );
    }

    @PatchMapping("/update_answer")
    public ResponseEntity<String> updateAnswer (
            @RequestParam Integer answer_index,
            @RequestBody AnswerDTO request
    ) {

        log.info("Request updateAnswer received");

        Boolean result = answerService.updateAnswer(
                answer_index,
                request.getComment()
        );

        if (result){
            log.info("Response updateAnswer sent: Success");
        }

        return ResponseEntity.ok(result ? "Successful updateAnswer" : "Failed updateAnswer" );
    }




}
