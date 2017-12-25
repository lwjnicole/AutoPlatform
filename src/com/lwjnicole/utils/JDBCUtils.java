package com.lwjnicole.utils;

import java.sql.Connection;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *
 * <b>类名：</b>JDBCUtils.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月17日 下午10:07:22
 * @Description 
 */
public class JDBCUtils {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getDataSource(){
		return DATA_SOURCE;
	}
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		
		try {
			conn = DATA_SOURCE.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
