package et.po;

import java.util.Date;

/**
 * ScreenPriceDay generated by MyEclipse Persistence Tools
 */

public class ScreenPriceDay implements java.io.Serializable {

	// Fields

	private String id;

	private String custAddr;

	private String dictProductType1;

	private String dictProductType2;

	private String productName;

	private String productPrice;

	private String remark;

	private Date addtime;

	private String priceUnit;

	private String dictPriceType;

	// Constructors

	/** default constructor */
	public ScreenPriceDay() {
	}

	/** minimal constructor */
	public ScreenPriceDay(String id) {
		this.id = id;
	}

	/** full constructor */
	public ScreenPriceDay(String id, String custAddr, String dictProductType1,
			String dictProductType2, String productName, String productPrice,
			String remark, Date addtime, String priceUnit, String dictPriceType) {
		this.id = id;
		this.custAddr = custAddr;
		this.dictProductType1 = dictProductType1;
		this.dictProductType2 = dictProductType2;
		this.productName = productName;
		this.productPrice = productPrice;
		this.remark = remark;
		this.addtime = addtime;
		this.priceUnit = priceUnit;
		this.dictPriceType = dictPriceType;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustAddr() {
		return this.custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getDictProductType1() {
		return this.dictProductType1;
	}

	public void setDictProductType1(String dictProductType1) {
		this.dictProductType1 = dictProductType1;
	}

	public String getDictProductType2() {
		return this.dictProductType2;
	}

	public void setDictProductType2(String dictProductType2) {
		this.dictProductType2 = dictProductType2;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public String getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getDictPriceType() {
		return this.dictPriceType;
	}

	public void setDictPriceType(String dictPriceType) {
		this.dictPriceType = dictPriceType;
	}

}