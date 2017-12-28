package com.lwjnicole.service;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Api;

/**
 * 接口模块的service
 * @author user
 *
 */
public interface ApiService {
	

	void addApi(Api api) throws SQLException;

	List<Api> findAllApi() throws SQLException;

	Api findApiByAid(String aid) throws SQLException;


}
