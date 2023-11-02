package traininglab.personalrecord.application;

import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.GetRecordListFilersDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;
import traininglab.user.domain.model.User;

import java.util.List;

public interface PersonalRecordApplicationService {

	RecordEntryDTO createRecordEntry(User currentUser, CreateRecordRequestDTO data);

	RecordEntryDTO updateRecordEntry(User currentUser, Long id, CreateRecordRequestDTO data);

	List<RecordEntryDTO> getRecordList(User currentUser, GetRecordListFilersDTO filters);

	List<ExerciseDTO> getExerciseList();

}
