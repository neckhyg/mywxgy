package io.meeting.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 * @author neckhyg
 * @email 497273569@qq.com
 * @date 2017-03-23 15:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
