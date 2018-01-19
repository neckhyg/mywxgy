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

import io.meeting.entity.MeetingInfoEntity;
import io.meeting.service.MeetingInfoService;
import io.meeting.utils.PageUtils;
import io.meeting.utils.Query;
import io.meeting.utils.R;


/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 13:43:10
 */
@RestController
@RequestMapping("meetinginfo")
public class MeetingInfoController {
	@Autowired
	private MeetingInfoService meetingInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("meetinginfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MeetingInfoEntity> meetingInfoList = meetingInfoService.queryList(query);
		int total = meetingInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(meetingInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("meetinginfo:info")
	public R info(@PathVariable("id") Integer id){
		MeetingInfoEntity meetingInfo = meetingInfoService.queryObject(id);
		
		return R.ok().put("meetingInfo", meetingInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("meetinginfo:save")
	public R save(@RequestBody MeetingInfoEntity meetingInfo){
		meetingInfoService.save(meetingInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("meetinginfo:update")
	public R update(@RequestBody MeetingInfoEntity meetingInfo){
		meetingInfoService.update(meetingInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("meetinginfo:delete")
	public R delete(@RequestBody Integer[] ids){
		meetingInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
