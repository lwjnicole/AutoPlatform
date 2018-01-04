package com.lwjnicole.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.lwjnicole.service.ActionService;
import com.lwjnicole.web.listener.ExtentIReporterListener;

/**
 *
 * <b>类名：</b>ActionServiceImpl.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2018年1月3日 上午12:04:22
 * @Description 用例执行接口的实现类
 */
public class ActionServiceImpl implements ActionService {

	/**
	 * 测试用例的执行方法
	 */
	@Override
	public void action() {
		//执行testng,在testng.xml中定义需要执行的测试类
		 /*TestNG testNG = new TestNG();
		 List<String> suites = new ArrayList<String>(); 
		 suites.add(".\\testng.xml");
		 testNG.setTestSuites(suites);
		 testNG.run();		*/
		
		//动态生成testng.xml文件，生成一个在内存中存在的虚拟testng.xml
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");

		XmlTest test = new XmlTest(suite);
		test.setName("Test");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.lwjnicole.test.ApiTestFactory"));
		test.setXmlClasses(classes);
		//将这个XmlSuite传递给TestNG
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		ExtentIReporterListener extentIReporterListener = new ExtentIReporterListener();
		TestNG tng = new TestNG();
		tng.addListener(extentIReporterListener);
		tng.setXmlSuites(suites);
		tng.run(); 
	}
	
}
