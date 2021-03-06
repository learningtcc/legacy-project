/*
 * Created on 2005/04/15
 *
 */
package jp.go.jsps.kaken.web.system.kenkyushaKanri;

import jp.go.jsps.kaken.web.struts.BaseSearchForm;

/**
 * @author masuo_t
 *
 */
public class KenkyushaSearchForm extends BaseSearchForm {

	/** \¿ÒID */
	private String kenkyuNo;

	/** \¿Ò¼i¿-©j */
	private String nameKanjiSei;

	/** \¿Ò¼i¿-¼j */
	private String nameKanjiMei;

	/** \¿Ò¼itKi-©j */
	private String nameKanaSei;

	/** \¿Ò¼itKi-¼j */
	private String nameKanaMei;

	/** ®@ÖR[h */
	private String shozokuCd;



	/**
	 * @return
	 */
	public String getKenkyuNo() {
		return kenkyuNo;
	}

	/**
	 * @return
	 */
	public String getNameKanaMei() {
		return nameKanaMei;
	}

	/**
	 * @return
	 */
	public String getNameKanaSei() {
		return nameKanaSei;
	}

	/**
	 * @return
	 */
	public String getNameKanjiMei() {
		return nameKanjiMei;
	}

	/**
	 * @return
	 */
	public String getNameKanjiSei() {
		return nameKanjiSei;
	}

	/**
	 * @return
	 */
	public String getShozokuCd() {
		return shozokuCd;
	}

	/**
	 * @param string
	 */
	public void setKenkyuNo(String string) {
		kenkyuNo = string;
	}

	/**
	 * @param string
	 */
	public void setNameKanaMei(String string) {
		nameKanaMei = string;
	}

	/**
	 * @param string
	 */
	public void setNameKanaSei(String string) {
		nameKanaSei = string;
	}

	/**
	 * @param string
	 */
	public void setNameKanjiMei(String string) {
		nameKanjiMei = string;
	}

	/**
	 * @param string
	 */
	public void setNameKanjiSei(String string) {
		nameKanjiSei = string;
	}

	/**
	 * @param string
	 */
	public void setShozokuCd(String string) {
		shozokuCd = string;
	}

}
