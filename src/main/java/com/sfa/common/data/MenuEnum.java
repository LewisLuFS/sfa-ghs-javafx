package com.sfa.common.data;

public enum MenuEnum {
	// 文件
	FILE_LOGOUT("文件", MenuTypeEnum.COMMAND, "logout", "重新登录", null, "logout", "Ctrl+L"),
	SEPARATOR_01("文件", "separator_01"),
	FILE_EXIT("文件", MenuTypeEnum.COMMAND, "exit", "退出", null, "exit", "Alt+X"),

	// 配载
	WB_FLIGHT("配载", MenuTypeEnum.PAGE, "flight", "航班列表", null, "/fxml/wb/flight.fxml"),
	SEPARATOR_02("配载", "separator_02"),
	WB_PRE("配载", MenuTypeEnum.PAGE, "", "转板预配", null, ""),
	WB_PRE2("配载", MenuTypeEnum.PAGE, "", "转板预配还原", null, ""),
	SEPARATOR_03("配载", "separator_03"),
	WB_CARGE("配载", MenuTypeEnum.PAGE, "", "货邮舱单", null, ""),

	// 实验室
	LAB_DEMO("实验室", MenuTypeEnum.PAGE, "demo", "配载DEMO", null, "/fxml/lab/demo.fxml"),
	LAB_DEMO2("实验室", MenuTypeEnum.PAGE, "demo2", "配载DEMO2", null, "/fxml/lab/demo.fxml"),

	// 帮助
	HELP_ABOUT("帮助", MenuTypeEnum.ALERT, "about", "关于", null, "/fxml/help/about.fxml");

	private String parentName;
	private MenuTypeEnum menuType;
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
		this(parentName, MenuTypeEnum.SEPARATOR, null, null, null, null, null);
	}

	/**
	 * 无快捷键菜单
	 * 
	 * @param parentName
	 * @param code
	 * @param name
	 * @param menuType
	 * @param content
	 */
	private MenuEnum(String parentName, MenuTypeEnum menuType, String code, String name, String icon, String content) {
		this(parentName, menuType, code, name, icon, content, null);
	}

	/**
	 * 普通菜单
	 * 
	 * @param parentName
	 * @param menuType
	 * @param code
	 * @param name
	 * @param icon
	 * @param content
	 * @param accelerator
	 */
	private MenuEnum(String parentName, MenuTypeEnum menuType, String code, String name, String icon, String content,
			String accelerator) {
		this.parentName = parentName;
		this.menuType = menuType;
		this.code = code;
		this.name = name;
		this.icon = icon;
		this.content = content;
		this.accelerator = accelerator;
	}

	public String getParentName() {
		return parentName;
	}

	public MenuTypeEnum getMenuType() {
		return menuType;
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
}
