package com.lwjnicole.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * <b>类名：</b>Test.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月17日 下午10:59:14
 * @Description 
 */
public class Test {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/autoplatform", "root", "123456");
				Statement stat	 = conn.createStatement();
				
				String sql = "select * from user where username = 'admin' and pwd = '123456'";
				ResultSet rs = stat.executeQuery(sql);
				while(rs.next()){
					String username = rs.getString("username");
					System.out.println(username);
				}
				
				conn.close();
				stat.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
	}
}
