/*======================================================================
 *    SYSTEM      : ���{�w�p�U����d�q�\���V�X�e���i�Ȋw������⏕���j
 *    Source name : SearchListTokuteiAction.java
 *    Description : ���ƊǗ���񌟍��A�N�V�����N���X�B��t�����厖�ƈꗗ��ʂ�\������
 *
 *    Author      : Admin
 *    Date        : 2003/11/14
 *
 *    Revision history
 *    Date          Revision    Author         Description
 *    2003/11/14    v1.0        Admin          �V�K�쐬
 *    2006/07/10    v1.1        Dis.dyh        �ύX
 *====================================================================== 
 */
package jp.go.jsps.kaken.web.shinsei;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jsps.kaken.model.common.IJigyoKubun;
import jp.go.jsps.kaken.model.common.IServiceName;
import jp.go.jsps.kaken.model.exceptions.ApplicationException;
import jp.go.jsps.kaken.model.exceptions.NoDataFoundException;
import jp.go.jsps.kaken.model.exceptions.SystemException;
import jp.go.jsps.kaken.model.vo.JigyoKanriSearchInfo;
import jp.go.jsps.kaken.util.Page;
import jp.go.jsps.kaken.web.common.IConstants;
import jp.go.jsps.kaken.web.common.UserContainer;
import jp.go.jsps.kaken.web.struts.BaseAction;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ���ƊǗ���񌟍��A�N�V�����N���X�B
 * ��t�����厖�ƈꗗ��ʂ�\������B
 */
public class SearchListTokuteiAction extends BaseAction {

	/** �����Ώێ���ID */
	private final static String[] JIGYO_KUBUN = new String[] { IJigyoKubun.JIGYO_KUBUN_TOKUTEI };

	/* (�� Javadoc)
	 * @see jp.go.jsps.kaken.web.struts.BaseAction#doMainProcessing(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, jp.go.jsps.kaken.web.common.UserContainer)
	 */
	public ActionForward doMainProcessing(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		UserContainer container)
		throws ApplicationException {
			
		//-----ActionErrors�̐錾�i��^�����j-----
		ActionErrors errors = new ActionErrors();

		//------�L�����Z����		
		if (isCancelled(request)) {
			return forwardCancel(mapping);
		}

		//���������̎擾
//2006/06/21 �c�@�C����������        
//		BaseSearchForm searchForm = (BaseSearchForm)form;
        TokuteiSearchForm searchForm = (TokuteiSearchForm)form;
//2006/06/21 �c�@�C�������܂�        
		//���X�g�̂ݕ\�������邽�߁A�y�[�W������1���ɂ���B
		searchForm.setPageSize(0);

		//-------�� VO�Ƀf�[�^���Z�b�g����B
		JigyoKanriSearchInfo searchInfo = new JigyoKanriSearchInfo();

		try {
			PropertyUtils.copyProperties(searchInfo, searchForm);
		} catch (Exception e) {
			log.error(e);
			throw new SystemException("�v���p�e�B�̐ݒ�Ɏ��s���܂����B", e);
		}

		//�������s
		Page result = null;
		try{
			//���Ƌ敪�Z�b�g
			searchInfo.setJigyoKubun(JIGYO_KUBUN);
//2006/06/21 �c�@�ǉ���������
            searchInfo.setJigyoCds(searchForm.getJigyoCds());
//2006/06/21�@�c�@�C�������܂�            
				
			result =
					getSystemServise(
					IServiceName.JIGYOKANRI_MAINTENANCE_SERVICE).searchUketukeJigyo(
									container.getUserInfo(),searchInfo);
		}catch(NoDataFoundException e){
			//0���̃y�[�W�I�u�W�F�N�g�𐶐�
			result = Page.EMPTY_PAGE;
		}

		//�������ʂ����N�G�X�g�����ɃZ�b�g
		request.setAttribute(IConstants.RESULT_INFO,result);       

		//-----��ʑJ�ځi��^�����j-----
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return forwardFailure(mapping);
		}
		return forwardSuccess(mapping);
	}
}