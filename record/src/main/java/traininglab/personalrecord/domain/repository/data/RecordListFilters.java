package traininglab.personalrecord.domain.repository.data;

import lombok.Data;

@Data
public class RecordListFilters {

	private String userId;
	private String exerciseId;

	private int pageSize = 20;
	private long offset = 0;

}
