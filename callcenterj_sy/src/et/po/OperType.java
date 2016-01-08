package et.po;

/**
 * OperType generated by MyEclipse Persistence Tools
 */

public class OperType implements java.io.Serializable {

	// Fields

	private Integer id;

	private String type1;

	private String type2;

	// Constructors

	/** default constructor */
	public OperType() {
	}

	/** full constructor */
	public OperType(String type1, String type2) {
		this.type1 = type1;
		this.type2 = type2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType1() {
		return this.type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

}