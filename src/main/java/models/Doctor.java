package models;

import javax.persistence.*;

@Entity
@Table(name="Doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id=0;
	private String nam;
	private String surn;
	private String email;
	private String phys;
	private String hosp;
	
	public Doctor(Integer id, String nam, String surn, String email, String phys, String hosp) {
		super();
		this.id = id;
		this.nam = nam;
		this.surn = surn;
		this.email = email;
		this.phys = phys;
		this.hosp = hosp;
	}
	
	public Doctor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	public String getSurn() {
		return surn;
	}

	public void setSurn(String surn) {
		this.surn = surn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhys() {
		return phys;
	}

	public void setPhys(String phys) {
		this.phys = phys;
	}

	public String getHosp() {
		return hosp;
	}

	public void setHosp(String hosp) {
		this.hosp = hosp;
	}
}
