package com.hr.financemanager.model.response;

import java.sql.Timestamp;

public record EducationInformationResponse(

        int id,
        String qualification,
        String institutionName,
        String courseOfStudy,
        String grade,
        Timestamp createdAt,
        Timestamp updatedAt
) {}
