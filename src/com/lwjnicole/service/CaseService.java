package com.lwjnicole.service;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.domain.Cases;
import com.lwjnicole.vo.CaseVo;

/**
 *
 * <b>类名：</b>CaseService.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月29日 下午11:14:55
 * @Description 接口用例service
 */
public interface CaseService {

	void addCase(Cases cases) throws SQLException;

	List<CaseVo> findAllCase() throws SQLException;

	CaseVo findCaseByCid(String cid) throws SQLException;

	void updateCase(Cases cases) throws SQLException;

	void delCaseByCid(String cid) throws SQLException;

}
