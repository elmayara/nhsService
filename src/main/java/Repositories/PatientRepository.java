package Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import models.Patient;

public interface PatientRepository extends CrudRepository <Patient,Integer> {
	List<Patient> findById(int id);
}
