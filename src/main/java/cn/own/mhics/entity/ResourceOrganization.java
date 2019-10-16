package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource_organization")
public class ResourceOrganization {

	
	@Id
	@Column(name="ro_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roId;
	
	@Column(name="re_id")
	private Integer reId;
	
	@Column(name="or_id")
	private Integer orId;

	public Integer getRoId() {
		return roId;
	}

	public void setRoId(Integer roId) {
		this.roId = roId;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Integer getOrId() {
		return orId;
	}

	public void setOrId(Integer orId) {
		this.orId = orId;
	}

	@Override
	public String toString() {
		return "ResourceOrganization [roId=" + roId + ", reId=" + reId + ", orId=" + orId + "]";
	}
	
}
