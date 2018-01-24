package io.meeting.dao;

import io.meeting.dao.BaseDao;
import io.meeting.entity.UserEntity;

/**
 * 用户
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-03-23 15:22:06
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
