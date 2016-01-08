/**
 * 沈阳卓越科技有限公司版权所有
 * 项目名称：common
 * 制作时间：Dec 6, 200711:10:05 AM
 * 包名：com.zyf.autokey.service
 * 文件名：AutoKeyService.java
 * 制作者：zhaoyf
 * @version 1.0
 */
package com.zyf.autokey.service;

import com.zyf.core.ServiceBase;

/**
 * 
 * @author zhaoyf
 * @version 1.0
 */
public interface AutoKeyService extends ServiceBase {

	public final String SERVICE_NAME = "common.autokey";
	/**
	 * 
	 * 功能描述 得到编号
	 * @param key 编号的key
	 * @return sn
	 * Dec 6, 2007 11:15:15 AM
	 * @version 1.0
	 * @author zhaoyf
	 */
	public String autoSn(String key);
	/**
	 * 
	 * 功能描述 得到编号
	 * @param key 编号的key
	 * @param style 编号样式
	 * @return sn
	 * Dec 6, 2007 11:15:15 AM
	 * @version 1.0
	 * @author zhaoyf
	 */
	public String fautoSn(String key,String style);
	/**
	 * 
	 * 功能描述 回滚编号，只回滚一个
	 * @param key 编号key
	 * @return sn，回滚之后的sn
	 * Dec 6, 2007 11:15:53 AM
	 * @version 1.0
	 * @author zhaoyf
	 */
	public String rollbackSn(String key);
	/**
	 * 
	 * 功能描述 设置sn
	 * @param key 编号的key
	 * @param sn 编号值
	 * @return sn 设置后的编号
	 * Dec 6, 2007 11:17:33 AM
	 * @version 1.0
	 * @author zhaoyf
	 */
	public String setSn(String key,int sn);
}
