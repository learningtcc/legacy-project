package et.po;

import java.sql.Date;

/**
 * EasyConfChannelState generated by MyEclipse Persistence Tools
 */

public class EasyConfChannelState implements java.io.Serializable {

	// Fields

	private Integer id;

	private Integer channelno;

	private String callerid;

	private Integer roomno;

	private Integer currentstate;

	private Integer newstate;

	private String deleteMark;
	
	private String allowflag;

	private Date addtime;
	// Constructors

	/** default constructor */
	public EasyConfChannelState() {
	}

	/** full constructor */
	public EasyConfChannelState(Integer channelno, String callerid,
			Integer roomno, Integer currentstate, Integer newstate,
			String deleteMark) {
		this.channelno = channelno;
		this.callerid = callerid;
		this.roomno = roomno;
		this.currentstate = currentstate;
		this.newstate = newstate;
		this.deleteMark = deleteMark;
	}

	// Property accessors

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getChannelno() {
		return this.channelno;
	}

	public void setChannelno(Integer channelno) {
		this.channelno = channelno;
	}

	public String getCallerid() {
		return this.callerid;
	}

	public void setCallerid(String callerid) {
		this.callerid = callerid;
	}

	public Integer getRoomno() {
		return this.roomno;
	}

	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
	}

	public Integer getCurrentstate() {
		return this.currentstate;
	}

	public void setCurrentstate(Integer currentstate) {
		this.currentstate = currentstate;
	}

	public Integer getNewstate() {
		return this.newstate;
	}

	public void setNewstate(Integer newstate) {
		this.newstate = newstate;
	}

	public String getDeleteMark() {
		return this.deleteMark;
	}

	public void setDeleteMark(String deleteMark) {
		this.deleteMark = deleteMark;
	}

	public String getAllowflag() {
		return allowflag;
	}

	public void setAllowflag(String allowflag) {
		this.allowflag = allowflag;
	}

}