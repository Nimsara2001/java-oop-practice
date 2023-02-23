package Controller;
import Tm.InParkingTM;
import Tm.OnDeliveryTM;
import Tm.driverListTM;
import Tm.vehicleListTM;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import static Controller.DashBoardFormController.*;

public class ManagementFormController{
    public AnchorPane rootMgtBoard;
    public ComboBox cmbSelectMode;
    public JFXButton btnAddVehicle;
    public JFXButton btnAddDriver;
    public JFXButton btnLogOut;
    public AnchorPane rootAddVehicle;
    public ComboBox<String> cmbVehicleType;
    public JFXButton btnAddVehicleCancel;
    public JFXButton btnAddDriverCancel;
    public AnchorPane rootAddDriver;
    public TextField txtDriverNic;
    public TextField txtDriverLicense;
    public TextField txtDriverAddress;
    public TextField txtDriverName;
    public TextField txtDriverContact;
    public TextField txtVehicleNumber;
    public TextField txtVehicleWeight;
    public TextField txtVehiclePassengers;
    public JFXButton btnAddVehicleDetails;

    public static Vehicle[] vehicleArray=new Vehicle[14];
    public static Driver[] driverArray=new Driver[16];

    public static  int vArrayCount;
    public static  int dArrayCount;

    public Label frameVehicleListImg;
    public Label frameVehicleModeCmb;
    public Label frameDriverListImg;
    public Label frameAddVehicleBtn;
    public Label frameAddDriverBtn;
    public Label frameLogOutBtn;

    private String VehicleType;
    private String SelectMode;
    int vlTable=0,dlTable=0,OnDTable=0,OnPTable=0;
    public JFXButton btnAddDriverDetails;
    public TableView <OnDeliveryTM> tblOnDelivery;
    public TableView <InParkingTM> tblOnParking;
    public TableView <vehicleListTM> tblVehicleList;
    public TableView <driverListTM> tblDriverList;

    public void initialize(){
        rootAddVehicle.setVisible(false);
        rootAddDriver.setVisible(false);

        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(false);

        tblOnDelivery.setVisible(true);
        tblOnParking.setVisible(false);
        tblVehicleList.setVisible(false);
        tblDriverList.setVisible(false);

        cmbSelectMode.getItems().addAll("On Delivery","In Parking");
        cmbVehicleType.getItems().addAll("Van","Cargo Lorry","Bus");
        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            this.VehicleType=newValue;
        }));
        cmbSelectMode.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            this.SelectMode= (String) newValue;

            if (SelectMode.equals("On Delivery")){
                OnDTable=vArrayCount;
                loadOnDeliveryTable();
                OnDTable++;
                tblOnDelivery.setVisible(true);
                tblOnParking.setVisible(false);
                tblDriverList.setVisible(false);
                tblVehicleList.setVisible(false);
            }else {
                OnPTable=vArrayCount;
                loadInParkingTable();
                OnPTable++;
                tblOnParking.setVisible(true);
                tblOnDelivery.setVisible(false);
                tblDriverList.setVisible(false);
                tblVehicleList.setVisible(false);
            }
        }));

        tblVehicleList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("VlNumber"));
        tblVehicleList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("VlType"));
        tblVehicleList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("VlMaxWeight"));
        tblVehicleList.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("VlNoPassengers"));

        tblDriverList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("DlNic"));
        tblDriverList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("DlName"));
        tblDriverList.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("DlLicNo"));
        tblDriverList.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("DlAddress"));
        tblDriverList.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("DlContactNo"));

        tblOnDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("OnDeliveryVehicleNumber"));
        tblOnDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("OnDeliveryVehicleType"));
        tblOnDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("OnDeliveryDriverName"));
        tblOnDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("OnDeliveryLeftTime"));

        tblOnParking.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("InParkingVehicleNumber"));
        tblOnParking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("InParkingVehicleType"));
        tblOnParking.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("InParkingSlot"));
        tblOnParking.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("InParkingTime"));

        loadVehicleListTable();
        loadDriverListTable();
        loadOnDeliveryTable();
        loadInParkingTable();

    }

    public void btnAddVehicalOnAction(ActionEvent actionEvent) {
        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(true);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(false);

        rootAddVehicle.setVisible(true);
        rootAddDriver.setVisible(false);

    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        frameAddDriverBtn.setVisible(true);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(false);

        rootAddDriver.setVisible(true);
        rootAddVehicle.setVisible(false);

    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(true);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(false);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setX(505.0);
        alert.setY(235.0);
        alert.setContentText("Do you want to sure Log Out ?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.get() == ButtonType.OK){
            Parent parent= FXMLLoader.load(this.getClass().getResource("../View/DashBoardForm.fxml"));
            Scene scene=new Scene(parent);

            Stage primaryStage=(Stage) this.rootMgtBoard.getScene().getWindow();
            primaryStage.setScene(scene);
        }
        if (result.get()==ButtonType.CANCEL){
            frameLogOutBtn.setVisible(false);
        }
    }

    public void btnAddVehicleCancelOnAction(ActionEvent actionEvent) {
        rootAddVehicle.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
    }

    public void btnAddDriverCancelOnAction(ActionEvent actionEvent) {
        rootAddDriver.setVisible(false);
        frameAddDriverBtn.setVisible(false);
    }

    public void btnAddVehicleDetailsOnAction(ActionEvent actionEvent) {
        int maxW=Integer.parseInt(txtVehicleWeight.getText());
        int noPassenger=Integer.parseInt(txtVehiclePassengers.getText());

        vehicleArray[vArrayCount]=new Vehicle(txtVehicleNumber.getText(),maxW,noPassenger,VehicleType);
        vehicleArray[vArrayCount].setVehicleState("NonBoth");
        if (VehicleType.equals("Van")){
            for (int i = 0; i < vanSlotArr.length; i++) {
                if (vanSlotState[i]==0){
                    vehicleArray[vArrayCount].setSlotNumber(vanSlotArr[i]);
                    vanSlotState[i]=1;
                    break;
                }
            }
        }else if (VehicleType.equals("Cargo Lorry")){
            for (int i = 0; i < lorrySlotArr.length; i++) {
                if (lorrySlotState[i]==0){
                    vehicleArray[vArrayCount].setSlotNumber(lorrySlotArr[i]);
                    lorrySlotState[i]=1;
                    break;
                }
            }
        }else {
            if (busSlotState==0){
                vehicleArray[vArrayCount].setSlotNumber(busSlot);
                busSlotState=1;
            }
        }
        txtVehicleNumber.clear();
        txtVehiclePassengers.clear();
        txtVehicleWeight.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setX(505.0);
        alert.setY(235.0);
        alert.setContentText("The Vehicle Was Successfully Added..!");
        Optional<ButtonType> result = alert.showAndWait();

        vlTable=vArrayCount;
        vArrayCount++;
        loadVehicleListTable();
        vlTable++;
    }

    public void btnAddDriverDetailsOnAction(ActionEvent actionEvent) {
        driverArray[dArrayCount]=new Driver(
                txtDriverName.getText(),
                txtDriverNic.getText(),
                txtDriverLicense.getText(),
                txtDriverAddress.getText(),
                txtDriverContact.getText()
        );

        txtDriverContact.clear();
        txtDriverAddress.clear();
        txtDriverLicense.clear();
        txtDriverName.clear();
        txtDriverNic.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert!");
        alert.setX(505.0);
        alert.setY(235.0);
        alert.setContentText("The Driver Was Successfully Added..!");
        Optional<ButtonType> result = alert.showAndWait();

        dlTable=dArrayCount;
        dArrayCount++;
        loadDriverListTable();
        dlTable++;
    }

    private void loadVehicleListTable(){
        ObservableList<vehicleListTM> allVehicles = tblVehicleList.getItems();
        for (int i = vlTable; i < vArrayCount; i++) {
            vehicleListTM newVehicle = new vehicleListTM(
                    vehicleArray[i].getVehicleNumber(),
                    vehicleArray[i].getVehicleType(),
                    String.valueOf(vehicleArray[i].getVehicleMaxWeight()),
                    String.valueOf(vehicleArray[i].getVehicleNoOfPassengers())
            );
            allVehicles.add(newVehicle);
        }
    }

    private void loadDriverListTable(){
        ObservableList<driverListTM> allDrivers = tblDriverList.getItems();
        for (int i = dlTable; i <dArrayCount; i++) {
            driverListTM newDriver = new driverListTM(
                    driverArray[i].getDriverNic(),
                    driverArray[i].getDriverName(),
                    driverArray[i].getDriverLicenseNo(),
                    driverArray[i].getDriverAddress(),
                    driverArray[i].getDriverContactNo()
            );
            allDrivers.add(newDriver);
        }
    }

    private void loadOnDeliveryTable(){
        ObservableList<OnDeliveryTM> deliveryRecords = tblOnDelivery.getItems();
        for (int i = OnDTable; i <vArrayCount ; i++) {
            if (vehicleArray[i].getVehicleState().equals("OnDelivery")){
                OnDeliveryTM newDeliveryRecord=new OnDeliveryTM(
                        vehicleArray[i].getVehicleNumber(),
                        vehicleArray[i].getVehicleType(),
                        vehicleArray[i].getDriverOfVehicleNow(),
                        vehicleArray[i].getParkedOrLeftTime()
                );
                deliveryRecords.add(newDeliveryRecord);
            }
        }
    }

    private void loadInParkingTable(){
        ObservableList<InParkingTM> parkingRecords = tblOnParking.getItems();
        for (int i = OnPTable; i < vArrayCount; i++) {
            if (vehicleArray[i].getVehicleState().equals("InParking")){
                InParkingTM newParkingRecord =new InParkingTM(
                        vehicleArray[i].getVehicleNumber(),
                        vehicleArray[i].getVehicleType(),
                        vehicleArray[i].getSlotNumber(),
                        vehicleArray[i].getParkedOrLeftTime()
                );
                parkingRecords.add(newParkingRecord);
            }
        }
    }

    public void imgVehicleListOnClicked(MouseEvent mouseEvent) {
        tblOnDelivery.setVisible(false);
        tblOnParking.setVisible(false);
        tblVehicleList.setVisible(true);
        tblDriverList.setVisible(false);

        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(true);

    }

    public void imgDriverListOnClicked(MouseEvent mouseEvent) {
        tblOnDelivery.setVisible(false);
        tblOnParking.setVisible(false);
        tblVehicleList.setVisible(false);
        tblDriverList.setVisible(true);

        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(true);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(false);
        frameVehicleListImg.setVisible(false);

    }

    public void cmbSelectModeOnAction(ActionEvent actionEvent) {
        frameAddDriverBtn.setVisible(false);
        frameAddVehicleBtn.setVisible(false);
        frameDriverListImg.setVisible(false);
        frameLogOutBtn.setVisible(false);
        frameVehicleModeCmb.setVisible(true);
        frameVehicleListImg.setVisible(false);
    }
}


