package traininglab.personalrecord;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.repository.RecordRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.user.domain.model.User;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
//needed for application-test.property use -> set mysql mode
@ActiveProfiles("test")
@Transactional //Needed to activate test rollback. Without the database remain dirty after every test
public class RecordServiceTest {

	@Autowired
	private RecordService recordService;
	@Autowired
	private RecordRepository recordRepository;

	@Test
	public void testRecordService() {

		List<Exercise> exerciseList = recordService.getExerciseList();

		Assert.assertEquals(5, exerciseList.size());

	}

	@Test
	public void testJPA() {

		Exercise exercise = new Exercise();
		exercise.setId("1");
		exercise.setName("ex1");

		User user = new User();
		user.setId("1");
		user.setFirstname("us1");
		user.setFirstname("last1");

		Record record = new Record();
		record.setExercise(exercise);
		record.setUser(user);
		record.setValue(BigDecimal.ONE);
		record.setRecordDate(LocalDate.now());

		recordRepository.save(record);

		System.out.println(recordService.getExerciseList().get(0).getName());

		record.getExercise().setName("ciao");

		recordRepository.save(record);

		System.out.println(recordService.getExerciseList().get(0).getName());

	}

}
