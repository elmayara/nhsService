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
	@PutMapping(path="/UpdAp")
	public @ResponseBody Object updateAppointment (@RequestBody Appointment newAppointment ) {
		
		if(newAppointment.getId()==null) {
			return new Status(0,"Id not defined in the request");
		}		
		Optional<Appointment> newOpcionalAppointment = appointmentRepository.findById(newAppointment.getId());

		if(!newOpcionalAppointment.isPresent()) {
			return new Status(404,"Appointment not found");
		}
		
		Appointment newAppointments=newOpcionalAppointment.get();
		
		if(newAppointment.getPatientId()!=null) {
			newAppointments.setPatientId(newAppointment.getPatientId());
		}
		
		if(newAppointment.getLoc()!=null) {
			newAppointments.setLoc(newAppointment.getLoc());
		}
		
		if(newAppointment.getDr()!=null) {
			newAppointments.setDr(newAppointment.getDr());
		}
		
		if(newAppointment.getDate()!=null) {
			newAppointments.setDate(newAppointment.getDate());
		}
				
		return appointmentRepository.save(newAppointment);
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
