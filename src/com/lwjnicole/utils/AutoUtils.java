package com.lwjnicole.utils;

import java.text.SimpleDateFormat;

public class AutoUtils {
	/**
	 * 生成站点ID
	 * @return
	 */
	public static String getSiteId(){
		return "S" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());
	}
	
	/**
	 * 生成接口ID
	 * @return
	 */
	public static String getApiId(){
		return "A" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());
	}
}
