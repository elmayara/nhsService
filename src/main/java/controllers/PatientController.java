package controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Patient;
import Repositories.PatientRepository;
import controllers.Status;


@Controller
@RequestMapping()
public class PatientController {

	@Autowired 
	private PatientRepository patientRepository;
	
	@CrossOrigin
	@PostMapping(path="/addP")
	public @ResponseBody Patient addP(@RequestBody Patient patient) {
		patientRepository.save(patient);
		return patient;		
	}
	
	@CrossOrigin
	@GetMapping(path="/allP")
	public @ResponseBody Iterable<Patient>getAllPatients(){
		return patientRepository.findAll();
	}
	
	@CrossOrigin
	@DeleteMapping(path="/DltPatient/{id}")
	public @ResponseBody Object deletePa(@PathVariable("id") Integer id) {
		if(patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
			return new Status(200,"ok");
		}
		return new Status(404,"The patient doesn't exist");
	}
}
