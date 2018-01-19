package io.meeting.service;

import io.meeting.entity.MeetingInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 13:43:10
 */
public interface MeetingInfoService {
	
	MeetingInfoEntity queryObject(Integer id);
	
	List<MeetingInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingInfoEntity meetingInfo);
	
	void update(MeetingInfoEntity meetingInfo);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
