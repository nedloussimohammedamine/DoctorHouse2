package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import database.DoctorDatabase;
import database.ReservationData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Doctor;
import models.Reservation;

public class reservationscontroll implements Initializable {
	private static Reservation reservation;
	private static ReservationData reservationData = new ReservationData();
	ReservationData doc = new ReservationData();
	
	 	public static Reservation getReservation() {
			return reservation;
		}

		public static void setReservation(Reservation reservation) {
			reservationscontroll.reservation = reservation;
		}
		
		

    @FXML
    private TableColumn<Reservation, Timestamp> date;

    @FXML
    private Button annuler_reservation;

    @FXML
    private Button back;

    @FXML
    private TableColumn<Reservation, Integer> doctor_name;

    @FXML
    private TableColumn<Reservation, Integer> id;

    @FXML
    private TableColumn<Reservation, String> name;

    @FXML
    private TableView<Reservation> tbview;
    
    @FXML
    private Button mettre_fin;
    
    public static ReservationData getReservationData() {
		return reservationData;
	}

	public static void setReservationData(ReservationData reservationData) {
		reservationscontroll.reservationData = reservationData;
	}

    @FXML
    void annuler_reservation(ActionEvent event) throws SQLException {
    	 Reservation selectedReservation = tbview.getSelectionModel().getSelectedItem();
    	 DoctorDatabase doctor  = new DoctorDatabase();
    	 Doctor docmodel = doctor.getDoctor(selectedReservation.getDoctor());
    	 docmodel.setDisponibilite(true);
      doctor.isDispo(docmodel);	
    	reservationData.deleteReservation(selectedReservation);
    	
    	tbview.getItems().setAll(medecinscontroll.getReservationData().getAllReservations());
    	
    }
    @FXML
    void mettre_fin(ActionEvent event) throws SQLException {
   	    Reservation selectedReservation = tbview.getSelectionModel().getSelectedItem();
     	reservationData.deleteReservation(selectedReservation);
     	tbview.getItems().setAll(medecinscontroll.getReservationData().getAllReservations());
    }

    @FXML
    void back(ActionEvent e) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/interfaces/Accueil.fxml"));
        Stage stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
    	stage.show();
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		date.setCellValueFactory(new PropertyValueFactory<Reservation,Timestamp>("DateR"));
		doctor_name.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("Doctor"));
		name.setCellValueFactory(new PropertyValueFactory<Reservation,String>("Patient"));
		id.setCellValueFactory(new PropertyValueFactory<Reservation,Integer>("idR"));
		System.out.println(medecinscontroll.getReservationData());
		try {
			tbview.getItems().setAll(medecinscontroll.getReservationData().getAllReservations());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
