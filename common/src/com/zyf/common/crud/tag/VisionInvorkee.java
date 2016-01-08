/**
 * 沈阳卓越科技有限公司版权所有
 * 制作时间：Oct 25, 20078:34:26 PM
 * 文件名：DefaultComInvorkee.java
 * 制作者：wuym
 * 
 */
package com.zyf.common.crud.tag;

//import com.zyf.security.model.CurrentUser;
import com.zyf.context.BusinessContext;
import com.zyf.context.OperType;
import com.zyf.security.SecurityContextInfo;
import com.zyf.security.model.CurrentUser;
import com.zyf.security.model.RWCtrlType;

/**
 * @author wuym
 * 
 */
public class VisionInvorkee implements IVisionInvorkee {
	public VisionStatusInfo getVisionStatusInfo(String rwCtrlType,String permissionCode) {
		int operType = BusinessContext.getOperType();
		CurrentUser currentUser = SecurityContextInfo.getCurrentUser();
		VisionStatusInfo visionStatusInfo = new VisionStatusInfo();

		//数据项状态
		int type = Integer.parseInt(rwCtrlType);
		int field = 1;//currentUser.getFieldRWCtrlType(SecurityContextInfo.getCurrentPageUrl(),permissionCode);
		//int page = 2;//currentUser.getPageDefaultRWCtrlType(SecurityContextInfo.getCurrentPageUrl());
		int least = type > field ? field : type;
		
		//新增页
		if(operType==OperType.ADD){
			visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);
			visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);
		}//查看页
		else if(operType==OperType.VIEW){
			visionStatusInfo.setPageType(IVisionInvorkee.VIEWPAGE);
			visionStatusInfo.setEditableStatus(IVisionInvorkee.UNEDITABLE);
			//查看项不可见
			if(least==RWCtrlType.SIGHTLESS){
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.UNVISIBLE);
			}else{
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			}
		}//编辑页
		else if(operType==OperType.EDIT){
			visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);
			
			if(least==RWCtrlType.SIGHTLESS){
				//查看项不可见
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.UNVISIBLE);
			}else{
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			}
			if(least==RWCtrlType.READ_ONLY){
				//查看项不可编辑
				visionStatusInfo.setEditableStatus(IVisionInvorkee.UNEDITABLE);
			}else{
				//查看项可编辑
				visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);
			}
		}
		
		//visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);// 查看页或编辑页
		//visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);// 是否可见状态
		//visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);// 是否编辑状态
		return visionStatusInfo;
	}
}
