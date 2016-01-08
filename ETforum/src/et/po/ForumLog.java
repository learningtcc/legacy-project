package et.po;

import java.util.Date;


/**
 * ForumLog generated by MyEclipse - Hibernate Tools
 */

public class ForumLog  implements java.io.Serializable {


    // Fields    

     private String id;
     private String userId;
     private String moduleName;
     private String action;
     private Date operTime;
     private String postId;
     private String remark;
     private String ip;


    // Constructors

    /** default constructor */
    public ForumLog() {
    }

	/** minimal constructor */
    public ForumLog(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public ForumLog(String id, String userId, String moduleName, String action, Date operTime, String postId, String remark, String ip) {
        this.id = id;
        this.userId = userId;
        this.moduleName = moduleName;
        this.action = action;
        this.operTime = operTime;
        this.postId = postId;
        this.remark = remark;
        this.ip = ip;
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

    public String getModuleName() {
        return this.moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    public Date getOperTime() {
        return this.operTime;
    }
    
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getPostId() {
        return this.postId;
    }
    
    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
   








}