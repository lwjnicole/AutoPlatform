package com.lwjnicole.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * <b>类名：</b>BaseServlet.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月24日 下午8:25:33
 * @Description 通用的servlet
 */
public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//接收参数
		String methodName = req.getParameter("method");
		
		if(methodName == null || "".equals(methodName)){
			resp.getWriter().println("method参数为null!!!");
			return;
		}
		//获得子类的Class对象
		Class clazz = this.getClass();
		//获得子类中的所有方法
		try {
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//执行方法
			String path = (String) method.invoke(this, req,resp);
			
			if(path != null){
				req.getRequestDispatcher(path).forward(req, resp);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
