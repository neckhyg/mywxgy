package io.meeting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.meeting.dao.MeetingInfoDao;
import io.meeting.entity.MeetingInfoEntity;
import io.meeting.service.MeetingInfoService;



@Service("meetingInfoService")
public class MeetingInfoServiceImpl implements MeetingInfoService {
	@Autowired
	private MeetingInfoDao meetingInfoDao;
	
	@Override
	public MeetingInfoEntity queryObject(Integer id){
		return meetingInfoDao.queryObject(id);
	}
	
	@Override
	public List<MeetingInfoEntity> queryList(Map<String, Object> map){
		return meetingInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingInfoEntity meetingInfo){
		meetingInfoDao.save(meetingInfo);
	}
	
	@Override
	public void update(MeetingInfoEntity meetingInfo){
		meetingInfoDao.update(meetingInfo);
	}
	
	@Override
	public void delete(Integer id){
		meetingInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		meetingInfoDao.deleteBatch(ids);
	}
	
}
