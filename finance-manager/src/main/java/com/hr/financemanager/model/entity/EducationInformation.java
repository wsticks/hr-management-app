package com.hr.financemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "educational_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationInformation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String qualification;
    private String institutionName;
    private String courseOfStudy;
    private  String grade;
    private  Timestamp createdAt;
    private Timestamp updatedAt;
}
