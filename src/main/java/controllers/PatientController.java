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


import models.Patient;
import Repositories.PatientRepository;
import controllers.Status;


@Controller
@RequestMapping()
public class PatientController {

	@Autowired 
	private PatientRepository patientRepository;
	
	@CrossOrigin
	@PostMapping(path="/addPa")
	public @ResponseBody Patient addP(@RequestBody Patient patient) {
		patientRepository.save(patient);
		return patient;		
	}
	
	@CrossOrigin
	@GetMapping(path="/allPa")
	public @ResponseBody Iterable<Patient>getAllPatients(){
		return patientRepository.findAll();
	}
	
	@CrossOrigin
	@PutMapping(path="/UpdPa")
	public @ResponseBody Object updatePatient (@RequestBody Patient newPatient) {
		
		if(newPatient.getId()==null) {
			return new Status(0, "Id not defined in the request");
		}
		
		Optional<Patient> newOpcionalPatient = patientRepository.findById(newPatient.getId());

		if(!newOpcionalPatient.isPresent()) {
			return new Status(404,"Doctor not found");
		}
		
		Patient newOpcionalPatients=newOpcionalPatient.get();
		
		if(newPatient.getNam()!=null) {
			newPatient.setNam(newPatient.getNam());
		}
		
		if(newPatient.getSurn()!=null) {
			newPatient.setSurn(newPatient.getSurn());
		}
		
		
		if(newPatient.getEmail()!=null) {
			newPatient.setEmail(newPatient.getEmail());
		}
		
		if(newPatient.getAddrs()!=null) {
			newPatient.setAddrs(newPatient.getAddrs());
		}
		
		if(newPatient.getMeds()!=null) {
			newPatient.setMeds(newPatient.getMeds());
		}
		
		if(newPatient.getPostcode()!=null) {
			newPatient.setPostcode(newPatient.getPostcode());
		}
		
		if(newPatient.getRBCs()!=null) {
			newPatient.setRBCs(newPatient.getRBCs());
		}
		
		if(newPatient.getTlf()!=null) {
			newPatient.setTlf(newPatient.getTlf());
		}
		
		return patientRepository.save(newPatient);
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
