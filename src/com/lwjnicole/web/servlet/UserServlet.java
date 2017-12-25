package com.lwjnicole.web.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.domain.User;
import com.lwjnicole.service.UserService;
import com.lwjnicole.utils.BeanFactory;

/**
 * 用户模块的servlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	public String login(HttpServletRequest request,HttpServletResponse response){
		//接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//封装参数
		User user = new User();
		user.setUsername(username);
		user.setPwd(password);
		//调用业务层
		UserService userService = (UserService) BeanFactory.getBean("userService");
		try {
			User exitUser = userService.login(user);
			//页面跳转
			if(exitUser != null){
				//登录成功
				//记住用户名
				String remember = request.getParameter("remember");
				if("true".equals(remember)){
					Cookie cookie =  new Cookie("username", exitUser.getUsername());
					cookie.setPath("/AutoPlatform");
					cookie.setMaxAge(24*60*60);
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("user", exitUser);
				return "/view/HomePage.jsp";
			}else {
				//登录失败
				request.setAttribute("msg", "用户名或密码错误");
				return "/view/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	/**
	 * 退出功能
	 * @param request
	 * @param response
	 * @return
	 */
	public String logOut(HttpServletRequest request,HttpServletResponse response){
		//销毁session
		request.getSession().invalidate();
		
		try {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 跳转到锁屏页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String lockUI(HttpServletRequest request,HttpServletResponse response){
		try {
			response.sendRedirect(request.getContextPath() + "/view/lock.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
		
	}
	
	/**
	 * 锁屏后，重新登录功能
	 * @param request
	 * @param response
	 * @return
	 */
	public String relogin(HttpServletRequest request,HttpServletResponse response){
		//接收参数
		String password = request.getParameter("password");
		//调用业务层
		User exitUser = (User) request.getSession().getAttribute("user");
		String username = exitUser.getUsername();
		
		UserService userService = (UserService) BeanFactory.getBean("userService");
		User user = null;
		try {
			user = userService.findUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//页面跳转
		if(user.getPwd().equals(password)){
			//密码输入正确，可以登录
			return "/view/HomePage.jsp";
		}else {
			//密码输入错误
			request.setAttribute("msg","密码输入错误，请重新输入");
			return "/view/lock.jsp";
		}
	}

}
