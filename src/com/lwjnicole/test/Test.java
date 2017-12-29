package com.lwjnicole.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lwjnicole.domain.Api;
import com.lwjnicole.domain.Site;
import com.lwjnicole.utils.JDBCUtils;
import com.lwjnicole.vo.ApiVo;

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
	
	public static void main(String[] args) throws SQLException {
	
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select s.sname,a.aurl,a.business,a.aname,a.method,a.aid,a.sid,s.sid from api a left join site s on a.sid=s.sid where a.aid = ?";
		ApiVo apiVo = qr.query(sql, new BeanHandler<ApiVo>(ApiVo.class), "A20171229100053117");
		System.out.println(apiVo.toString());
		
	}
}
