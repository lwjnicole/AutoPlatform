package com.lwjnicole.vo;

import java.util.Date;

/**
 * 接口管理Vo,用于展示数据
 * @author user
 *
 */
public class ApiVo {
	private Integer id;	//主键ID
	private String aid;	//接口ID
	private String business;	//业务模块	
	private String aname;	//接口名称
	private String aurl;	//接口请求地址
	private String method;	//请求方式
	private Date create_time;	//创建时间
	private String createTime;
	private String sid;	//所属站点ID
	private String sname;//所属站点名称
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAurl() {
		return aurl;
	}
	public void setAurl(String aurl) {
		this.aurl = aurl;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "ApiVo [id=" + id + ", aid=" + aid + ", business=" + business + ", aname=" + aname + ", aurl=" + aurl
				+ ", method=" + method + ", create_time=" + create_time + ", createtime=" + createTime + ", sid=" + sid
				+ ", sname=" + sname + "]";
	}
	
}
