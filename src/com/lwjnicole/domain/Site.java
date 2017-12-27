package com.lwjnicole.domain;

import java.util.Date;
/**
 * 站点实体类
 * @author user
 *
 */
public class Site {
	private int sid;
	private String sname;
	private String desc;
	private String createTime;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Site(int sid, String sname, String desc, String createTime) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.desc = desc;
		this.createTime = createTime;
	}
	public Site() {
		super();
	}
	@Override
	public String toString() {
		return "Site [sid=" + sid + ", sname=" + sname + ", desc=" + desc + ", createTime=" + createTime + "]";
	}	
}
