package et.po;



/**
 * PoliceinfoTemp generated by MyEclipse - Hibernate Tools
 */

public class PoliceinfoTemp  implements java.io.Serializable {


    // Fields    

     private String id;
     private String PId;
     private String tagInfo;
     private String quInfo;
     private String content;
     private String remark;
     private String tag;


    // Constructors

    /** default constructor */
    public PoliceinfoTemp() {
    }

	/** minimal constructor */
    public PoliceinfoTemp(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public PoliceinfoTemp(String id, String PId, String tagInfo, String quInfo, String content, String remark, String tag) {
        this.id = id;
        this.PId = PId;
        this.tagInfo = tagInfo;
        this.quInfo = quInfo;
        this.content = content;
        this.remark = remark;
        this.tag = tag;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getPId() {
        return this.PId;
    }
    
    public void setPId(String PId) {
        this.PId = PId;
    }

    public String getTagInfo() {
        return this.tagInfo;
    }
    
    public void setTagInfo(String tagInfo) {
        this.tagInfo = tagInfo;
    }

    public String getQuInfo() {
        return this.quInfo;
    }
    
    public void setQuInfo(String quInfo) {
        this.quInfo = quInfo;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTag() {
        return this.tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
   








}