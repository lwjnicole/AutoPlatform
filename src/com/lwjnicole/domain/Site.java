package com.lwjnicole.domain;

import java.util.Date;
/**
 * 站点实体类
 * @author user
 *
 */
public class Site {
	private Integer id;
	private String sname;
	private String description;
	private Date create_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Site [id=" + id + ", sname=" + sname + ", description=" + description + ", create_time=" + create_time
				+ "]";
	}
	public Site() {
		super();
	}
	public Site(Integer id, String sname, String description, Date create_time) {
		super();
		this.id = id;
		this.sname = sname;
		this.description = description;
		this.create_time = create_time;
	}
}
