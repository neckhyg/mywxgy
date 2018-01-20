package io.meeting.service;

import io.meeting.entity.MeetingTeacherEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-20 22:12:54
 */
public interface MeetingTeacherService {
	
	MeetingTeacherEntity queryObject(Integer id);
	
	List<MeetingTeacherEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingTeacherEntity meetingTeacher);
	
	void update(MeetingTeacherEntity meetingTeacher);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    List<MeetingTeacherEntity> queryListByDeptNO(String deptno);
}
