package cn.own.mhics.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="node")
public class Node {
	
	@Id
	@Column(name="node_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long nodeId;

	@Column(name="node_code")
	private String nodeCode;
	
	@Column(name="work_no")
	private String workNo;
	
	@Column(name="project_no")
	private String projectNo;
	
	@Column(name="year_laid")
	private Date yearLaid;
	
	@Column(name="status")
	private String status;
	
	@Column(name="function")
	private String function;
	
	@Column(name="node_type")
	private String nodeType;
	
	@Column(name="co_shape")
	private String coShape;
	
	@Column(name="co_type")
	private String coType;
	
	@Column(name="co_duty")
	private String coverDuty;
	
	@Column(name="co_sizec")
	private float coSizec;
	
	@Column(name="co_sizek")
	private float coverSizek;
	
	@Column(name="co_level")
	private float coverLevel;
	
	@Column(name="hinged")
	private String hinged;
	
	@Column(name="locked")
	private String locked;
	
	@Column(name="sh_side_entry")
	private String shSideEntry;
	
	@Column(name="sh_regular_course")
	private String shRegularCourse;
	
	@Column(name="sh_depth")
	private float shDepth;
	
	@Column(name="sh_sizec")
	private float shSizec;

	@Column(name="sh_sizek")
	private float shSizek;
	
	@Column(name="ch_soffit")
	private  String chSoffit;
	
	@Column(name="ch_steps")
	private Integer chSteps;
	
	@Column(name="ch_ladders")
	private Integer chLadders;
	
	@Column(name="ch_lndgs")
	private Integer chLndgs;
	
	@Column(name="ch_sizec")
	private float chSizec;
	
	@Column(name="ch_sizek")
	private float chSizek;
	
	@Column(name="toxic")
	private String toxic;
	
	@Column(name="vermin")
	private String vermin;
	
	@Column(name="con_code")
	private String conCode;
	
	@Column(name="location")
	private String location;
	
	@Column(name="location_pic")
	private String locationPic;
	
	@Column(name="inter_pic")
	private String interPic;
	
	@Column(name="location_sketch")
	private String locationSketch;
	
	@Column(name="plan_ofmh")
	private String planOfmh;
	
	@Column(name="dep_of_flow")
	private float depOfFlow;
	
	@Column(name="dep_of_silt")
	private float depOfSilt;
	
	@Column(name="height_surch")
	private float heightSurch;
	
	@Column(name="mh_dep")
	private float mhDep;
	
	@Column(name="colng")
	private float colng;
	
	@Column(name="colat")
	private float colat;
	
	@Column(name="utr")
	private String utr;
	
	@Column(name="utl")
	private String utl;
	
	@Column(name="utga")
	private String utga;
	
	@Column(name="uts")
	private String uts;
	
	@Column(name="jetting")
	private String jetting;
	
	@Column(name="on_slope")
	private String onSlope;
	
	@Column(name="slope_code")
	private String slopeCode;
	
	@Column(name="co_con")
	private String coCon;
	
	@Column(name="ladder_con")
	private String ladderCon;
	
	@Column(name="ladder_photo")
	private String ladderPhoto;
	
	@Column(name="sh_con")
	private String shCon;
	
	@Column(name="ch_con")
	private String chCon;
	
	@Column(name="ben_con")
	private String benCon;
	
	@Column(name="oth_con")
	private String othCon;
	
	@Column(name="cctv_cond")
	private String cctvCond;
	
	@Column(name="crity")
	private String crity;
	
	@Column(name="re_plan_differ")
	private String rePlanDiffer;
	
	@Column(name="idms_manhole_id")
	private String idmsManholeId;
	
	@Column(name="dsd_ref")
	private String dsdRef;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="w_risk_assess")
	private String wRiskAssess;
	
	@Column(name="w_permit_towork")
	private String wPermitTowork;
	
	@Column(name="w_traffic_permit")
	private String wTrafficPermit;
	
	@Column(name="drarea_code")
	private String drareaCode;
	
	@Column(name="survey_date")
	private Date surveyDate;
	
	@Column(name="survey_account")
	private String surveyAccount;

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public Date getYearLaid() {
		return yearLaid;
	}

	public void setYearLaid(Date yearLaid) {
		this.yearLaid = yearLaid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getCoShape() {
		return coShape;
	}

	public void setCoShape(String coShape) {
		this.coShape = coShape;
	}

	public String getCoType() {
		return coType;
	}

	public void setCoType(String coType) {
		this.coType = coType;
	}

	public String getCoverDuty() {
		return coverDuty;
	}

	public void setCoverDuty(String coverDuty) {
		this.coverDuty = coverDuty;
	}

	public float getCoSizec() {
		return coSizec;
	}

	public void setCoSizec(float coSizec) {
		this.coSizec = coSizec;
	}

	public float getCoverSizek() {
		return coverSizek;
	}

	public void setCoverSizek(float coverSizek) {
		this.coverSizek = coverSizek;
	}

	public float getCoverLevel() {
		return coverLevel;
	}

	public void setCoverLevel(float coverLevel) {
		this.coverLevel = coverLevel;
	}

	public String getHinged() {
		return hinged;
	}

	public void setHinged(String hinged) {
		this.hinged = hinged;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getShSideEntry() {
		return shSideEntry;
	}

	public void setShSideEntry(String shSideEntry) {
		this.shSideEntry = shSideEntry;
	}

	public String getShRegularCourse() {
		return shRegularCourse;
	}

	public void setShRegularCourse(String shRegularCourse) {
		this.shRegularCourse = shRegularCourse;
	}

	public float getShDepth() {
		return shDepth;
	}

	public void setShDepth(float shDepth) {
		this.shDepth = shDepth;
	}

	public float getShSizec() {
		return shSizec;
	}

	public void setShSizec(float shSizec) {
		this.shSizec = shSizec;
	}

	public float getShSizek() {
		return shSizek;
	}

	public void setShSizek(float shSizek) {
		this.shSizek = shSizek;
	}

	public String getChSoffit() {
		return chSoffit;
	}

	public void setChSoffit(String chSoffit) {
		this.chSoffit = chSoffit;
	}

	public Integer getChSteps() {
		return chSteps;
	}

	public void setChSteps(Integer chSteps) {
		this.chSteps = chSteps;
	}

	public Integer getChLadders() {
		return chLadders;
	}

	public void setChLadders(Integer chLadders) {
		this.chLadders = chLadders;
	}

	public Integer getChLndgs() {
		return chLndgs;
	}

	public void setChLndgs(Integer chLndgs) {
		this.chLndgs = chLndgs;
	}

	public float getChSizec() {
		return chSizec;
	}

	public void setChSizec(float chSizec) {
		this.chSizec = chSizec;
	}

	public float getChSizek() {
		return chSizek;
	}

	public void setChSizek(float chSizek) {
		this.chSizek = chSizek;
	}

	public String getToxic() {
		return toxic;
	}

	public void setToxic(String toxic) {
		this.toxic = toxic;
	}

	public String getVermin() {
		return vermin;
	}

	public void setVermin(String vermin) {
		this.vermin = vermin;
	}

	public String getConCode() {
		return conCode;
	}

	public void setConCode(String conCode) {
		this.conCode = conCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationPic() {
		return locationPic;
	}

	public void setLocationPic(String locationPic) {
		this.locationPic = locationPic;
	}

	public String getInterPic() {
		return interPic;
	}

	public void setInterPic(String interPic) {
		this.interPic = interPic;
	}

	public String getLocationSketch() {
		return locationSketch;
	}

	public void setLocationSketch(String locationSketch) {
		this.locationSketch = locationSketch;
	}

	public String getPlanOfmh() {
		return planOfmh;
	}

	public void setPlanOfmh(String planOfmh) {
		this.planOfmh = planOfmh;
	}

	public float getDepOfFlow() {
		return depOfFlow;
	}

	public void setDepOfFlow(float depOfFlow) {
		this.depOfFlow = depOfFlow;
	}

	public float getDepOfSilt() {
		return depOfSilt;
	}

	public void setDepOfSilt(float depOfSilt) {
		this.depOfSilt = depOfSilt;
	}

	public float getHeightSurch() {
		return heightSurch;
	}

	public void setHeightSurch(float heightSurch) {
		this.heightSurch = heightSurch;
	}

	public float getMhDep() {
		return mhDep;
	}

	public void setMhDep(float mhDep) {
		this.mhDep = mhDep;
	}

	public float getColng() {
		return colng;
	}

	public void setColng(float colng) {
		this.colng = colng;
	}

	public float getColat() {
		return colat;
	}

	public void setColat(float colat) {
		this.colat = colat;
	}

	public String getUtr() {
		return utr;
	}

	public void setUtr(String utr) {
		this.utr = utr;
	}

	public String getUtl() {
		return utl;
	}

	public void setUtl(String utl) {
		this.utl = utl;
	}

	public String getUtga() {
		return utga;
	}

	public void setUtga(String utga) {
		this.utga = utga;
	}

	public String getUts() {
		return uts;
	}

	public void setUts(String uts) {
		this.uts = uts;
	}

	public String getJetting() {
		return jetting;
	}

	public void setJetting(String jetting) {
		this.jetting = jetting;
	}

	public String getOnSlope() {
		return onSlope;
	}

	public void setOnSlope(String onSlope) {
		this.onSlope = onSlope;
	}

	public String getSlopeCode() {
		return slopeCode;
	}

	public void setSlopeCode(String slopeCode) {
		this.slopeCode = slopeCode;
	}

	public String getCoCon() {
		return coCon;
	}

	public void setCoCon(String coCon) {
		this.coCon = coCon;
	}

	public String getLadderCon() {
		return ladderCon;
	}

	public void setLadderCon(String ladderCon) {
		this.ladderCon = ladderCon;
	}

	public String getLadderPhoto() {
		return ladderPhoto;
	}

	public void setLadderPhoto(String ladderPhoto) {
		this.ladderPhoto = ladderPhoto;
	}

	public String getShCon() {
		return shCon;
	}

	public void setShCon(String shCon) {
		this.shCon = shCon;
	}

	public String getChCon() {
		return chCon;
	}

	public void setChCon(String chCon) {
		this.chCon = chCon;
	}

	public String getBenCon() {
		return benCon;
	}

	public void setBenCon(String benCon) {
		this.benCon = benCon;
	}

	public String getOthCon() {
		return othCon;
	}

	public void setOthCon(String othCon) {
		this.othCon = othCon;
	}

	public String getCctvCond() {
		return cctvCond;
	}

	public void setCctvCond(String cctvCond) {
		this.cctvCond = cctvCond;
	}

	public String getCrity() {
		return crity;
	}

	public void setCrity(String crity) {
		this.crity = crity;
	}

	public String getRePlanDiffer() {
		return rePlanDiffer;
	}

	public void setRePlanDiffer(String rePlanDiffer) {
		this.rePlanDiffer = rePlanDiffer;
	}

	public String getIdmsManholeId() {
		return idmsManholeId;
	}

	public void setIdmsManholeId(String idmsManholeId) {
		this.idmsManholeId = idmsManholeId;
	}

	public String getDsdRef() {
		return dsdRef;
	}

	public void setDsdRef(String dsdRef) {
		this.dsdRef = dsdRef;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getwRiskAssess() {
		return wRiskAssess;
	}

	public void setwRiskAssess(String wRiskAssess) {
		this.wRiskAssess = wRiskAssess;
	}

	public String getwPermitTowork() {
		return wPermitTowork;
	}

	public void setwPermitTowork(String wPermitTowork) {
		this.wPermitTowork = wPermitTowork;
	}

	public String getwTrafficPermit() {
		return wTrafficPermit;
	}

	public void setwTrafficPermit(String wTrafficPermit) {
		this.wTrafficPermit = wTrafficPermit;
	}

	public String getDrareaCode() {
		return drareaCode;
	}

	public void setDrareaCode(String drareaCode) {
		this.drareaCode = drareaCode;
	}

	public Date getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}

	public String getSurveyAccount() {
		return surveyAccount;
	}

	public void setSurveyAccount(String surveyAccount) {
		this.surveyAccount = surveyAccount;
	}

	@Override
	public String toString() {
		return "Node [nodeId=" + nodeId + ", nodeCode=" + nodeCode + ", workNo=" + workNo + ", projectNo=" + projectNo
				+ ", yearLaid=" + yearLaid + ", status=" + status + ", function=" + function + ", nodeType=" + nodeType
				+ ", coShape=" + coShape + ", coType=" + coType + ", coverDuty=" + coverDuty + ", coSizec=" + coSizec
				+ ", coverSizek=" + coverSizek + ", coverLevel=" + coverLevel + ", hinged=" + hinged + ", locked="
				+ locked + ", shSideEntry=" + shSideEntry + ", shRegularCourse=" + shRegularCourse + ", shDepth="
				+ shDepth + ", shSizec=" + shSizec + ", shSizek=" + shSizek + ", chSoffit=" + chSoffit + ", chSteps="
				+ chSteps + ", chLadders=" + chLadders + ", chLndgs=" + chLndgs + ", chSizec=" + chSizec + ", chSizek="
				+ chSizek + ", toxic=" + toxic + ", vermin=" + vermin + ", conCode=" + conCode + ", location="
				+ location + ", locationPic=" + locationPic + ", interPic=" + interPic + ", locationSketch="
				+ locationSketch + ", planOfmh=" + planOfmh + ", depOfFlow=" + depOfFlow + ", depOfSilt=" + depOfSilt
				+ ", heightSurch=" + heightSurch + ", mhDep=" + mhDep + ", colng=" + colng + ", colat=" + colat
				+ ", utr=" + utr + ", utl=" + utl + ", utga=" + utga + ", uts=" + uts + ", jetting=" + jetting
				+ ", onSlope=" + onSlope + ", slopeCode=" + slopeCode + ", coCon=" + coCon + ", ladderCon=" + ladderCon
				+ ", ladderPhoto=" + ladderPhoto + ", shCon=" + shCon + ", chCon=" + chCon + ", benCon=" + benCon
				+ ", othCon=" + othCon + ", cctvCond=" + cctvCond + ", crity=" + crity + ", rePlanDiffer="
				+ rePlanDiffer + ", idmsManholeId=" + idmsManholeId + ", dsdRef=" + dsdRef + ", remark=" + remark
				+ ", wRiskAssess=" + wRiskAssess + ", wPermitTowork=" + wPermitTowork + ", wTrafficPermit="
				+ wTrafficPermit + ", drareaCode=" + drareaCode + ", surveyDate=" + surveyDate + ", surveyAccount="
				+ surveyAccount + "]";
	}
	
}
