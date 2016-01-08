package et.po;



/**
 * CcExtension generated by MyEclipse - Hibernate Tools
 */

public class CcExtension  implements java.io.Serializable {


    // Fields    

     private String id;
     private String sn;
     private String extension;
     private String tagFreeze;
     private String cardId;
     private String clientId;
     private String remark;


    // Constructors

    /** default constructor */
    public CcExtension() {
    }

	/** minimal constructor */
    public CcExtension(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public CcExtension(String id, String sn, String extension, String tagFreeze, String cardId, String clientId, String remark) {
        this.id = id;
        this.sn = sn;
        this.extension = extension;
        this.tagFreeze = tagFreeze;
        this.cardId = cardId;
        this.clientId = clientId;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getSn() {
        return this.sn;
    }
    
    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getExtension() {
        return this.extension;
    }
    
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTagFreeze() {
        return this.tagFreeze;
    }
    
    public void setTagFreeze(String tagFreeze) {
        this.tagFreeze = tagFreeze;
    }

    public String getCardId() {
        return this.cardId;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getClientId() {
        return this.clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}