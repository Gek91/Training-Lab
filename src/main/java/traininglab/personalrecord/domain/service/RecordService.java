package traininglab.personalrecord.domain.service;


import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.service.data.CreateRecordData;

public interface RecordService {

	RecordEntry createRecordEntry(CreateRecordData data);
}
