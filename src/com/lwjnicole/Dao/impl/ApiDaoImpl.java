package com.lwjnicole.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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

	@Override
	public List<Api> findAllApi() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from api order by create_time desc";
		List<Api> apiList = qr.query(sql, new BeanListHandler<Api>(Api.class));
		return apiList;
	}

	@Override
	public void addApi(Api api) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into api (aid,business,aname,aurl,method,create_time,sid) values (?,?,?,?,?,?,?)";
		qr.update(sql, api.getAid(),api.getBusiness(),api.getAname(),api.getAurl(),api.getMethod(),api.getCreate_time(),api.getSid());
	}

}
