package com.lwjnicole.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

import com.lwjnicole.service.ActionService;
import com.lwjnicole.utils.CreateFileUtils;
import com.lwjnicole.vo.CaseVo;

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
	public void action(CaseVo caseVo) {
		CreateFileUtils.CreateJavaFile(caseVo);
		 TestNG testNG = new TestNG();
		 List<String> suites = new ArrayList<String>(); 
		 suites.add(".\\testng.xml");
		 testNG.setTestSuites(suites);
		 testNG.run();		
	}
	
}
