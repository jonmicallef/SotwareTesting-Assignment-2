package aspects;

import larva.*;
public aspect _asp_Delete0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Delete0.initialize();
}
}
before () : (call(* *.noAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Delete0.lock){

_cls_Delete0 _cls_inst = _cls_Delete0._get_cls_Delete0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 478/*noAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 478/*noAlerts*/);
}
}
before ( boolean Alert) : (call(* *.AmountOfAlert(..)) && args(Alert) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Delete0.lock){

_cls_Delete0 _cls_inst = _cls_Delete0._get_cls_Delete0_inst();
_cls_inst.Alert = Alert;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 480/*AmountOfAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 480/*AmountOfAlert*/);
}
}
before () : (call(* *.DeleteRequest(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Delete0.lock){

_cls_Delete0 _cls_inst = _cls_Delete0._get_cls_Delete0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 476/*DeleteRequest*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 476/*DeleteRequest*/);
}
}
}