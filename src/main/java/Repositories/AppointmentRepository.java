package Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import models.Appointment;
public interface AppointmentRepository extends CrudRepository <Appointment, Integer> {
	List<Appointment> findById(int id);
}
