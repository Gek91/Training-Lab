package traininglab.personalrecord.application.impl;

import org.springframework.transaction.annotation.Transactional;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.repository.RecordEntryRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.rest.data.CreateRecordRequestDTO;
import traininglab.rest.data.ExerciseDTO;
import traininglab.rest.data.RecordEntryDTO;
import traininglab.user.domain.model.User;

import java.util.List;
import java.util.Optional;

@Transactional
public class PersonalRecordApplicationServiceImpl implements PersonalRecordApplicationService {

	private ExerciseRepository exerciseRepository;
	private RecordEntryRepository recordEntryRepository;
	private RecordService recordService;
	private MapperService mapperService;


	public PersonalRecordApplicationServiceImpl(
			ExerciseRepository exerciseRepository,
			RecordEntryRepository recordEntryRepository,
			RecordService recordService,
			MapperService mapperService) {
		this.recordEntryRepository = recordEntryRepository;
		this.exerciseRepository = exerciseRepository;
		this.recordService = recordService;
		this.mapperService = mapperService;
	}

	@Override
	public RecordEntryDTO createRecordEntry(CreateRecordRequestDTO data) {

		//TODO get user from context
		RecordEntry entry = recordService.createRecordEntry(buildFromRequest(null, data));

		recordEntryRepository.add(entry);

		return mapperService.map(entry, RecordEntryDTO.class);
	}

	private CreateRecordData buildFromRequest(User user, CreateRecordRequestDTO data) {

		//TODO: INPUT VALIDATION

		Optional<Exercise> optionalExercise = exerciseRepository.getExerciseList().stream().filter(elem -> elem.getId().equals(data.getExerciseId())).findFirst();

		return new CreateRecordData(
				user,
				optionalExercise.isPresent() ? optionalExercise.get() : null,
				data.getRecordDate(),
				data.getValue(),
				data.getPercentage()
		);
	}

	@Override
	public List<ExerciseDTO> getExerciseList() {

		List<Exercise> exercises = exerciseRepository.getExerciseList();

		return mapperService.mapAll(exercises, ExerciseDTO.class);
	}
}
