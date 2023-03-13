package traininglab.personalrecord.domain.service.impl;


import traininglab.personalrecord.domain.model.RecordEntry;

import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.data.CreateRecordData;

public class RecordServiceImpl implements RecordService {

	public RecordServiceImpl() {

	}

	@Override
	public RecordEntry createRecordEntry(CreateRecordData data) {

		//TODO: DOMAIN VALIDATION

		RecordEntry record = buildRecordFromData(data);

		return record;
	}

	private RecordEntry buildRecordFromData(CreateRecordData data) {

		RecordEntry record = new RecordEntry();
		record.setRecordDate(data.getRecordDate());
		record.setExercise(data.getExecise());
		record.setUser(data.getUser());
		record.setValue(data.getValue());
		record.setPercentage(data.getPercentage());

		return record;
	}
}
