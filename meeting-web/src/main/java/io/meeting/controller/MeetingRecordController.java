package io.meeting.controller;

import io.meeting.entity.MeetingInfoEntity;
import io.meeting.entity.MeetingRecordEntity;
import io.meeting.entity.MeetingTeacherEntity;
import io.meeting.service.MeetingInfoService;
import io.meeting.service.MeetingRecordService;
import io.meeting.service.MeetingTeacherService;
import io.meeting.utils.PageUtils;
import io.meeting.utils.Query;
import io.meeting.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import simplemail.MailTest2;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 14:59:32
 */
@RestController
@RequestMapping("meetingrecord")
public class MeetingRecordController {
	@Autowired
	private MeetingRecordService meetingRecordService;
    @Autowired
    private MeetingInfoService meetingInfoService;
    @Autowired
    private MeetingTeacherService meetingTeacherService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("meetingrecord:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MeetingRecordEntity> meetingRecordList = meetingRecordService.queryList(query);
		int total = meetingRecordService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(meetingRecordList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
    @ResponseBody
    @RequestMapping("/count")
    // @RequiresPermissions("zfxsxxjbb:count")
    public R count(@RequestParam Map<String, Object> params){
        return null;
    }
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("meetingrecord:info")
	public R info(@PathVariable("id") Integer id){
		MeetingRecordEntity meetingRecord = meetingRecordService.queryObject(id);
		
		return R.ok().put("meetingRecord", meetingRecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("meetingrecord:save")
	public R save(@RequestBody MeetingRecordEntity meetingRecord){
		meetingRecordService.save(meetingRecord);
		
		return R.ok();
	}
    private void sendMail(String userID, String msg){

//        Mail mail = new Mail();
//
//        mail.setHost("smtp.wxgyxy.cn");
//        mail.setSender("heyg@wxgyxy.cn");
//        mail.setUsername("heyg@wxgyxy.cn");
//        mail.setPassword("wxgy2013");

        MeetingTeacherEntity meetingTeacherEntity = meetingTeacherService.queryObjectByUserId(userID);
//        mail.setReceiver(meetingTeacherEntity.getEmail());
//
//        mail.setSubject("会议通知");
//        mail.setMessage(msg);
//        MailUtil util = new MailUtil();
//        if(util.send(mail)){
//
//            return true;
//        }else{
//            return false;
//        }
        MailTest2.sendmail("smtp.sohu.com","neckx@sohu.com",meetingTeacherEntity.getEmail(),"会议通知",msg);

   }
    @RequestMapping("/groupsave")
    @RequiresPermissions("meetingrecord:groupsave")
    public R groupsave(Integer meetingno,String idGroup,String nameGroup){
        MeetingInfoEntity meetingInfo = meetingInfoService.queryObject(meetingno) ;
        String[] idgroup =  idGroup.split(",");
        String[] namegroup =  nameGroup.split(",");
        for (int i = 0; i< idgroup.length;i++){
            MeetingRecordEntity    meetingRecord = new MeetingRecordEntity();
            meetingRecord.setMeetingno(meetingInfo.getMeetingno());
            meetingRecord.setMeetingname(meetingInfo.getMeetingname());
            meetingRecord.setMeetingdate(meetingInfo.getMeetingdate());
            meetingRecord.setMeetinglocation(meetingInfo.getMeetinglocation());
            meetingRecord.setChairman(meetingInfo.getChairman());
            meetingRecord.setSignstatus("未签到");
            meetingRecord.setAttendanceid(idgroup[i]);
            meetingRecord.setAttendancename(namegroup[i]);
            meetingRecordService.save(meetingRecord);
              String msg =  namegroup[i]+"您有一个会议通知：" +   "\n会议名称： "+meetingInfo.getMeetingname()
                           +"\n会议地点： "+meetingInfo.getMeetinglocation()
                           +"\n会议时间：  "+  meetingInfo.getMeetingdate() ;
            sendMail(idgroup[i],msg);
        }
//        MeetingRecordEntity    meetingRecord = new MeetingRecordEntity();
//        meetingRecordService.save(meetingRecord);

        return R.ok();
    }
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("meetingrecord:update")
	public R update(@RequestBody MeetingRecordEntity meetingRecord){
		meetingRecordService.update(meetingRecord);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("meetingrecord:delete")
	public R delete(@RequestBody Integer[] ids){
		meetingRecordService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
