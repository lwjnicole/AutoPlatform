package com.lwjnicole.utils;

import com.lwjnicole.vo.CaseVo;

/**
 *
 * <b>类名：</b>CaseFactory.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2018年1月3日 上午12:17:48
 * @Description 生成测试用例的工厂类
 */
public class CaseFactory {
	public static String getCase(CaseVo caseVo){
		String rt = "\r\n";
		
		String src = "package com.lwjnicole.test;" + rt;
			   src += "import org.testng.annotations.Test;" + rt; 
			   src += "public class myTest{" + rt;
			   src += "	@Test" + rt;
			   src += "	public void test(){" + rt;
			   src += "		System.out.println(\"测试一下\");" + rt;
			   src += "	}" + rt;
			   src += "}";
		return src;
		
	}
}
