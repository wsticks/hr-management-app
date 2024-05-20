package com.hr.humanmanager.controller;

import com.hr.humanmanager.model.request.EmployeeInfoRequest;
import com.hr.humanmanager.service.EmployeeInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee-info")
public class EmployeeInfoController {


    private final EmployeeInfoService employeeInfoService;

    public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
        this.employeeInfoService = employeeInfoService;
    }

    @PostMapping("/send")
    public String sendEmployeeInfo(@RequestBody EmployeeInfoRequest employeeInfoRequest) {
        return employeeInfoService.sendEmployeeInfo(employeeInfoRequest);
    }

    @GetMapping("/get")
    public String sendEmployeeInfo(String message) {
        message = "Welcome ";
        return message;
    }

}
