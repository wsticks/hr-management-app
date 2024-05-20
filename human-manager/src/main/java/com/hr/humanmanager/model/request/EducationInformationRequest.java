package com.hr.humanmanager.model.request;

public record EducationInformationRequest (

        String qualification,
        String institutionName,
        String courseOfStudy,
        String grade
) {}
