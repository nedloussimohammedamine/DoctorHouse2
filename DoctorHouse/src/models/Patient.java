package models;

public class Patient {
  int id ;
  String name ;
  String mail ;
  String username ;
  String password ;
  
  
  
public Patient(String name, String mail, String username, String password) {
	super();
	
	this.name = name;
	this.mail = mail;
	this.username = username;
	this.password = password;
}
public Patient() {
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
  

}
