package com.lwjnicole.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.Dao.ApiDao;
import com.lwjnicole.domain.Api;
import com.lwjnicole.service.ApiService;
import com.lwjnicole.utils.BeanFactory;

/**
 * 接口模块的service实现类
 * @author user
 *
 */
public class ApiServiceImpl implements ApiService {

	

	@Override
	public void addApi(Api api) throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		apiDao.addApi(api);
	}

	@Override
	public List<Api> findAllApi() throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		return apiDao.findAllApi();
	}

	@Override
	public Api findApiByAid(String aid) throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		return apiDao.findApiByAid(aid);
	}

	

}
