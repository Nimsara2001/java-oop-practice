package Tm;

public class InParkingTM {
    private String InParkingVehicleNumber;
    private String InParkingVehicleType;
    private String InParkingSlot;
    private String InParkingTime;

    public InParkingTM() {
    }

    public InParkingTM(String inParkingVehicleNumber, String inParkingVehicleType, String inParkingSlot, String inParkingTime) {
        InParkingVehicleNumber = inParkingVehicleNumber;
        InParkingVehicleType = inParkingVehicleType;
        InParkingSlot = inParkingSlot;
        InParkingTime = inParkingTime;
    }

    public String getInParkingVehicleNumber() {
        return InParkingVehicleNumber;
    }

    public void setInParkingVehicleNumber(String inParkingVehicleNumber) {
        InParkingVehicleNumber = inParkingVehicleNumber;
    }

    public String getInParkingVehicleType() {
        return InParkingVehicleType;
    }

    public void setInParkingVehicleType(String inParkingVehicleType) {
        InParkingVehicleType = inParkingVehicleType;
    }

    public String getInParkingSlot() {
        return InParkingSlot;
    }

    public void setInParkingSlot(String inParkingSlot) {
        InParkingSlot = inParkingSlot;
    }

    public String getInParkingTime() {
        return InParkingTime;
    }

    public void setInParkingTime(String inParkingTime) {
        InParkingTime = inParkingTime;
    }
}
