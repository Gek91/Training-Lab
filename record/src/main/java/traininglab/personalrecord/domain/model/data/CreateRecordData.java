package traininglab.personalrecord.domain.model.data;

import lombok.Data;
import lombok.Value;
import org.springframework.security.core.userdetails.UserDetails;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.user.domain.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class CreateRecordData {

	private User user;
	private Exercise execise;
	private LocalDate recordDate;
	private BigDecimal value;
	private BigDecimal percentage;

}
