package models;

public class Doctor {
     int id;
     String  speciality;
     String  username;
     String  password;
     boolean Disponibilite;
     
     
     public Doctor(int id, String speciality, String username, String password, boolean disponibilite) {
 		super();
 		this.id = id;
 		this.speciality = speciality;
 		this.username = username;
 		this.password = password;
 		Disponibilite = disponibilite;
 	}
     public Doctor(int id, String username,String speciality,  boolean disponibilite) {
  		super();
  		this.id = id;
  		this.username = username;
  		this.speciality = speciality;
  		Disponibilite = disponibilite;
  	}
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isDisponibilite() {
		return Disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		Disponibilite = disponibilite;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
	