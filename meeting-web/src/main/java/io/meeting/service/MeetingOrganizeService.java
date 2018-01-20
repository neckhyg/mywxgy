package io.meeting.service;

import io.meeting.entity.MeetingOrganizeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 22:42:18
 */
public interface MeetingOrganizeService {
	
	MeetingOrganizeEntity queryObject(String id);
	
	List<MeetingOrganizeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingOrganizeEntity meetingOrganize);
	
	void update(MeetingOrganizeEntity meetingOrganize);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
