package io.meeting.service;

import io.meeting.entity.YbmEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-07-28 15:33:03
 */
public interface YbmService {
	
	YbmEntity queryObject(Integer id);
	
	List<YbmEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(YbmEntity ybm);
	
	void update(YbmEntity ybm);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
