package et.po;

/**
 * SysKey generated by MyEclipse Persistence Tools
 */

public class SysKey implements java.io.Serializable {

	// Fields

	private String tbName;

	private String tbIdMax;

	// Constructors

	/** default constructor */
	public SysKey() {
	}

	/** minimal constructor */
	public SysKey(String tbName) {
		this.tbName = tbName;
	}

	/** full constructor */
	public SysKey(String tbName, String tbIdMax) {
		this.tbName = tbName;
		this.tbIdMax = tbIdMax;
	}

	// Property accessors

	public String getTbName() {
		return this.tbName;
	}

	public void setTbName(String tbName) {
		this.tbName = tbName;
	}

	public String getTbIdMax() {
		return this.tbIdMax;
	}

	public void setTbIdMax(String tbIdMax) {
		this.tbIdMax = tbIdMax;
	}

}