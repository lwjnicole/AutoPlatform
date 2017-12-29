package com.lwjnicole.web.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lwjnicole.domain.Cases;
import com.lwjnicole.domain.Site;
import com.lwjnicole.service.CaseService;
import com.lwjnicole.service.SiteService;
import com.lwjnicole.utils.AutoUtils;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.CaseVo;

/**
 * 接口用例的servlet
 */
public class CaseServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询所有用例
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAllCase(HttpServletRequest request,HttpServletResponse response){
		try{
			//调用业务层
			CaseService caseService = (CaseService) BeanFactory.getBean("caseService");
			List<CaseVo> caseLisVo = caseService.findAllCase();
			for(int i=0;i<caseLisVo.size();i++){
				CaseVo caseVo = caseLisVo.get(i);
				caseVo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(caseVo.getCreate_time()));
				caseLisVo.set(i, caseVo);
			}
			request.setAttribute("caseLisVo", caseLisVo);
			//页面跳转
			return "/view/caseList.jsp";
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}
	/**
	 * 跳转到新增用例页面
	 * @param request
	 * @param response
	 * @return
	 */
    public String addCaseUI(HttpServletRequest request,HttpServletResponse response){
		try{
			//调用业务层
	    	SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
	    	List<Site> siteList = siteService.findAllSite();
	    	request.setAttribute("siteList", siteList);
	    	//页面跳转
	    	return "/view/addCase.jsp";  	
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}	
    }

    /**
     * 新增用例的执行方法
     * @param request
     * @param response
     * @return
     */
    public String addCase(HttpServletRequest request,HttpServletResponse response){
		try{
			//接收参数
	    	String sid = request.getParameter("sname");
	    	String cbusiness = request.getParameter("cbusiness");
	    	String curl = request.getParameter("curl");
	    	String cname = request.getParameter("cname");
	    	String cmethod = request.getParameter("cmethod");
	    	String cparam = request.getParameter("cparam");
	    	String cresult = request.getParameter("cresult");
	    	//封装参数
	    	Cases cases = new Cases();
	    	cases.setCbusiness(cbusiness);
	    	cases.setCurl(curl);
	    	cases.setCname(cname);
	    	cases.setCmethod(cmethod);
	    	cases.setCparam(cparam);
	    	cases.setCresult(cresult);
	    	cases.setCreate_time(new Date());
	    	cases.setCid(AutoUtils.getCaseId());
	    	SiteService siteService = (SiteService) BeanFactory.getBean("siteService");
	    	Site site = siteService.findSiteById(sid);
	    	cases.setSite(site);
	    	//调用业务层
	    	CaseService caseService = (CaseService) BeanFactory.getBean("caseService");
	    	caseService.addCase(cases);
	    	//页面跳转
	    	response.sendRedirect(request.getContextPath() + "/CaseServlet?method=findAllCase");
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		return null;
    }
}
