package io.meeting.dao;

import io.meeting.entity.TokenEntity;
import io.meeting.dao.BaseDao;

/**
 * 用户Token
 * 
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
	
}
