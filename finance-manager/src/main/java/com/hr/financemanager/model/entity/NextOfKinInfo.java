package com.hr.financemanager.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "next_of_kin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NextOfKinInfo {

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        String firstname;
        String lastname;
        String address;
        String phoneNumber;
        String relationship;
        @CreationTimestamp
        private Timestamp createdAt;
        @UpdateTimestamp
        private Timestamp updatedAt;
}
