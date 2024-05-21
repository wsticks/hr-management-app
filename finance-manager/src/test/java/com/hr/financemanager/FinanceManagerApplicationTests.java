package com.hr.financemanager;

import com.hr.financemanager.model.entity.*;
import com.hr.financemanager.model.request.*;
import com.hr.financemanager.model.response.*;
import com.hr.financemanager.repository.EmployeeApprovalRepository;
import com.hr.financemanager.service.EmailService;
import com.hr.financemanager.service.EmployeeApprovalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class FinanceManagerApplicationTests {

    @Autowired
    private EmployeeApprovalService employeeService;
    @MockBean
    private EmployeeApprovalRepository employeeApprovalRepository;
    @MockBean
    private EmailService emailService;

    private static final String copyEmail1 = "williamsondrums@gmail.com";
    private static final String copyEmail2 = "akannimuyiwa@gmail.com";
    private static final String emailSubject = "Finance Department Approval Of Employee";
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

    private EmployeeInfo employeeInfo;
    private BankDetails bankDetails;
    private EducationInformation educationInformation;
    private NextOfKinInfo nextOfKinInfo;
    private ChildrenDetails childrenDetails;

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
            Timestamp.valueOf("2024-05-21 11:37:23.578365"),
            Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        bankDetailsResponseList.add(bankDetailsResponse);
    educationInformationResponse =
        new EducationInformationResponse(1,
                "BSC",
                "UNILAG",
                "Computer Science",
                "SECOND_CLASS_UPPER",
                Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        educationInformationResponseList.add(educationInformationResponse);
    nextOfKinInfoResponse =
        new NextOfKinInfoResponse(1,
                "Sharon",
                "Smith",
                "10, olumide street",
                "08028892",
                "Wife",
                Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        nextOfKinInfoResponseList.add(nextOfKinInfoResponse);
    childrenDetailsResponse = new ChildrenDetailsResponse(1,
            "Tobi",
            "Smith",
            "10",
            Timestamp.valueOf("2024-05-21 11:37:23.578365"),
            Timestamp.valueOf("2024-05-21 11:37:23.578365"));
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
            Timestamp.valueOf("2024-05-21 11:37:23.578365"),
            Timestamp.valueOf("2024-05-21 11:37:23.578365"));
    }

    @BeforeEach
    void setUpEmployeeInfo() {
        List<BankDetails> bankDetailsList = new ArrayList<>();
        List<EducationInformation> educationInformationList = new ArrayList<>();
        List<NextOfKinInfo> nextOfKinInfoList = new ArrayList<>();
        List<ChildrenDetails> childrenDetailsList = new ArrayList<>();
        bankDetails = new BankDetails(1,
                "Access Bank",
                "12345678",
                "Williams Smith",
                Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        bankDetailsList.add(bankDetails);
        educationInformation =
                new EducationInformation(1,
                        "BSC",
                        "UNILAG",
                        "Computer Science",
                        "SECOND_CLASS_UPPER",
                        Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                        Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        educationInformationList.add(educationInformation);
        nextOfKinInfo =
                new NextOfKinInfo(1,
                        "Sharon",
                        "Smith",
                        "10, olumide street",
                        "08028892",
                        "Wife",
                        Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                        Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        nextOfKinInfoList.add(nextOfKinInfo);
        childrenDetails = new ChildrenDetails(1,
                "Tobi",
                "Smith",
                "10",
                Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                Timestamp.valueOf("2024-05-21 11:37:23.578365"));
        childrenDetailsList.add(childrenDetails);
        employeeInfo = new EmployeeInfo(
                1,"williams",
                "Smith",
                "williamsondrums@gmail.com",
                "1990-03-16",
                50,
                "IT",
                "2002-03-16",
                true,
                bankDetailsList,
                educationInformationList,
                nextOfKinInfoList,
                childrenDetailsList,
                Timestamp.valueOf("2024-05-21 11:37:23.578365"),
                Timestamp.valueOf("2024-05-21 11:37:23.578365"));
    }

    @Test
    void testApproveEmployee() {
        Mockito.when(employeeApprovalRepository.save(any(EmployeeInfo.class))).thenReturn(employeeInfo);
        employeeInfoResponse = employeeService.approveEmployee(employeeInfoRequest);
        assertTrue(employeeInfoResponse.employeeApproved());
        verify(employeeApprovalRepository, times(1)).save(any(EmployeeInfo.class));
        verify(emailService, times(1)).sendMail(eq(copyEmail1), eq(new String[]{copyEmail2, copyEmail1}), eq(emailSubject), anyString());
    }

    @Test
    void testSaveEmployeeInfo() {
        employeeInfo = employeeService.saveEmployeeInfo(employeeInfoRequest);
        assertNotNull(employeeInfo);
        assertEquals(employeeService.saveEmployeeInfo(employeeInfoRequest),employeeInfo);
    }

}
