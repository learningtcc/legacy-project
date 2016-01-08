package et.po;

/**
 * StaffLanguage generated by MyEclipse Persistence Tools
 */

public class StaffLanguage implements java.io.Serializable {

	// Fields

	private String id;

	private StaffBasic staffBasic;

	private String dictLanguageType;

	private String dictLanguageDegree;

	private String remark;

	// Constructors

	/** default constructor */
	public StaffLanguage() {
	}

	/** minimal constructor */
	public StaffLanguage(String id) {
		this.id = id;
	}

	/** full constructor */
	public StaffLanguage(String id, StaffBasic staffBasic,
			String dictLanguageType, String dictLanguageDegree, String remark) {
		this.id = id;
		this.staffBasic = staffBasic;
		this.dictLanguageType = dictLanguageType;
		this.dictLanguageDegree = dictLanguageDegree;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StaffBasic getStaffBasic() {
		return this.staffBasic;
	}

	public void setStaffBasic(StaffBasic staffBasic) {
		this.staffBasic = staffBasic;
	}

	public String getDictLanguageType() {
		return this.dictLanguageType;
	}

	public void setDictLanguageType(String dictLanguageType) {
		this.dictLanguageType = dictLanguageType;
	}

	public String getDictLanguageDegree() {
		return this.dictLanguageDegree;
	}

	public void setDictLanguageDegree(String dictLanguageDegree) {
		this.dictLanguageDegree = dictLanguageDegree;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}