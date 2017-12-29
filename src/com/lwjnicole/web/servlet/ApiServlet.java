package com.lwjnicole.web.servlet;

import java.text.SimpleDateFormat;
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
			List<ApiVo> apiListVo = apiService.findAllApi();
			for (int i=0;i<apiListVo.size();i++) {
				ApiVo apiVo = apiListVo.get(i);
				apiVo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(apiVo.getCreate_time()));
				apiListVo.set(i,apiVo);
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
			if(sid.equals("0")){
				request.setAttribute("snamemsg", "请选择所属站点");
				return "/ApiServlet?method=addApiUI";
			}
			if(business.equals("")){
				request.setAttribute("businessmsg", "业务模块不能为空");
				return "/ApiServlet?method=addApiUI";
			}
			if(aname.equals("")){
				request.setAttribute("anamemsg", "接口名称不能为空");
				return "/ApiServlet?method=addApiUI";
			}
			if(aurl.equals("")){
				request.setAttribute("aurlmsg", "URL不能为空");
				return "/ApiServlet?method=addApiUI";
			}
			if(amethod.equals("0")){
				request.setAttribute("amethodmsg", "请求方法不能为空");
				return "/ApiServlet?method=addApiUI";
			}
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
	
	/**
	 * 跳转到编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	public String editApiUI(HttpServletRequest request, HttpServletResponse response){
		try{
			//接收参数
			String aid = request.getParameter("aid");
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			ApiVo apiVo = apiService.findApiByAid(aid);			
			request.setAttribute("apiVo", apiVo);
			
			//查所有站点
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			List<Site> siteList = siteService.findAllSite();
			request.setAttribute("siteList", siteList);
			
			//页面跳转
			return "/view/editApi.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
	
	/**
	 * 更新接口数据
	 * @param request
	 * @param response
	 * @return
	 */
	public String updateApi(HttpServletRequest request, HttpServletResponse response){
		try{
			//接收参数
			String aid = request.getParameter("aid");
			String sid = request.getParameter("sname");
			String business = request.getParameter("business");
			String aname = request.getParameter("aname");
			String aurl = request.getParameter("aurl");
			String amethod = request.getParameter("amethod");
			//封装参数
			Api api = new Api();
			api.setAid(aid);
			api.setAname(aname);
			api.setAurl(aurl);
			api.setBusiness(business);
			api.setMethod(amethod);
			SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
			Site site = siteService.findSiteById(sid);
			api.setSite(site);
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			apiService.updateApiByAid(api);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/ApiServlet?method=findAllApi");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}		
		return null;
	}
	
	public String deleteApiByAid(HttpServletRequest request, HttpServletResponse response){
		try{
			//接收参数
			String aid = request.getParameter("aid");
			//调用业务层
			ApiService apiService = (ApiService) BeanFactory.getBean("apiService");
			apiService.deleteApiByAid(aid);
			//页面跳转
			response.sendRedirect(request.getContextPath() + "/ApiServlet?method=findAllApi");
			return null;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
				
	}
}
