package com.hr.humanmanager.controller;

import com.hr.humanmanager.model.request.EmployeeInfoRequest;
import com.hr.humanmanager.service.EmployeeInfoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employeeinfo")
public class EmployeeInfoController {


    private final EmployeeInfoService employeeInfoService;

    public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
        this.employeeInfoService = employeeInfoService;
    }

    @PostMapping("/send")
    public String sendEmployeeInfo(@RequestBody EmployeeInfoRequest employeeInfoRequest) {
        return employeeInfoService.sendEmployeeInfo(employeeInfoRequest);
    }

}
