package et.test.callcenter.server;

public interface TestConsts {
	String[] CMD ={			
			//0、初始化
			"PTTYPE:0#0#1#3!1#0#1#3!2#0#1#3!3#0#1#3!4#0#1#3!5#0#1#3!6#1#0#3!7#2#0#3!8#0#0#0!9#0#0#0!10#0#0#0!11#0#0#0!12#0#0#0!13#0#0#0!14#0#0#0!15#0#0#0!;",//			
			//1、PTRING:0,801	呼入
			"PTRING:0,801;",
			//验证
			"PTCALL:0,801,888,123456;",
			//振铃
			"RINGPT:0,7,0,801;",
			//通话
			"PTTALK:0,7;",
			//停止
			"PTSTOP:0,7;",			
	};
}
