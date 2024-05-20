package com.hr.financemanager.model.response;

import java.sql.Timestamp;

public record ChildrenDetailsResponse(

        int id,
        String firstname,
        String lastname,
        String age,
        Timestamp createdAt,
        Timestamp updatedAt
) {}
