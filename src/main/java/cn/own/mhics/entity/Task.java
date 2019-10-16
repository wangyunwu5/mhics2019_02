package cn.own.mhics.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {

	@Id
	@Column(name="ta_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long taId;
	
	@Column(name="task_code")
	private String taskCode;//任务编号
	
	@Column(name="create_account")
	private String createAccount;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="content")
	private String content;
	
	@Column(name="status")
	private Integer status;//任务状态，
	
	@Column(name="node_code")
	private String nodeCode;
	
	@Column(name="type")
	private Integer type;//任务类型，0：调查，1：巡查
	
	@Column(name="priority")
	private Integer  priority;//优先级别，0：急，1：高，2：中，3：低

	public Long getTaId() {
		return taId;
	}

	public void setTaId(Long taId) {
		this.taId = taId;
	}
	
	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getCreateAccount() {
		return createAccount;
	}

	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Task [taId=" + taId + ", taskCode=" + taskCode + ", createAccount=" + createAccount + ", createTime="
				+ createTime + ", startTime=" + startTime + ", endTime=" + endTime + ", content=" + content
				+ ", status=" + status + ", nodeCode=" + nodeCode + ", type=" + type + ", priority=" + priority + "]";
	}
}
