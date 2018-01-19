package io.meeting.service.impl;

import io.meeting.dao.ConferenceUserDao;
import io.meeting.entity.ConferenceUserEntity;
import io.meeting.service.ConferenceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("conferenceUserService")
public class ConferenceUserServiceImpl implements ConferenceUserService {
	@Autowired
	private ConferenceUserDao conferenceUserDao;
	
	@Override
	public ConferenceUserEntity queryObject(Integer id){
		return conferenceUserDao.queryObject(id);
	}
	
	@Override
	public List<ConferenceUserEntity> queryList(Map<String, Object> map){
		return conferenceUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return conferenceUserDao.queryTotal(map);
	}
	
	@Override
	public void save(ConferenceUserEntity conferenceUser){
		conferenceUserDao.save(conferenceUser);
	}
	
	@Override
	public void update(ConferenceUserEntity conferenceUser){
		conferenceUserDao.update(conferenceUser);
	}
	
	@Override
	public void delete(Integer id){
		conferenceUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		conferenceUserDao.deleteBatch(ids);
	}

    @Override
    public ConferenceUserEntity queryObjectByUserId(String userId){
        return conferenceUserDao.queryObjectBySql(userId);
    }
}
