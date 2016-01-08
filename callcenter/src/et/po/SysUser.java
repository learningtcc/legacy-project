package et.po;

import java.util.HashSet;
import java.util.Set;


/**
 * SysUser generated by MyEclipse - Hibernate Tools
 */

public class SysUser  implements java.io.Serializable {


    // Fields    

     private String userId;
     private SysDepartment sysDepartment;
     private SysRole sysRole;
     private SysGroup sysGroup;
     private String password;
     private String userName;
     private String deleteMark;
     private String remark;
     private String isSys;
     private Set sysUserInfos = new HashSet(0);
     private Set sysLogs = new HashSet(0);
     private Set sysRightUsers = new HashSet(0);
     private Set addresslistsortInfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public SysUser() {
    }

	/** minimal constructor */
    public SysUser(String userId) {
        this.userId = userId;
    }
    
    /** full constructor */
    public SysUser(String userId, SysDepartment sysDepartment, SysRole sysRole, SysGroup sysGroup, String password, String userName, String deleteMark, String remark, String isSys, Set sysUserInfos, Set sysLogs, Set sysRightUsers, Set addresslistsortInfos) {
        this.userId = userId;
        this.sysDepartment = sysDepartment;
        this.sysRole = sysRole;
        this.sysGroup = sysGroup;
        this.password = password;
        this.userName = userName;
        this.deleteMark = deleteMark;
        this.remark = remark;
        this.isSys = isSys;
        this.sysUserInfos = sysUserInfos;
        this.sysLogs = sysLogs;
        this.sysRightUsers = sysRightUsers;
        this.addresslistsortInfos = addresslistsortInfos;
    }

   
    // Property accessors

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SysDepartment getSysDepartment() {
        return this.sysDepartment;
    }
    
    public void setSysDepartment(SysDepartment sysDepartment) {
        this.sysDepartment = sysDepartment;
    }

    public SysRole getSysRole() {
        return this.sysRole;
    }
    
    public void setSysRole(SysRole sysRole) {
        this.sysRole = sysRole;
    }

    public SysGroup getSysGroup() {
        return this.sysGroup;
    }
    
    public void setSysGroup(SysGroup sysGroup) {
        this.sysGroup = sysGroup;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeleteMark() {
        return this.deleteMark;
    }
    
    public void setDeleteMark(String deleteMark) {
        this.deleteMark = deleteMark;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsSys() {
        return this.isSys;
    }
    
    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    public Set getSysUserInfos() {
        return this.sysUserInfos;
    }
    
    public void setSysUserInfos(Set sysUserInfos) {
        this.sysUserInfos = sysUserInfos;
    }

    public Set getSysLogs() {
        return this.sysLogs;
    }
    
    public void setSysLogs(Set sysLogs) {
        this.sysLogs = sysLogs;
    }

    public Set getSysRightUsers() {
        return this.sysRightUsers;
    }
    
    public void setSysRightUsers(Set sysRightUsers) {
        this.sysRightUsers = sysRightUsers;
    }

    public Set getAddresslistsortInfos() {
        return this.addresslistsortInfos;
    }
    
    public void setAddresslistsortInfos(Set addresslistsortInfos) {
        this.addresslistsortInfos = addresslistsortInfos;
    }
   








}