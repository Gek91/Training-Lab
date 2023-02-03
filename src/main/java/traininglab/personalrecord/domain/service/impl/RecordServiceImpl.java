package traininglab.personalrecord.domain.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.repository.RecordRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.personalrecord.domain.service.validator.RecordValidator;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.domain.service.UserService;

import java.util.List;

public class RecordServiceImpl implements RecordService {

	private ExerciseRepository exerciseRepository;
	private RecordRepository recordRepository;
	private UserService userService;
	private RecordValidator recordValidator;

	public RecordServiceImpl(ExerciseRepository exerciseRepository, RecordRepository recordRepository, UserService userService, RecordValidator recordValidator) {
		this.exerciseRepository = exerciseRepository;
		this.recordRepository = recordRepository;
		this.userService = userService;
		this.recordValidator = recordValidator;
	}

	@Override
	public List<Exercise> getExerciseList() {
		return exerciseRepository.getExerciseList();
	}

	@Override
	public Record createRecord(CreateRecordData data) {

		Record record = buildRecordFromData(data);
		recordRepository.save(record);

		return record;
	}

	private Record buildRecordFromData(CreateRecordData data) {

		Record record = new Record();
		record.setRecordDate(data.getRecordDate());
		record.setExercise(data.getExecise());
		record.setUser(data.getUser());
		record.setValue(data.getValue());

		return record;
	}
}
