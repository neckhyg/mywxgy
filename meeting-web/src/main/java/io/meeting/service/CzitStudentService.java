package io.meeting.service;

import io.meeting.entity.CzitStudentEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-07-26 15:46:00
 */
public interface CzitStudentService {
	
	CzitStudentEntity queryObject(Integer id);
	
	List<CzitStudentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CzitStudentEntity czitStudent);
	
	void update(CzitStudentEntity czitStudent);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

    CzitStudentEntity queryObjectByidCard(String  idCard);
}
