package et.po;



/**
 * SysStationInfo generated by MyEclipse - Hibernate Tools
 */

public class SysStationInfo  implements java.io.Serializable {


    // Fields    

     private String id;
     private String departmentId;
     private String depPersonName;
     private String depLevel;
     private String depDescribe;
     private String remark;


    // Constructors

    /** default constructor */
    public SysStationInfo() {
    }

	/** minimal constructor */
    public SysStationInfo(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public SysStationInfo(String id, String departmentId, String depPersonName, String depLevel, String depDescribe, String remark) {
        this.id = id;
        this.departmentId = departmentId;
        this.depPersonName = depPersonName;
        this.depLevel = depLevel;
        this.depDescribe = depDescribe;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepPersonName() {
        return this.depPersonName;
    }
    
    public void setDepPersonName(String depPersonName) {
        this.depPersonName = depPersonName;
    }

    public String getDepLevel() {
        return this.depLevel;
    }
    
    public void setDepLevel(String depLevel) {
        this.depLevel = depLevel;
    }

    public String getDepDescribe() {
        return this.depDescribe;
    }
    
    public void setDepDescribe(String depDescribe) {
        this.depDescribe = depDescribe;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}