package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {
	
	@Id
	@Column(name="re_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reId;
	
	@Column(name="re_name")
	private String reName;
	
	@Column(name="re_code")
	private String reCode;//资源编号
	
	@Column(name="parent_code")
	private String parentCode;//父亲编号
	
	@Column(name="re_icon")
	private String reIcon;//资源图标路径
	
	@Column(name="re_url")//资源访问路径
	private String reUrl;
	
	@Column(name="sort_id")
	private Integer sortId;//排序
	
	@Column(name="type")
	private Integer type;//资源类型，0：菜单，1：按钮，2：其他
	
	@Column(name="status")
	private String status;//资源状态，1：正常，0：冻结

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public String getReName() {
		return reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}

	public String getReCode() {
		return reCode;
	}

	public void setReCode(String reCode) {
		this.reCode = reCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getReIcon() {
		return reIcon;
	}

	public void setReIcon(String reIcon) {
		this.reIcon = reIcon;
	}

	public String getReUrl() {
		return reUrl;
	}

	public void setReUrl(String reUrl) {
		this.reUrl = reUrl;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Resource [reId=" + reId + ", reName=" + reName + ", reCode=" + reCode + ", parentCode=" + parentCode
				+ ", reIcon=" + reIcon + ", reUrl=" + reUrl + ", sortId=" + sortId + ", type=" + type + ", status="
				+ status + "]";
	}
	
}
