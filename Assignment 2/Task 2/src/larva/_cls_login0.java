package larva;


import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_login0 implements _callable{

public static PrintWriter pw; 
public static _cls_login0 root;

public static LinkedHashMap<_cls_login0,_cls_login0> _cls_login0_instances = new LinkedHashMap<_cls_login0,_cls_login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\jonjo\\Task 2/src/output_login.txt");

root = new _cls_login0();
_cls_login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_login0 parent; //to remain null - this class does not have a parent!
public static boolean loginResultt;
int no_automata = 1;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_login0() {
}

public void initialisation() {
}

public static _cls_login0 _get_cls_login0_inst() { synchronized(_cls_login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_login0_instances){
_performLogic_logins(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_login0[] a = new _cls_login0[1];
synchronized(_cls_login0_instances){
a = _cls_login0_instances.keySet().toArray(a);}
for (_cls_login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_login0_instances){
_cls_login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_logins = 209;

public void _performLogic_logins(String _info, int... _event) {

_cls_login0.pw.println("[logins]AUTOMATON::> logins("+") STATE::>"+ _string_logins(_state_id_logins, 0));
_cls_login0.pw.flush();

if (0==1){}
else if (_state_id_logins==209){
		if (1==0){}
		else if ((_occurredEvent(_event,502/*Incorrect*/)) && (loginResultt ==true )){
		_cls_login0.pw .println ("Bad login observed.");

		_state_id_logins = 208;//moving to state badLogin
		_goto_logins(_info);
		}
		else if ((_occurredEvent(_event,500/*Correct*/)) && (loginResultt ==false )){
		_cls_login0.pw .println ("Good login observed.");

		_state_id_logins = 209;//moving to state goodLogin
		_goto_logins(_info);
		}
}
}

public void _goto_logins(String _info){
_cls_login0.pw.println("[logins]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_logins(_state_id_logins, 1));
_cls_login0.pw.flush();
}

public String _string_logins(int _state_id, int _mode){
switch(_state_id){
case 208: if (_mode == 0) return "badLogin"; else return "!!!SYSTEM REACHED BAD STATE!!! badLogin "+new _BadStateExceptionlogin().toString()+" ";
case 209: if (_mode == 0) return "goodLogin"; else return "goodLogin";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}