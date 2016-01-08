package com.zyf.common.crud.tag;

import org.apache.commons.lang.StringUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zyf.context.BusinessContext;
import com.zyf.context.OperType;
import com.zyf.security.model.RWCtrlType;
import com.zyf.tools.MessageInfo;
import com.zyf.web.MessageUtils;

public class TagSecurityTotalForgrPolicy extends TagSecurityDefautPolicy {

	//设置页面状态:OperType.ADD新增页/OperType.EDIT编辑页/OperType.VIEW查看页
	public int pageType(){

		if (pageContext.getRequest().getParameter("oid") == null 
				|| pageContext.getRequest().getParameter("oid").toString().length()==0){
			return OperType.ADD;
		}
		
		//是否设置了权限
//		if(this.rwCtrlType != -1){
//			switch (this.rwCtrlType) {
//				case RWCtrlType.EDIT:
//					return OperType.EDIT;
//				case RWCtrlType.READ_ONLY:
//					return OperType.VIEW;
//				default:
//					return OperType.VIEW;
//			}
//		}else{
//			if(!BusinessContext.isNull()){
//				if(BusinessContext.getOperType()==OperType.EDIT){
//					return OperType.EDIT;
//				}else if(BusinessContext.getOperType()==OperType.VIEW){
//					return OperType.VIEW;
//				}else {
//					return OperType.ADD;
//				}
//			}else {
//				return OperType.EDIT;
//			}
//		}
		
		try{
			if(!BusinessContext.isNull()){
				if(BusinessContext.getOperType()==OperType.EDIT){
					return OperType.EDIT;
				}else if(BusinessContext.getOperType()==OperType.VIEW){
					return OperType.VIEW;
				}else {
					throw new Exception("画面类型设定错误!");
				}
			}else if(this.rwCtrlType != -1){
				switch (this.rwCtrlType) {
				case RWCtrlType.EDIT:
					return OperType.EDIT;
				case RWCtrlType.READ_ONLY:
					return OperType.EDIT;
				default:
					return OperType.VIEW;
				}
			}else{
				throw new Exception("无法判断画面类型!");
			}
		}catch(Exception e){
			e.printStackTrace();
			return OperType.EDIT;
		}
		
	}
	//查看页设置
	public VisionStatusInfo inviewPagePermission(HibernateTemplate hibernateTemplate){
		visionStatusInfo.setPageType(ITagSecurityPolicy.VIEWPAGE);
		visionStatusInfo.setEditableStatus(ITagSecurityPolicy.UNEDITABLE);
		//查看项不可见
		if(least==RWCtrlType.SIGHTLESS){
			visionStatusInfo.setVisiableStatus(ITagSecurityPolicy.UNVISIBLE);
		}else{
			visionStatusInfo.setVisiableStatus(ITagSecurityPolicy.VISIBLE);
		}
		return visionStatusInfo;
	}
	//编辑页设置
	public VisionStatusInfo inEditPagePermission(HibernateTemplate hibernateTemplate){
		visionStatusInfo.setPageType(ITagSecurityPolicy.EDITPAGE);
		
		if(least==RWCtrlType.SIGHTLESS){
			//查看项不可见
			visionStatusInfo.setVisiableStatus(ITagSecurityPolicy.UNVISIBLE);
		}else{
			visionStatusInfo.setVisiableStatus(ITagSecurityPolicy.VISIBLE);
		}
		if(least==RWCtrlType.READ_ONLY){
			//查看项不可编辑
			visionStatusInfo.setEditableStatus(ITagSecurityPolicy.UNEDITABLE);
		}else{
			//查看项可编辑
			visionStatusInfo.setEditableStatus(ITagSecurityPolicy.EDITABLE);
		}
		return visionStatusInfo;
	}
}
