package et.po;

import java.util.Date;

/**
 * OperMarketAnalysisScreen generated by MyEclipse Persistence Tools
 */

public class OperMarketAnalysisScreen implements java.io.Serializable {

	// Fields

	private String id;

	private String analysiser;

	private String analysiserInfo;

	private String analysiserPhoto;

	private String title;

	private String analysisContent;

	private String analysisType;

	private String remark;
	
	private Date addTime;

	// Constructors

	/** default constructor */
	public OperMarketAnalysisScreen() {
	}

	/** minimal constructor */
	public OperMarketAnalysisScreen(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperMarketAnalysisScreen(String id, String analysiser,
			String analysiserInfo, String analysiserPhoto, String title,
			String analysisContent, String analysisType, String remark,
			Date addTime) {
		this.id = id;
		this.analysiser = analysiser;
		this.analysiserInfo = analysiserInfo;
		this.analysiserPhoto = analysiserPhoto;
		this.title = title;
		this.analysisContent = analysisContent;
		this.analysisType = analysisType;
		this.remark = remark;
		this.addTime = addTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAnalysiser() {
		return this.analysiser;
	}

	public void setAnalysiser(String analysiser) {
		this.analysiser = analysiser;
	}

	public String getAnalysiserInfo() {
		return this.analysiserInfo;
	}

	public void setAnalysiserInfo(String analysiserInfo) {
		this.analysiserInfo = analysiserInfo;
	}

	public String getAnalysiserPhoto() {
		return this.analysiserPhoto;
	}

	public void setAnalysiserPhoto(String analysiserPhoto) {
		this.analysiserPhoto = analysiserPhoto;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnalysisContent() {
		return this.analysisContent;
	}

	public void setAnalysisContent(String analysisContent) {
		this.analysisContent = analysisContent;
	}

	public String getAnalysisType() {
		return this.analysisType;
	}

	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

}