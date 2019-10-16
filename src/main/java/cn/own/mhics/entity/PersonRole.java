package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personrole")
public class PersonRole {
	
	@Id
	@Column(name="pr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer prId;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="user_id")
	private Long userId;

	public Integer getPrId() {
		return prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PersonRole [prId=" + prId + ", roleId=" + roleId + ", userId=" + userId + "]";
	}
	
	

}
