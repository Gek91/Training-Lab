package traininglab.personalrecord.application;

import traininglab.rest.data.CreateRecordRequestDTO;
import traininglab.rest.data.ExerciseDTO;
import traininglab.rest.data.RecordEntryDTO;

import java.util.List;

public interface PersonalRecordApplicationService {

	RecordEntryDTO createRecordEntry(CreateRecordRequestDTO data);

	List<ExerciseDTO> getExerciseList();

}
