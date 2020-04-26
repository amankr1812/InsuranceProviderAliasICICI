
package com.demo.controller;

import com.demo.entity.Insurance;
import com.demo.exception.ResourceNotFoundException;
import com.demo.exception.TypeMismatchException;
import com.demo.repos.InsuranceRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

	@Autowired
	private InsuranceRepository InsuranceRepository;

	@GetMapping("/insurance")
	public List<Insurance> getAllInsurance() {
		return InsuranceRepository.findAll();
	}

	@GetMapping("/insurance/{id}")
	  public <T> ResponseEntity<Insurance> getInsuranceProvidersById(@PathVariable(value = "id") T insuranceId)
	      throws ResourceNotFoundException,TypeMismatchException,Exception {
	      long id;
	      String value;
	      value=(String) insuranceId;
	      try{
	          id=Long.parseLong(value);
	      }catch(Exception e) {
	          throw new TypeMismatchException("Data Type Mismatch on the given ID");
	      }
	           Insurance insurance =
	                        InsuranceRepository
	                      .findById(id)
	                      .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
	              return ResponseEntity.ok().body(insurance);
	                 
	     
	  }
	
	@GetMapping("/insurance/filter/{filter}")
	  public <T> List<Insurance> getInsuranceProvidersByFilter(@PathVariable(value = "filter") T filter)
	  {
	
		  String value;
	      value=(String) filter;
	      
	      List<Insurance> list = new ArrayList<>();
			if(value.equalsIgnoreCase("all")){
				list=getAllInsurance();
			}
			else {
			for(Insurance ins:getAllInsurance()) {
				String temp=ins.getInsuranceType().toLowerCase(); // life, health, vehicle(4 wheeler, 2 wheeler) etc
				if(temp.contains(value)) {
					list.add(ins);
				}
			}
			}
			
		System.out.println(list);
	      	return list;
		  
	  }
	
	
	@PostMapping("/insurance")
	public Insurance createUser(@Valid @RequestBody Insurance insurance) {
		return InsuranceRepository.save(insurance);
	}

	@PutMapping("/insurance/{id}")
	public ResponseEntity<Insurance> updateUser(@PathVariable(value = "id") Long insuranceId,
			@Valid @RequestBody Insurance userDetails) throws ResourceNotFoundException {

		Insurance insurance = InsuranceRepository.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance not found on :: " + insuranceId));

		insurance.setInsuranceValid(userDetails.getInsuranceValid());
		insurance.setPlan_name(userDetails.getPlan_name());
		insurance.setInsuranceType(userDetails.getInsuranceType());
		insurance.setInsuranceCompany(userDetails.getInsuranceCompany());
		insurance.setAnnualPremium(userDetails.getAnnualPremium());
		final Insurance updatedInsurance = InsuranceRepository.save(insurance);
		return ResponseEntity.ok(updatedInsurance);
	}

	@DeleteMapping("/insurance/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long insuranceId) throws Exception {
		Insurance insurance = InsuranceRepository.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance not found on :: " + insuranceId));

		InsuranceRepository.delete(insurance);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
