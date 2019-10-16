package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_organization")
public class PersonOrganization {

	@Id
	@Column(name="po_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer poId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="or_id")
	private Integer orId;

	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrId() {
		return orId;
	}

	public void setOrId(Integer orId) {
		this.orId = orId;
	}

	@Override
	public String toString() {
		return "PersonOrganization [poId=" + poId + ", userId=" + userId + ", orId=" + orId + "]";
	}
	
	
}
