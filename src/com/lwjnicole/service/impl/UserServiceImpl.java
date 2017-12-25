package com.lwjnicole.service.impl;

import java.sql.SQLException;

import com.lwjnicole.Dao.UserDao;
import com.lwjnicole.domain.User;
import com.lwjnicole.service.UserService;
import com.lwjnicole.utils.BeanFactory;

/**
 *
 * <b>类名：</b>UserServiceImpl.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月24日 下午9:11:56
 * @Description 
 */
public class UserServiceImpl implements UserService{

	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) throws SQLException{
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.login(user);
	}

	/**
	 * 锁屏重新登录功能
	 */
	@Override
	public User findUserByUsername(String username) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.findUserByUsername(username);
	}

}
