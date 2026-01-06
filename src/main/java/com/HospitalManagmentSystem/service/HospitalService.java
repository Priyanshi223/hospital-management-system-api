package com.HospitalManagmentSystem.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.HospitalManagmentSystem.entity.HospitalEntity;
import com.HospitalManagmentSystem.entity.HospitalPatientList;
import com.HospitalManagmentSystem.entity.HospitalResponseDTO;
import com.HospitalManagmentSystem.entity.PatientResponseDTO;
import com.HospitalManagmentSystem.repository.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private RestTemplate restTemplate;

   
    public HospitalEntity addHospitalDetails(HospitalEntity hospital) {
        return hospitalRepository.save(hospital);
    }

    
    public List<HospitalPatientList> getAllHospitalDetails() {

        List<HospitalEntity> hospitalDetails = hospitalRepository.findAll();

        
        List<PatientResponseDTO> patientList = restTemplate
                .getForEntity("http://localhost:8082/patient/getAll", List.class)
                .getBody();

        if (hospitalDetails == null || hospitalDetails.isEmpty()) {
            System.out.println("No hospital details found");
            return null;
        }

        List<HospitalPatientList> hospitalPatientList = new ArrayList<>();

        HospitalPatientList list = new HospitalPatientList();
        list.setHospitalEntities(hospitalDetails);
        list.setPatientResponseDTOs(patientList);

        hospitalPatientList.add(list);

        System.out.println("Here is the list of hospital details with patients");
        return hospitalPatientList;
    }

    
    public HospitalResponseDTO findHospitalDetailsById(Integer id) {

       
        List<PatientResponseDTO> patientData = restTemplate
                .getForEntity("http://localhost:8082/patient/getAll", List.class)
                .getBody();

        HospitalEntity entity = hospitalRepository.findById(id).orElse(null);

        if (entity == null) {
            System.out.println("No hospital found with this id");
            return null;
        } else {
            HospitalResponseDTO response = new HospitalResponseDTO();
            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setLocation(entity.getLocation());
            response.setNumOfDepartments(entity.getNumOfDepartments());
            response.setContactNumber(entity.getContactNumber());
            response.setEmail(entity.getEmail());
            response.setPatientEntity(patientData);

            System.out.println("Hospital details with patients shown for id: " + id);
            return response;
        }
    }

    
    public void deleteHospitalDetailsById(Integer id) {
        HospitalEntity entity = hospitalRepository.findById(id).orElse(null);

        if (entity == null) {
            System.out.println("Hospital details not found for id: " + id);
        } else {
            hospitalRepository.deleteById(id);
            System.out.println("Hospital details deleted successfully");
        }
    }

   
    public HospitalEntity updateHospitalDetailById(Integer id,
                                                   String name,
                                                   String location,
                                                   Integer numOfDepartments,
                                                   String contactNumber,
                                                   String email) {

        HospitalEntity hospital = hospitalRepository.findById(id).orElse(null);

        if (hospital == null) {
            System.out.println("Hospital data not found for id: " + id);
            return null;
        } else {
            hospital.setName(name);
            hospital.setLocation(location);
            hospital.setNumOfDepartments(numOfDepartments);
            hospital.setContactNumber(contactNumber);
            hospital.setEmail(email);

            return hospitalRepository.save(hospital);
        }
    }
}
