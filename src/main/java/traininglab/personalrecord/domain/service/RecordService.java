package traininglab.personalrecord.domain.service;

import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.personalrecord.domain.service.data.RecordListFilters;

import java.util.List;

public interface RecordService {

	List<Exercise> getExerciseList();

	Record createRecord(CreateRecordData data);

//	List<Record> getRecordList(RecordListFilters filters);
}
