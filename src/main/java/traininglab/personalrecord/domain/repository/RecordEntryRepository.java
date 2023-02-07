package traininglab.personalrecord.domain.repository;

import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.repository.data.RecordListFilters;

import java.util.List;

public interface RecordEntryRepository {

	void add(RecordEntry entry);

 	List<RecordEntry> getRecordList(RecordListFilters filters);
}
