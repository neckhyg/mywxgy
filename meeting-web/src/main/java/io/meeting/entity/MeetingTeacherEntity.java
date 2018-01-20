package io.meeting.entity;

import java.io.Serializable;



/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-20 22:12:54
 */
public class MeetingTeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String userid;
	//
	private String name;
	//
	private String sex;
	//
	private String post;
	//
	private String deptno;
	//
	private String mobilephone;
	//
	private String email;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 获取：
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setPost(String post) {
		this.post = post;
	}
	/**
	 * 获取：
	 */
	public String getPost() {
		return post;
	}
	/**
	 * 设置：
	 */
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	/**
	 * 获取：
	 */
	public String getDeptno() {
		return deptno;
	}
	/**
	 * 设置：
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**
	 * 获取：
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**
	 * 设置：
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：
	 */
	public String getEmail() {
		return email;
	}
}
