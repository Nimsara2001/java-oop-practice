package Controller;

public class Vehicle {
    private String vehicleNumber;
    private int vehicleMaxWeight;
    private int vehicleNoOfPassengers;
    private String vehicleType;

    //The following variables depending on the user's input and System input(timeDate)
    private String vehicleState;
    private String slotNumber;
    private String parkedOrLeftTime;
    private String driverOfVehicleNow;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, int vehicleMaxWeight, int vehicleNoOfPassengers, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleMaxWeight = vehicleMaxWeight;
        this.vehicleNoOfPassengers = vehicleNoOfPassengers;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleName) {
        this.vehicleNumber = vehicleName;
    }

    public int getVehicleMaxWeight() {
        return vehicleMaxWeight;
    }

    public void setVehicleMaxWeight(int vehicleMaxWeight) {
        this.vehicleMaxWeight = vehicleMaxWeight;
    }

    public int getVehicleNoOfPassengers() {
        return vehicleNoOfPassengers;
    }

    public void setVehicleNoOfPassengers(int vehicleNoOfPassengers) {
        this.vehicleNoOfPassengers = vehicleNoOfPassengers;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(String vehicleState) {
        this.vehicleState = vehicleState;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getParkedOrLeftTime() {
        return parkedOrLeftTime;
    }

    public void setParkedOrLeftTime(String parkedOrLeftTime) {
        this.parkedOrLeftTime = parkedOrLeftTime;
    }

    public String getDriverOfVehicleNow() {
        return driverOfVehicleNow;
    }

    public void setDriverOfVehicleNow(String driverOfVehicleNow) {
        this.driverOfVehicleNow = driverOfVehicleNow;
    }
}
