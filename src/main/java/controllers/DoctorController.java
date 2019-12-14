package controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Appointment;
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
	@PostMapping(path="/addDr")
	public @ResponseBody Doctor addD(@RequestBody Doctor doctor) {
		doctorRepository.save(doctor);
		return doctor;		
	}
	
	@CrossOrigin
	@GetMapping(path="/allDr")
	public @ResponseBody Iterable<Doctor>getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	@CrossOrigin
	@PutMapping(path="/UpdDR")
	public @ResponseBody Object updateDoctor (@RequestBody Doctor newDoctor){
		
		if(newDoctor.getId()==null) {
			return new Status(0,"Id not defined in the request");
		}
		
		Optional<Doctor> newOpcionalDoctor = doctorRepository.findById(newDoctor.getId());

		if(!newOpcionalDoctor.isPresent()) {
			return new Status(404,"Doctor not found");
		}
		
		Doctor newOpcionalDoctors=newOpcionalDoctor.get();
		
		if(newDoctor.getNam()!=null) {
			newDoctor.setNam(newDoctor.getNam());
		}
		
		if(newDoctor.getSurn()!=null) {
			newDoctor.setSurn(newDoctor.getSurn());
		}
		
		if(newDoctor.getEmail()!=null) {
			newDoctor.setEmail(newDoctor.getEmail());
		}
		
		if(newDoctor.getHosp()!=null) {
			newDoctor.setHosp(newDoctor.getHosp());
		}
		
		if(newDoctor.getPhys()!=null) {
			newDoctor.setPhys(newDoctor.getPhys());
		}
		
		return doctorRepository.save(newDoctor);
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
