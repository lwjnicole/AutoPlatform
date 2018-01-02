package com.lwjnicole.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.service.CaseService;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.CaseVo;

/**
 * 测试用例的执行servlet
 */
public class ActionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * 测试用例的执行方法
     * @param request
     * @param response
     * @return
     */
	public String runCase(HttpServletRequest request,HttpServletResponse response){
		//接收参数
		String cid = request.getParameter("checkedIds");
		//进行分割，存到数组
		String checkedCids[] = cid.split(",");
		//调用业务层
		try{
			CaseService caseService = (CaseService) BeanFactory.getBean("caseService");
			for(int i=0;i<checkedCids.length;i++){
				if(!checkedCids[i].equals("")){
					cid = checkedCids[i];
					CaseVo caseVo = caseService.findCaseByCid(cid);
					System.out.println(caseVo.toString());
					//调用测试用例的执行方法
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return null;
		
	}
}
