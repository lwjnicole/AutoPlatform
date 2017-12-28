package com.lwjnicole.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.Dao.SiteDao;
import com.lwjnicole.domain.Site;
import com.lwjnicole.service.SiteService;
import com.lwjnicole.utils.BeanFactory;

/**
 * 站点模块的service接口的实现类
 * @author user
 *
 */
public class SiteServiceImpl implements SiteService {

	/**
	 * 新增功能service
	 */
	@Override
	public void addSite(Site site) throws SQLException{
		SiteDao siteDao = (SiteDao) BeanFactory.getBean("siteDao");
		siteDao.addSite(site);
	}

	/**
	 * 查询所有站点
	 */
	@Override
	public List<Site> findAllSite() throws SQLException {
		SiteDao siteDao = (SiteDao) BeanFactory.getBean("siteDao");
		return siteDao.findAllSite();
	}

	/**
	 * 根据sid查询站点信息
	 * @throws SQLException 
	 */
	@Override
	public Site findSiteById(String sid) throws SQLException {
		SiteDao siteDao = (SiteDao) BeanFactory.getBean("siteDao");
		return siteDao.findSiteById(sid);
	}

	/**
	 * 根据sid更新站点信息
	 * @throws SQLException 
	 */
	@Override
	public void updateSite(Site site) throws SQLException {
		SiteDao siteDao = (SiteDao) BeanFactory.getBean("siteDao");
		siteDao.updateSite(site);
	}

	@Override
	public void delSiteById(String sid) throws SQLException {
		SiteDao siteDao = (SiteDao) BeanFactory.getBean("siteDao");
		siteDao.delSiteById(sid);
	}

}
