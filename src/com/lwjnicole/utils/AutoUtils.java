package com.lwjnicole.utils;

import java.text.SimpleDateFormat;

public class AutoUtils {
	/**
	 * 生成站点ID
	 * @return
	 */
	public static String getSiteId(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(System.currentTimeMillis());
	}
}
