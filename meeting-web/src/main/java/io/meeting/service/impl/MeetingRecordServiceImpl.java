package io.meeting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.meeting.dao.MeetingRecordDao;
import io.meeting.entity.MeetingRecordEntity;
import io.meeting.service.MeetingRecordService;



@Service("meetingRecordService")
public class MeetingRecordServiceImpl implements MeetingRecordService {
	@Autowired
	private MeetingRecordDao meetingRecordDao;
	
	@Override
	public MeetingRecordEntity queryObject(Integer id){
		return meetingRecordDao.queryObject(id);
	}
	
	@Override
	public List<MeetingRecordEntity> queryList(Map<String, Object> map){
		return meetingRecordDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingRecordDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingRecordEntity meetingRecord){
		meetingRecordDao.save(meetingRecord);
	}
	
	@Override
	public void update(MeetingRecordEntity meetingRecord){
		meetingRecordDao.update(meetingRecord);
	}
	
	@Override
	public void delete(Integer id){
		meetingRecordDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		meetingRecordDao.deleteBatch(ids);
	}
	
}
