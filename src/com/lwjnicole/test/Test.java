package com.lwjnicole.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.domain.Site;
import com.lwjnicole.utils.JDBCUtils;

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
	//	Site site = new Site();
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	//	String sql = "select * from site order by create_time desc";
		String sql = "select * from site order by create_time desc limit 1";
		try {
	//		List<Site> list = qr.query(sql, new BeanListHandler<Site>(Site.class));
		Site site = qr.query(sql, new BeanHandler<Site>(Site.class));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(site.getCreate_time()));
		System.out.println(site.toString());
			/*for (Site site2 : list) {
				System.out.println(site2.toString());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
}
