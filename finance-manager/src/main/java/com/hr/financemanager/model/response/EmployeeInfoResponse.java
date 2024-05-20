package com.hr.financemanager.model.response;

import com.hr.financemanager.model.entity.BankDetails;
import com.hr.financemanager.model.entity.EmployeeInfo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public record EmployeeInfoResponse(

        int id,
        String firstname,
        String lastname,
        String email,
        String dateOfBirth,
        float employeeKycPoint,
        String department,
        String employmentDate,
        List<BankDetailsResponse> bankDetails,
        List<EducationInformationResponse> educationInformation,
        List<NextOfKinInfoResponse> nextOfKinInfo,
        List<ChildrenDetailsResponse> childrenDetails,
        Timestamp createdAt,
        Timestamp updatedAt
) {

    public static EmployeeInfoResponse fromEmployeeInfo(EmployeeInfo employeeInfo) {
        List<BankDetailsResponse> bankDetailsResponses = new ArrayList<>();
        List<EducationInformationResponse> educationInformationResponses = new ArrayList<>();
        List<NextOfKinInfoResponse> nextOfKinInfoResponses = new ArrayList<>();
        List<ChildrenDetailsResponse> childrenDetailsResponses = new ArrayList<>();
        employeeInfo.getBankDetails().forEach(bankDetails -> {
            BankDetailsResponse bankDetailsResponse = new BankDetailsResponse(
                    bankDetails.getId(),
                    bankDetails.getBankName(),
                    bankDetails.getEmployeeBankAccountNumber(),
                    bankDetails.getEmployeeAccountName(),
                    bankDetails.getCreatedAt(),
                    bankDetails.getUpdatedAt()
            );
            bankDetailsResponses.add(bankDetailsResponse);
        });
        employeeInfo
        .getEducationInformation()
        .forEach(
            educationInformation -> {
              EducationInformationResponse educationInformationResponse =
                  new EducationInformationResponse(
                          educationInformation.getId(),
                          educationInformation.getQualification(),
                          educationInformation.getInstitutionName(),
                          educationInformation.getCourseOfStudy(),
                          educationInformation.getGrade(),
                          educationInformation.getCreatedAt(),
                          educationInformation.getUpdatedAt());
              educationInformationResponses.add(educationInformationResponse);
            });
        employeeInfo
                .getNextOfKinInfo()
                .forEach(
                        nextOfKinInfo -> {
                            NextOfKinInfoResponse nextOfKinInfoResponse =
                                    new NextOfKinInfoResponse(
                                            nextOfKinInfo.getId(),
                                            nextOfKinInfo.getFirstname(),
                                            nextOfKinInfo.getLastname(),
                                            nextOfKinInfo.getAddress(),
                                            nextOfKinInfo.getPhoneNumber(),
                                            nextOfKinInfo.getRelationship(),
                                            nextOfKinInfo.getCreatedAt(),
                                            nextOfKinInfo.getUpdatedAt());
                            nextOfKinInfoResponses.add(nextOfKinInfoResponse);
                        });
        employeeInfo
                .getChildrenDetails()
                .forEach(
                        childrenDetails -> {
                            ChildrenDetailsResponse childrenDetailsResponse =
                                    new ChildrenDetailsResponse(
                                            childrenDetails.getId(),
                                            childrenDetails.getFirstname(),
                                            childrenDetails.getLastname(),
                                            childrenDetails.getAge(),
                                            childrenDetails.getCreatedAt(),
                                            childrenDetails.getUpdatedAt());
                            childrenDetailsResponses.add(childrenDetailsResponse);
                        });
        return new EmployeeInfoResponse(employeeInfo.getId(),
                employeeInfo.getFirstname(),
                employeeInfo.getLastname(),
                employeeInfo.getEmail(),
                employeeInfo.getDateOfBirth(),
                employeeInfo.getEmployeeKycPoint(),
                employeeInfo.getDepartment(),
                employeeInfo.getEmploymentDate(),
                bankDetailsResponses,
                educationInformationResponses,
                nextOfKinInfoResponses,
                childrenDetailsResponses,
                employeeInfo.getCreatedAt(),
                employeeInfo.getUpdatedAt()
        );
    }

}
