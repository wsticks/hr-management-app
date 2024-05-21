package com.hr.financemanager;

import com.hr.financemanager.model.entity.BankDetails;
import com.hr.financemanager.model.entity.EducationInformation;
import com.hr.financemanager.model.entity.EmployeeInfo;
import com.hr.financemanager.model.request.*;
import com.hr.financemanager.model.response.*;
import com.hr.financemanager.repository.EmployeeApprovalRepository;
import com.hr.financemanager.service.EmailService;
import com.hr.financemanager.service.EmployeeApprovalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class FinanceManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    @MockBean
    private EmployeeApprovalService employeeService;
    @MockBean
    private EmployeeApprovalRepository employeeApprovalRepository;
    @MockBean
    private EmailService emailService;

    private static final String copyEmail1 = "copy1@example.com";
    private static final String copyEmail2 = "copy2@example.com";
    private static final String emailSubject = "Employee Approval";
    private static final String emailBody = "Your employee request has been approved.";
    private static final int employeeApprovalPoint = 50;
    private EmployeeInfoRequest employeeInfoRequest;
    private BankDetailsRequest bankDetailsRequest;
    private EducationInformationRequest educationInformationRequest;
    private NextOfKinInfoRequest nextOfKinInfoRequest;
    private ChildrenDetailsRequest childrenDetailsRequest;

    private EmployeeInfoResponse employeeInfoResponse;
    private BankDetailsResponse bankDetailsResponse;
    private EducationInformationResponse educationInformationResponse;
    private NextOfKinInfoResponse nextOfKinInfoResponse;
    private ChildrenDetailsResponse childrenDetailsResponse;

    @BeforeEach
    void setUpEmployeeInfoRequest() {
        List<BankDetailsRequest> bankDetailsList = new ArrayList<>();
        List<EducationInformationRequest> educationInformationList = new ArrayList<>();
        List<NextOfKinInfoRequest> nextOfKinInfoList = new ArrayList<>();
        List<ChildrenDetailsRequest> childrenDetailsList = new ArrayList<>();
        bankDetailsRequest = new BankDetailsRequest("Access Bank",
                "12345678",
                "Williams Smith");
        bankDetailsList.add(bankDetailsRequest);
        educationInformationRequest = new EducationInformationRequest("BSC",
                "UNILAG",
                "Computer Science",
                "SECOND_CLASS_UPPER");
        educationInformationList.add(educationInformationRequest);
        nextOfKinInfoRequest = new NextOfKinInfoRequest("Sharon",
                "Smith",
                "10, olumide street",
                "08028892",
                "Wife");
        nextOfKinInfoList.add(nextOfKinInfoRequest);
        childrenDetailsRequest  = new ChildrenDetailsRequest("Tobi",
                "Smith",
                "10");
        childrenDetailsList.add(childrenDetailsRequest);
        employeeInfoRequest = new EmployeeInfoRequest(
                "williams",
                "Smith",
                "williamsondrums@gmail.com",
                "1990-03-16",
                50,
                "IT",
                "2002-03-16",
                bankDetailsList,
                educationInformationList,
                nextOfKinInfoList,
                childrenDetailsList
        );
    }

    @BeforeEach
    void setUpEmployeeInfoResponse() {
        List<BankDetailsResponse> bankDetailsResponseList = new ArrayList<>();
        List<EducationInformationResponse> educationInformationResponseList = new ArrayList<>();
        List<NextOfKinInfoResponse> nextOfKinInfoResponseList = new ArrayList<>();
        List<ChildrenDetailsResponse> childrenDetailsResponseList = new ArrayList<>();
    bankDetailsResponse = new BankDetailsResponse(1,
            "Access Bank",
            "12345678",
            "Williams Smith",
            "",
            "");
        bankDetailsResponseList.add(bankDetailsResponse);
    educationInformationResponse =
        new EducationInformationResponse(1,
                "BSC",
                "UNILAG",
                "Computer Science",
                "SECOND_CLASS_UPPER",
                "",
                "");
        educationInformationResponseList.add(educationInformationResponse);
    nextOfKinInfoResponse =
        new NextOfKinInfoResponse(1,
                "Sharon",
                "Smith",
                "10, olumide street",
                "08028892",
                "Wife",
                "",
                "");
        nextOfKinInfoResponseList.add(nextOfKinInfoResponse);
    childrenDetailsResponse = new ChildrenDetailsResponse(1,
            "Tobi",
            "Smith",
            "10",
            "",
            "");
        childrenDetailsResponseList.add(childrenDetailsResponse);
    employeeInfoResponse = new EmployeeInfoResponse(
            1,"williams",
            "Smith",
            "williamsondrums@gmail.com",
            "1990-03-16",
            50,
            "IT",
            "2002-03-16",
            true,
            bankDetailsResponseList,
            educationInformationResponseList,
            nextOfKinInfoResponseList,
            childrenDetailsResponseList,
            "",
            "");
    }

//    @Test
//    void testApproveEmployee() {
//        employeeService.approveEmployee(employeeInfoRequest);
//        verify(employeeApprovalRepository, times(1)).save(any(EmployeeInfo.class));
//        verify(emailService, never()).sendMail(anyString(), any(String[].class), anyString(), anyString());
//    }

    @Test
    void testApproveEmployee() {
        EmployeeInfoResponse response = employeeService.approveEmployee(employeeInfoRequest);

        // Assert
        assertTrue(response.employeeApproved());
        verify(employeeApprovalRepository, times(1)).save(any(EmployeeInfo.class));
        verify(emailService, never()).sendMail(anyString(), any(String[].class), anyString(), anyString());
    }

//    @Test
//    void testApproveEmployee_Approved() {
//        // Arrange
//        EmployeeInfoRequest request = new EmployeeInfoRequest();
//        request.setEmployeeKycPoint(6);
//        request.setEmail("employee@example.com");
//
//        // Act
//        EmployeeInfoResponse response = employeeService.approveEmployee(request);
//
//        // Assert
//        assertTrue(response.isEmployeeApproved());
//        verify(employeeApprovalRepository, times(1)).save(any(EmployeeInfo.class));
//        verify(emailService, times(1)).sendMail(eq("employee@example.com"), eq(new String[]{copyEmail1, copyEmail2}), eq(emailSubject), anyString());
//    }

}
