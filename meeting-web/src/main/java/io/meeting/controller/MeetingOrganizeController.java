package io.meeting.controller;

import io.meeting.entity.MeetingOrganizeEntity;
import io.meeting.service.MeetingOrganizeService;
import io.meeting.utils.PageUtils;
import io.meeting.utils.Query;
import io.meeting.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2018-01-19 22:42:18
 */
@RestController
@RequestMapping("meetingorganize")
public class MeetingOrganizeController {
	@Autowired
	private MeetingOrganizeService meetingOrganizeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("meetingorganize:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MeetingOrganizeEntity> meetingOrganizeList = meetingOrganizeService.queryList(query);
		int total = meetingOrganizeService.queryTotal(query);
//        return R.ok().put("list", meetingOrganizeList);
		PageUtils pageUtil = new PageUtils(meetingOrganizeList, total, query.getLimit(), query.getPage());
//
		return R.ok().put("page", pageUtil);
	}
    @RequestMapping("/list2")
    @RequiresPermissions("meetingorganize:list2")
    public R list2(@RequestParam Map<String, Object> params){
        //查询列表数据
//        Query query = new Query(params);



        List<MeetingOrganizeEntity> meetingOrganizeList = meetingOrganizeService.queryList(null);
//        int total = meetingOrganizeService.queryTotal(query);
////        return R.ok().put("list", meetingOrganizeList);
//        PageUtils pageUtil = new PageUtils(meetingOrganizeList, total, query.getLimit(), query.getPage());
////
        return R.ok().put("list2", meetingOrganizeList);
    }
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("meetingorganize:info")
	public R info(@PathVariable("id") String id){
		MeetingOrganizeEntity meetingOrganize = meetingOrganizeService.queryObject(id);
		
		return R.ok().put("meetingOrganize", meetingOrganize);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("meetingorganize:save")
	public R save(@RequestBody MeetingOrganizeEntity meetingOrganize){
		meetingOrganizeService.save(meetingOrganize);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("meetingorganize:update")
	public R update(@RequestBody MeetingOrganizeEntity meetingOrganize){
		meetingOrganizeService.update(meetingOrganize);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("meetingorganize:delete")
	public R delete(@RequestBody String[] ids){
		meetingOrganizeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
