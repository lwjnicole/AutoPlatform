package com.lwjnicole.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.Dao.ApiDao;
import com.lwjnicole.domain.Api;
import com.lwjnicole.utils.JDBCUtils;
import com.lwjnicole.vo.ApiVo;

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
	public List<ApiVo> findAllApi() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select s.sname,a.aurl,a.business,a.aname,a.method,a.create_time,a.aid from api a left join site s on a.sid=s.sid order by a.create_time desc";
		List<ApiVo> apiListVo = qr.query(sql, new BeanListHandler<ApiVo>(ApiVo.class));
		return apiListVo;
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
	public ApiVo findApiByAid(String aid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select s.sname,a.aurl,a.business,a.aname,a.method,a.aid,a.sid from api a left join site s on a.sid=s.sid where a.aid = ?";
		ApiVo apiVo = qr.query(sql, new BeanHandler<ApiVo>(ApiVo.class), aid);
		return apiVo;
	}

	/**
	 * 根据aid更新接口数据
	 */
	@Override
	public void updateApiByAid(Api api) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update api set business=?,aname=?,aurl=?,method=?,sid=? where aid=?";
		qr.update(sql, api.getBusiness(),api.getAname(),api.getAurl(),api.getMethod(),api.getSite().getSid(),api.getAid());
	}

	/**
	 * 根据aid删除接口数据
	 * @throws SQLException 
	 */
	@Override
	public void deleteApiByAid(String aid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from api where aid = ?";
		qr.update(sql, aid);
	}

	

}
