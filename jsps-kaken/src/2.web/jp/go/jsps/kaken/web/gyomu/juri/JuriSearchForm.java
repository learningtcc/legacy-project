/*======================================================================
 *    SYSTEM      : dq\¿VXeiÈw¤ïâàj
 *    Source name : JuriSearchForm
 *    Description : óo^ÎÛåîñõptH[
 *
 *    Author      : DIS.dyh
 *    Date        : 2006/05/30
 *
 *    Revision history
 *    Date          Revision    Author         Description
 *
 *====================================================================== 
 */
package jp.go.jsps.kaken.web.gyomu.juri;

import java.util.ArrayList;
import java.util.List;

import jp.go.jsps.kaken.web.struts.BaseSearchForm;

/**
 * óo^ÎÛåîñõptH[
 */
public class JuriSearchForm extends BaseSearchForm{

    /** VersionUID */
    private static final long serialVersionUID = -2147403507609272092L;

    //---------------------------------------------------------------------
    // Instance data
    //---------------------------------------------------------------------
    /** ÆCD */
    private String jigyoCd;

    /** ¤íÚ¼ */
    private String jigyoNm;

    /** ¤íÚ¼Xg */
    private List jigyoNmList = new ArrayList();

    /** ®R[h */
    private String shozokuCd;

    /** ®¤@Ö¼ */
    private String shozokuNm;

    /**
     * ÆCDðæ¾
     * @return String ÆCD
     */
    public String getJigyoCd() {
        return jigyoCd;
    }

    /**
     * ÆCDðÝè
     * @param jigyoCd ÆCD
     */
    public void setJigyoCd(String jigyoCd) {
        this.jigyoCd = jigyoCd;
    }

    /**
     * ¤íÚ¼ðæ¾
     * @return String ¤íÚ¼
     */
    public String getJigyoNm() {
        return jigyoNm;
    }

    /**
     * ¤íÚ¼ðÝè
     * @param jigyoNm ¤íÚ¼
     */
    public void setJigyoNm(String jigyoNm) {
        this.jigyoNm = jigyoNm;
    }

    /**
     * ¤íÚ¼Xgðæ¾
     * @return String ¤íÚ¼Xg
     */
    public List getJigyoNmList() {
        return jigyoNmList;
    }

    /**
     * ¤íÚ¼XgðÝè
     * @param jigyoNmList ¤íÚ¼Xg
     */
    public void setJigyoNmList(List jigyoNmList) {
        this.jigyoNmList = jigyoNmList;
    }

    /**
     * ®R[hðæ¾
     * @return String ®R[h
     */
    public String getShozokuCd() {
        return shozokuCd;
    }

    /**
     * ®R[hðÝè
     * @param shozokuCd ®R[h
     */
    public void setShozokuCd(String shozokuCd) {
        this.shozokuCd = shozokuCd;
    }

    /**
     * ®¤@Ö¼ðæ¾
     * @return String ®¤@Ö¼
     */
    public String getShozokuNm() {
        return shozokuNm;
    }

    /**
     * ®¤@Ö¼ðÝè
     * @param shozokuNm ®¤@Ö¼
     */
    public void setShozokuNm(String shozokuNm) {
        this.shozokuNm = shozokuNm;
    }
}