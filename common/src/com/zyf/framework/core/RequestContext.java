/* 
 * 浙江大学快威集团版权所有(2006-2007), Power by COHEG TEAM.
 */
package com.zyf.framework.core;

import com.zyf.framework.authentication.entity.Function;
import com.zyf.framework.codename.UserCodeName;
import com.zyf.persistent.filter.ConditionInfo;

/**
 * <p>系统服务接口, 通过<code>AOP</code>来实现, 提供上下文的通用信息, 像当前登录用户, 检索条
 * 件等, 任何一个配置在<code>spring bean factory</code>的<code>ServiceBase</code>服务
 * 都可以<code>cast</code>成这个类型以获取所需信息</p>
 * <p>如果在服务中使用了这些信息, 那么在<code>junit</code>时被测试的服务实现要再实现这个接口
 * 同时<code>mock</code>你使用的信息</p>
 * @author zhangli
 * @version $Id: RequestContext.java,v 1.1 2007/11/05 03:16:27 yushn Exp $
 * @since 2007-6-11
 */
public interface RequestContext {
    
    /**
     * 检索当前登录的用户
     * @return 当前登录的用户
     */
    UserCodeName getCurrentUser();
    
    /**
     * 检索当前请求中的执行条件
     * @return 当前请求中的执行条件
     */
    ConditionInfo getConditionInfo();
    
    /**
     * 检索当前请求的功能
     * @return 当前请求的功能
     */
    Function getCurrentFunction();
}
