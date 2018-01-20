package io.meeting.controller;

import io.meeting.entity.MeetingTeacherEntity;
import io.meeting.service.MeetingTeacherService;
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
 * @date 2018-01-20 22:12:54
 */
@RestController
@RequestMapping("meetingteacher")
public class MeetingTeacherController {
	@Autowired
	private MeetingTeacherService meetingTeacherService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("meetingteacher:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MeetingTeacherEntity> meetingTeacherList = meetingTeacherService.queryList(query);
		int total = meetingTeacherService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(meetingTeacherList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}

    @RequestMapping("/listbydeptno/{deptNO}")
    @RequiresPermissions("meetingteacher:listbydeptno")
    public R list(@PathVariable("deptNO") String deptno){
        //查询列表数据
//        Query query = new Query(params);

        List<MeetingTeacherEntity> meetingTeacherEntity = meetingTeacherService.queryListByDeptNO(deptno);
//        int total = selectattendanceService.queryTotal(query);
//
//        PageUtils pageUtil = new PageUtils(selectattendanceList, total, query.getLimit(), query.getPage());

        return R.ok().put("list", meetingTeacherEntity);
    }
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("meetingteacher:info")
	public R info(@PathVariable("id") Integer id){
		MeetingTeacherEntity meetingTeacher = meetingTeacherService.queryObject(id);
		
		return R.ok().put("meetingTeacher", meetingTeacher);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("meetingteacher:save")
	public R save(@RequestBody MeetingTeacherEntity meetingTeacher){
		meetingTeacherService.save(meetingTeacher);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("meetingteacher:update")
	public R update(@RequestBody MeetingTeacherEntity meetingTeacher){
		meetingTeacherService.update(meetingTeacher);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("meetingteacher:delete")
	public R delete(@RequestBody Integer[] ids){
		meetingTeacherService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
