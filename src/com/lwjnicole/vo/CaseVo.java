package com.lwjnicole.vo;

import java.util.Date;

import com.lwjnicole.domain.Site;

/**
 *
 * <b>类名：</b>CaseVo.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月30日 上午12:37:04
 * @Description caseVo用于展示用例数据
 */
public class CaseVo {
	private Integer id;
	private String cid;
	private String cname;
	private String cbusiness;
	private String curl;
	private String cmethod;
	private String cheader;
	private String cparamtype;
	private String cparam;
	private String cresult;
	private Date create_time;
	private String createTime;
	private Site site;
	private String sid;
	private String sname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCbusiness() {
		return cbusiness;
	}
	public void setCbusiness(String cbusiness) {
		this.cbusiness = cbusiness;
	}
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}
	public String getCmethod() {
		return cmethod;
	}
	
	public String getCheader() {
		return cheader;
	}
	public void setCheader(String cheader) {
		this.cheader = cheader;
	}
	public String getCparamtype() {
		return cparamtype;
	}
	public void setCparamtype(String cparamtype) {
		this.cparamtype = cparamtype;
	}
	public void setCmethod(String cmethod) {
		this.cmethod = cmethod;
	}
	public String getCparam() {
		return cparam;
	}
	public void setCparam(String cparam) {
		this.cparam = cparam;
	}
	public String getCresult() {
		return cresult;
	}
	public void setCresult(String cresult) {
		this.cresult = cresult;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "CaseVo [id=" + id + ", cid=" + cid + ", cname=" + cname + ", cbusiness=" + cbusiness + ", curl=" + curl
				+ ", cmethod=" + cmethod + ", cheader=" + cheader + ", cparamtype=" + cparamtype + ", cparam=" + cparam
				+ ", cresult=" + cresult + ", create_time=" + create_time + ", createTime=" + createTime + ", site="
				+ site + ", sid=" + sid + ", sname=" + sname + "]";
	}
	public CaseVo() {
		super();
	}
}
