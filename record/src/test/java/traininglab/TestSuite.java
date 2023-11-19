package traininglab;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import traininglab.controller.ControllerTestSuite;
import traininglab.percentage.PercentageTestSuite;
import traininglab.personalrecord.PersonalRecordTestSuite;
import traininglab.user.UserTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationStartUpTest.class, UserTestSuite.class, PersonalRecordTestSuite.class, PercentageTestSuite.class, ControllerTestSuite.class })
public class TestSuite {
}
