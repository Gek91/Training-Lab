package traininglab.personalrecord.application.data;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateRecordRequestDTO {

	private String exerciseId;
	private LocalDate recordDate;
	private BigDecimal value;
	private BigDecimal percentage;

}
