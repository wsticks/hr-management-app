package com.hr.humanmanager.model.request;

public record BankDetailsRequest (
        String bankName,
        String employeeBankAccountNumber,
        String employeeAccountName
) {


}
