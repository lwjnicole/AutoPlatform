package com.lwjnicole.Dao;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Api;
import com.lwjnicole.vo.ApiVo;

/**
 * 接口模块的Dao
 * @author user
 *
 */
public interface ApiDao {


	void addApi(Api api) throws SQLException;

	List<ApiVo> findAllApi() throws SQLException;

	ApiVo findApiByAid(String aid) throws SQLException;

	void updateApiByAid(Api api) throws SQLException;

	void deleteApiByAid(String aid) throws SQLException;


}
