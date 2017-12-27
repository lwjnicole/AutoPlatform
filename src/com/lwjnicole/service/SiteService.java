package com.lwjnicole.service;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Site;

/**
 * 站点模块的service接口
 * @author user
 *
 */
public interface SiteService {

	void addSite(Site site) throws SQLException;

	List<Site> findAllSite() throws SQLException;

}
