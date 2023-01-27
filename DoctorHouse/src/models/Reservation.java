package models;

import java.sql.Timestamp;
import java.time.Instant;

public class Reservation {
    int idR;
    
   
    Timestamp DateR;
    int Patient;
    public Timestamp getDateR() {
		return DateR;
	}
	public void setDateR(Timestamp dateR) {
		DateR = dateR;
	}
	int Doctor;
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	
	public int getPatient() {
		return Patient;
	}
	public void setPatient(int patient) {
		Patient = patient;
	}
	public int getDoctor() {
		return Doctor;
	}
	public void setDoctor(int doctor) {
		Doctor = doctor;
	}
	public Reservation(int patient, int doctor) {
		super();
		 Instant instant = Instant.now();
		DateR = Timestamp.from(instant);
	
		Patient = patient;
		Doctor = doctor;
	}
	public Reservation() {
		super();
		 Instant instant = Instant.now();
			DateR = Timestamp.from(instant);
	}
	
    
    
}
