package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.cj.MysqlConnection;
import com.mysql.cj.protocol.Resultset;

import application.Database;
import database.DoctorDatabase;
import database.PatientDatabase;
import database.ReservationData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Doctor;
import models.Patient;
import models.Reservation;

public class medecinscontroll implements Initializable{
	
	@FXML
	private TableView<Doctor> tbview;

    @FXML
    private TableColumn<Doctor, Boolean> disponibility;

    @FXML
    private TableColumn<Doctor, Integer> id;

    @FXML
    private TableColumn<Doctor, String> name;

    @FXML
    private TableColumn<Doctor, String> speciality;


    
    ObservableList<Doctor> ListM;
    int index = -1 ;
    Connection conn = null;
    Resultset rs = null;
    PreparedStatement pst = null;
    private static ReservationData reservationData = new ReservationData();
    private static Doctor doctor;
    DoctorDatabase doc = new DoctorDatabase();
    
    public static Doctor getDoctor() {
		return doctor;
	}

	public static void setDoctor(Doctor doctor) {
		medecinscontroll.doctor = doctor;
	}

	public static ReservationData getReservationData() {
		return reservationData;
	}

	public static void setReservationData(ReservationData reservationData) {
		medecinscontroll.reservationData = reservationData;
	}

	@FXML
    void commander(ActionEvent event) throws SQLException, IOException {
        doctor = tbview.getSelectionModel().getSelectedItem();
        doctor.setDisponibilite(false);
        doc.isDispo(doctor);
        Reservation reserv = new Reservation(logincontrol.getPt().getId(),doctor.getId());
        reservationData.addReservation(reserv);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Reservations.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
		
        
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	id.setCellValueFactory(new PropertyValueFactory<Doctor,Integer>("id"));
    	name.setCellValueFactory(new PropertyValueFactory<Doctor,String>("username"));
    	speciality.setCellValueFactory(new PropertyValueFactory<Doctor,String>("speciality"));
    	disponibility.setCellValueFactory(new PropertyValueFactory<Doctor,Boolean>("Disponibilite"));
    	
    	
    	tbview.getItems().setAll(doc.getDataDoctor());
    	
    	
    }
    
    @FXML
    void back(ActionEvent e) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Accueil.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
    }

    
}


