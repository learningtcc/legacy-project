package et.po;

import java.util.Date;


/**
 * SysLog generated by MyEclipse - Hibernate Tools
 */

public class SysLog  implements java.io.Serializable {


    // Fields    

     private String id;
     private SysUser sysUser;
     private Date dt;
     private String modu;
     private String actorType;
     private String ip;
     private String remark;


    // Constructors

    /** default constructor */
    public SysLog() {
    }

	/** minimal constructor */
    public SysLog(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public SysLog(String id, SysUser sysUser, Date dt, String modu, String actorType, String ip, String remark) {
        this.id = id;
        this.sysUser = sysUser;
        this.dt = dt;
        this.modu = modu;
        this.actorType = actorType;
        this.ip = ip;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public SysUser getSysUser() {
        return this.sysUser;
    }
    
    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Date getDt() {
        return this.dt;
    }
    
    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getModu() {
        return this.modu;
    }
    
    public void setModu(String modu) {
        this.modu = modu;
    }

    public String getActorType() {
        return this.actorType;
    }
    
    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}