package com.sfa.ghs.custom.vo;

public class BRItemVO {
	private String uldNo;
	private int weight;
	private String dest;
	private String type;

	public BRItemVO() {
		super();
	}

	public BRItemVO(String uldNo, int weight, String dest, String type) {
		super();
		this.uldNo = uldNo;
		this.weight = weight;
		this.dest = dest;
		this.type = type;
	}

	public String getUldNo() {
		return uldNo;
	}

	public void setUldNo(String uldNo) {
		this.uldNo = uldNo;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
