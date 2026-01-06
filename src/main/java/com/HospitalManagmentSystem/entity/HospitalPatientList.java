package com.HospitalManagmentSystem.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalPatientList {

	private List<HospitalEntity> hospitalEntities;
	private List<PatientResponseDTO> patientResponseDTOs;
}
