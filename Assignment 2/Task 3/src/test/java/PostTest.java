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


public class PostTest implements FsmModel {
    System System = new System();

    PostEnum stateEnum = PostEnum.POST;


    @Override
    public Object getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if(b){
            System = new System();
        }

        stateEnum = PostEnum.POST;
    }


    public boolean PostMadeGuard(){return getState().equals(PostEnum.POST);}
    public @Action void PostMade(){

        stateEnum =  PostEnum.FieldsFull;
        assertEquals(true, System.postAPI(true));

    }

    //this checks for any empty fields in the formate
    public boolean formatGuard(){return getState().equals(PostEnum.FieldsFull);}
    public @Action void formate(){
        assertEquals(true, System.formate(true));

    }

    //    this tests that if not more than 5 are in the list
    public boolean LessThan5inListGuard(){return getState().equals(PostEnum.notMoreThan5);}
    public @Action void NotMoreThan5(){
        assertEquals(true, System.FiveInList(true));
    }

    @Test
    public void Runner(){
        final GreedyTester tester = new GreedyTester(new PostTest());
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

