package com.lwjnicole.web.servlet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.domain.Api;
import com.lwjnicole.domain.Site;
import com.lwjnicole.service.ApiService;
import com.lwjnicole.service.SiteService;
import com.lwjnicole.utils.AutoUtils;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.ApiVo;

/**
 * 接口模块的servlet
 */
public class ApiServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询所有接口数据
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAllApi(HttpServletRequest request, HttpServletResponse response){
		try{
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			List<Api> apiList = apiService.findAllApi();
			List<ApiVo> apiListVo = new ArrayList<ApiVo>();
			for (Api api : apiList) {
				ApiVo apiVo = new ApiVo();				
				apiVo.setAid(api.getAid());
				apiVo.setAname(api.getAname());
				apiVo.setAurl(api.getAurl());
				apiVo.setBusiness(api.getBusiness());
				apiVo.setMethod(api.getMethod());
				apiVo.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(api.getCreate_time()));
				apiListVo.add(apiVo);
			}
			request.setAttribute("apiListVo", apiListVo);
			//页面跳转
			return "/view/apiList.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	
	/**
	 * 跳转到新增接口页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String addApiUI(HttpServletRequest request, HttpServletResponse response){
		try{
			//调用业务层，查询站点信息，展示到页面中
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			List<Site> site = siteService.findAllSite();
			request.setAttribute("site", site);
			return "/view/addApi.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}
	
	/**
	 * 新增接口的执行功能
	 * @param request
	 * @param response
	 * @return
	 */
	public String addApi(HttpServletRequest request, HttpServletResponse response){
		try{
			//接收参数
			String sid = request.getParameter("sname");
			String business = request.getParameter("business");
			String aname = request.getParameter("aname");
			String aurl = request.getParameter("aurl");
			String amethod = request.getParameter("amethod");
			//封装参数
			Api api = new Api();
			api.setAname(aname);
			api.setAurl(aurl);
			api.setBusiness(business);
			api.setMethod(amethod);
			api.setAid(AutoUtils.getApiId());
			api.setCreate_time(new Date());
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			Site site = siteService.findSiteById(sid);
			api.setSite(site);
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			apiService.addApi(api);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/ApiServlet?method=findAllApi");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
	}
	
	public String editApiUI(HttpServletRequest request, HttpServletResponse response){
		try{
			//接收参数
			String aid = request.getParameter("aid");
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			Api api = apiService.findApiByAid(aid);
			/*SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			Site site = siteService.findSiteById(sid);*/
			request.setAttribute("api", api);
			//页面跳转
			return "/view/editApi.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
}
