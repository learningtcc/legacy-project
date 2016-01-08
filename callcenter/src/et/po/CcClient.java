package et.po;



/**
 * CcClient generated by MyEclipse - Hibernate Tools
 */

public class CcClient  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String ip;
     private String macAddr;
     private String cpuSn;
     private String tagFreeze;


    // Constructors

    /** default constructor */
    public CcClient() {
    }

	/** minimal constructor */
    public CcClient(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public CcClient(String id, String name, String ip, String macAddr, String cpuSn, String tagFreeze) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.macAddr = macAddr;
        this.cpuSn = cpuSn;
        this.tagFreeze = tagFreeze;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMacAddr() {
        return this.macAddr;
    }
    
    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public String getCpuSn() {
        return this.cpuSn;
    }
    
    public void setCpuSn(String cpuSn) {
        this.cpuSn = cpuSn;
    }

    public String getTagFreeze() {
        return this.tagFreeze;
    }
    
    public void setTagFreeze(String tagFreeze) {
        this.tagFreeze = tagFreeze;
    }
   








}