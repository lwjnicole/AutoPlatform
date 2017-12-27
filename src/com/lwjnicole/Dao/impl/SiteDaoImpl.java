package com.lwjnicole.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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
		String sql = "insert into site (sname,description,create_time) values (?,?,?)";
		Object[] params = {site.getSname(),site.getDesc(),site.getCreateTime()};
		qr.update(sql, params);
		
	}

}
