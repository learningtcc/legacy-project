package et.po;



/**
 * ForumPostsWeapon generated by MyEclipse - Hibernate Tools
 */

public class ForumPostsWeapon  implements java.io.Serializable {


    // Fields    

     private String id;
     private String postsId;
     private String weaponId;
     private String weaponNumber;
     private String remark;


    // Constructors

    /** default constructor */
    public ForumPostsWeapon() {
    }

	/** minimal constructor */
    public ForumPostsWeapon(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public ForumPostsWeapon(String id, String postsId, String weaponId, String weaponNumber, String remark) {
        this.id = id;
        this.postsId = postsId;
        this.weaponId = weaponId;
        this.weaponNumber = weaponNumber;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getPostsId() {
        return this.postsId;
    }
    
    public void setPostsId(String postsId) {
        this.postsId = postsId;
    }

    public String getWeaponId() {
        return this.weaponId;
    }
    
    public void setWeaponId(String weaponId) {
        this.weaponId = weaponId;
    }

    public String getWeaponNumber() {
        return this.weaponNumber;
    }
    
    public void setWeaponNumber(String weaponNumber) {
        this.weaponNumber = weaponNumber;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}