package io.meeting.service.impl;

import io.meeting.dao.MeetingTeacherDao;
import io.meeting.entity.MeetingTeacherEntity;
import io.meeting.service.MeetingTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("meetingTeacherService")
public class MeetingTeacherServiceImpl implements MeetingTeacherService {
	@Autowired
	private MeetingTeacherDao meetingTeacherDao;
	
	@Override
	public MeetingTeacherEntity queryObject(Integer id){
		return meetingTeacherDao.queryObject(id);
	}
	
	@Override
	public List<MeetingTeacherEntity> queryList(Map<String, Object> map){
		return meetingTeacherDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return meetingTeacherDao.queryTotal(map);
	}
	
	@Override
	public void save(MeetingTeacherEntity meetingTeacher){
		meetingTeacherDao.save(meetingTeacher);
	}
	
	@Override
	public void update(MeetingTeacherEntity meetingTeacher){
		meetingTeacherDao.update(meetingTeacher);
	}
	
	@Override
	public void delete(Integer id){
		meetingTeacherDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		meetingTeacherDao.deleteBatch(ids);
	}

    @Override
    public List<MeetingTeacherEntity> queryListByDeptNO(String deptno) {

        List<MeetingTeacherEntity> list = meetingTeacherDao.queryListByDeptID(deptno);
        return list;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
