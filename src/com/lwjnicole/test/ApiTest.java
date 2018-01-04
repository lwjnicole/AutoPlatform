package com.lwjnicole.test;

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
		System.out.println(caseVo.getCmethod()+","+caseVo.getCurl()+","+caseVo.getCresult()+","+caseVo.getCparam());
	}
}
