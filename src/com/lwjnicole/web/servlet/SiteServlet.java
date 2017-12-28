package com.lwjnicole.web.servlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.domain.Site;
import com.lwjnicole.service.SiteService;
import com.lwjnicole.utils.AutoUtils;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.SiteVo;

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
			if(sname.equals("")){
				request.setAttribute("msg", "站点名称不能为空");
				return "/view/addSite.jsp";
			}
			Site site = new Site();
			site.setSid(AutoUtils.getSiteId());
			site.setSname(sname);
			site.setDescription(desc);		
			site.setCreate_time(new Date());
			//调用业务层
			SiteService siteService =  (SiteService) BeanFactory.getBean("siteService");
			siteService.addSite(site);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/SiteServlet?method=findAllSite");
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}		
		return null;		
	}
	
	/**
	 * 查询所有站点
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAllSite(HttpServletRequest request,HttpServletResponse response){
		List<SiteVo> siteListVo  = new ArrayList<SiteVo>();		
		try{
			//调用业务层
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			List<Site> siteList = siteService.findAllSite();
			//遍历查询出来的siteList，将值赋给siteVo对象，用于展示数据
			for (Site site : siteList) {
				SiteVo siteVo = new SiteVo();
				siteVo.setId(site.getId());
				siteVo.setSid(site.getSid());
				siteVo.setSname(site.getSname());
				siteVo.setDescription(site.getDescription());
				siteVo.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(site.getCreate_time()));
				siteListVo.add(siteVo);			
			}
			request.setAttribute("siteListVo",siteListVo);
			//页面跳转
			return "/view/siteList.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}
	
	/**
	 * 跳转到编辑站点页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String editSiteUI(HttpServletRequest request,HttpServletResponse response){
		try{
			//接收参数
			String sid = request.getParameter("sid");
			//调用业务层
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			Site site = siteService.findSiteById(sid);
			request.setAttribute("site", site);
			//页面跳转
			return "/view/editSite.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 更新站点信息
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateSite(HttpServletRequest request,HttpServletResponse response){
		try{
			//接收参数
			String sid  = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String desc = request.getParameter("desc");
			//封装参数
			Site site = new Site();
			site.setSid(sid);
			site.setSname(sname);
			site.setDescription(desc);
			//调用业务层
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			siteService.updateSite(site);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/SiteServlet?method=findAllSite");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return null;
	}
	
	public String delSite(HttpServletRequest request,HttpServletResponse response){
		try{
			//接收参数
			String sid = request.getParameter("sid");
			//调用业务层
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			siteService.delSiteById(sid);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/SiteServlet?method=findAllSite");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}	
		return null;		
	}
}
