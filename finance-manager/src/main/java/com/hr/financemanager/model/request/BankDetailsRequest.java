package com.hr.financemanager.model.request;

public record BankDetailsRequest (
        String bankName,
        String employeeBankAccountNumber,
        String employeeAccountName
) {


}
