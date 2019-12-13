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

import models.Doctor;
import models.Patient;
import Repositories.DoctorRepository;
import controllers.Status;

@Controller
@RequestMapping()
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	@CrossOrigin
	@PostMapping(path="/addD")
	public @ResponseBody Doctor addD(@RequestBody Doctor doctor) {
		doctorRepository.save(doctor);
		return doctor;		
	}
	@CrossOrigin
	@GetMapping(path="/allD")
	public @ResponseBody Iterable<Doctor>getAllDoctors(){
		return doctorRepository.findAll();
	}
	@CrossOrigin
	@DeleteMapping(path="/DltDoctor/{id}")
	public @ResponseBody Object deleteDoc(@PathVariable("id") Integer id) {
		if(doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return new Status(200,"ok");
		}
		return new Status(404,"The doctor doesn't exist");
	}
}
