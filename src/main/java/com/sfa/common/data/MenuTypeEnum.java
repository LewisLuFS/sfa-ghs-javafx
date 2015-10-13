package com.sfa.common.data;

/**
 * 菜单类型
 * <ul>
 * <li>COMMAND: 命令，例如重新登录，退出等</li>
 * <li>SEPARATOR: 分隔符</li>
 * <li>ALERT: 弹出框，例如关于等</li>
 * <li>PAGE: 页面</li>
 * </ul>
 * 
 * @author 431520
 */
public enum MenuTypeEnum {
	COMMAND("command", "命令"), SEPARATOR("separator", "分割线"), ALERT("alert", "弹出框"), PAGE("page", "页面");

	private String code;
	private String name;

	private MenuTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "[name:" + name + ", code:" + code + "]";
	}
}
