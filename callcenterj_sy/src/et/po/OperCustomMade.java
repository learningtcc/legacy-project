package et.po;

import java.util.Date;

/**
 * OperCustomMade generated by MyEclipse Persistence Tools
 */

public class OperCustomMade implements java.io.Serializable {

	// Fields

	private String id;

	private String serviceType;

	private String columnName;

	private String columnDetail;

	private String customMadeMethod;

	private String priceInfo;

	private String remark;

	private String recordPerson;

	private Date recordTime;

	private Date addtime;

	// Constructors

	/** default constructor */
	public OperCustomMade() {
	}

	/** minimal constructor */
	public OperCustomMade(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperCustomMade(String id, String serviceType, String columnName, String columnDetail, String customMadeMethod, String priceInfo, String remark, String recordPerson, Date recordTime,
			Date addtime) {
		this.id = id;
		this.serviceType = serviceType;
		this.columnName = columnName;
		this.columnDetail = columnDetail;
		this.customMadeMethod = customMadeMethod;
		this.priceInfo = priceInfo;
		this.remark = remark;
		this.recordPerson = recordPerson;
		this.recordTime = recordTime;
		this.addtime = addtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnDetail() {
		return this.columnDetail;
	}

	public void setColumnDetail(String columnDetail) {
		this.columnDetail = columnDetail;
	}

	public String getCustomMadeMethod() {
		return this.customMadeMethod;
	}

	public void setCustomMadeMethod(String customMadeMethod) {
		this.customMadeMethod = customMadeMethod;
	}

	public String getPriceInfo() {
		return this.priceInfo;
	}

	public void setPriceInfo(String priceInfo) {
		this.priceInfo = priceInfo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRecordPerson() {
		return this.recordPerson;
	}

	public void setRecordPerson(String recordPerson) {
		this.recordPerson = recordPerson;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

}