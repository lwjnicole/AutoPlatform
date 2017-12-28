package com.lwjnicole.domain;

import java.util.Date;

/**
 * 接口的实体类
 * @author user
 *
 */
public class Api {
	private Integer id;	//主键ID
	private String aid;	//接口ID
	private String business;	//业务模块	
	private String aname;	//接口名称
	private String aurl;	//接口请求地址
	private String method;	//请求方式
	private Date create_time;	//创建时间
	private Site site;	//所属站点ID
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
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	public Api(Integer id, String aid, String business, String aname, String aurl, String method, Date create_time,
			Site site) {
		super();
		this.id = id;
		this.aid = aid;
		this.business = business;
		this.aname = aname;
		this.aurl = aurl;
		this.method = method;
		this.create_time = create_time;
		this.site = site;
	}
	@Override
	public String toString() {
		return "Api [id=" + id + ", aid=" + aid + ", business=" + business + ", aname=" + aname + ", aurl=" + aurl
				+ ", method=" + method + ", create_time=" + create_time + ", site=" + site + "]";
	}
	public Api() {
		super();
	}
}