package com.lwjnicole.web.servlet;

import java.io.File;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.service.ActionService;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.utils.PropertiesUtils;

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
		File file = new File(PropertiesUtils.getValues("Action_Dir"));			
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			fw.write(cid);
			fw.close();
			
			ActionService actionService = (ActionService) BeanFactory.getBean("actionService");
			//调用业务层的执行用例方法
			actionService.action();
			
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/CaseServlet?method=findAllCase");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
