package models;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="Patient")
public class Patient {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id=0;
	private String nam;
	private String surn;
	private String email;
	private String addrs;
	private String postcode;
	private String gender;
	private String DoB;//Date of Birth
	private String tlf;
	private String RBCs;
	private String meds;
	private String nin;//national insurance number
	
	
	public Patient(Integer id, String nam, String surn, String email, String addrs, String postcode, String tlf,
			String rBCs, String meds) {
		super();
		this.id = id;
		this.nam = nam;
		this.surn = surn;
		this.email = email;
		this.addrs = addrs;
		this.postcode = postcode;
		this.tlf = tlf;
		RBCs = rBCs;
		this.meds = meds;
	}

	public Patient() {}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nam
	 */
	public String getNam() {
		return nam;
	}

	/**
	 * @param nam the nam to set
	 */
	public void setNam(String nam) {
		this.nam = nam;
	}

	/**
	 * @return the surn
	 */
	public String getSurn() {
		return surn;
	}

	/**
	 * @param surn the surn to set
	 */
	public void setSurn(String surn) {
		this.surn = surn;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the addrs
	 */
	public String getAddrs() {
		return addrs;
	}

	/**
	 * @param addrs the addrs to set
	 */
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the tlf
	 */
	public String getTlf() {
		return tlf;
	}

	/**
	 * @param tlf the tlf to set
	 */
	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	/**
	 * @return the rBCs
	 */
	public String getRBCs() {
		return RBCs;
	}

	public void setRBCs(String rBCs) {
		RBCs = rBCs;
	}

	/**
	 * @return the meds
	 */
	public String getMeds() {
		return meds;
	}

	/**
	 * @param meds the meds to set
	 */
	public void setMeds(String meds) {
		this.meds = meds;
	}
	
	
	
	
	
	
}
