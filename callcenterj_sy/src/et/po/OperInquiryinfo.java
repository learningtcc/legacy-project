package et.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OperInquiryinfo generated by MyEclipse Persistence Tools
 */

public class OperInquiryinfo implements java.io.Serializable {

	// Fields

	private String id;

	private String dictInquiryType;

	private String topic;

	private String organiztion;

	private String aim;

	private Date beginTime;

	private Date endTime;

	private String organizers;

	private String actors;

	private String detail;

	private String resultReport;

	private String reportTopic;

	private String reportTopic2;

	private String reportCopywriter;

	private String reportKeyword;

	private String reportAbstract;

	private String reportSwatch;

	private String reportEfficiency;

	private String reportContent;

	private String reportReview;

	private String reportRemark;

	private String state;

	private String reportState;

	private Set operInquiryCards = new HashSet(0);
	
	private String caserid;

	// Constructors

	/** default constructor */
	public OperInquiryinfo() {
	}

	/** minimal constructor */
	public OperInquiryinfo(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperInquiryinfo(String id, String dictInquiryType, String topic, String organiztion, String aim, Date beginTime, Date endTime, String organizers, String actors, String detail,
			String resultReport, String reportTopic, String reportTopic2, String reportCopywriter, String reportKeyword, String reportAbstract, String reportSwatch, String reportEfficiency,
			String reportContent, String reportReview, String reportRemark, String state, String reportState, Set operInquiryCards, String caserid) {
		this.id = id;
		this.dictInquiryType = dictInquiryType;
		this.topic = topic;
		this.organiztion = organiztion;
		this.aim = aim;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.organizers = organizers;
		this.actors = actors;
		this.detail = detail;
		this.resultReport = resultReport;
		this.reportTopic = reportTopic;
		this.reportTopic2 = reportTopic2;
		this.reportCopywriter = reportCopywriter;
		this.reportKeyword = reportKeyword;
		this.reportAbstract = reportAbstract;
		this.reportSwatch = reportSwatch;
		this.reportEfficiency = reportEfficiency;
		this.reportContent = reportContent;
		this.reportReview = reportReview;
		this.reportRemark = reportRemark;
		this.state = state;
		this.reportState = reportState;
		this.operInquiryCards = operInquiryCards;
		this.caserid = caserid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictInquiryType() {
		return this.dictInquiryType;
	}

	public void setDictInquiryType(String dictInquiryType) {
		this.dictInquiryType = dictInquiryType;
	}

	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getOrganiztion() {
		return this.organiztion;
	}

	public void setOrganiztion(String organiztion) {
		this.organiztion = organiztion;
	}

	public String getAim() {
		return this.aim;
	}

	public void setAim(String aim) {
		this.aim = aim;
	}

	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getOrganizers() {
		return this.organizers;
	}

	public void setOrganizers(String organizers) {
		this.organizers = organizers;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getResultReport() {
		return this.resultReport;
	}

	public void setResultReport(String resultReport) {
		this.resultReport = resultReport;
	}

	public String getReportTopic() {
		return this.reportTopic;
	}

	public void setReportTopic(String reportTopic) {
		this.reportTopic = reportTopic;
	}

	public String getReportTopic2() {
		return this.reportTopic2;
	}

	public void setReportTopic2(String reportTopic2) {
		this.reportTopic2 = reportTopic2;
	}

	public String getReportCopywriter() {
		return this.reportCopywriter;
	}

	public void setReportCopywriter(String reportCopywriter) {
		this.reportCopywriter = reportCopywriter;
	}

	public String getReportKeyword() {
		return this.reportKeyword;
	}

	public void setReportKeyword(String reportKeyword) {
		this.reportKeyword = reportKeyword;
	}

	public String getReportAbstract() {
		return this.reportAbstract;
	}

	public void setReportAbstract(String reportAbstract) {
		this.reportAbstract = reportAbstract;
	}

	public String getReportSwatch() {
		return this.reportSwatch;
	}

	public void setReportSwatch(String reportSwatch) {
		this.reportSwatch = reportSwatch;
	}

	public String getReportEfficiency() {
		return this.reportEfficiency;
	}

	public void setReportEfficiency(String reportEfficiency) {
		this.reportEfficiency = reportEfficiency;
	}

	public String getReportContent() {
		return this.reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportReview() {
		return this.reportReview;
	}

	public void setReportReview(String reportReview) {
		this.reportReview = reportReview;
	}

	public String getReportRemark() {
		return this.reportRemark;
	}

	public void setReportRemark(String reportRemark) {
		this.reportRemark = reportRemark;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReportState() {
		return this.reportState;
	}

	public void setReportState(String reportState) {
		this.reportState = reportState;
	}

	public Set getOperInquiryCards() {
		return this.operInquiryCards;
	}

	public void setOperInquiryCards(Set operInquiryCards) {
		this.operInquiryCards = operInquiryCards;
	}

	public String getCaserid() {
		return caserid;
	}

	public void setCaserid(String caserid) {
		this.caserid = caserid;
	}

}