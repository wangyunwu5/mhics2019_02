package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role_resource")
public class RoleResource {
	
	@Id
	@Column(name="rr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rrId;
	
	@Column(name="re_id")
	private Integer reId;
	
	@Column(name="ro_id")
	private Integer roId;

	public Integer getRrId() {
		return rrId;
	}

	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Integer getRoId() {
		return roId;
	}

	public void setRoId(Integer roId) {
		this.roId = roId;
	}

	@Override
	public String toString() {
		return "RoleResource [rrId=" + rrId + ", reId=" + reId + ", roId=" + roId + "]";
	}
	
}
