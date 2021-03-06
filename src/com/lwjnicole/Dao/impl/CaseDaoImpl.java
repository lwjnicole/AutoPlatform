package com.lwjnicole.Dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.Dao.CaseDao;
import com.lwjnicole.domain.Cases;
import com.lwjnicole.utils.JDBCUtils;
import com.lwjnicole.vo.CaseVo;

/**
 *
 * <b>类名：</b>CaseDaoImpl.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月29日 下午11:17:55
 * @Description 接口用例的Dao类的实现类
 */
public class CaseDaoImpl implements CaseDao {

	/**
	 * 新增用例方法
	 * @throws SQLException 
	 */
	@Override
	public void addCase(Cases cases) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into a_case (cid,cname,cbusiness,curl,cmethod,cheader,cparamtype,cparam,cresult,create_time,sid) values (?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, cases.getCid(),cases.getCname(),cases.getCbusiness(),cases.getCurl(),cases.getCmethod(),cases.getCheader(),cases.getCparamtype(),cases.getCparam(),cases.getCresult(),cases.getCreate_time(),cases.getSite().getSid());
	}

	/**
	 * 查询所有用例数据
	 * @throws SQLException 
	 */
	@Override
	public List<CaseVo> findAllCase() throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select c.cid,c.cname,c.cbusiness,c.curl,c.cmethod,c.cparam,c.cresult,c.create_time,c.sid,s.sname from a_case c left join site s on c.sid=s.sid order by c.create_time desc";
		List<CaseVo> caseListVo = qr.query(sql, new BeanListHandler<CaseVo>(CaseVo.class));
		return caseListVo;
	}

	/**
	 * 根据cid查询用例数据
	 * @throws SQLException 
	 */
	@Override
	public CaseVo findCaseByCid(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select cname,cbusiness,curl,cmethod,cheader,cparamtype,cparam,cresult,sid,cid from a_case where cid = ?";
		CaseVo caseVo = qr.query(sql, new BeanHandler<CaseVo>(CaseVo.class), cid);
		return caseVo;
	}

	/**
	 * 更新用例
	 * @throws SQLException 
	 */
	@Override
	public void updateCase(Cases cases) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update a_case set cname=?,cbusiness=?,curl=?,cmethod=?,cheader=?,cparamtype=?,cparam=?,cresult=?,sid=? where cid = ?";
		qr.update(sql, cases.getCname(),cases.getCbusiness(),cases.getCurl(),cases.getCmethod(),cases.getCheader(),cases.getCparamtype(),cases.getCparam(),cases.getCresult(),cases.getSite().getSid(),cases.getCid());		
	}

	@Override
	public void delCaseByCid(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from a_case where cid = ?";
		qr.update(sql, cid);
	}

}
