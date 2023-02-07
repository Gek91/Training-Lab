package traininglab;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
//needed for application-test.property use -> set mysql mode
@ActiveProfiles("test")
@Transactional
//Needed to activate test rollback. Without the database remain dirty after every test
public class ApplicationStartUpTest {

	@Test
	public void contextLoads() {
	}

}