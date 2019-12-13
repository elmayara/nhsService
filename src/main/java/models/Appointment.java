package models;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="Appointment")
public class Appointment {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id=0;
	private Integer patientId;
	private String date;
	private Integer dr;//id of the doctor
	private String loc;
	
	public Appointment(Integer id, Integer patientId, String date, Integer dr, String loc) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.date = date;
		this.dr = dr;
		this.loc = loc;
	}

	public Appointment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDr() {
		return dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
	

}
