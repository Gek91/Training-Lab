package traininglab.personalrecord.application.impl;

import org.springframework.transaction.annotation.Transactional;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.personalrecord.application.data.GetRecordListFilersDTO;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.repository.RecordEntryRepository;
import traininglab.personalrecord.domain.repository.data.RecordListFilters;
import traininglab.personalrecord.domain.model.data.CreateRecordData;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;
import traininglab.user.application.UserService;
import traininglab.user.domain.model.User;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Transactional
public class PersonalRecordApplicationServiceImpl implements PersonalRecordApplicationService {

	private final ExerciseRepository exerciseRepository;
	private final RecordEntryRepository recordEntryRepository;
	private final MapperService mapperService;
	private final UserService userService;

	public PersonalRecordApplicationServiceImpl(
			ExerciseRepository exerciseRepository,
			RecordEntryRepository recordEntryRepository,
			MapperService mapperService,
			UserService userService) {
		this.recordEntryRepository = recordEntryRepository;
		this.exerciseRepository = exerciseRepository;
		this.mapperService = mapperService;
		this.userService = userService;
	}

	@Override
	public RecordEntryDTO createRecordEntry(CreateRecordRequestDTO data) {

		User currentUser = userService.getCurrentUser();

		RecordEntry entry = RecordEntry.buildRecordFromData(buildFromRequest(currentUser, data));

		recordEntryRepository.add(entry);

		return mapperService.map(entry, RecordEntryDTO.class);
	}

	private CreateRecordData buildFromRequest(User user, CreateRecordRequestDTO data) {

		//TODO: INPUT VALIDATION

		Optional<Exercise> optionalExercise = exerciseRepository.getExerciseList().stream().filter(elem -> elem.getId().equals(data.getExerciseId())).findFirst();

		return new CreateRecordData(
				user,
				optionalExercise.orElse(null),
				data.getRecordDate(),
				data.getValue(),
				data.getPercentage()
		);
	}

	@Override
	public RecordEntryDTO updateRecordEntry(Long id, CreateRecordRequestDTO data) {

		User currentUser = userService.getCurrentUser();

		RecordEntry entry = getRecordEntryWithUser(id, currentUser);

		entry.updateRecordEntryFromData(buildFromRequest(currentUser, data));

		return mapperService.map(entry, RecordEntryDTO.class);
	}

	private RecordEntry getRecordEntryWithUser(Long id, User currentUser) {

		RecordEntry entry = recordEntryRepository.getRecordById(id);

		if(entry == null) {
			throw new EntityExistsException();
		}

		if(!checkUserCanEditRecord(currentUser, entry)) {
			//TODO permission exception
		}

		return entry;
	}

	private boolean checkUserCanEditRecord(User user, RecordEntry record) {
		return user.getId().equals(record.getUser().getId());
	}

	@Override
	public List<RecordEntryDTO> getRecordList(GetRecordListFilersDTO filters) {

		User currentUser = userService.getCurrentUser();

		List<RecordEntry> recordList = recordEntryRepository.getRecordList(buildFilters(currentUser, filters));

		return mapperService.mapAll(recordList, RecordEntryDTO.class);
	}

	private RecordListFilters buildFilters(User user, GetRecordListFilersDTO filters) {

		RecordListFilters output = new RecordListFilters();

		Optional.ofNullable(user).ifPresent(x -> output.setUserId(x.getId()));

		if(filters != null) {
			Optional.ofNullable(filters.getExerciseId()).ifPresent(output::setExerciseId);
			Optional.ofNullable(filters.getOffset()).ifPresent(output::setOffset);
			Optional.ofNullable(filters.getPageSize()).ifPresent(output::setPageSize);
		}

		return output;
	}


	@Override
	public List<ExerciseDTO> getExerciseList() {

		List<Exercise> exercises = exerciseRepository.getExerciseList();

		return mapperService.mapAll(exercises, ExerciseDTO.class);
	}
}
