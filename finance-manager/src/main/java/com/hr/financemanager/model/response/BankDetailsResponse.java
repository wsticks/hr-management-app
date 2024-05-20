package com.hr.financemanager.model.response;

import java.sql.Timestamp;

public record BankDetailsResponse(

        int id,
        String bankName,
        String employeeBankAccountNumber,
        String employeeAccountName,
        Timestamp createdAt,
        Timestamp updatedAt
) {}
