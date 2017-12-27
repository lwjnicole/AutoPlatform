package com.lwjnicole.vo;
/**
 * 实体类SiteVo，用于展示数据
 * @author user
 *
 */
public class SiteVo {
	private Integer id;
	private String sname;
	private String description;
	private String create_time;
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
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "SiteVo [id=" + id + ", sname=" + sname + ", description=" + description + ", create_time=" + create_time
				+ "]";
	}
	public SiteVo(Integer id, String sname, String description, String create_time) {
		super();
		this.id = id;
		this.sname = sname;
		this.description = description;
		this.create_time = create_time;
	}
	public SiteVo() {
		super();
	}	
}
