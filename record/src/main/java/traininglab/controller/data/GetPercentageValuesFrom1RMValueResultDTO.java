package traininglab.controller.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class GetPercentageValuesFrom1RMValueResultDTO {

	private List<PercentageValueValueDTO> values;

	public GetPercentageValuesFrom1RMValueResultDTO() {}

	public static GetPercentageValuesFrom1RMValueResultDTO buildFromPercentageValuesMap(Map<BigDecimal, BigDecimal> input) {

		List<PercentageValueValueDTO> valueList = new ArrayList<>();

		input.forEach((key, value) -> valueList.add(new PercentageValueValueDTO(key, value)));

		GetPercentageValuesFrom1RMValueResultDTO result = new GetPercentageValuesFrom1RMValueResultDTO();
		result.setValues(valueList);

		return result;
	}

	@Data
	public static class PercentageValueValueDTO {
		private final BigDecimal percentage;
		private final BigDecimal value;
	}
}
