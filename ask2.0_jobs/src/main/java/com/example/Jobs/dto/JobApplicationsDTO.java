package com.example.Jobs.dto;

import lombok.*;
import java.sql.*;

@Setter
@Getter
public class JobApplicationsDTO {

    private int application_index;

    private int jobs_index;

    private int members_index;

    private String self_introduction;

    private String application_status; // Enum 타입: 'PENDING', 'APPROVED', 'REJECTED'

    private Timestamp created_date;

    private Timestamp updated_date;
}
