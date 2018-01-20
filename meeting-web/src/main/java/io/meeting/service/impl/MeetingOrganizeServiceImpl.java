package io.meeting.service.impl;

import io.meeting.dao.MeetingOrganizeDao;
import io.meeting.entity.MeetingOrganizeEntity;
import io.meeting.service.MeetingOrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("meetingOrganizeService")
public class MeetingOrganizeServiceImpl implements MeetingOrganizeService {
	@Autowired
	private MeetingOrganizeDao meetingOrganizeDao;
	
	@Override
	public MeetingOrganizeEntity queryObject(String id){
		return meetingOrganizeDao.queryObject(id);
	}
	
	@Override
	public List<MeetingOrganizeEntity> queryList(Map<String, Object> map){
		return meetingOrganizeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingOrganizeDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingOrganizeEntity meetingOrganize){
		meetingOrganizeDao.save(meetingOrganize);
	}
	
	@Override
	public void update(MeetingOrganizeEntity meetingOrganize){
		meetingOrganizeDao.update(meetingOrganize);
	}
	
	@Override
	public void delete(String id){
		meetingOrganizeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		meetingOrganizeDao.deleteBatch(ids);
	}
	
}
