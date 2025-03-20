package com.example.CommunityServer.dto;

import lombok.*;
import java.sql.Timestamp;

@Setter
@Getter
public class AnswerDTO {

    private int answer_index;

    private int member_index;

    private int question_index;

    private String comment;

    private Timestamp created_date;

    private Timestamp updated_date;

}
