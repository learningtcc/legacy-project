/**
 * 	@(#)IDongjinLink.java   2006-12-22 上午10:40:27
 *	 。 
 *	 
 */
package et.bo.callcenter.plant.dongjin_c161a;

 /**
 * @author zhaoyifei
 * @version 2006-12-22
 * @see
 */
public interface IDongjinLink {

	/**
	 * 
	 * 连通函数
	 * 
	 */
	
	/**
	 * 两路连通
	 * 两路通道正在连通时，如果对某一通道放音或停止放音，将会变成单项连通。调用本函数之前必须停止放音。
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 */
	public abstract int setLink(int wOne,int wAnother);
	
	/**
	 * 两路拆除连接
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 */
	public abstract int clearLink(int wOne,int wAnother);
	
	/**
	 * 两路单项连通。调用该函数后，实现单项连通；通道one可以听到another声音，但another听不到one的声音。
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 */
	public abstract int linkOneToAnother(int wOne,int wAnother);
	
	/**
	 * 拆除单项连通
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 */
	public abstract int clearOneFromAnother(int wOne,int wAnother);
	
	/**
	 * 三方连通，由单项连通实现，所以声音比较小。
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @param wThree 三路
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 * @return -6 三路超出范围
	 * @return -7 三路正在放音
	 */
	public abstract int linkThree(int wOne,int wTwo,int wThree);
	
	/**
	 * 拆除三方连通
	 * @param wOne 一路（0～127）
	 * @param wAnother 二路（0～127）
	 * @param wThree 三路
	 * @version 2006-11-22
	 * @return 0 成功
	 * @return -1 一路超出范围
	 * @return -2 二路超出范围
	 * @return -3 一路二路不在一个卡上，卡之间没有连线
	 * @return -4 一路正在放音
	 * @return -5 二路正在放音
	 * @return -6 三路超出范围
	 * @return -7 三路正在放音
	 */
	public abstract int clearThree(int wOne,int wTwo,int wThree);
	
}
