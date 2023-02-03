package traininglab.personalrecord.domain.repository;

import traininglab.personalrecord.domain.model.Record;

public interface RecordRepository {

	void save(Record record);
}
