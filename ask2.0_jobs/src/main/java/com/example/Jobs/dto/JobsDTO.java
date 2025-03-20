package com.example.Jobs.dto;

import lombok.*;
import java.sql.*;

@Setter
@Getter
public class JobsDTO {

    private int jobs_index;

    private int member_index;

    private String title;

    private String location;

    private String level;

    private String responsibilities;

    private String qualification;

    private String preferences;

    private Date start_date;

    private Date end_date;

    private Timestamp created_date;

    private Timestamp updated_date;


}

