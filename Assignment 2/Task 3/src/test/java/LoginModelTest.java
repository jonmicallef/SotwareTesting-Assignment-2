
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.example.System;
import org.junit.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginModelTest implements FsmModel{
     System System = new System();

     LoginStateEnum stateEnum = LoginStateEnum.LoginPage;


    String UserID = "157831f5-179f-4640-9634-98d2801da987";

    @Override
    public Object getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if(b){
            System = new System();
        }

        stateEnum = LoginStateEnum.LoginPage;
    }

    public boolean LoginPageGuard(){return getState().equals(LoginStateEnum.LoginPage);}
    public @Action void LoginPage(){

        stateEnum =  LoginStateEnum.AlertList;
        assertEquals(true, System.LoginPage(true));

    }

    //    this tests that if you put an incorrect login it will show log in details again
    public boolean LoginIncorrectGuard(){return getState().equals(LoginStateEnum.LoginPageAgain);}
    public @Action void LoginIncorrect(){
        assertEquals(true, System.LoginIncorrect(true));
    }


    @Test
    public void Runner(){
        final GreedyTester tester = new GreedyTester(new LoginModelTest());
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(2); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}
