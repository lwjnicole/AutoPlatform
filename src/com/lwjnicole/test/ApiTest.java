package com.lwjnicole.test;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.lwjnicole.vo.CaseVo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;  
import static com.jayway.restassured.RestAssured.*;

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
		String cparamtype = caseVo.getCparamtype();
		String cheader = caseVo.getCheader();
		String cresult = caseVo.getCresult();
		
		if(cmethod !=null){
			if("GET".equals(cmethod)){
				if("FORM".equals(cparamtype)){
					Response response = RestAssured.get(curl+cparam);
					System.out.println(response.asString());
					JsonPath jsonPath = new JsonPath(response.asString());
					String[] result = cresult.split("=");
					System.out.println(result[0] + "   " + result[1]);
					String expectResult = jsonPath.getString(result[0]);
					Assert.assertEquals(expectResult, "111");
				}
			}else if("POST".equalsIgnoreCase(cmethod)){
						given().
						header("Content-Type", "application/json").
						body(cparam).
					when().
			        	post(curl).
			        then().
			        	assertThat().statusCode(200).
			        	assertThat().body("result", equalTo(1));
		
									
				
			}
		}
	}
}
