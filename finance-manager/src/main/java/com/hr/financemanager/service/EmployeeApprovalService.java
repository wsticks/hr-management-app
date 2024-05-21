package com.hr.financemanager.service;

import com.hr.financemanager.model.entity.*;
import com.hr.financemanager.model.request.*;
import com.hr.financemanager.model.response.EmployeeInfoResponse;
import com.hr.financemanager.repository.EmployeeApprovalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import static com.hr.financemanager.model.response.EmployeeInfoResponse.fromEmployeeInfo;

@Service
public class EmployeeApprovalService {

    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeApprovalService.class);

    @Value("${employee.approval.point}")
    private float employeeApprovalPoint;
    @Value("${email.subject}")
    private String emailSubject;
    @Value("${email.cc1}")
    private String copyEmail1;
    @Value("${email.cc2}")
    private String copyEmail2;


    private final EmployeeApprovalRepository employeeApprovalRepository;
    private final EmailService emailService;

    @Autowired
    public EmployeeApprovalService(EmployeeApprovalRepository employeeApprovalRepository, EmailService emailService) {
        this.employeeApprovalRepository = employeeApprovalRepository;
        this.emailService = emailService;
    }

    public EmployeeInfoResponse approveEmployee(EmployeeInfoRequest employeeInfoRequest) {
        String[] copiedEmail = {copyEmail1,copyEmail2};

        LOGGER.info("START: incoming Approve Employee Info : {}",  employeeInfoRequest);
        EmployeeInfo employeeInfo = saveEmployeeInfo(employeeInfoRequest);
        if(employeeInfoRequest.employeeKycPoint() >= employeeApprovalPoint){
            employeeInfo.setEmployeeApproved(true);
            emailService.sendMail(employeeInfoRequest.email(),copiedEmail,emailSubject,emailBody(employeeInfoRequest));
        }
        LOGGER.info(" Employee info to be saved : {}",  employeeInfo);
        employeeInfo = employeeApprovalRepository.save(employeeInfo);
       return fromEmployeeInfo(employeeInfo);
    }

    public EmployeeInfo saveEmployeeInfo(EmployeeInfoRequest employeeInfoRequest) {
        List<BankDetails> bankDetailsList = new ArrayList<>();
        List<EducationInformation> educationInformationList = new ArrayList<>();
        List<NextOfKinInfo> nextOfKinInfoList = new ArrayList<>();
        List<ChildrenDetails> childrenDetailsList = new ArrayList<>();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setFirstname(employeeInfoRequest.firstname());
        employeeInfo.setLastname(employeeInfoRequest.lastname());
        employeeInfo.setEmail(employeeInfoRequest.email());
        employeeInfo.setDateOfBirth(employeeInfoRequest.dateOfBirth());
        employeeInfo.setDepartment(employeeInfoRequest.department());
        employeeInfo.setEmployeeKycPoint(employeeInfoRequest.employeeKycPoint());
        employeeInfoRequest.bankDetails().forEach(bankDetailsRequest -> {
            BankDetails bankDetails = new BankDetails();
            bankDetails.setBankName(bankDetailsRequest.bankName());
            bankDetails.setEmployeeAccountName(bankDetailsRequest.employeeAccountName());
            bankDetails.setEmployeeBankAccountNumber(bankDetailsRequest.employeeBankAccountNumber());
            bankDetailsList.add(bankDetails);
        });
    employeeInfoRequest
        .educationInformation()
        .forEach(
            educationInformationRequest -> {
              EducationInformation educationInformation = new EducationInformation();
                educationInformation.setGrade(educationInformationRequest.grade());
                educationInformation.setCourseOfStudy(educationInformationRequest.courseOfStudy());
                educationInformation.setQualification(educationInformationRequest.qualification());
                educationInformation.setInstitutionName(educationInformationRequest.institutionName());
              educationInformationList.add(educationInformation);
            });
        employeeInfoRequest
                .nextOfKinInfo()
                .forEach(
                        nextOfKinInfoRequest -> {
                            NextOfKinInfo nextOfKinInfo = new NextOfKinInfo();
                            nextOfKinInfo.setFirstname(nextOfKinInfoRequest.firstname());
                            nextOfKinInfo.setLastname(nextOfKinInfoRequest.lastname());
                            nextOfKinInfo.setAddress(nextOfKinInfoRequest.address());
                            nextOfKinInfo.setRelationship(nextOfKinInfoRequest.relationship());
                            nextOfKinInfo.setPhoneNumber(nextOfKinInfoRequest.phoneNumber());
                            nextOfKinInfoList.add(nextOfKinInfo);
                        });
        employeeInfoRequest
                .childrenDetails()
                .forEach(
                        childrenDetailsRequest -> {
                            ChildrenDetails childrenDetails = new ChildrenDetails();
                            childrenDetails.setFirstname(childrenDetailsRequest.firstname());
                            childrenDetails.setLastname(childrenDetailsRequest.lastname());
                            childrenDetails.setAge(childrenDetailsRequest.age());
                            childrenDetailsList.add(childrenDetails);
                        });
        employeeInfo.setBankDetails(bankDetailsList);
        employeeInfo.setEducationInformation(educationInformationList);
        employeeInfo.setNextOfKinInfo(nextOfKinInfoList);
        employeeInfo.setChildrenDetails(childrenDetailsList);
        return employeeInfo;
    }

    public static String emailBody(EmployeeInfoRequest employeeInfoRequest){
        return  "Dear "+ employeeInfoRequest.lastname() +
                        " Your employee approval was successful";
    }
}
