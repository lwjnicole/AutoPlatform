package com.lwjnicole.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.Dao.SiteDao;
import com.lwjnicole.domain.Site;
import com.lwjnicole.utils.JDBCUtils;

/**
 * 站点模块Dao类的实现类
 * @author user
 *
 */
public class SiteDaoImpl implements SiteDao {

	/**
	 * 新增站点
	 * @throws SQLException 
	 */
	@Override
	public void addSite(Site site) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into site (sid,sname,description,create_time) values (?,?,?,?)";
		Object[] params = {site.getSid(),site.getSname(),site.getDescription(),site.getCreate_time()};
		qr.update(sql, params);
		
	}

	/**
	 * 查询所有站点
	 */
	@Override
	public List<Site> findAllSite() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from site order by create_time desc";
		List<Site> siteList = qr.query(sql, new BeanListHandler<Site>(Site.class));
		return siteList;
	}

}
