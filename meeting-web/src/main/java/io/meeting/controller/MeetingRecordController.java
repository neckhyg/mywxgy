package io.meeting.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.meeting.entity.MeetingRecordEntity;
import io.meeting.service.MeetingRecordService;
import io.meeting.utils.PageUtils;
import io.meeting.utils.Query;
import io.meeting.utils.R;


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
