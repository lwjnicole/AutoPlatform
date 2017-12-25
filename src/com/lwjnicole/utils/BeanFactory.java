package com.lwjnicole.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * <b>类名：</b>BeanFactory.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月24日 下午9:16:54
 * @Description 类工厂
 */
public class BeanFactory {
	public static Object getBean(String id){
		//使用dom4j解析xml文件
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("applicationContext.xml"));
			Element baenElement = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
			String value = baenElement.attributeValue("class");
			Class clazz = Class.forName(value);
			return clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
