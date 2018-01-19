package io.meeting.service;

import io.meeting.entity.ZfXsxxjbbEntity;
import io.meeting.entity.ZfstudentchartEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-31 16:00:34
 */
public interface ZfXsxxjbbService {
	
	ZfXsxxjbbEntity queryObject(String xh);
	
	List<ZfXsxxjbbEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ZfXsxxjbbEntity zfXsxxjbb);
	
	void update(ZfXsxxjbbEntity zfXsxxjbb);
	
	void delete(String xh);
	
	void deleteBatch(String[] xhs);

    List<ZfstudentchartEntity> queryStudentChartList(Map<String, Object> map);
}
