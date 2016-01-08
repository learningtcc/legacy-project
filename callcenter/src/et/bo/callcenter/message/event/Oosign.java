package et.bo.callcenter.message.event;

import java.util.Date;
import java.util.Iterator;

import et.bo.callcenter.base.CardInfo;
import et.bo.callcenter.base.CardState;
import et.bo.callcenter.base.OperatorState;
import et.bo.callcenter.message.BaseEvent;
/*
 * [事件]签入签出
OOSIGN:<1/0>;
0表示签出，1表示签入。
?	规约格式：OOSIGN:{0};
 */
public class Oosign extends BaseEvent {
	private final String SIGN_IN="1";
	private final String SIGN_OUT="0";
	@Override
	protected String execute() {
		//init
		String sState = args[0];
		String ip = args[1];
		
		if(this.SIGN_IN.equals(sState)){
			//refresh class
			Iterator itTest=OperatorState.getOperatorStateMap().keySet().iterator();
			while(itTest.hasNext()){
				//sT is 
				String sT=(String)itTest.next();
				System.out.println("***********xunhuan************");
				System.out.println(sT);
				OperatorState os1T=(OperatorState)OperatorState.getOperatorStateMap().get(sT);
				System.out.println(os1T.getIp());
			}
			System.out.println("**************************--");
			OperatorState os1 = OperatorState.getOperatorState(ip);		
			System.out.println("**************************--");
			System.out.println(ip);
			os1.setCurTime(new Date());
			os1.setIp(ip);
			os1.setState(os1.SIGNIN);
			String on = os1.getOperatorNum();//////////
			
//			OperatorState.setOperatorStateLogon(on, ip);
//			OperatorState.getOperatorStateMap().put(on, os1);
			//--
			CardState cs1=new CardState();
			cs1.setCurTime(new Date());
			cs1.setOperatorNum(on);
			
			cs1.setState(cs1.INNER_SIGNIN);
			//通过ip找到port from cardinfo
			Iterator it=CardInfo.getCardMap().keySet().iterator();
			String physicsPort=null;
			while(it.hasNext()){
				String port = (String)it.next();
				CardInfo ci= (CardInfo)CardInfo.getCardMap().get(port);
				if(ip.equals(ci.getIp()))physicsPort=ci.getPhysicsPort();//////////
			}
			cs1.setPhysicsPort(physicsPort);
			CardState.setInnerActiveMap(cs1);
			System.err.println(cs1.isActiveInner(physicsPort));
			//refresh pannle
			this.eventHelper.refreshIccAndOperator();
			//do sth tell icc about on,on and physicsPort is 对应的。
			this.eventHelper.refreshIccOperator(physicsPort, on);
			eventHelper.oosign(on, sState);
			return null;
		}
		if(this.SIGN_OUT.equals(sState)){
			//refresh class
			OperatorState os1 = OperatorState.getOperatorState(ip);
			String on = os1.getOperatorNum();
			os1.setCurTime(new Date());
			os1.setIp(ip);
			os1.setState(os1.SIGNOUT);
//			OperatorState.getOperatorStateMap().remove(on);
			//
			CardState cs1=new CardState();
			cs1.setCurTime(new Date());
//			cs1.setOperatorNum(on);
			cs1.setOperatorNum(null);
			cs1.setState(cs1.INNER_SIGNOUT);
//			通过ip找到port from cardinfo
			Iterator it=CardInfo.getCardMap().keySet().iterator();
			//外线端口
			String physicsPort=null;
			while(it.hasNext()){
				String port = (String)it.next();
				CardInfo ci= (CardInfo)CardInfo.getCardMap().get(port);
				if(ip.equals(ci.getIp()))physicsPort=ci.getPhysicsPort();
			}
			
			cs1.setPhysicsPort(physicsPort);
//			CardState.setInnerActiveMap(cs1);
			boolean b=cs1.getInnerActivePortMap().containsKey(physicsPort);
			cs1.removeInnerActive(cs1);
			b=cs1.getInnerActivePortMap().containsKey(physicsPort);
			//refresh pannle
			this.eventHelper.refreshIccAndOperator();
			eventHelper.oosign(on, sState);
			return null;
		}
		return null;
		
		
		
		
		
		
		
		/*
		 * need to do Sthing operator argument.
		 */
//		String operatorNum="aaa";
//		//1set CardState
//		CardState cardState1 =(CardState)CardState.getInnerActiveIpMap().get(ip);
//		if(cardState1!=null){
//			String curState =this.SIGN_IN.equals(sState)?cardState1.INNER_SIGNIN:cardState1.INNER_SIGNOUT;
//			cardState1.setState(curState);
//			cardState1.setOperatorNum(operatorNum);
//			cardState1.setCurTime(new Date());
//		}		
//		
//		//2refresh icc
//		this.eventHelper.refreshIccOperatorState();
	}

}
