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
import Repositories.AppointmentRepository;
import Repositories.DoctorRepository;
import Repositories.PatientRepository;
import controllers.Status;


@Controller
@RequestMapping()
public class MainController {

	@Autowired
	private  AppointmentRepository appointmentRepository ;
	
	@Autowired
	private  DoctorRepository doctorRepository ;
	
	@Autowired
	private  PatientRepository patientRepository ;
	
	@GetMapping(path="/t")
	public @ResponseBody String ts() {
		return "Test";
	}
	
}
