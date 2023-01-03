package aspects;

import larva.*;
public aspect _asp_login0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_login0.initialize();
}
}
before () : (call(* *.Correct(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 500/*Correct*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 500/*Correct*/);
}
}
before () : (call(* *.login(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 498/*login*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 498/*login*/);
}
}
before ( boolean loginResultt) : (call(* *.loginResult(..)) && args(loginResultt) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst.loginResultt = loginResultt;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 504/*loginResult*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 504/*loginResult*/);
}
}
before () : (call(* *.Incorrect(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_login0.lock){

_cls_login0 _cls_inst = _cls_login0._get_cls_login0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 502/*Incorrect*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 502/*Incorrect*/);
}
}
}