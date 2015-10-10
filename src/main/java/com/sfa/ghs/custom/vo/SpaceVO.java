package com.sfa.ghs.custom.vo;

import java.util.List;

public class SpaceVO {
	private List<SpaceItemVO> mainSpaces;
	private List<SpaceItemVO> fwdSpaces;
	private List<SpaceItemVO> aftSpaces;

	public List<SpaceItemVO> getMainSpaces() {
		return mainSpaces;
	}

	public void setMainSpaces(List<SpaceItemVO> mainSpaces) {
		this.mainSpaces = mainSpaces;
	}

	public List<SpaceItemVO> getFwdSpaces() {
		return fwdSpaces;
	}

	public void setFwdSpaces(List<SpaceItemVO> fwdSpaces) {
		this.fwdSpaces = fwdSpaces;
	}

	public List<SpaceItemVO> getAftSpaces() {
		return aftSpaces;
	}

	public void setAftSpaces(List<SpaceItemVO> aftSpaces) {
		this.aftSpaces = aftSpaces;
	}
}
