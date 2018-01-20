package io.meeting.entity;

import java.io.Serializable;



/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 22:42:18
 */
public class MeetingOrganizeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String deptname;
	//
	private String deptno;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	/**
	 * 获取：
	 */
	public String getDeptname() {
		return deptname;
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
}
