package com.HospitalManagmentSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HospitalManagmentSystem.entity.HospitalEntity;
import com.HospitalManagmentSystem.entity.HospitalPatientList;
import com.HospitalManagmentSystem.entity.HospitalResponseDTO;
import com.HospitalManagmentSystem.service.HospitalService;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

  
    @PostMapping("/addHospitalDetails")
    public HospitalEntity insertHospitalDetails(@RequestBody HospitalEntity hospital) {
        HospitalEntity entity = hospitalService.addHospitalDetails(hospital);

        if (entity == null) {
            return null;
        } else {
            return entity;
        }
    }

   
    @GetMapping("/getAll")
    public List<HospitalPatientList> getAllHospitalDetails() {
        return hospitalService.getAllHospitalDetails();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<HospitalResponseDTO> findHospitalById(@PathVariable Integer id) {
        HospitalResponseDTO hospitalResponse = hospitalService.findHospitalDetailsById(id);
        return ResponseEntity.ok(hospitalResponse);
    }


    @PutMapping("/update/{id}")
    public HospitalEntity updateHospital(
            @PathVariable Integer id,
            @RequestBody HospitalEntity updatedHospital) {

        return hospitalService.updateHospitalDetailById(
                id,
                updatedHospital.getName(),
                updatedHospital.getLocation(),
                updatedHospital.getNumOfDepartments(),
                updatedHospital.getContactNumber(),
                updatedHospital.getEmail()
        );
    }

  
    @DeleteMapping("/delete/{id}")
    public void deleteHospital(@PathVariable Integer id) {
        hospitalService.deleteHospitalDetailsById(id);
    }
}
