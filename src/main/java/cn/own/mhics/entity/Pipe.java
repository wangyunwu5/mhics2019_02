package cn.own.mhics.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pipe")
public class Pipe {
	
	@Id
	@Column(name="pi_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long piId;
	
	@Column(name="pipe_code")
	private String pipeCode;
	
	@Column(name="node_code")
	private String nodeCode;
	
	@Column(name="pipe_type")
	private String pipeType;
	
	@Column(name="pipe_shape")
	private String pipeShape;
	
	@Column(name="pipe_long")
	private float pipeLong;
	
	@Column(name="pipe_wide")
	private float pipeWide;
	
	@Column(name="backdrop")
	private float backDrop;
	
	@Column(name="pipe_material")
	private String pipeMaterial;
	
	@Column(name="lining")
	private String lining;
	
	@Column(name="pipe_depth")
	private float pipeDepth;
	
	@Column(name="invert")
	private float invert;
	
	@Column(name="photo_no")
	private String photoNo;
	
	@Column(name="wall_no")
	private String wallNo;
	
	@Column(name="location")
	private String location;

	public Long getPiId() {
		return piId;
	}

	public void setPiId(Long piId) {
		this.piId = piId;
	}

	public String getPipeCode() {
		return pipeCode;
	}

	public void setPipeCode(String pipeCode) {
		this.pipeCode = pipeCode;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getPipeType() {
		return pipeType;
	}

	public void setPipeType(String pipeType) {
		this.pipeType = pipeType;
	}

	public String getPipeShape() {
		return pipeShape;
	}

	public void setPipeShape(String pipeShape) {
		this.pipeShape = pipeShape;
	}

	public float getPipeLong() {
		return pipeLong;
	}

	public void setPipeLong(float pipeLong) {
		this.pipeLong = pipeLong;
	}

	public float getPipeWide() {
		return pipeWide;
	}

	public void setPipeWide(float pipeWide) {
		this.pipeWide = pipeWide;
	}

	public float getBackDrop() {
		return backDrop;
	}

	public void setBackDrop(float backDrop) {
		this.backDrop = backDrop;
	}

	public String getPipeMaterial() {
		return pipeMaterial;
	}

	public void setPipeMaterial(String pipeMaterial) {
		this.pipeMaterial = pipeMaterial;
	}

	public String getLining() {
		return lining;
	}

	public void setLining(String lining) {
		this.lining = lining;
	}

	public float getPipeDepth() {
		return pipeDepth;
	}

	public void setPipeDepth(float pipeDepth) {
		this.pipeDepth = pipeDepth;
	}

	public float getInvert() {
		return invert;
	}

	public void setInvert(float invert) {
		this.invert = invert;
	}

	public String getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(String photoNo) {
		this.photoNo = photoNo;
	}

	public String getWallNo() {
		return wallNo;
	}

	public void setWallNo(String wallNo) {
		this.wallNo = wallNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Pipe [piId=" + piId + ", pipeCode=" + pipeCode + ", nodeCode=" + nodeCode + ", pipeType=" + pipeType
				+ ", pipeShape=" + pipeShape + ", pipeLong=" + pipeLong + ", pipeWide=" + pipeWide + ", backDrop="
				+ backDrop + ", pipeMaterial=" + pipeMaterial + ", lining=" + lining + ", pipeDepth=" + pipeDepth
				+ ", invert=" + invert + ", photoNo=" + photoNo + ", wallNo=" + wallNo + ", location=" + location + "]";
	}
	
}
