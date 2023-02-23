package Controller;

public class Driver {
    private String driverName;
    private String driverNic;
    private String driverLicenseNo;
    private String driverAddress;
    private String driverContactNo;

    public Driver(String text, String txtDriverNicText, String txtDriverLicenseText) {
    }

    public Driver(String driverName, String driverNic, String driverLicenseNo, String driverAddress, String driverContactNo) {
        this.driverName = driverName;
        this.driverNic = driverNic;
        this.driverLicenseNo = driverLicenseNo;
        this.driverAddress = driverAddress;
        this.driverContactNo = driverContactNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNic() {
        return driverNic;
    }

    public void setDriverNic(String driverNic) {
        this.driverNic = driverNic;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverContactNo() {
        return driverContactNo;
    }

    public void setDriverContactNo(String driverContactNo) {
        this.driverContactNo = driverContactNo;
    }
}
