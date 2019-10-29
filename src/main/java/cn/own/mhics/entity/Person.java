package cn.own.mhics.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name="account")
	private String account;
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="user_tel")
	private String userTel;
	
	@Column(name="email")
	private String email;
	
	@Column(name="user_pic")
	private String userPic;
	
	@Column(name="hire_date")
	private Date hireDate;
	
	@Column(name="quit_date")
	private Date quitDate;
	
	@Column(name="position")
	private String position;
	
	@Column(name="is_lock")
	private Integer isLock;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	@Override
	public String toString() {
		return "Person [userId=" + userId + ", account=" + account + ", password=" + password + ", name=" + name
				+ ", sex=" + sex + ", userTel=" + userTel + ", email=" + email + ", userPic=" + userPic + ", hireDate="
				+ hireDate + ", quitDate=" + quitDate + ", position=" + position + ", isLock=" + isLock + "]";
	}
	
}
