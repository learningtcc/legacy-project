package et.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SmsContent generated by MyEclipse Persistence Tools
 */

public class SmsContent implements java.io.Serializable {

	// Fields

	private String id;

	private String sendNum;

	private String sendManId;

	private Date operTime;

	private String content;

	private String quantity;

	private String delSign;

	private String remark;

	private Set smsSends = new HashSet(0);

	private Set smsNotsends = new HashSet(0);

	private Set smsLoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SmsContent() {
	}

	/** minimal constructor */
	public SmsContent(String id) {
		this.id = id;
	}

	/** full constructor */
	public SmsContent(String id, String sendNum, String sendManId,
			Date operTime, String content, String quantity, String delSign,
			String remark, Set smsSends, Set smsNotsends, Set smsLoses) {
		this.id = id;
		this.sendNum = sendNum;
		this.sendManId = sendManId;
		this.operTime = operTime;
		this.content = content;
		this.quantity = quantity;
		this.delSign = delSign;
		this.remark = remark;
		this.smsSends = smsSends;
		this.smsNotsends = smsNotsends;
		this.smsLoses = smsLoses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSendNum() {
		return this.sendNum;
	}

	public void setSendNum(String sendNum) {
		this.sendNum = sendNum;
	}

	public String getSendManId() {
		return this.sendManId;
	}

	public void setSendManId(String sendManId) {
		this.sendManId = sendManId;
	}

	public Date getOperTime() {
		return this.operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDelSign() {
		return this.delSign;
	}

	public void setDelSign(String delSign) {
		this.delSign = delSign;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getSmsSends() {
		return this.smsSends;
	}

	public void setSmsSends(Set smsSends) {
		this.smsSends = smsSends;
	}

	public Set getSmsNotsends() {
		return this.smsNotsends;
	}

	public void setSmsNotsends(Set smsNotsends) {
		this.smsNotsends = smsNotsends;
	}

	public Set getSmsLoses() {
		return this.smsLoses;
	}

	public void setSmsLoses(Set smsLoses) {
		this.smsLoses = smsLoses;
	}

}