package com.hr.financemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "children_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildrenDetails {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String age;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
