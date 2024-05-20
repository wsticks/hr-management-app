package com.hr.financemanager.model.request;

public record EducationInformationRequest (

        String qualification,
        String institutionName,
        String courseOfStudy,
        String grade
) {}
