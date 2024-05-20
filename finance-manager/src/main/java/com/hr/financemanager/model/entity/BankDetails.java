package com.hr.financemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "bank_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDetails
{

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String bankName;
        private String employeeBankAccountNumber;
        private String employeeAccountName;
        private Timestamp createdAt;
        private Timestamp updatedAt;

}

