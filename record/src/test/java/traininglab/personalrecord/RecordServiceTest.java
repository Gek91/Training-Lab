package traininglab.personalrecord;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.GetRecordListFilersDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
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
	public void testGetExerciseList() {

		List<ExerciseDTO> exerciseList = applicationService.getExerciseList();

		Assert.assertEquals(5, exerciseList.size());
		Assert.assertEquals("1", exerciseList.get(0).getId());
		Assert.assertEquals("ex1", exerciseList.get(0).getName());
		Assert.assertTrue(exerciseList.stream().map(ExerciseDTO::getId).collect(Collectors.toSet()).containsAll(Arrays.asList("1","2","3","4","5")));

	}

	@Test
	@WithMockUser(username = "1")
	public void testGetRecordList1() {

		List<RecordEntryDTO> recordList = applicationService.getRecordList(new GetRecordListFilersDTO());

		Assert.assertEquals(3, recordList.size());
		Assert.assertEquals(Long.valueOf(1), recordList.get(0).getId());

		checkEqualsRecordEntryDTO(recordList.get(0), 1L, "1", LocalDate.of(2023, 1,1), BigDecimal.valueOf(100L), BigDecimal.valueOf(1L));
		checkEqualsRecordEntryDTO(recordList.get(1), 2L, "2", LocalDate.of(2023, 1,2), BigDecimal.valueOf(110L), BigDecimal.valueOf(1L));
		checkEqualsRecordEntryDTO(recordList.get(2), 3L, "3", LocalDate.of(2023, 1,3), BigDecimal.valueOf(120L), BigDecimal.valueOf(1L));
	}

	private void checkEqualsRecordEntryDTO(RecordEntryDTO entityToCheck, Long id, String exerciseId, LocalDate recordDate, BigDecimal value, BigDecimal percentage) {

		Assert.assertEquals(id, entityToCheck.getId());
		checkEqualsRecordEntryDTOWithoutId(entityToCheck, exerciseId, recordDate, value, percentage);
	}

	private void checkEqualsRecordEntryDTOWithoutId(RecordEntryDTO entityToCheck, String exerciseId, LocalDate recordDate, BigDecimal value, BigDecimal percentage) {

		Assert.assertNotNull(entityToCheck.getId());
		Assert.assertNotNull(entityToCheck.getExercise());
		Assert.assertEquals(exerciseId, entityToCheck.getExercise().getId());
		Assert.assertEquals(value.setScale(2, RoundingMode.HALF_UP), entityToCheck.getValue().setScale(2, RoundingMode.HALF_UP));
		Assert.assertEquals(recordDate, entityToCheck.getRecordDate());
		Assert.assertEquals(percentage.setScale(2, RoundingMode.HALF_UP), entityToCheck.getPercentage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	@WithMockUser(username = "2")
	public void testGetRecordList2() {

		List<RecordEntryDTO> recordList = applicationService.getRecordList(new GetRecordListFilersDTO());

		Assert.assertEquals(1, recordList.size());
		checkEqualsRecordEntryDTO(recordList.get(0), 4L, "1", LocalDate.of(2023, 1,4), BigDecimal.valueOf(120L), BigDecimal.valueOf(1L));
	}

	@Test
	@WithMockUser(username = "2")
	public void testCreateRecord() {

		int size = applicationService.getRecordList(new GetRecordListFilersDTO()).size();

		CreateRecordRequestDTO data = new CreateRecordRequestDTO();
		data.setRecordDate(LocalDate.of(2023, 1,5));
		data.setExerciseId("2");
		data.setValue(BigDecimal.valueOf(80L));
		data.setPercentage(BigDecimal.valueOf(1L));

		RecordEntryDTO result = applicationService.createRecordEntry(data);

		checkEqualsRecordEntryDTOWithoutId(result, "2", LocalDate.of(2023, 1,5), BigDecimal.valueOf(80L), BigDecimal.valueOf(1L));

		List<RecordEntryDTO> records = applicationService.getRecordList(new GetRecordListFilersDTO());

		Assert.assertEquals(size + 1 ,records.size());

		RecordEntryDTO record = records.stream().filter(x -> x.getId().equals(result.getId())).findFirst().orElseGet(() -> null);

		checkEqualsRecordEntryDTO(record, result.getId(), "2", LocalDate.of(2023, 1,5), BigDecimal.valueOf(80L), BigDecimal.valueOf(1L));
	}

	@Test
	@WithMockUser(username = "2")
	public void updateRecord() {

		RecordEntryDTO entry = applicationService.getRecordList(new GetRecordListFilersDTO()).get(0);

		CreateRecordRequestDTO data = new CreateRecordRequestDTO();
		data.setRecordDate(LocalDate.of(2023, 1,5));
		data.setExerciseId("2");
		data.setValue(BigDecimal.valueOf(80L));
		data.setPercentage(BigDecimal.valueOf(1L));

		entry = applicationService.updateRecordEntry(entry.getId(), data);

		checkEqualsRecordEntryDTO(entry, entry.getId(), "2", LocalDate.of(2023, 1,5), BigDecimal.valueOf(80L), BigDecimal.valueOf(1L));
		Long id = entry.getId();
		entry = applicationService.getRecordList(new GetRecordListFilersDTO()).stream().filter(x -> id.equals(x.getId())).findFirst().orElseGet(() -> null);

		checkEqualsRecordEntryDTO(entry, entry.getId(), "2", LocalDate.of(2023, 1,5), BigDecimal.valueOf(80L), BigDecimal.valueOf(1L));
	}

}
