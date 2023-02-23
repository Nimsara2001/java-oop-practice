package Controller;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static Controller.ManagementFormController.*;

public class DashBoardFormController {
    public JFXButton btnMgtLog;
    public AnchorPane rootDashBoard;
    public AnchorPane rootAdminLogIn;
    public JFXButton btnAdminLogIn;
    public JFXButton btnAdminCancel;
    public Label timeLabel;
    public Label dateLabel;
    public ComboBox cmbSelectVehicle;
    public ComboBox cmbSelectDriver;
    public Label lblSlotNumber;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDeliveryShift;
    public Label lblSelectedVehicleType;
    public Label lblAutoSetMatchedDriver;
    public TextField txtMgtUserName;
    public PasswordField txtMgtPassword;
    private volatile boolean stop=false;

    public static String selectedVehicleNumberCmb; //Selected vehicle from Dashboard Cmb
    public static String selectedDriverNameCmb; //Selected driver from Dashboard Cmb

    public static String[] vanSlotArr=new String[]{"01","02","03","04","12","13"};
    public static int[] vanSlotState=new int[6];
    public static String busSlot="14";
    public static int busSlotState=0;
    public static String[] lorrySlotArr=new String[]{"05","06","07","08","09","10","11"};
    public static int[] lorrySlotState=new int[7];

    public void initialize(){
        TimeNow();
        rootAdminLogIn.setVisible(false);
        lblAutoSetMatchedDriver.setVisible(false);

        for (int i = 0; i < vArrayCount ; i++) {
            cmbSelectVehicle.getItems().addAll(vehicleArray[i].getVehicleNumber());
        }
        for (int i = 0; i <dArrayCount; i++) {
            cmbSelectDriver.getItems().addAll(driverArray[i].getDriverName());
        }
        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            this.selectedVehicleNumberCmb= (String) newValue;
            lblAutoSetMatchedDriver.setVisible(false);
            cmbSelectDriver.setVisible(true);
            afterSelectDriverOnDashBoard();
        }));

        cmbSelectDriver.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            this.selectedDriverNameCmb= (String) newValue;
            lblAutoSetMatchedDriver.setVisible(false);
            cmbSelectDriver.setVisible(true);
        }));

    }

    private void afterSelectDriverOnDashBoard(){
        for ( int i = 0; i < vArrayCount; i++) {
            if (selectedVehicleNumberCmb.equals(vehicleArray[i].getVehicleNumber())){
                lblSelectedVehicleType.setText("  "+vehicleArray[i].getVehicleType());
                if (vehicleArray[i].getVehicleState().equals("InParking")){
                    btnParkVehicle.setDisable(true);
                    btnOnDeliveryShift.setDisable(false);

                    lblSlotNumber.setText(vehicleArray[i].getSlotNumber());
                    break;
                }else if ((vehicleArray[i].getVehicleState().equals("OnDelivery"))){
                    btnOnDeliveryShift.setDisable(true);
                    btnParkVehicle.setDisable(false);

                    cmbSelectDriver.setVisible(false);
                    lblAutoSetMatchedDriver.setVisible(true);
                    lblAutoSetMatchedDriver.setText("  "+vehicleArray[i].getDriverOfVehicleNow());

                    if (lblSelectedVehicleType.getText().equals("  Van")){
                        for (int j = 0; j < vanSlotState.length; j++) {
                            if (vanSlotState[j]==0){
                                lblSlotNumber.setText(vanSlotArr[j]);
                                break;
                            }
                        }
                    }else if (lblSelectedVehicleType.getText().equals("  Cargo Lorry")){
                        for (int j = 0; j < lorrySlotState.length; j++) {
                            if (lorrySlotState[j]==0){
                                lblSlotNumber.setText(lorrySlotArr[j]);
                                break;
                            }
                        }
                    }
                }else {
                    btnParkVehicle.setDisable(false);
                    btnOnDeliveryShift.setDisable(false);
                    lblSlotNumber.setText(vehicleArray[i].getSlotNumber());
                    break;
                }
            }
        }
    }

    public void btnParkVehicleOnAction(ActionEvent actionEvent) throws IOException {
        btnParkVehicle.setDisable(true);
        btnOnDeliveryShift.setDisable(false);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setX(505.0);
        alert.setY(235.0);
        alert.setContentText("The vehicle was successfully parked..!");
        Optional<ButtonType> result = alert.showAndWait();

        loop1:
        for (int i = 0; i < vArrayCount; i++) {
            if (selectedVehicleNumberCmb.equals(vehicleArray[i].getVehicleNumber())){
                vehicleArray[i].setVehicleState("InParking");
                vehicleArray[i].setParkedOrLeftTime(returnDateTime());
                vehicleArray[i].setSlotNumber(lblSlotNumber.getText());

                if (lblSelectedVehicleType.getText().equals("  Van")){
                    for (int j = 0; j < vanSlotArr.length; j++) {
                        if (lblSlotNumber.getText().equals(vanSlotArr[j])){
                            vanSlotState[j]=1;
                            break loop1;
                        }
                    }
                }else if (lblSelectedVehicleType.getText().equals("  Cargo Lorry")){
                    for (int j = 0; j < lorrySlotState.length; j++) {
                        if (lblSlotNumber.getText().equals(lorrySlotArr[j])){
                            lorrySlotState[j]=1;
                            break loop1;
                        }
                    }
                }else {
                    busSlotState=1;
                    break loop1;
                }
            }
        }

        Parent parent= FXMLLoader.load(this.getClass().getResource("../View/DashBoardForm.fxml"));
        Scene scene=new Scene(parent);

        Stage primaryStage=(Stage) this.rootDashBoard.getScene().getWindow();
        primaryStage.setScene(scene);

    }

    public void btnOnDeliveryShiftOnAction(ActionEvent actionEvent) throws IOException {
        btnOnDeliveryShift.setDisable(true);
        btnParkVehicle.setDisable(false);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setX(505.0);
        alert.setY(235.0);
        alert.setContentText("The vehicle was successfully dispatched..!");
        Optional<ButtonType> result = alert.showAndWait();

        loop1:
        for (int i = 0; i < vArrayCount; i++) {
            if (selectedVehicleNumberCmb.equals(vehicleArray[i].getVehicleNumber())){
                vehicleArray[i].setVehicleState("OnDelivery");
                vehicleArray[i].setParkedOrLeftTime(returnDateTime());
                vehicleArray[i].setDriverOfVehicleNow(selectedDriverNameCmb);

                if (lblSelectedVehicleType.getText().equals("  Van")){
                    for (int k = 0; k < vanSlotArr.length; k++) {
                        if (lblSlotNumber.getText().equals(vanSlotArr[k])){
                            vanSlotState[k]=0;
                            break loop1;
                        }
                    }
                }else if (lblSelectedVehicleType.getText().equals("  Cargo Lorry")){
                    for (int k = 0; k < lorrySlotArr.length; k++) {
                        if (lblSlotNumber.getText().equals(lorrySlotArr[k])){
                            lorrySlotState[k]=0;
                            break loop1;
                        }
                    }
                }else {
                    if (lblSlotNumber.getText().equals("14")){
                        busSlotState=0;
                        break loop1;
                    }
                }
            }
        }

        Parent parent= FXMLLoader.load(this.getClass().getResource("../View/DashBoardForm.fxml"));
        Scene scene=new Scene(parent);

        Stage primaryStage=(Stage) this.rootDashBoard.getScene().getWindow();
        primaryStage.setScene(scene);
    }

    public void btnMgtLogOnAction(ActionEvent actionEvent)  {
        rootAdminLogIn.setVisible(true);
    }

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {
        if (txtMgtUserName.getText().equals("admin") && txtMgtPassword.getText().equals("1234")){
            Parent parent= FXMLLoader.load(this.getClass().getResource("../View/ManagementForm.fxml"));
            Scene scene=new Scene(parent);

            Stage primaryStage=(Stage) this.rootDashBoard.getScene().getWindow();
            primaryStage.setScene(scene);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Log In Error");
            alert.setX(505.0);
            alert.setY(235.0);
            alert.setContentText("Please Enter Valid Details..");
            Optional<ButtonType> result = alert.showAndWait();
            txtMgtUserName.clear();
            txtMgtPassword.clear();
        }
    }

    public void btnAdminCancelOnAction(ActionEvent actionEvent) {
        rootAdminLogIn.setVisible(false);
    }

    public String returnDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm a");
        Date date = new Date();
        return formatter.format(date);
    }

    public void TimeNow(){
        Thread thread=new Thread(() ->{
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat(" hh:mm:ss a");
            SimpleDateFormat date=new SimpleDateFormat("                      dd/MM/yyyy");
            while (!stop){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
                final String timeNow=simpleDateFormat.format(new Date());
                final String dateNow=date.format(new Date());
                Platform.runLater(() ->{
                    timeLabel.setText(timeNow);
                    dateLabel.setText(dateNow);
                });
            }
        });
        thread.start();
    }
}
