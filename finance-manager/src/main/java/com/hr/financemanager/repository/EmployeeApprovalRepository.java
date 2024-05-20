package com.hr.financemanager.repository;

import com.hr.financemanager.model.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface EmployeeApprovalRepository extends JpaRepository<EmployeeInfo, Integer> {


}
