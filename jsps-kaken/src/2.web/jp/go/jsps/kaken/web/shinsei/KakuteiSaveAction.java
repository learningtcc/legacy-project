/*======================================================================
 *    SYSTEM      : 日本学術振興会電子申請システム（科学研究費補助金）
 *    Source name : KatuteiSaveAction.java
 *    Description : 領域内研究計画調書確定を行うアクションクラス。
 *
 *    Author      : DIS.jzx
 *    Date        : 2006/06/20
 *
 *    Revision history
 *    Date          Revision    Author         Description
 *    2006/06/14    V1.0        DIS.jzx        新規作成
 *====================================================================== 
 */
package jp.go.jsps.kaken.web.shinsei;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jsps.kaken.model.common.IServiceName;
import jp.go.jsps.kaken.model.exceptions.ApplicationException;
import jp.go.jsps.kaken.model.exceptions.NoDataFoundException;
import jp.go.jsps.kaken.model.vo.ShinseiDataInfo;
import jp.go.jsps.kaken.status.StatusCode;
import jp.go.jsps.kaken.web.common.UserContainer;
import jp.go.jsps.kaken.web.struts.BaseAction;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 領域内研究計画調書確定を行うアクションクラス。
 * 
 * ID RCSfile="$RCSfile: KakuteiSaveAction.java,v $"
 * Revision="$Revision: 1.1 $"
 * Date="$Date: 2007/06/28 02:07:00 $"
 */
public class KakuteiSaveAction extends BaseAction {

    /** 所属機関受付中(状況ID:03)以降の状況ID */
    private static String[] JOKYO_ID = new String[]{
            StatusCode.STATUS_RYOUIKIDAIHYOU_KAKUNIN //申請状況：「領域代表者確認中」
    };

    /* (非 Javadoc)
     * @see jp.go.jsps.kaken.web.struts.BaseAction#doMainProcessing(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, jp.go.jsps.kaken.web.common.UserContainer)
     */
    public ActionForward doMainProcessing(
        ActionMapping mapping,
        ActionForm form,
        HttpServletRequest request,
        HttpServletResponse response,
        UserContainer container)
        throws ApplicationException {
            
        //-----ActionErrorsの宣言（定型処理）-----
        ActionErrors errors = new ActionErrors();

        //-----簡易申請書入力フォームの取得
        RyoikiGaiyoForm ryoikiGaiyoForm =(RyoikiGaiyoForm)form;
        ShinseiDataInfo shinseiDataInfo = new ShinseiDataInfo();
        shinseiDataInfo.setSystemNo(ryoikiGaiyoForm.getRyoikiSystemNo());
        shinseiDataInfo.setRyouikiNo(ryoikiGaiyoForm.getKariryoikiNo());

        //研究項目番号を「総括班」に設定
        shinseiDataInfo.setRyouikiKoumokuNo("X00");

        //削除フラグ 
        shinseiDataInfo.setDelFlg("0");
        shinseiDataInfo.setJokyoId(StatusCode.STATUS_RYOUIKIDAIHYOU_KAKUNIN);

        //申請状況：「領域代表者確認中」 
        shinseiDataInfo.setJokyoIds(JOKYO_ID);
        try {
            getSystemServise(IServiceName.TEISHUTU_MAINTENANCE_SERVICE)
                .kakuteiRyoikiGaiyo(container.getUserInfo(),shinseiDataInfo);
        }catch (NoDataFoundException ex) {
            errors.add("該当データはありません", new ActionError("errors.5002"));
        }
        
        //-----画面遷移（定型処理）-----
        if (!errors.isEmpty()) {
            saveErrors(request, errors);
            return forwardFailure(mapping);
        }
        
        return forwardSuccess(mapping);
    }  
}