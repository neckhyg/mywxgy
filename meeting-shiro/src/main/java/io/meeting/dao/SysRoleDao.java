package io.meeting.dao;

import io.meeting.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色管理
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2016年9月18日 上午9:33:33
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
