package io.meeting.service;

import io.meeting.entity.MeetingRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 14:59:32
 */
public interface MeetingRecordService {
	
	MeetingRecordEntity queryObject(Integer id);
	
	List<MeetingRecordEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MeetingRecordEntity meetingRecord);
	
	void update(MeetingRecordEntity meetingRecord);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
