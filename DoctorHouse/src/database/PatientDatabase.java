package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Database;
import models.Patient;

public class PatientDatabase {
	static Connection con = Database.getConnection();
	
		
		public Patient getPatient(String username) throws SQLException  {
			   System.out.println(username);
				String query
		        = "select * from patient where username = ?";
				PreparedStatement ps
					= con.prepareStatement(query);

				ps.setString(1,username);
				Patient patient = new Patient();
				
				ResultSet rs = ps.executeQuery();
				
				boolean check = false;
		      
				while (rs.next()) {
		        check = true;
		        patient.setMail(rs.getString("mail"));
		        patient.setName(rs.getString("Name"));
		        patient.setPassword(rs.getString("password"));
		        patient.setUsername(rs.getString("username"));
		        patient.setId(rs.getInt("idPatient"));
				}
				if (check) {
					return patient;
				}
				else	return null;
			}	
		
		
		
	}


