package traininglab.personalrecord.application.data;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class CreateRecordRequestDTO {

	private String exerciseId;
	private LocalDate recordDate;
	private BigDecimal value;

}
