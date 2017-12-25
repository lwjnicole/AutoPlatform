package com.lwjnicole.Dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lwjnicole.Dao.UserDao;
import com.lwjnicole.domain.User;
import com.lwjnicole.utils.JDBCUtils;

/**
 *
 * <b>类名：</b>UserDaoImpl.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月24日 下午9:13:41
 * @Description 
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 用户登录
	 * @throws SQLException 
	 */
	@Override
	public User login(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and pwd =?";
		User exitUser = qr.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPwd());
		return exitUser;
	}

	/**
	 * 锁屏重新登录功能
	 */
	@Override
	public User findUserByUsername(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where username = ?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

}
