package com.lwjnicole.Dao;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Site;

/**
 * 站点模块的Dao接口
 * @author user
 *
 */
public interface SiteDao {

	void addSite(Site site) throws SQLException;

	List<Site> findAllSite() throws SQLException;

	Site findSiteById(String sid) throws SQLException;

	void updateSite(Site site) throws SQLException;

	void delSiteById(String sid) throws SQLException;

}
