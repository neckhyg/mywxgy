package io.meeting.dao;

import io.meeting.entity.ScheduleJobEntity;

import java.util.Map;

/**
 * 定时任务
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2016年12月1日 下午10:29:57
 */
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
