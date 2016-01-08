package et.po;

import java.util.Date;


/**
 * GovDriverInfo generated by MyEclipse - Hibernate Tools
 */

public class GovDriverInfo  implements java.io.Serializable {


    // Fields    

     private String driverId;
     private String driverName;
     private Integer driverSex;
     private Date driverDate;
     private String driverQq;
     private String driverEmail;
     private String driverAddress;
     private String driverPhone;
     private String driverCompany;
     private String driverImage;
     private String driverLicence;
     private String driverCode;
     private String driverType;
     private Date driverTime;
     private String delMark;
     private String remark;


    // Constructors

    /** default constructor */
    public GovDriverInfo() {
    }

	/** minimal constructor */
    public GovDriverInfo(String driverId) {
        this.driverId = driverId;
    }
    
    /** full constructor */
    public GovDriverInfo(String driverId, String driverName, Integer driverSex, Date driverDate, String driverQq, String driverEmail, String driverAddress, String driverPhone, String driverCompany, String driverImage, String driverLicence, String driverCode, String driverType, Date driverTime, String delMark, String remark) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverSex = driverSex;
        this.driverDate = driverDate;
        this.driverQq = driverQq;
        this.driverEmail = driverEmail;
        this.driverAddress = driverAddress;
        this.driverPhone = driverPhone;
        this.driverCompany = driverCompany;
        this.driverImage = driverImage;
        this.driverLicence = driverLicence;
        this.driverCode = driverCode;
        this.driverType = driverType;
        this.driverTime = driverTime;
        this.delMark = delMark;
        this.remark = remark;
    }

   
    // Property accessors

    public String getDriverId() {
        return this.driverId;
    }
    
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return this.driverName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverSex() {
        return this.driverSex;
    }
    
    public void setDriverSex(Integer driverSex) {
        this.driverSex = driverSex;
    }

    public Date getDriverDate() {
        return this.driverDate;
    }
    
    public void setDriverDate(Date driverDate) {
        this.driverDate = driverDate;
    }

    public String getDriverQq() {
        return this.driverQq;
    }
    
    public void setDriverQq(String driverQq) {
        this.driverQq = driverQq;
    }

    public String getDriverEmail() {
        return this.driverEmail;
    }
    
    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public String getDriverAddress() {
        return this.driverAddress;
    }
    
    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverPhone() {
        return this.driverPhone;
    }
    
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverCompany() {
        return this.driverCompany;
    }
    
    public void setDriverCompany(String driverCompany) {
        this.driverCompany = driverCompany;
    }

    public String getDriverImage() {
        return this.driverImage;
    }
    
    public void setDriverImage(String driverImage) {
        this.driverImage = driverImage;
    }

    public String getDriverLicence() {
        return this.driverLicence;
    }
    
    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    public String getDriverCode() {
        return this.driverCode;
    }
    
    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverType() {
        return this.driverType;
    }
    
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Date getDriverTime() {
        return this.driverTime;
    }
    
    public void setDriverTime(Date driverTime) {
        this.driverTime = driverTime;
    }

    public String getDelMark() {
        return this.delMark;
    }
    
    public void setDelMark(String delMark) {
        this.delMark = delMark;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}