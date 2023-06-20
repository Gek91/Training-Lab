package traininglab.personalrecord.application;

import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.GetRecordListFilersDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;

import java.util.List;

public interface PersonalRecordApplicationService {

	RecordEntryDTO createRecordEntry(CreateRecordRequestDTO data);

	List<RecordEntryDTO> getRecordList(GetRecordListFilersDTO filters);

	List<ExerciseDTO> getExerciseList();

}
