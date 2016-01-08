/**
 * 	@(#) TelServiceImpl.java 2008-4-11 ����01:09:59
 *	��Ȩ���� ������׿Խ�Ƽ����޹�˾�� 
 *	׿Խ�Ƽ� ����һ��Ȩ��
 */
package et.bo.stat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;

import et.bo.common.proc.ProcSql;
import et.bo.jfree.service.JFreeService;
import et.bo.jfree.service.impl.JFreeImpl;
import et.bo.stat.service.PriceStatForProductService;
import excellence.common.key.KeyService;
import excellence.framework.base.dao.BaseDAO;
import excellence.framework.base.dto.IBaseDTO;
import excellence.framework.base.dto.impl.DynaBeanDTO;

/**
 * @author chen gang
 * 
 */
public class PriceStatForProductImpl implements PriceStatForProductService {
	private BaseDAO dao;

	private KeyService ks;

	private ProcSql procSql;

	private JFreeService chartService;

	public JFreeService getChartService() {
		return chartService;
	}

	public void setChartService(JFreeService chartService) {
		this.chartService = chartService;
	}

	public ProcSql getProcSql() {
		return procSql;
	}

	public void setProcSql(ProcSql procSql) {
		this.procSql = procSql;
	}

	public BaseDAO getDao() {
		return dao;
	}

	public void setDao(BaseDAO dao) {
		this.dao = dao;
	}

	public KeyService getKs() {
		return ks;
	}

	public void setKs(KeyService ks) {
		this.ks = ks;
	}

	public JFreeChart statistic(IBaseDTO dto) {
		// TODO Auto-generated method stub
		JFreeChart chart = null;
		// ����������������ô洢����
		StatDateStr.setBeginEndTime(dto);
		List<String> params = new ArrayList<String>();
		List results = new ArrayList();
		procSql.setProcedureName("proc_productPriceStatisticsForProduct");
//		ͳ�������м��롰�۸����͡�
		procSql.setProcedureName("proc_productPriceStatisticsForProduct_addPriceType");
		params.add(dto.get("beginTime").toString());
		params.add(dto.get("endTime").toString());
		params.add(dto.get("address").toString());
		params.add(dto.get("dictProductType1").toString());
		params.add(dto.get("dictProductType2").toString());
		params.add((String)dto.get("productName"));
//		String type = dto.get("condition").toString();
//		if("class1".equals(type))
//			type = "����";
//		else if("class2".equals(type))
//			type = "С��";
//		else if("class3".equals(type))
//			type = "����";
//		
//		params.add(type);
		
		String productType = (String)dto.get("productType");
		if(productType!=null&&!"".equals(productType.trim()))
			params.add(" and dict_price_type = '"+productType+"' ");
		else
			params.add("");	
		
		procSql.setSqlvalues(params);
		results = procSql.execute();
		
		// �Դ洢���̷��صĵĽ�����зּ�
		List<String> xAxis = getXaxis(results);
		List<String> yAxis = getYaxis(results);
		List<String> valueList = getValues(results, xAxis, yAxis);
		// ����JFreeChart���������
		Map<String, Object> properties = new HashMap<String, Object>();
		String chartType = dto.get("chartType").toString();
		if ("on".equals(dto.get("is3d"))) {
			chartType += "3d";
		}
		// ����ͼ�ε�ͨ������
		properties.put("chartType", chartType);
		properties.put("chartTitle", "�����ظ���Ʒ�۸�����ֵ����Сֵ��ƽ��ֵ");
		// ����ͼ�ε��ض�����
//		String yChartName="count".equals(dto.get("condition"))?"�绰����":"ͨ��ʱ��";
		String yChartName="�۸���ֵ";
		if (chartType.indexOf(JFreeImpl.BAR) >= 0) {
			if(!"".equals(dto.get("address").toString()))
				properties.put("xChartName", dto.get("address").toString());
			else
				properties.put("xChartName", "���в���");
			
			properties.put("yChartName", yChartName);
			properties.put("xChartValues", xAxis);
			properties.put("yChartValues", yAxis);
			properties.put("chartValues", valueList);
		} else if (chartType.indexOf(JFreeImpl.LINE) >= 0) {
			if(!"".equals(dto.get("address").toString()))
				properties.put("xChartName", dto.get("address").toString());
			else
				properties.put("xChartName", "���в���");
			
			properties.put("yChartName", yChartName);
			properties.put("xChartValues", xAxis);
			properties.put("yChartValues", yAxis);
			properties.put("chartValues", valueList);
		} else if (chartType.indexOf(JFreeImpl.PIE) >= 0) {
			properties.put("pieTextValues", xAxis);
		}
		// ����JFreeChart����
		chart = chartService.createJFreeChart(valueList, properties);
		return chart;
	}

	public List<DynaBeanDTO> query(IBaseDTO dto) {
		// TODO Auto-generated method stub
		List<DynaBeanDTO> list = new ArrayList<DynaBeanDTO>();
		// ���ô洢����ȡ��ͳ�ƽ��
		StatDateStr.setBeginEndTime(dto);
		List<String> params = new ArrayList<String>();
		List results = new ArrayList();
//		procSql.setProcedureName("proc_productPriceStatisticsForProduct");
//		ͳ�������м��롰�۸����͡�
		procSql.setProcedureName("proc_productPriceStatisticsForProduct_addPriceType");
		params.add(dto.get("beginTime").toString());
		params.add(dto.get("endTime").toString());
		params.add(dto.get("address").toString());
		params.add(dto.get("dictProductType1").toString());
		params.add(dto.get("dictProductType2").toString());
		params.add((String)dto.get("productName"));
//		String type = dto.get("condition").toString();
//		if("class1".equals(type))
//			type = "����";
//		else if("class2".equals(type))
//			type = "С��";
//		else if("class3".equals(type))
//			type = "����";
//		
//		params.add(type);
		
		String productType = (String)dto.get("productType");
		if(productType!=null&&!"".equals(productType.trim()))
			params.add(" and dict_price_type = '"+productType+"' ");
		else
			params.add("");	
		
		procSql.setSqlvalues(params);
		results = procSql.execute();
		
		
		// �Դ洢���̷��صĵĽ�����зּ�
		List<String> xAxis = getXaxis(results);
		List<String> yAxis = getYaxis(results);
		List<String> valueList = getValues(results, xAxis, yAxis);

		if(!"".equals(dto.get("address").toString())){
			if(xAxis.size()>0&&yAxis.size()>0) {
				for (Iterator<String> i = xAxis.iterator(); i.hasNext();) {
					String tmp = i.next();
					DynaBeanDTO r = new DynaBeanDTO();
					r.set("address", dto.get("address").toString());
					r.set("productName", tmp);
					r.set("maxValue", valueList.get(xAxis.indexOf(tmp) * yAxis.size()));
					r.set("minValue", valueList.get(xAxis.indexOf(tmp)
									* yAxis.size() + 1));
					r.set("avgValue", valueList.get(xAxis.indexOf(tmp)
							* yAxis.size() + 2));
					list.add(r);
				}
			}
		} else{
			if(xAxis.size()>0&&yAxis.size()>0) {
				for (Iterator<String> i = xAxis.iterator(); i.hasNext();) {
					String tmp = i.next();
					DynaBeanDTO r = new DynaBeanDTO();
					r.set("address", "���в���");
					r.set("productName", tmp);
					r.set("maxValue", valueList.get(xAxis.indexOf(tmp) * yAxis.size()));
					r.set("minValue", valueList.get(xAxis.indexOf(tmp)
									* yAxis.size() + 1));
					r.set("avgValue", valueList.get(xAxis.indexOf(tmp)
							* yAxis.size() + 2));
					list.add(r);
				}
			}
		}
		return list;
	}

	private List<String> getXaxis(List result) {
		List<String> xAxis = new ArrayList<String>();
		// ����X�����label����
		for (Iterator i = ((List) result.get(0)).iterator(); i.hasNext();) {
			Map xLabel = (Map) i.next();
			xAxis.add(xLabel.get("xaxis").toString());
		}
		return xAxis;
	}

	private List<String> getYaxis(List result) {
		List<String> yAxis = new ArrayList<String>();
		// ����Y�����label����
		for (Iterator i = ((List) result.get(1)).iterator(); i.hasNext();) {
			Map yLabel = (Map) i.next();
			yAxis.add(yLabel.get("yaxis").toString());
		}
		return yAxis;
	}

	private List<String> getValues(List result, List<String> xAxis,
			List<String> yAxis) {
		// ����X��Y�����Label������������
		List<String> valueList = new ArrayList<String>();
		for (int i = 0; i < xAxis.size() * yAxis.size(); i++) {
			valueList.add("0");
		}
		for (Iterator i = ((List) result.get(2)).iterator(); i.hasNext();) {
			Map record = (Map) i.next();
			String respondent = record.get("xaxis").toString();
			String processType = record.get("yaxis").toString();
			String value = record.get("value").toString();
			valueList.set((xAxis.indexOf(respondent)) * yAxis.size()
					+ yAxis.indexOf(processType), value);
		}
		return valueList;
	}
}