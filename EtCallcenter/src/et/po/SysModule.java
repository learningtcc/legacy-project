package et.po;

import java.util.HashSet;
import java.util.Set;


/**
 * SysModule generated by MyEclipse - Hibernate Tools
 */

public class SysModule  implements java.io.Serializable {


    // Fields    

     private String id;
     private String action;
     private String icon;
     private String remarks;
     private String parentId;
     private String tagShow;
     private String name;
     private String layerOrder;
     private String isSys;
     private Set sysRightUsers = new HashSet(0);
     private Set sysRightGroups = new HashSet(0);


    // Constructors

    /** default constructor */
    public SysModule() {
    }

	/** minimal constructor */
    public SysModule(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public SysModule(String id, String action, String icon, String remarks, String parentId, String tagShow, String name, String layerOrder, String isSys, Set sysRightUsers, Set sysRightGroups) {
        this.id = id;
        this.action = action;
        this.icon = icon;
        this.remarks = remarks;
        this.parentId = parentId;
        this.tagShow = tagShow;
        this.name = name;
        this.layerOrder = layerOrder;
        this.isSys = isSys;
        this.sysRightUsers = sysRightUsers;
        this.sysRightGroups = sysRightGroups;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getLayerOrder() {
        return this.layerOrder;
    }
    
    public void setLayerOrder(String layerOrder) {
        this.layerOrder = layerOrder;
    }

    public String getIsSys() {
        return this.isSys;
    }
    
    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public Set getSysRightUsers() {
        return this.sysRightUsers;
    }
    
    public void setSysRightUsers(Set sysRightUsers) {
        this.sysRightUsers = sysRightUsers;
    }

    public Set getSysRightGroups() {
        return this.sysRightGroups;
    }
    
    public void setSysRightGroups(Set sysRightGroups) {
        this.sysRightGroups = sysRightGroups;
    }
   








}