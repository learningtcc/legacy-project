package base.zyf.web.crud.db;

import java.util.HashSet;
import java.util.Set;

/**
 * CommonTableView generated by MyEclipse Persistence Tools
 */

public class CommonTableView implements java.io.Serializable {

	// Fields

	private String id;

	private String tableName;

	private String rowName;

	private String rowDisplayname;

	private Integer orderby;

	private String remark;

	private String dictName;
	
	private String popLink;
	
	private String style;

	private Set commonTableViewSets = new HashSet(0);

	// Constructors

	/** default constructor */
	public CommonTableView() {
	}

	/** minimal constructor */
	public CommonTableView(String id) {
		this.id = id;
	}



	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getRowName() {
		return this.rowName;
	}

	public void setRowName(String rowName) {
		this.rowName = rowName;
	}

	public String getRowDisplayname() {
		return this.rowDisplayname;
	}

	public void setRowDisplayname(String rowDisplayname) {
		this.rowDisplayname = rowDisplayname;
	}



	public Integer getOrderby() {
		return orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Set getCommonTableViewSets() {
		return this.commonTableViewSets;
	}

	public void setCommonTableViewSets(Set commonTableViewSets) {
		this.commonTableViewSets = commonTableViewSets;
	}

	public String getPopLink() {
		return popLink;
	}

	public void setPopLink(String popLink) {
		this.popLink = popLink;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return the dictName
	 */
	public String getDictName() {
		return dictName;
	}

	/**
	 * @param dictName the dictName to set
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

}