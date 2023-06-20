package traininglab.rest.impl;

import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.rest.RecordRestApi;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;

import java.util.List;

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
