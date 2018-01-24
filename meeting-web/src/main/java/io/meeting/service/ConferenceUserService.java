package io.meeting.service;

import io.meeting.entity.ConferenceUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-03-02 09:56:17
 */
public interface ConferenceUserService {
	
	ConferenceUserEntity queryObject(Integer id);
	
	List<ConferenceUserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ConferenceUserEntity conferenceUser);
	
	void update(ConferenceUserEntity conferenceUser);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    ConferenceUserEntity queryObjectByUserId(String userId);
}
