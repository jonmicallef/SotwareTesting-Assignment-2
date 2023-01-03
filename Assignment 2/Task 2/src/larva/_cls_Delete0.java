package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Delete0 implements _callable{

public static PrintWriter pw; 
public static _cls_Delete0 root;

public static LinkedHashMap<_cls_Delete0,_cls_Delete0> _cls_Delete0_instances = new LinkedHashMap<_cls_Delete0,_cls_Delete0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jonjo\\Task 2/src/output_Delete.txt");

root = new _cls_Delete0();
_cls_Delete0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Delete0 parent; //to remain null - this class does not have a parent!
public static boolean Alert;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Delete0() {
}

public void initialisation() {
}

public static _cls_Delete0 _get_cls_Delete0_inst() { synchronized(_cls_Delete0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Delete0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Delete0_instances){
_performLogic_IslistEmpty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Delete0[] a = new _cls_Delete0[1];
synchronized(_cls_Delete0_instances){
a = _cls_Delete0_instances.keySet().toArray(a);}
for (_cls_Delete0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Delete0_instances){
_cls_Delete0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_IslistEmpty = 203;

public void _performLogic_IslistEmpty(String _info, int... _event) {

_cls_Delete0.pw.println("[IslistEmpty]AUTOMATON::> IslistEmpty("+") STATE::>"+ _string_IslistEmpty(_state_id_IslistEmpty, 0));
_cls_Delete0.pw.flush();

if (0==1){}
else if (_state_id_IslistEmpty==203){
		if (1==0){}
		else if ((_occurredEvent(_event,478/*noAlerts*/)) && (Alert ==true )){
		_cls_Delete0.pw .println ("List has alert");

		_state_id_IslistEmpty = 202;//moving to state AlertInList
		_goto_IslistEmpty(_info);
		}
		else if ((_occurredEvent(_event,476/*DeleteRequest*/)) && (Alert ==false )){
		_cls_Delete0.pw .println ("list is empty");

		_state_id_IslistEmpty = 203;//moving to state EmptyList
		_goto_IslistEmpty(_info);
		}
}
}

public void _goto_IslistEmpty(String _info){
_cls_Delete0.pw.println("[IslistEmpty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_IslistEmpty(_state_id_IslistEmpty, 1));
_cls_Delete0.pw.flush();
}

public String _string_IslistEmpty(int _state_id, int _mode){
switch(_state_id){
case 203: if (_mode == 0) return "EmptyList"; else return "EmptyList";
case 202: if (_mode == 0) return "AlertInList"; else return "!!!SYSTEM REACHED BAD STATE!!! AlertInList "+new _BadStateExceptionDelete().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}