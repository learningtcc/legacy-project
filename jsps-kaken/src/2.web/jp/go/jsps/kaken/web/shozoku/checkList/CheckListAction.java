/*======================================================================
 *    SYSTEM      : 日本学術振興会電子申請システム（科学研究費補助金）
 *    Source name : CheckListAction.java
 *    Description : チェックリストの情報を取得する
 *
 *    Author      : 
 *    Date        : 2005/03/31
 *
 *    Revision history
 *    Date          Revision    Author         Description
 *    2005/03/31    V1.0                       新規作成
 *====================================================================== 
 */
package jp.go.jsps.kaken.web.shozoku.checkList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.go.jsps.kaken.model.common.IServiceName;
import jp.go.jsps.kaken.model.exceptions.ApplicationException;
import jp.go.jsps.kaken.model.exceptions.NoDataFoundException;
import jp.go.jsps.kaken.model.exceptions.SystemException;
import jp.go.jsps.kaken.model.vo.CheckListSearchInfo;
import jp.go.jsps.kaken.status.StatusCode;
import jp.go.jsps.kaken.util.Page;
import jp.go.jsps.kaken.web.common.IConstants;
import jp.go.jsps.kaken.web.common.UserContainer;
import jp.go.jsps.kaken.web.struts.BaseAction;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * チェックリストアクションクラス。
 * チェックリストの情報を取得する。
 * 
 * @author masuo_t
 */
public class CheckListAction extends BaseAction {

	//2005.12.19 iso チェックリストの件数修正
	/** 所属機関受付中(状況ID:03)以降の状況ID */
	private static String[] JIGYO_IDS = new String[]{
			StatusCode.STATUS_SHOZOKUKIKAN_UKETUKETYU,   //所属機関受付中
			StatusCode.STATUS_GAKUSIN_SHORITYU,          //学振受付中
			StatusCode.STATUS_GAKUSIN_JYURI,             //学振受理
			StatusCode.STATUS_GAKUSIN_FUJYURI,           //学振不受理
			StatusCode.STATUS_SHINSAIN_WARIFURI_SHORIGO, //審査員割り振り処理後
			StatusCode.STATUS_WARIFURI_CHECK_KANRYO,     //割り振りチェック完了
			StatusCode.STATUS_1st_SHINSATYU,             //一次審査中
			StatusCode.STATUS_1st_SHINSA_KANRYO,         //一次審査：判定
			StatusCode.STATUS_2nd_SHINSA_KANRYO          //二次審査完了
	};
	
	public ActionForward doMainProcessing(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		UserContainer container)
		throws ApplicationException {
		
		//------キャンセル時		
		if (isCancelled(request)) {
			return forwardCancel(mapping);
		}

		//-------▼ VOにデータをセットする。
		CheckListSearchInfo checkInfo = new CheckListSearchInfo();
		checkInfo.setShozokuCd(container.getUserInfo().getShozokuInfo().getShozokuCd());
// 20050606 Start 検索条件に追加したため
//update start dyh 2006/2/8
		CheckListForm listForm = (CheckListForm)form;
		checkInfo.setJigyoKubun(listForm.getJigyoKbn().trim());//事業区分
//		checkInfo.setJigyoKubun(IJigyoKubun.JIGYO_KUBUN_KIBAN);
//update end dyh 2006/2/8
// Horikoshi End
		
		//2005.12.19 iso チェックリストの件数修正
		checkInfo.setSearchJokyoId(JIGYO_IDS);
		
		CheckListForm checkForm = (CheckListForm)form;	
		try {
			PropertyUtils.copyProperties(checkInfo, checkForm);
		} catch (Exception e) {
			log.error(e);
			throw new SystemException("プロパティの設定に失敗しました。", e);
		}
		
		//2005/05/19 追加 ここから--------------------------------------------------
		//理由　チェックリスト画面のタイトル情報取得のため
		
		//タイトル表示情報の取得
		Page titleResult = getSystemServise(
                IServiceName.CHECKLIST_MAINTENANCE_SERVICE)
                .selectTitle(checkInfo);
		//タイトル表示情報をフォームにセットする
		request.setAttribute(IConstants.TITLE_INFO, titleResult);
		
		//追加 ここまで-------------------------------------------------------------
			
		Page result = null;
		//2005/05/19 追加 ここから--------------------------------------------------
		//理由 データが存在しない場合にpageにEMPTY_PAGEをセットするためtry-catchの追加
		try{	
    		//出力
    		result = getSystemServise(
                    IServiceName.CHECKLIST_MAINTENANCE_SERVICE)
                    .selectListData(container.getUserInfo(),checkInfo);
		}catch(NoDataFoundException e){
			//0件のページオブジェクトを生成
			result = Page.EMPTY_PAGE;
		}
		//追加 ここまで------------------------------------------------------------	
		
		
		//2005/04/13 追加 ここから--------------------------------------------------
		//有効期限チェックの追加

		//有効期限チェック
		boolean inPeriod = getSystemServise(
			IServiceName.CHECKLIST_MAINTENANCE_SERVICE).checkLimitDate(
			container.getUserInfo(),
			checkInfo);
			
		//有効期限チェック結果をフォームに格納
		checkForm.setPeriod(inPeriod);
		//追加 ここまで-------------------------------------------------------------
		
		//検索条件をフォームにセットする。
		request.setAttribute(IConstants.RESULT_INFO, result);
		
		return forwardSuccess(mapping);
	}
}