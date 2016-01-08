package et.po;

import java.util.Date;

/**
 * OperInquiryResult generated by MyEclipse Persistence Tools
 */

public class OperInquiryResult implements java.io.Serializable {

	// Fields

	private String id;

	private String topicId;

	private String actor;

	private String rid;

	private Date createTime;

	private String cardId;

	private String questionType;

	private String question;

	private String answer;

	private String actorOrder;

	private String remark;

	private String num;

	private String questionId;

	// Constructors

	/** default constructor */
	public OperInquiryResult() {
	}

	/** minimal constructor */
	public OperInquiryResult(String id) {
		this.id = id;
	}

	/** full constructor */
	public OperInquiryResult(String id, String topicId, String actor, String rid, Date createTime, String cardId, String questionType, String question, String answer, String actorOrder,
			String remark, String num, String questionId) {
		this.id = id;
		this.topicId = topicId;
		this.actor = actor;
		this.rid = rid;
		this.createTime = createTime;
		this.cardId = cardId;
		this.questionType = questionType;
		this.question = question;
		this.answer = answer;
		this.actorOrder = actorOrder;
		this.remark = remark;
		this.num = num;
		this.questionId = questionId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getActorOrder() {
		return this.actorOrder;
	}

	public void setActorOrder(String actorOrder) {
		this.actorOrder = actorOrder;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}