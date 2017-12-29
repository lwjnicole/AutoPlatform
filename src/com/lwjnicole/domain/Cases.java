package com.lwjnicole.domain;

import java.util.Date;

/**
 *
 * <b>类名：</b>Case.java<br>
 * <p><b>标题：</b>意真金融接口自动化测试</p>
 * <p><b>描述：</b>意真金融将接口自动化测试</p>
 * <p><b>版权声明：</b>Copyright (c) 2017</p>
 * <p><b>公司：</b>意真金融信息服务有限公司 </p>
 * @author <font color='blue'>李文吉</font>
 * @version 1.0.1
 * @date  2017年12月29日 下午11:08:07
 * @Description 接口用例实体类
 */
public class Cases {
	private Integer id;
	private String cid;
	private String cname;
	private String cbusiness;
	private String curl;
	private String cmethod;
	private String cparam;
	private String cresult;
	private Date create_time;
	private Site site;
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
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	@Override
	public String toString() {
		return "Cases [id=" + id + ", cid=" + cid + ", cname=" + cname + ", cbusiness=" + cbusiness + ", curl=" + curl
				+ ", cmethod=" + cmethod + ", cparam=" + cparam + ", cresult=" + cresult + ", create_time="
				+ create_time + ", site=" + site + "]";
	}
	public Cases() {
		super();
	}
}
