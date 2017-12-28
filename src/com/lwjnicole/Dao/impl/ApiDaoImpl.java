package com.lwjnicole.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.Dao.ApiDao;
import com.lwjnicole.domain.Api;
import com.lwjnicole.utils.JDBCUtils;

/**
 * 接口模块Dao的实现类
 * @author user
 *
 */
public class ApiDaoImpl implements ApiDao {

	/**
	 * 查询所有接口信息
	 */
	@Override
	public List<Api> findAllApi() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from api order by create_time desc";
		List<Api> apiList = qr.query(sql, new BeanListHandler<Api>(Api.class));
		return apiList;
	}

	/**
	 * 新增接口
	 */
	@Override
	public void addApi(Api api) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into api (aid,business,aname,aurl,method,create_time,sid) values (?,?,?,?,?,?,?)";
		qr.update(sql, api.getAid(),api.getBusiness(),api.getAname(),api.getAurl(),api.getMethod(),api.getCreate_time(),api.getSite().getSid());
	}


	/**
	 * 根据aid查询接口数据
	 * @throws SQLException 
	 */
	@Override
	public Api findApiByAid(String aid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from api where aid = ?";
		Api api = qr.query(sql, new BeanHandler<Api>(Api.class), aid);
		return api;
	}

	

}
