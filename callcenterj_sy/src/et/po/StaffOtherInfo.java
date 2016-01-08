package et.po;

import java.util.Date;

/**
 * StaffOtherInfo generated by MyEclipse Persistence Tools
 */

public class StaffOtherInfo implements java.io.Serializable {

	// Fields

	private String staffId;

	private StaffBasic staffBasic;

	private String AStudyTitle;

	private String ADictTechniclName;

	private String AApproveOrgan;

	private Date AOutTime;

	private String AOutWhy;

	private Date AEnterTime;

	private String ADictUseWorkState;

	private String remark;

	// Constructors

	/** default constructor */
	public StaffOtherInfo() {
	}

	/** minimal constructor */
	public StaffOtherInfo(String staffId, StaffBasic staffBasic) {
		this.staffId = staffId;
		this.staffBasic = staffBasic;
	}

	/** full constructor */
	public StaffOtherInfo(String staffId, StaffBasic staffBasic,
			String AStudyTitle, String ADictTechniclName, String AApproveOrgan,
			Date AOutTime, String AOutWhy, Date AEnterTime,
			String ADictUseWorkState, String remark) {
		this.staffId = staffId;
		this.staffBasic = staffBasic;
		this.AStudyTitle = AStudyTitle;
		this.ADictTechniclName = ADictTechniclName;
		this.AApproveOrgan = AApproveOrgan;
		this.AOutTime = AOutTime;
		this.AOutWhy = AOutWhy;
		this.AEnterTime = AEnterTime;
		this.ADictUseWorkState = ADictUseWorkState;
		this.remark = remark;
	}

	// Property accessors

	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public StaffBasic getStaffBasic() {
		return this.staffBasic;
	}

	public void setStaffBasic(StaffBasic staffBasic) {
		this.staffBasic = staffBasic;
	}

	public String getAStudyTitle() {
		return this.AStudyTitle;
	}

	public void setAStudyTitle(String AStudyTitle) {
		this.AStudyTitle = AStudyTitle;
	}

	public String getADictTechniclName() {
		return this.ADictTechniclName;
	}

	public void setADictTechniclName(String ADictTechniclName) {
		this.ADictTechniclName = ADictTechniclName;
	}

	public String getAApproveOrgan() {
		return this.AApproveOrgan;
	}

	public void setAApproveOrgan(String AApproveOrgan) {
		this.AApproveOrgan = AApproveOrgan;
	}

	public Date getAOutTime() {
		return this.AOutTime;
	}

	public void setAOutTime(Date AOutTime) {
		this.AOutTime = AOutTime;
	}

	public String getAOutWhy() {
		return this.AOutWhy;
	}

	public void setAOutWhy(String AOutWhy) {
		this.AOutWhy = AOutWhy;
	}

	public Date getAEnterTime() {
		return this.AEnterTime;
	}

	public void setAEnterTime(Date AEnterTime) {
		this.AEnterTime = AEnterTime;
	}

	public String getADictUseWorkState() {
		return this.ADictUseWorkState;
	}

	public void setADictUseWorkState(String ADictUseWorkState) {
		this.ADictUseWorkState = ADictUseWorkState;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}