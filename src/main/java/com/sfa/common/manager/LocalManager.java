package com.sfa.common.manager;

import java.util.HashMap;
import java.util.Map;

import com.sfa.MainApp;
import com.sfa.common.util.SysUser;

/**
 * LocalManager是全局管理器，只有一个私有的构造方法，不提供其他方法来获取其对象。
 * 
 * @author 431520
 */
public class LocalManager {
	// 用于保存客户端全局信息的Map对象
	private final static Map<String, Object> params = new HashMap<>();
	// User对象对应的键值
	private final static String userKey = "user";
	// Main对象的键值
	private final static String appKey = "app";

	private LocalManager() {

	}

	public static Object getParam(String key) {
		return params.get(key);
	}

	public static void setParam(String key, Object value) {
		params.put(key, value);
	}

	public static void clearParams() {
		params.clear();
	}

	public static SysUser getUser() {
		return (SysUser) params.get(userKey);
	}

	public static void setUser(SysUser user) {
		user.setPassword("");
		params.put(userKey, user);
	}

	public static void cleanUser() {
		params.remove(userKey);
	}

	public static void setApp(MainApp app) {
		params.put(appKey, app);
	}

	public static MainApp getApp() {
		return (MainApp) params.get(appKey);
	}
}
