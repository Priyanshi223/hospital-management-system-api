package com.HospitalManagmentSystem.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponseDTO {

	private Integer id;

	private String name;

	private String location;

	private Integer numOfDepartments;

	private String contactNumber;

	private String email;

	private List<PatientResponseDTO> patientEntity;

}
