package Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import models.Doctor;

public interface DoctorRepository extends CrudRepository <Doctor,Integer>{
	List<Doctor>findById(int id);
}
