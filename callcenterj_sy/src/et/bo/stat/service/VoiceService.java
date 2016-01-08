/*
 * @(#)UseService.java	 2008-04-14
 *
 * 版权所有 沈阳市卓越科技有限公司。
 */

package et.bo.stat.service;

import java.util.List;

import org.jfree.chart.JFreeChart;

import excellence.common.tools.LabelValueBean;
import excellence.framework.base.dto.IBaseDTO;
import excellence.framework.base.dto.impl.DynaBeanDTO;

/**
 * @author chen gang 
 */
public interface VoiceService {
	/**
	 * 根据dto对象的参数值，执行统计，并返回根据统计结果生成的JFreeChart对象
	 * @param dto
	 * @return
	 */
	public JFreeChart statistic(IBaseDTO dto);
	/**
	 * 根据DTO对象的参数值，执行统计，并将统计结果进行处理，生成符合报表格式的列表
	 * @param dto
	 * @return
	 */
	public List<DynaBeanDTO> query(IBaseDTO dto);
	/**
	 * 返回menu列表供用户选择
	 * @param
	 * @return List<LabelValueBean>
	 */
	public List<LabelValueBean> menuList();
}
