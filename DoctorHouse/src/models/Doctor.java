package models;

import javafx.beans.property.SimpleBooleanProperty;

public class Doctor {
     int id;
     String  speciality;
     String  username;
     String  password;
     SimpleBooleanProperty Disponibilite = new SimpleBooleanProperty();
     
     
     public Doctor(int id, String speciality, String username, String password, boolean disponibilite) {
 		super();
 		this.id = id;
 		this.speciality = speciality;
 		this.username = username;
 		this.password = password;
 		Disponibilite.set(disponibilite);
 	}
     public Doctor(int id, String username,String speciality,  boolean disponibilite) {
  		super();
  		this.id = id;
  		this.username = username;
  		this.speciality = speciality;
  		Disponibilite.set(disponibilite);
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
		return Disponibilite.get();
	}
	public void setDisponibilite(boolean disponibilite) {
		Disponibilite.set(disponibilite);
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isDisponibilite(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
	