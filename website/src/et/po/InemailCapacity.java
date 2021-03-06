package et.po;



/**
 * InemailCapacity generated by MyEclipse - Hibernate Tools
 */

public class InemailCapacity  implements java.io.Serializable {


    // Fields    

     private String id;
     private String userId;
     private Double capacityNum;
     private Double useNum;
     private Double leaveNum;
     private String remark;


    // Constructors

    /** default constructor */
    public InemailCapacity() {
    }

	/** minimal constructor */
    public InemailCapacity(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public InemailCapacity(String id, String userId, Double capacityNum, Double useNum, Double leaveNum, String remark) {
        this.id = id;
        this.userId = userId;
        this.capacityNum = capacityNum;
        this.useNum = useNum;
        this.leaveNum = leaveNum;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getCapacityNum() {
        return this.capacityNum;
    }
    
    public void setCapacityNum(Double capacityNum) {
        this.capacityNum = capacityNum;
    }

    public Double getUseNum() {
        return this.useNum;
    }
    
    public void setUseNum(Double useNum) {
        this.useNum = useNum;
    }

    public Double getLeaveNum() {
        return this.leaveNum;
    }
    
    public void setLeaveNum(Double leaveNum) {
        this.leaveNum = leaveNum;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}