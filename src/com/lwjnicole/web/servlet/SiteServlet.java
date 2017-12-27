package com.lwjnicole.web.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.domain.Site;
import com.lwjnicole.service.SiteService;
import com.lwjnicole.utils.BeanFactory;

/**
 * 站点模块的servlet
 */
public class SiteServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 跳转到新增站点页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String addSiteUI(HttpServletRequest request,HttpServletResponse response){		
		return "/view/addSite.jsp";		
	}
	
	/**
	 * 实现新增站点功能
	 * @param request
	 * @param response
	 * @return
	 */
	public String addSite(HttpServletRequest request,HttpServletResponse response){
		try{
			//接收参数
			String sname = request.getParameter("sname");
			String desc = request.getParameter("desc");
			//封装参数
			Site site = new Site();
			site.setSname(sname);
			site.setDesc(desc);
			
			String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			site.setCreateTime(sdf);
			//调用业务层
			SiteService siteService =  (SiteService) BeanFactory.getBean("siteService");
			siteService.addSite(site);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		//页面跳转
		return "/view/siteList.jsp";		
	}
}
