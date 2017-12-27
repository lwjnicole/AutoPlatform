package com.lwjnicole.Dao;

import java.sql.SQLException;

import com.lwjnicole.domain.Site;

/**
 * 站点模块的Dao接口
 * @author user
 *
 */
public interface SiteDao {

	void addSite(Site site) throws SQLException;

}
