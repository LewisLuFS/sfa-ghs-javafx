package com.sfa.common.data;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum MenuEnum {
	// 配载管理
	WB_FLIGHT("航班列表", "配载管理", ""),
	WB_PRE_("转板预配", "配载管理", ""),
	WB_abc("货邮舱单", "配载管理", ""),

	// 实验室
	LAB_DEMO("配载DEMO", "实验室", "/fxml/lab/demo.fxml"),
	LAB_CRUD("单表CRUD", "实验室", "/fxml/lab/crud.fxml"),
	LAB_ALERT("弹出框", "实验室", "/fxml/lab/alert.fxml"),
	LAB_DROP("拖拉拽", "实验室", "/fxml/lab/drop.fxml"),
	LAB_CUSTOMER_UI("自定义组件", "实验室", "/fxml/lab/customerUI.fxml"),

	// 帮助
	HELP_ABOUT("关于", "帮助", "/fxml/help/about.fxml");

	private String name;
	private String parentName;
	private String file;

	private MenuEnum(String name, String parentName, String file) {
		this.name = name;
		this.parentName = parentName;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public String getParentName() {
		return parentName;
	}

	public String getFile() {
		return file;
	}

	private static final Map<String, MenuEnum> lookup = new HashMap<String, MenuEnum>();

	static {
		for (MenuEnum menu : EnumSet.allOf(MenuEnum.class)) {
			lookup.put(menu.getName(), menu);
		}
	}

	public static MenuEnum find(String name, MenuEnum menuEnum) {
		MenuEnum value = lookup.get(name);
		if (value == null) {
			return null;
		}
		return value;
	}
}
