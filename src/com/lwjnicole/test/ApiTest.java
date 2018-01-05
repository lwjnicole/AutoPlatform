package com.lwjnicole.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.lwjnicole.vo.CaseVo;
import org.testng.annotations.Test;

public class ApiTest {
	
	private CaseVo caseVo;

	public ApiTest(CaseVo caseVo) {
		super();
		this.caseVo = caseVo;
	}
	
	
	@Test
	public void myTest(){
		String cmethod = caseVo.getCmethod();
		String curl = caseVo.getCurl();
		String cparam = caseVo.getCparam();
		if("GET".equals(cmethod)){
			Response response = RestAssured.get(curl+cparam);
			System.out.println(response.asString());
		}
	}
}
