package com.hr.humanmanager.model;

public record NextOfKinInfoRequest (

        String firstname,
        String lastname,
        String address,
        String phoneNumber,
        String relationship
) {}
