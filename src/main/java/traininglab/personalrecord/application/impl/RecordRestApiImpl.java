package traininglab.personalrecord.application.impl;

import org.springframework.transaction.annotation.Transactional;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.RecordRestApi;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.RecordDTO;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.user.domain.model.User;

import java.util.List;
import java.util.Optional;

@Transactional
public class RecordRestApiImpl implements RecordRestApi {

	private RecordService recordService;
	private MapperService mapperService;

	public RecordRestApiImpl(RecordService recordService, MapperService mapperService) {
		this.recordService = recordService;
		this.mapperService = mapperService;
	}

	@Override
	public List<ExerciseDTO> getExeciseList() {

		List<Exercise> exercises = recordService.getExerciseList();

		return mapperService.mapAll(exercises, ExerciseDTO.class);
	}

	@Override
	public RecordDTO createRecord(CreateRecordRequestDTO request) {

		//TODO: get connected user
		Record record = recordService.createRecord(buildCreateRecordDataFromRequest(null, request));

		return mapperService.map(record, RecordDTO.class);
	}

	private CreateRecordData buildCreateRecordDataFromRequest(User user, CreateRecordRequestDTO request) {

		Optional<Exercise> optionalExercise = recordService.getExerciseList().stream().filter(elem -> elem.getId().equals(request.getExerciseId())).findFirst();

		return new CreateRecordData(
				user,
				optionalExercise.isPresent() ? optionalExercise.get() : null,
				request.getRecordDate(),
				request.getValue()
		);
	}
}
