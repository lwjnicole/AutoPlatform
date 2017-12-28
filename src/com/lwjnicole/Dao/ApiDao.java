package com.lwjnicole.Dao;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Api;

/**
 * 接口模块的Dao
 * @author user
 *
 */
public interface ApiDao {


	void addApi(Api api) throws SQLException;

	List<Api> findAllApi() throws SQLException;

	Api findApiByAid(String aid) throws SQLException;


}
