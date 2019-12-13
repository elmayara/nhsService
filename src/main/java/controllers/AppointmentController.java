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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Appointment;
import Repositories.AppointmentRepository;
import controllers.Status;



@Controller 
@RequestMapping()
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository appointmentRepository ;
	
	
	@CrossOrigin
	@PostMapping(path="/addAp")
	public @ResponseBody Appointment addAp(@RequestBody Appointment appointment) {
		appointmentRepository.save(appointment);
		return appointment;		
	}
	
	@CrossOrigin
	@GetMapping(path="/allAp")
	public @ResponseBody Iterable<Appointment>getAllAppointment(){
		return appointmentRepository.findAll();
	}
	
	@CrossOrigin
	@DeleteMapping(path="/DltAppointment/{id}")
	public @ResponseBody Object deleteApp(@PathVariable("id") Integer id) {
		if(appointmentRepository.existsById(id)) {
			appointmentRepository.deleteById(id);
			return new Status(200,"ok");
		}
		return new Status(404,"This appointment doesn't exist");
	}
	

}
