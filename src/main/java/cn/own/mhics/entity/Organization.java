package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {
	
	@Id
	@Column(name="or_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orId;
	
	@Column(name="or_name")
	private String orName;//组织名称
	
	@Column(name="or_code")
	private String orCode;//组织编号
	
	@Column(name="parent_code")
	private String parentCode;
	
	@Column(name="sort_id")
	private String sortId;
	
	@Column(name="describe")
	private String describe;

	public Integer getOrId() {
		return orId;
	}

	public void setOrId(Integer orId) {
		this.orId = orId;
	}

	public String getOrName() {
		return orName;
	}

	public void setOrName(String orName) {
		this.orName = orName;
	}

	public String getOrCode() {
		return orCode;
	}

	public void setOrCode(String orCode) {
		this.orCode = orCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "Organization [orId=" + orId + ", orName=" + orName + ", orCode=" + orCode + ", parentCode=" + parentCode
				+ ", sortId=" + sortId + ", describe=" + describe + "]";
	}
	

}
