package Tm;

public class driverListTM {
    private String DlNic;
    private String DlName;
    private String DlLicNo;
    private String DlAddress;
    private String DlContactNo;

    public driverListTM() {
    }

    public driverListTM(String dlNic, String dlName, String dlLicNo, String dlAddress, String dlContactNo) {
        DlNic = dlNic;
        DlName = dlName;
        DlLicNo = dlLicNo;
        DlAddress = dlAddress;
        DlContactNo = dlContactNo;
    }

    public String getDlNic() {
        return DlNic;
    }

    public void setDlNic(String dlNic) {
        DlNic = dlNic;
    }

    public String getDlName() {
        return DlName;
    }

    public void setDlName(String dlName) {
        DlName = dlName;
    }

    public String getDlLicNo() {
        return DlLicNo;
    }

    public void setDlLicNo(String dlLicNo) {
        DlLicNo = dlLicNo;
    }

    public String getDlAddress() {
        return DlAddress;
    }

    public void setDlAddress(String dlAddress) {
        DlAddress = dlAddress;
    }

    public String getDlContactNo() {
        return DlContactNo;
    }

    public void setDlContactNo(String dlContactNo) {
        DlContactNo = dlContactNo;
    }
}
