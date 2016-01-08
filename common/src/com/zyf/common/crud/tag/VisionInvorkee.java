/**
 * ����׿Խ�Ƽ����޹�˾��Ȩ����
 * ����ʱ�䣺Oct 25, 20078:34:26 PM
 * �ļ�����DefaultComInvorkee.java
 * �����ߣ�wuym
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

		//������״̬
		int type = Integer.parseInt(rwCtrlType);
		int field = 1;//currentUser.getFieldRWCtrlType(SecurityContextInfo.getCurrentPageUrl(),permissionCode);
		//int page = 2;//currentUser.getPageDefaultRWCtrlType(SecurityContextInfo.getCurrentPageUrl());
		int least = type > field ? field : type;
		
		//����ҳ
		if(operType==OperType.ADD){
			visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);
			visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);
		}//�鿴ҳ
		else if(operType==OperType.VIEW){
			visionStatusInfo.setPageType(IVisionInvorkee.VIEWPAGE);
			visionStatusInfo.setEditableStatus(IVisionInvorkee.UNEDITABLE);
			//�鿴��ɼ�
			if(least==RWCtrlType.SIGHTLESS){
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.UNVISIBLE);
			}else{
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			}
		}//�༭ҳ
		else if(operType==OperType.EDIT){
			visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);
			
			if(least==RWCtrlType.SIGHTLESS){
				//�鿴��ɼ�
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.UNVISIBLE);
			}else{
				visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);
			}
			if(least==RWCtrlType.READ_ONLY){
				//�鿴��ɱ༭
				visionStatusInfo.setEditableStatus(IVisionInvorkee.UNEDITABLE);
			}else{
				//�鿴��ɱ༭
				visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);
			}
		}
		
		//visionStatusInfo.setPageType(IVisionInvorkee.EDITPAGE);// �鿴ҳ��༭ҳ
		//visionStatusInfo.setVisiableStatus(IVisionInvorkee.VISIBLE);// �Ƿ�ɼ�״̬
		//visionStatusInfo.setEditableStatus(IVisionInvorkee.EDITABLE);// �Ƿ�༭״̬
		return visionStatusInfo;
	}
}