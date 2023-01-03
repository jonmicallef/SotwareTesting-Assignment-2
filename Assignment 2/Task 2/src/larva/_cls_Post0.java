package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Post0 implements _callable{

public static PrintWriter pw; 
public static _cls_Post0 root;

public static LinkedHashMap<_cls_Post0,_cls_Post0> _cls_Post0_instances = new LinkedHashMap<_cls_Post0,_cls_Post0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jonjo\\Task 2/src/output_Post.txt");

root = new _cls_Post0();
_cls_Post0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Post0 parent; //to remain null - this class does not have a parent!
public static boolean postResultt;
int no_automata = 1;
 public int AlertCount =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Post0() {
}

public void initialisation() {
}

public static _cls_Post0 _get_cls_Post0_inst() { synchronized(_cls_Post0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Post0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Post0_instances){
_performLogic_post(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Post0[] a = new _cls_Post0[1];
synchronized(_cls_Post0_instances){
a = _cls_Post0_instances.keySet().toArray(a);}
for (_cls_Post0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Post0_instances){
_cls_Post0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_post = 212;

public void _performLogic_post(String _info, int... _event) {

_cls_Post0.pw.println("[post]AUTOMATON::> post("+") STATE::>"+ _string_post(_state_id_post, 0));
_cls_Post0.pw.flush();

if (0==1){}
else if (_state_id_post==212){
		if (1==0){}
		else if ((_occurredEvent(_event,506/*postAPI*/)) && (postResultt ==true )){
		AlertCount ++;
_cls_Post0.pw .println ("Good post observed. this many alerts:"+AlertCount );

		_state_id_post = 212;//moving to state POST
		_goto_post(_info);
		}
		else if ((_occurredEvent(_event,506/*postAPI*/)) && (AlertCount ==6 )){
		_cls_Post0.pw .println ("there are 5 alerts, api will delete oldest one");

		_state_id_post = 211;//moving to state MoreThan5
		_goto_post(_info);
		}
		else if ((_occurredEvent(_event,506/*postAPI*/)) && (postResultt ==false )){
		_cls_Post0.pw .println ("bad UserId");

		_state_id_post = 210;//moving to state BadPOST
		_goto_post(_info);
		}
}
}

public void _goto_post(String _info){
_cls_Post0.pw.println("[post]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_post(_state_id_post, 1));
_cls_Post0.pw.flush();
}

public String _string_post(int _state_id, int _mode){
switch(_state_id){
case 212: if (_mode == 0) return "POST"; else return "POST";
case 211: if (_mode == 0) return "MoreThan5"; else return "!!!SYSTEM REACHED BAD STATE!!! MoreThan5 "+new _BadStateExceptionPost().toString()+" ";
case 210: if (_mode == 0) return "BadPOST"; else return "!!!SYSTEM REACHED BAD STATE!!! BadPOST "+new _BadStateExceptionPost().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}