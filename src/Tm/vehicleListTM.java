package Tm;

public class vehicleListTM {
    private String VlNumber;
    private String VlType;
    private String VlMaxWeight;
    private String VlNoPassengers;

    public vehicleListTM() {
    }

    public vehicleListTM(String vlNumber, String vlType, String vlMaxWeight, String vlNoPassengers) {
        VlNumber = vlNumber;
        VlType = vlType;
        VlMaxWeight = vlMaxWeight;
        VlNoPassengers = vlNoPassengers;
    }

    public String getVlNumber() {
        return VlNumber;
    }

    public void setVlNumber(String vlNumber) {
        VlNumber = vlNumber;
    }

    public String getVlType() {
        return VlType;
    }

    public void setVlType(String vlType) {
        VlType = vlType;
    }

    public String getVlMaxWeight() {
        return VlMaxWeight;
    }

    public void setVlMaxWeight(String vlMaxWeight) {
        VlMaxWeight = vlMaxWeight;
    }

    public String getVlNoPassengers() {
        return VlNoPassengers;
    }

    public void setVlNoPassengers(String vlNoPassengers) {
        VlNoPassengers = vlNoPassengers;
    }
}
