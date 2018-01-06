package com.lwjnicole.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import com.lwjnicole.service.CaseService;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.utils.PropertiesUtils;
import com.lwjnicole.vo.CaseVo;

/**
 * 测试类的工厂类，
 * 在带有@Factory注解的方法中调用被执行的测试类,TestNg会自动调用被执行类中带有@Test注解的方法，被执行的测试类为ApiTest；
 * 使用@DataProvider作为数据注入的方式,向Factory中注入数据,并执行测试。
 * @author user
 *
 */
public class ApiTestFactory{
	@DataProvider(name = "datasource")
	public static Object[][] datasource(){
		CaseService caseService = (CaseService) BeanFactory.getBean("caseService");
		List<CaseVo> caseListVo = new ArrayList<CaseVo>();
		CaseVo caseVo = null;
		try{
			File file = new File(PropertiesUtils.getValues("Action_Dir"));
			BufferedReader br = new BufferedReader(new FileReader(file));
			String cid = br.readLine();
			br.close();
			//将cid用逗号分割成数组
			String checkedCids[] = cid.split(",");
			
			for(int i=0;i<checkedCids.length;i++){
				if(!"".equals(checkedCids[i]) && checkedCids[i] != null){
					cid = checkedCids[i];
					caseVo = caseService.findCaseByCid(cid);
					caseListVo.add(caseVo);
				}			
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new Object[][]{
			{caseListVo}
		};
	}
	
	
	@Factory(dataProvider = "datasource")
	public Object[] createTest(List<CaseVo> caseListVo){
		Object[] obj = new Object[caseListVo.size()];
		for(int i=0;i<caseListVo.size();i++){
			obj[i] = new ApiTest(caseListVo.get(i));
		}
		return obj;
		
	}
}
