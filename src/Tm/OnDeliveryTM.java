package Tm;

public class OnDeliveryTM {
    private String OnDeliveryVehicleNumber;
    private String OnDeliveryVehicleType;
    private String OnDeliveryDriverName;
    private String OnDeliveryLeftTime;

    public OnDeliveryTM() {
    }

    public OnDeliveryTM(String onDeliveryVehicleNumber, String onDeliveryVehicleType, String onDeliveryDriverName, String onDeliveryLeftTime) {
        OnDeliveryVehicleNumber = onDeliveryVehicleNumber;
        OnDeliveryVehicleType = onDeliveryVehicleType;
        OnDeliveryDriverName = onDeliveryDriverName;
        OnDeliveryLeftTime = onDeliveryLeftTime;
    }

    public String getOnDeliveryVehicleNumber() {
        return OnDeliveryVehicleNumber;
    }

    public void setOnDeliveryVehicleNumber(String onDeliveryVehicleNumber) {
        OnDeliveryVehicleNumber = onDeliveryVehicleNumber;
    }

    public String getOnDeliveryVehicleType() {
        return OnDeliveryVehicleType;
    }

    public void setOnDeliveryVehicleType(String onDeliveryVehicleType) {
        OnDeliveryVehicleType = onDeliveryVehicleType;
    }

    public String getOnDeliveryDriverName() {
        return OnDeliveryDriverName;
    }

    public void setOnDeliveryDriverName(String onDeliveryDriverName) {
        OnDeliveryDriverName = onDeliveryDriverName;
    }

    public String getOnDeliveryLeftTime() {
        return OnDeliveryLeftTime;
    }

    public void setOnDeliveryLeftTime(String onDeliveryLeftTime) {
        OnDeliveryLeftTime = onDeliveryLeftTime;
    }
}
