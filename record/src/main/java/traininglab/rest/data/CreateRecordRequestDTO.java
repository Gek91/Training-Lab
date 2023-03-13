package traininglab.rest.data;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class CreateRecordRequestDTO {

	private String exerciseId;
	private LocalDate recordDate;
	private BigDecimal value;
	private BigDecimal percentage;

}
