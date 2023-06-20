package traininglab.personalrecord.application.data;

import lombok.Data;


@Data
public class GetRecordListFilersDTO {

	private String exerciseId;

	private Integer pageSize;
	private Long offset;

}
