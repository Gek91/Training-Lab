package traininglab;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import traininglab.percentage.PercentageTestSuite;
import traininglab.personalrecord.PersonalRecordTestSuite;
import traininglab.user.UserTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ApplicationStartUpTest.class, UserTestSuite.class, PersonalRecordTestSuite.class, PercentageTestSuite.class })
public class TestSuite {
}
