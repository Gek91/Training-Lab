package traininglab.controller.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.controller.RecordRestController;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.GetRecordListFilersDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;
import traininglab.user.application.UserService;
import traininglab.user.domain.model.User;

import java.util.List;

public class RecordRestControllerImpl implements RecordRestController {

	private final UserService userService;
	private final PersonalRecordApplicationService personalRecordApplicationService;

	public RecordRestControllerImpl(PersonalRecordApplicationService personalRecordApplicationService, UserService userService) {
		this.personalRecordApplicationService = personalRecordApplicationService;
		this.userService = userService;
	}

	@Override
	public List<ExerciseDTO> getExeciseList() {

		return personalRecordApplicationService.getExerciseList();
	}

	@Override
	public List<RecordEntryDTO> getUserRecords(String exerciseId) {

		User currentUser = userService.getCurrentUser();

		GetRecordListFilersDTO filters = new GetRecordListFilersDTO();
		filters.setExerciseId(exerciseId);

		return personalRecordApplicationService.getRecordList(currentUser, filters);
	}

	@Override
	public RecordEntryDTO createRecord(CreateRecordRequestDTO request) {

		User currentUser = userService.getCurrentUser();

		return personalRecordApplicationService.createRecordEntry(currentUser, request);
	}

	@Override
	public RecordEntryDTO updateRecord(Long id, CreateRecordRequestDTO request) {

		User currentUser = userService.getCurrentUser();

		return personalRecordApplicationService.updateRecordEntry(currentUser, id, request);
	}

}
