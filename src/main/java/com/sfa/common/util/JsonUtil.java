package com.sfa.common.util;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * JSON 操作工具类
 */
public class JsonUtil {
	public static final Logger logger = Logger.getLogger(JsonUtil.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 将 Java 对象转为 JSON 字符串
	 */
	public static <T> String toJson(T obj) {
		String jsonStr;
		try {
			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("Java转JSON出错！", e);
			throw new RuntimeException(e);
		}
		return jsonStr;
	}

	/**
	 * 将 JSON 字符串转为 Java 对象
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		T obj;
		try {
			obj = objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			logger.error("JSON转Java出错！", e);
			throw new RuntimeException(e);
		}
		return obj;
	}
}
