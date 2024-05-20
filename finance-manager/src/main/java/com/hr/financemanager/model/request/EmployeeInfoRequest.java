package com.hr.financemanager.model.request;

import java.util.List;

public record EmployeeInfoRequest(
         String firstname,
         String lastname,
         String email,
         String dateOfBirth,
         float employeeKycPoint,
         String department,
         String employmentDate,
        List<BankDetailsRequest> bankDetails,
        List<EducationInformationRequest> educationInformation,
        List<NextOfKinInfoRequest> nextOfKinInfo,
        List<ChildrenDetailsRequest> childrenDetails) {


}
