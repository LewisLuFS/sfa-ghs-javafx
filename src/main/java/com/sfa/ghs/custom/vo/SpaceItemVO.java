package com.sfa.ghs.custom.vo;

public class SpaceItemVO {
	private String name;
	private int num;

	public SpaceItemVO() {
		super();
	}

	public SpaceItemVO(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
