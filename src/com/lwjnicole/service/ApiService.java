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

	List<Api> findAllApi() throws SQLException;

	void addApi(Api api) throws SQLException;

}
