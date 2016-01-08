package et.po;

import java.util.Date;

/**
 * OperCorpinfo generated by MyEclipse Persistence Tools
 */

public class OperCorpinfo implements java.io.Serializable {

	// Fields

	private String id;

	private String corpRid;

	private String expert;

	private Date createtime;

	private String custName;

	private String custTel;

	private String custAddr;

	private String state;

	private String dictServiceType;

	private String contents;

	private String reply;

	private String remark;

	private String uploadfile;

	// Constructors

	/** default constructor */
	public OperCorpinfo() {
	}

	/** minimal constructor */
	public OperCorpinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperCorpinfo(String id, String corpRid, String expert, Date createtime, String custName, String custTel, String custAddr, String state, String dictServiceType, String contents,
			String reply, String remark, String uploadfile) {
		this.id = id;
		this.corpRid = corpRid;
		this.expert = expert;
		this.createtime = createtime;
		this.custName = custName;
		this.custTel = custTel;
		this.custAddr = custAddr;
		this.state = state;
		this.dictServiceType = dictServiceType;
		this.contents = contents;
		this.reply = reply;
		this.remark = remark;
		this.uploadfile = uploadfile;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorpRid() {
		return this.corpRid;
	}

	public void setCorpRid(String corpRid) {
		this.corpRid = corpRid;
	}

	public String getExpert() {
		return this.expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustTel() {
		return this.custTel;
	}

	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDictServiceType() {
		return this.dictServiceType;
	}

	public void setDictServiceType(String dictServiceType) {
		this.dictServiceType = dictServiceType;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUploadfile() {
		return this.uploadfile;
	}

	public void setUploadfile(String uploadfile) {
		this.uploadfile = uploadfile;
	}

}