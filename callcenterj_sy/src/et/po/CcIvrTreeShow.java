package et.po;

/**
 * CcIvrTreeShow generated by MyEclipse Persistence Tools
 */

public class CcIvrTreeShow implements java.io.Serializable {

	// Fields

	private String id;

	private String imgUrl;

	private String action;

	private String nickname;

	private String tagShow;

	private String target;

	// Constructors

	/** default constructor */
	public CcIvrTreeShow() {
	}

	/** minimal constructor */
	public CcIvrTreeShow(String id) {
		this.id = id;
	}

	/** full constructor */
	public CcIvrTreeShow(String id, String imgUrl, String action,
			String nickname, String tagShow, String target) {
		this.id = id;
		this.imgUrl = imgUrl;
		this.action = action;
		this.nickname = nickname;
		this.tagShow = tagShow;
		this.target = target;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTagShow() {
		return this.tagShow;
	}

	public void setTagShow(String tagShow) {
		this.tagShow = tagShow;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}