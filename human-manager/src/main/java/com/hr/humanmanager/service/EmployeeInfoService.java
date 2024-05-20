package com.hr.humanmanager.service;


import com.hr.humanmanager.model.request.EmployeeInfoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EmployeeInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInfoService.class);


    KafkaTemplate<String, Object> kafkaTemplate;

    public EmployeeInfoService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${spring.kafka.topic.name}")
    private String topic;

    public String sendEmployeeInfo(EmployeeInfoRequest employeeInfoRequest){
        LOGGER.info("START:: Employee info send request : {}", employeeInfoRequest);
        kafkaTemplate.send(topic, employeeInfoRequest);
        return "Message sent successfully";

    }
}
