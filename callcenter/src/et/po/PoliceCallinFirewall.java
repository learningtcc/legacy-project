package et.po;

import java.util.Date;


/**
 * PoliceCallinFirewall generated by MyEclipse - Hibernate Tools
 */

public class PoliceCallinFirewall  implements java.io.Serializable {


    // Fields    

     private String id;
     private String callinNumBegin;
     private String callinNumEnd;
     private Date beginTime;
     private Date endTime;
     private String isPass;
     private String isAvailable;
     private String remark;


    // Constructors

    /** default constructor */
    public PoliceCallinFirewall() {
    }

	/** minimal constructor */
    public PoliceCallinFirewall(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public PoliceCallinFirewall(String id, String callinNumBegin, String callinNumEnd, Date beginTime, Date endTime, String isPass, String isAvailable, String remark) {
        this.id = id;
        this.callinNumBegin = callinNumBegin;
        this.callinNumEnd = callinNumEnd;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.isPass = isPass;
        this.isAvailable = isAvailable;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getCallinNumBegin() {
        return this.callinNumBegin;
    }
    
    public void setCallinNumBegin(String callinNumBegin) {
        this.callinNumBegin = callinNumBegin;
    }

    public String getCallinNumEnd() {
        return this.callinNumEnd;
    }
    
    public void setCallinNumEnd(String callinNumEnd) {
        this.callinNumEnd = callinNumEnd;
    }

    public Date getBeginTime() {
        return this.beginTime;
    }
    
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getIsPass() {
        return this.isPass;
    }
    
    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    public String getIsAvailable() {
        return this.isAvailable;
    }
    
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}