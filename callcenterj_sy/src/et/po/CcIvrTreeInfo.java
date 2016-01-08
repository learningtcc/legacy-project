package et.po;

import java.util.HashSet;
import java.util.Set;

/**
 * CcIvrTreeInfo generated by MyEclipse Persistence Tools
 */

public class CcIvrTreeInfo implements java.io.Serializable {

	// Fields

	private String id;

	private BaseTree baseTree;

	private String functype;

	private String nickname;

	private String content;

	private String voiceType;

	private String telNum;

	private String telKey;

	private String lengthSize;

	private String checkValue;

	private String languageType;

	private String deleteMark;

	private String orderProgramme;

	private String customizeCancel;

	private String expertId;

	private Set ccIvrTreevoiceDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public CcIvrTreeInfo() {
	}

	/** minimal constructor */
	public CcIvrTreeInfo(String id, BaseTree baseTree) {
		this.id = id;
		this.baseTree = baseTree;
	}

	/** full constructor */
	public CcIvrTreeInfo(String id, BaseTree baseTree, String functype,
			String nickname, String content, String voiceType, String telNum,
			String telKey, String lengthSize, String checkValue,
			String languageType, String deleteMark, Set ccIvrTreevoiceDetails) {
		this.id = id;
		this.baseTree = baseTree;
		this.functype = functype;
		this.nickname = nickname;
		this.content = content;
		this.voiceType = voiceType;
		this.telNum = telNum;
		this.telKey = telKey;
		this.lengthSize = lengthSize;
		this.checkValue = checkValue;
		this.languageType = languageType;
		this.deleteMark = deleteMark;
		this.ccIvrTreevoiceDetails = ccIvrTreevoiceDetails;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BaseTree getBaseTree() {
		return this.baseTree;
	}

	public void setBaseTree(BaseTree baseTree) {
		this.baseTree = baseTree;
	}

	public String getFunctype() {
		return this.functype;
	}

	public void setFunctype(String functype) {
		this.functype = functype;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVoiceType() {
		return this.voiceType;
	}

	public void setVoiceType(String voiceType) {
		this.voiceType = voiceType;
	}

	public String getTelNum() {
		return this.telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getTelKey() {
		return this.telKey;
	}

	public void setTelKey(String telKey) {
		this.telKey = telKey;
	}

	public String getLengthSize() {
		return this.lengthSize;
	}

	public void setLengthSize(String lengthSize) {
		this.lengthSize = lengthSize;
	}

	public String getCheckValue() {
		return this.checkValue;
	}

	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}

	public String getLanguageType() {
		return this.languageType;
	}

	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}

	public String getDeleteMark() {
		return this.deleteMark;
	}

	public void setDeleteMark(String deleteMark) {
		this.deleteMark = deleteMark;
	}

	public Set getCcIvrTreevoiceDetails() {
		return this.ccIvrTreevoiceDetails;
	}

	public void setCcIvrTreevoiceDetails(Set ccIvrTreevoiceDetails) {
		this.ccIvrTreevoiceDetails = ccIvrTreevoiceDetails;
	}

	public String getCustomizeCancel() {
		return customizeCancel;
	}

	public void setCustomizeCancel(String customizeCancel) {
		this.customizeCancel = customizeCancel;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getOrderProgramme() {
		return orderProgramme;
	}

	public void setOrderProgramme(String orderProgramme) {
		this.orderProgramme = orderProgramme;
	}

	
}