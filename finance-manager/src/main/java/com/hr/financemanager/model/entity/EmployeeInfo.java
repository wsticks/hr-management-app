package com.hr.financemanager.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String dateOfBirth;
    private float employeeKycPoint;
    private String department;
    private String employmentDate;
    private boolean employeeApproved;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private List<BankDetails> bankDetails;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private List<EducationInformation> educationInformation;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private List<NextOfKinInfo> nextOfKinInfo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private List<ChildrenDetails> childrenDetails;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
