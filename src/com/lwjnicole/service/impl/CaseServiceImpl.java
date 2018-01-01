package com.lwjnicole.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lwjnicole.Dao.CaseDao;
import com.lwjnicole.domain.Cases;
import com.lwjnicole.service.CaseService;
import com.lwjnicole.utils.BeanFactory;
import com.lwjnicole.vo.CaseVo;

/**
 *
 * <b>类名：</b>CaseServiceImpl.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月29日 下午11:15:51
 * @Description 接口用例service的实现类
 */
public class CaseServiceImpl implements CaseService {

	/**
	 * 新增接口用例
	 * @throws SQLException 
	 */
	@Override
	public void addCase(Cases cases) throws SQLException {
		CaseDao caseDao = (CaseDao) BeanFactory.getBean("caseDao");
		caseDao.addCase(cases);
	}

	/**
	 * 查询所有用例数据
	 * @throws SQLException 
	 */
	@Override
	public List<CaseVo> findAllCase() throws SQLException {
		CaseDao caseDao = (CaseDao) BeanFactory.getBean("caseDao");
		return caseDao.findAllCase();
	}

	/**
	 * 根据cid查询用例数据
	 * @throws SQLException 
	 */
	@Override
	public CaseVo findCaseByCid(String cid) throws SQLException {
		CaseDao caseDao = (CaseDao) BeanFactory.getBean("caseDao");
		return caseDao.findCaseByCid(cid);
	}

	/**
	 * 更新用例
	 * @throws SQLException 
	 */
	@Override
	public void updateCase(Cases cases) throws SQLException {
		CaseDao caseDao = (CaseDao) BeanFactory.getBean("caseDao");
		caseDao.updateCase(cases);
	}

	/**
	 * 删除用例
	 * @throws SQLException 
	 */
	@Override
	public void delCaseByCid(String cid) throws SQLException {
		CaseDao caseDao = (CaseDao) BeanFactory.getBean("caseDao");
		caseDao.delCaseByCid(cid);	
	}

}
