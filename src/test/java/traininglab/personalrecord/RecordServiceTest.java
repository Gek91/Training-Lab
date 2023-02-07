package traininglab.personalrecord;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.repository.RecordEntryRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.rest.data.ExerciseDTO;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
//needed for application-test.property use -> set mysql mode
@ActiveProfiles("test")
@Transactional //Needed to activate test rollback. Without the database remain dirty after every test
public class RecordServiceTest {

	@Autowired
	private PersonalRecordApplicationService applicationService;

	@Test
	public void testRecordService() {

		List<ExerciseDTO> exerciseList = applicationService.getExerciseList();

		Assert.assertEquals(5, exerciseList.size());
		Assert.assertEquals("1", exerciseList.get(0).getId());
		Assert.assertEquals("ex1", exerciseList.get(0).getName());
		Assert.assertTrue(exerciseList.stream().map(ExerciseDTO::getId).collect(Collectors.toSet()).containsAll(Arrays.asList("1","2","3","4","5")));

	}

}
