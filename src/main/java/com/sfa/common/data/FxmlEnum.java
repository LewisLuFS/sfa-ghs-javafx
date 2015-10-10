package com.sfa.common.data;

public enum FxmlEnum {
	// 登录
	login(400, 240, "登录", "/fxml/login.fxml"),
	// 主页面
	main(1200, 800, "GHS配载系统客户端 - V0.1 Demo", "/fxml/main.fxml", true, true);

	private double width;
	private double height;
	private String title;
	private String file;
	private boolean resizable;
	private boolean maximized;

	private FxmlEnum(double width, double height, String title, String file) {
		this(width, height, title, file, false, false);
	}

	private FxmlEnum(double width, double height, String title, String file, boolean resizable, boolean maximized) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.file = file;
		this.resizable = resizable;
		this.maximized = maximized;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}

	public String getFile() {
		return file;
	}

	public boolean isResizable() {
		return resizable;
	}

	public boolean isMaximized() {
		return maximized;
	}
}
