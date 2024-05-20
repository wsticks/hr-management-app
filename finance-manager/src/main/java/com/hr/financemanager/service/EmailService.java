package com.hr.financemanager.service;

public interface EmailService {
    void sendMail(String to,String [] cc, String subject, String body);
}
