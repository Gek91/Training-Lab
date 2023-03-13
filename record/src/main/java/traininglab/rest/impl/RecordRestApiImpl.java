package traininglab.rest.impl;

import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.rest.RecordRestApi;
import traininglab.rest.data.CreateRecordRequestDTO;
import traininglab.rest.data.ExerciseDTO;
import traininglab.rest.data.RecordEntryDTO;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public class RecordRestApiImpl implements RecordRestApi {

	private MapperService mapperService;
	private PersonalRecordApplicationService personalRecordApplicationService;

	public RecordRestApiImpl(PersonalRecordApplicationService personalRecordApplicationService, MapperService mapperService) {
		this.personalRecordApplicationService = personalRecordApplicationService;
		this.mapperService = mapperService;
	}

	@Override
	public List<ExerciseDTO> getExeciseList() {
		return personalRecordApplicationService.getExerciseList();
	}

	@Override
	public RecordEntryDTO createRecord(CreateRecordRequestDTO request) {
		return personalRecordApplicationService.createRecordEntry(request);
	}
}
