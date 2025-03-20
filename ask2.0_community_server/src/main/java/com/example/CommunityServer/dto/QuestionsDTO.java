package com.example.CommunityServer.dto;

import lombok.*;
import java.sql.Timestamp;

@Setter
@Getter
public class QuestionsDTO {

    private int question_index;

    private int member_index;

    private String title;

    private String content;

    private Timestamp created_date;

    private Timestamp updated_date;

}
