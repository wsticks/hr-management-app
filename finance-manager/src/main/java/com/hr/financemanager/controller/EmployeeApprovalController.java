package com.hr.financemanager.controller;

import com.hr.financemanager.model.request.EmployeeInfoRequest;
import com.hr.financemanager.model.response.EmployeeInfoResponse;
import com.hr.financemanager.service.EmployeeApprovalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeApprovalController {

    private static  final Logger LOGGER = LoggerFactory.getLogger(EmployeeApprovalController.class);

    @Autowired
    private EmployeeApprovalService employeeApprovalService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public EmployeeInfoResponse employeeApproval(EmployeeInfoRequest employeeInfoRequest){
        LOGGER.info("Employee Approval received : {}", employeeInfoRequest);
        return employeeApprovalService.approveEmployee(employeeInfoRequest);
    }
}
