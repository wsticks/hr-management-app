package com.hr.financemanager.model.response;

import java.sql.Timestamp;

public record NextOfKinInfoResponse(

        int id,
        String firstname,
        String lastname,
        String address,
        String phoneNumber,
        String relationship,
        Timestamp createdAt,
        Timestamp updatedAt
) {}
