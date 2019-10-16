package cn.own.mhics.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solog")
public class Solog {

	@Id
	@Column(name="sol_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long solId;
	
	@Column(name="login_account")
	private String loginAccount;
	
	@Column(name="login_time")
	private Date loginTime;
	
	@Column(name="logout_time")
	private Date logoutTime;
	
	@Column(name="ip")
	private String ip;//登录ip
	
	@Column(name="login_way")
	private String loginWay;//登录方式，PC端、移动端
	
	@Column(name="operation_name")
	private String operationName;//操作名称
	
	@Column(name="operation_type")
	private String operationType;//操作类型，0:添加，1:修改，2:删除，3:查询

	public Long getSolId() {
		return solId;
	}

	public void setSolId(Long solId) {
		this.solId = solId;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLoginWay() {
		return loginWay;
	}

	public void setLoginWay(String loginWay) {
		this.loginWay = loginWay;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "Solog [solId=" + solId + ", loginAccount=" + loginAccount + ", loginTime=" + loginTime + ", logoutTime="
				+ logoutTime + ", ip=" + ip + ", loginWay=" + loginWay + ", operationName=" + operationName
				+ ", operationType=" + operationType + "]";
	}
	
	
}
