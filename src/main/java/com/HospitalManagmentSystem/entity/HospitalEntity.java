package com.HospitalManagmentSystem.entity;




import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hospital_tbl")
public class HospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id", unique = true)
    private Integer id;

    @Column(name = "hospital_name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "num_of_departments")
    private Integer numOfDepartments;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;
}
