package cn.own.mhics.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task_recive")
public class TaskRecive {

	@Id
	@Column(name="tr_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trId;
	
	@Column(name="task_code")
	private String taskCode;
	
	@Column(name="reciveman_account")
	private String recivemanAccount;
	
	@Column(name="recivezu_code")
	private String recivezuCode;
	
	@Column(name="recive_time")
	private Date reciveTime;
	
	@Column(name="finish_time")
	private Date finishTime;
	
	@Column(name="feedback")
	private String feedBack;

	public Long getTrId() {
		return trId;
	}

	public void setTrId(Long trId) {
		this.trId = trId;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getRecivemanAccount() {
		return recivemanAccount;
	}

	public void setRecivemanAccount(String recivemanAccount) {
		this.recivemanAccount = recivemanAccount;
	}

	public String getRecivezuCode() {
		return recivezuCode;
	}

	public void setRecivezuCode(String recivezuCode) {
		this.recivezuCode = recivezuCode;
	}

	public Date getReciveTime() {
		return reciveTime;
	}

	public void setReciveTime(Date reciveTime) {
		this.reciveTime = reciveTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	@Override
	public String toString() {
		return "TaskRecive [trId=" + trId + ", taskCode=" + taskCode + ", recivemanAccount=" + recivemanAccount
				+ ", recivezuCode=" + recivezuCode + ", reciveTime=" + reciveTime + ", finishTime=" + finishTime
				+ ", feedBack=" + feedBack + "]";
	}

}
