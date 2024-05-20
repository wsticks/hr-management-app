package com.hr.financemanager.model.request;

public record NextOfKinInfoRequest (

        String firstname,
        String lastname,
        String address,
        String phoneNumber,
        String relationship
) {}
