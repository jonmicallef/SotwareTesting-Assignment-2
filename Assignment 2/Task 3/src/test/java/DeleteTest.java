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

public class DeleteTest implements FsmModel {

    System System = new System();

    private deleteStateEnum stateEnum = deleteStateEnum.Get;

    @Override
    public Object getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            System = new System();
        }
        stateEnum = deleteStateEnum.Get;
    }

    public boolean DeleteSuccesfullyGuard() {
        return getState().equals(deleteStateEnum.Get);}
        public @Action void DeleteSuccesfully() {
            assertEquals(true, System.DeleteRequest(true));
        }

    public boolean NoAlertGuard() {
        return getState().equals(deleteStateEnum.NoAlerts);}
    public @Action void NoAlert() {
        assertEquals(true, System.NoAlerts(true));
    }

    @Test
    public void Runner(){
        final GreedyTester tester = new GreedyTester(new DeleteTest());
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



