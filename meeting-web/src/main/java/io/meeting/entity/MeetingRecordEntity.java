package io.meeting.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 14:59:32
 */
public class MeetingRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String meetingno;
	//
	private String meetingname;
	//
	private String meetinglocation;
	//
	private String meetingdate;
	//
	private String chairman;
	//
	private String attendanceid;
	//
	private String attendancename;
	//
	private String signdate;
	//
	private String signstatus;

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
	public void setMeetingno(String meetingno) {
		this.meetingno = meetingno;
	}
	/**
	 * 获取：
	 */
	public String getMeetingno() {
		return meetingno;
	}
	/**
	 * 设置：
	 */
	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}
	/**
	 * 获取：
	 */
	public String getMeetingname() {
		return meetingname;
	}
	/**
	 * 设置：
	 */
	public void setMeetinglocation(String meetinglocation) {
		this.meetinglocation = meetinglocation;
	}
	/**
	 * 获取：
	 */
	public String getMeetinglocation() {
		return meetinglocation;
	}
	/**
	 * 设置：
	 */
	public void setMeetingdate(String meetingdate) {
		this.meetingdate = meetingdate;
	}
	/**
	 * 获取：
	 */
	public String getMeetingdate() {
		return meetingdate;
	}
	/**
	 * 设置：
	 */
	public void setChairman(String chairman) {
		this.chairman = chairman;
	}
	/**
	 * 获取：
	 */
	public String getChairman() {
		return chairman;
	}
	/**
	 * 设置：
	 */
	public void setAttendanceid(String attendanceid) {
		this.attendanceid = attendanceid;
	}
	/**
	 * 获取：
	 */
	public String getAttendanceid() {
		return attendanceid;
	}
	/**
	 * 设置：
	 */
	public void setAttendancename(String attendancename) {
		this.attendancename = attendancename;
	}
	/**
	 * 获取：
	 */
	public String getAttendancename() {
		return attendancename;
	}
	/**
	 * 设置：
	 */
	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}
	/**
	 * 获取：
	 */
	public String getSigndate() {
		return signdate;
	}
	/**
	 * 设置：
	 */
	public void setSignstatus(String signstatus) {
		this.signstatus = signstatus;
	}
	/**
	 * 获取：
	 */
	public String getSignstatus() {
		return signstatus;
	}
}
