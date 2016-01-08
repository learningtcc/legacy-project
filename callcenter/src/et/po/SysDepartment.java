package et.po;

import java.util.HashSet;
import java.util.Set;


/**
 * SysDepartment generated by MyEclipse - Hibernate Tools
 */

public class SysDepartment  implements java.io.Serializable {


    // Fields    

     private String id;
     private String remarks;
     private String parentId;
     private String tagShow;
     private String name;
     private Set sysUsers = new HashSet(0);


    // Constructors

    /** default constructor */
    public SysDepartment() {
    }

	/** minimal constructor */
    public SysDepartment(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public SysDepartment(String id, String remarks, String parentId, String tagShow, String name, Set sysUsers) {
        this.id = id;
        this.remarks = remarks;
        this.parentId = parentId;
        this.tagShow = tagShow;
        this.name = name;
        this.sysUsers = sysUsers;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getParentId() {
        return this.parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTagShow() {
        return this.tagShow;
    }
    
    public void setTagShow(String tagShow) {
        this.tagShow = tagShow;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getSysUsers() {
        return this.sysUsers;
    }
    
    public void setSysUsers(Set sysUsers) {
        this.sysUsers = sysUsers;
    }
   








}