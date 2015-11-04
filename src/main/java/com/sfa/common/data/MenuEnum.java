package com.sfa.common.data;

public enum MenuEnum {
	// 文件
	FILE_LOGOUT("文件", Type.COMMAND, "logout", "重新登录", null, "logout", "Alt+L"),
	SEPARATOR_01("文件", "separator_01"),
	FILE_EXIT("文件", Type.COMMAND, "exit", "退出", null, "exit", "Alt+X"),

	// 配载操作
	WB_FLIGHT("配载操作", Type.PAGE, "flight", "航班列表", null, "/fxml/wb/flight.fxml"),
	SEPARATOR_02("配载操作", "separator_02"),
	WB_PRE("配载操作", Type.PAGE, "", "转板预配", null, ""),
	WB_PRE2("配载操作", Type.PAGE, "", "转板预配还原", null, ""),

	// 实验室
	LAB_DEMO("实验室", Type.PAGE, "demo", "配载DEMO", null, "/fxml/lab/demo.fxml"),

	// 帮助
	HELP_ABOUT("帮助", Type.ALERT, "about", "关于", null, "/fxml/help/about.fxml", "Alt+A");

	private String parentName;
	private Type type;
	private String code;
	private String name;
	private String icon;
	private String content;
	private String accelerator;

	/**
	 * 分隔符菜单
	 * 
	 * @param parentName
	 * @param code
	 */
	private MenuEnum(String parentName, String code) {
		this(parentName, Type.SEPARATOR, null, null, null, null, null);
	}

	/**
	 * 无快捷键菜单
	 * 
	 * @param parentName
	 * @param type
	 * @param code
	 * @param name
	 * @param menuType
	 * @param content
	 */
	private MenuEnum(String parentName, Type type, String code, String name, String icon, String content) {
		this(parentName, type, code, name, icon, content, null);
	}

	/**
	 * 普通菜单
	 * 
	 * @param parentName
	 * @param type
	 * @param code
	 * @param name
	 * @param icon
	 * @param content
	 * @param accelerator
	 */
	private MenuEnum(String parentName, Type type, String code, String name, String icon, String content,
			String accelerator) {
		this.parentName = parentName;
		this.type = type;
		this.code = code;
		this.name = name;
		this.icon = icon;
		this.content = content;
		this.accelerator = accelerator;
	}

	public String getParentName() {
		return parentName;
	}

	public Type getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getIcon() {
		return icon;
	}

	public String getContent() {
		return content;
	}

	public String getAccelerator() {
		return accelerator;
	}

	public enum Type {
		COMMAND("command", "命令"), SEPARATOR("separator", "分割线"), ALERT("alert", "弹出框"), PAGE("page", "页面");

		private String code;
		private String name;

		private Type(String code, String name) {
			this.code = code;
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return "[name:" + name + ", code:" + code + "]";
		}
	}
}
