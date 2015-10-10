package com.sfa.ghs.custom.vo;

public class SpaceItemVO {
	// 舱位类别
	private String spaceType;
	// 舱位名
	private String spaceName;
	// 舱位限重
	private int spaceWeightLimit;
	// 装载数量
	private int loadAmount;

	public SpaceItemVO() {
		super();
	}

	public SpaceItemVO(String spaceType, String spaceName, int spaceWeightLimit, int loadAmount) {
		super();
		this.spaceType = spaceType;
		this.spaceName = spaceName;
		this.spaceWeightLimit = spaceWeightLimit;
		this.loadAmount = loadAmount;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public String getSpaceName() {
		return spaceName;
	}

	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	public int getSpaceWeightLimit() {
		return spaceWeightLimit;
	}

	public void setSpaceWeightLimit(int spaceWeightLimit) {
		this.spaceWeightLimit = spaceWeightLimit;
	}

	public int getLoadAmount() {
		return loadAmount;
	}

	public void setLoadAmount(int loadAmount) {
		this.loadAmount = loadAmount;
	}
}
