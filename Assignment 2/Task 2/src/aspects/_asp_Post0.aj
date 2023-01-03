package aspects;

import larva.*;
public aspect _asp_Post0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Post0.initialize();
}
}
before ( boolean postResultt) : (call(* *.postResult(..)) && args(postResultt) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Post0.lock){

_cls_Post0 _cls_inst = _cls_Post0._get_cls_Post0_inst();
_cls_inst.postResultt = postResultt;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 508/*postResult*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 508/*postResult*/);
}
}
before () : (call(* *.postAPI(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Post0.lock){

_cls_Post0 _cls_inst = _cls_Post0._get_cls_Post0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 506/*postAPI*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 506/*postAPI*/);
}
}
}