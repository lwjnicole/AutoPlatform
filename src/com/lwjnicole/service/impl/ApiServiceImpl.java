package com.lwjnicole.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.Dao.ApiDao;
import com.lwjnicole.domain.Api;
import com.lwjnicole.service.ApiService;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.ApiVo;

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
	public List<ApiVo> findAllApi() throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		return apiDao.findAllApi();
	}

	@Override
	public ApiVo findApiByAid(String aid) throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		return apiDao.findApiByAid(aid);
	}

	@Override
	public void updateApiByAid(Api api) throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		apiDao.updateApiByAid(api);
	}

	@Override
	public void deleteApiByAid(String aid) throws SQLException {
		ApiDao apiDao = (ApiDao) BeanFactory.getBean("apiDao");	
		apiDao.deleteApiByAid(aid);	
	}

	

}
