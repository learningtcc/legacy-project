package et.bo.callcenter.message.event;

import java.util.Date;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import et.bo.callcenter.ConstRuleI;
import et.bo.callcenter.base.CardInfo;
import et.bo.callcenter.base.CardState;
import et.bo.callcenter.base.OperatorState;
import et.bo.callcenter.business.BusinessObject;
import et.bo.callcenter.message.BaseEvent;
/**
 * OOSEAT:<1/0>,<PASS>;
0表示离席，1在席。
	Pass表示状态改为在席时候的密码（用户名是通过ip来确定的）
	最后一个参数是ip。
 */
public class Ooseat extends BaseEvent {
	private static Log log = LogFactory.getLog(Ooseat.class);
	private final String IN="1";
	private final String OUT="0";
	
	private final String SUCCEED="1";
	private final String FAIL="0";
	
	@Override
	protected String execute() {
		//init
		String sState = args[0];
		String password=args[1];
		
		String ip = args[2];
		
		if(sState.equals(this.IN)){
			//验证
			OperatorState os1=OperatorState.getOperatorState(ip);
			String on = os1.getOperatorNum();
			os1.setState(os1.IN);
			os1.setCurTime(new Date());
			//验证
			String s=super.pi.validUser(on, password);
			String result=s.equals(BusinessObject.SUCCEED)?"1":"0";
			//send msg
			String cmd1 = cs.getSendMsg(ConstRuleI.CMD_OOVALI,new String[]{result});
			
			server.
				command(ip,
						cmd1
						);
			log.info(cmd1);
			
			//refresh工控和座席
			if(s.equals(BusinessObject.SUCCEED)){				
				CardState cs1=new CardState();
				cs1.setCurTime(new Date());
				cs1.setOperatorNum(on);
				cs1.setState(cs1.INNER_IN);
				
				//通过ip找到port from cardinfo
				Iterator it=CardInfo.getCardMap().keySet().iterator();
				String physicsPort=null;
				while(it.hasNext()){
					String port = (String)it.next();
					CardInfo ci= (CardInfo)CardInfo.getCardMap().get(port);
					if(ip.equals(ci.getIp()))physicsPort=ci.getPhysicsPort();
				}
				cs1.setPhysicsPort(physicsPort);
				CardState.setInnerActiveMap(cs1);
				System.err.println(cs1.isActiveInner(physicsPort));
				//refresh pannle
				this.eventHelper.refreshIccAndOperator();
				eventHelper.ooseat(on, sState);
			}
			return null;
		}
		//
		if(sState.equals(this.OUT)){			
			//类
			OperatorState os1=OperatorState.getOperatorState(ip);
			String on = os1.getOperatorNum();
			os1.setState(os1.OUT);
			os1.setCurTime(new Date());
			
			//
			CardState cs1=new CardState();
			cs1.setCurTime(new Date());
			cs1.setOperatorNum(on);
			////////////////////////////////////////////////////////////////////////////
			cs1.setState(cs1.INNER_OUT);
			//通过ip找到port from cardinfo
			Iterator it=CardInfo.getCardMap().keySet().iterator();
			String physicsPort=null;
			while(it.hasNext()){
				String port = (String)it.next();
				CardInfo ci= (CardInfo)CardInfo.getCardMap().get(port);
				if(ip.equals(ci.getIp()))physicsPort=ci.getPhysicsPort();
			}
			cs1.setPhysicsPort(physicsPort);
			CardState.removeInnerActive(cs1);
			System.err.println(cs1.isActiveInner(physicsPort));
			
			//refresh工控和座席
			this.eventHelper.refreshIccOperatorState();
			eventHelper.ooseat(on, sState);
			return null;
		}
		return null;
			//-----------------------------------------------------------------------
//		CardState cardState1 =(CardState)CardState.getInnerActiveIpMap().get(ip);
//		if(cardState1==null){
//			cardState1=new CardState();
//		}
//		cardState1.setCurTime(new Date());
//		String curState =this.IN.equals(sState)?cardState1.INNER_IN:cardState1.INNER_OUT;
//		cardState1.setState(curState);
//		
//		if(this.OUT.equals(sState)){
//			
//		}else{
//			String operatorNum =cardState1.getOperatorNum();
//			String result1=this.pi.isOperator(operatorNum, password);
//			String sendArg =BusinessObject.SUCCEED.equals(result1)?this.SUCCEED:this.FAIL;		
//			server.
//				command(ip, 
//					cs.getSendMsg(ConstRuleI.CMD_OOVALI,new String[]{sendArg})
//					);
//			if(this.FAIL.equals(sendArg)) return;
//		}
//		
//		//2set CardState,由于此过程不在接续过程中，所以对其它类没有影响。		
//		//3refresh icc
//		this.eventHelper.refreshIccOperatorState();
//		-----------------------------------------------------------------------
	}

}
