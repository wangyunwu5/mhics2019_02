package cn.own.mhics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="standard")
public class Standard {

	
	@Id
	@Column(name="st_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stId;
	
	@Column(name="describe_en")
	private String describeEn;
	
	@Column(name="describe_cn")
	private String describeCn;
	
	@Column(name="simple_code")
	private String simpleCode;
	
	@Column(name="full_code")
	private String fullCode;
	
	@Column(name="code_mean")
	private String codeMean;
	
	@Column(name="remark")
	private String remark;

	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getDescribeEn() {
		return describeEn;
	}

	public void setDescribeEn(String describeEn) {
		this.describeEn = describeEn;
	}

	public String getDescribeCn() {
		return describeCn;
	}

	public void setDescribeCn(String describeCn) {
		this.describeCn = describeCn;
	}

	public String getSimpleCode() {
		return simpleCode;
	}

	public void setSimpleCode(String simpleCode) {
		this.simpleCode = simpleCode;
	}

	public String getFullCode() {
		return fullCode;
	}

	public void setFullCode(String fullCode) {
		this.fullCode = fullCode;
	}

	public String getCodeMean() {
		return codeMean;
	}

	public void setCodeMean(String codeMean) {
		this.codeMean = codeMean;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Standard [stId=" + stId + ", describeEn=" + describeEn + ", describeCn=" + describeCn + ", simpleCode="
				+ simpleCode + ", fullCode=" + fullCode + ", codeMean=" + codeMean + ", remark=" + remark + "]";
	}
	
}
