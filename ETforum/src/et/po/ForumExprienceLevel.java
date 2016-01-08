package et.po;



/**
 * ForumExprienceLevel generated by MyEclipse - Hibernate Tools
 */

public class ForumExprienceLevel  implements java.io.Serializable {


    // Fields    

     private String id;
     private String userLevel;
     private Integer point;
     private String levelImg;
     private String remark;


    // Constructors

    /** default constructor */
    public ForumExprienceLevel() {
    }

	/** minimal constructor */
    public ForumExprienceLevel(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public ForumExprienceLevel(String id, String userLevel, Integer point, String levelImg, String remark) {
        this.id = id;
        this.userLevel = userLevel;
        this.point = point;
        this.levelImg = levelImg;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getUserLevel() {
        return this.userLevel;
    }
    
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPoint() {
        return this.point;
    }
    
    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getLevelImg() {
        return this.levelImg;
    }
    
    public void setLevelImg(String levelImg) {
        this.levelImg = levelImg;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}