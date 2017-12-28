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
	
	public static void main(String[] args) {
	
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from api order by create_time desc";
		try {
			List<ApiVo> apiListVo = qr.query(sql, new BeanListHandler<ApiVo>(ApiVo.class));
			for (ApiVo apiVo : apiListVo) {
				System.out.println(apiVo.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}
