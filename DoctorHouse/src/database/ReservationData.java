package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Reservation;

public class ReservationData {
	static Connection con = Database.getConnection();
	ObservableList<Reservation> reservations;
     public void addReservation(Reservation reservation) throws SQLException {
		
		String query
        = "insert into reservation(DateReservation, "
          + "Patient_idPatient,doctor_ID) VALUES (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setTimestamp(1, reservation.getDateR());
		ps.setInt(2, reservation.getPatient());
		ps.setInt(3, reservation.getDoctor());
		ps.executeUpdate();
		System.out.println("Reservation created");
		
	}
     public void deleteReservation(Reservation reservation) throws SQLException {
    	 String query
    	 = "delete from reservation(idReservation, "
    	   + "DateReservation,Patient_idPatient,doctor_ID) VALUES (?, ?, ?)";
    	 PreparedStatement ps = con.prepareStatement(query);
    	 ps.setInt(1, reservation.getIdR());
    	 ResultSet rs = ps.executeQuery();
	     reservations=FXCollections.observableArrayList();
	     reservations.remove(reservation);
    	 System.out.println("Reservation Supressed");
    	 
    	    while(rs.next()) {
    	    Reservation reservations = new Reservation();
        	reservations.setDoctor(rs.getInt("idReservation"));
        	reservations.setDateR(rs.getTimestamp("DateReservation"));; 
        	reservations.setIdR(rs.getInt("Patient_idPatient"));
        	reservations.setIdR(rs.getInt("Doctor_ID"));
        	System.out.println(reservations.getDateR().toString());
    	 }
     }
     public ObservableList<Reservation> getAllReservations(int id) throws SQLException {
    	 System.out.println("get all");
		 String query = "select * from reservation where Patient_idPatient = ?";
	        PreparedStatement ps= con.prepareStatement(query);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        reservations=FXCollections.observableArrayList();
	  
	        while (rs.next()) {

           	Reservation reservation = new Reservation();
           	reservation.setDoctor(rs.getInt("doctor_ID"));
           	reservation.setPatient(id);
           	reservation.setDateR(rs.getTimestamp("DateReservation"));; 
           	reservation.setIdR(rs.getInt("idReservation"));
           	System.out.println(reservation.getDateR().toString());
    		reservations.add(reservation);
		
	}
	        return reservations;

	}
     

}
