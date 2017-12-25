package com.lwjnicole.Dao;

import java.sql.SQLException;

import com.lwjnicole.domain.User;

/**
 *
 * <b>类名：</b>UserDao.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月24日 下午9:12:52
 * @Description 
 */
public interface UserDao {

	User login(User user) throws SQLException;

	User findUserByUsername(String username) throws SQLException;

}
