package com.lwjnicole.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性文件的工具类
 * @author user
 *
 */
public class PropertiesUtils {
	private static Properties pro = new Properties();
	public static String getValues(String key){
		
		try {
			InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties");
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro.getProperty(key);
	}
}
