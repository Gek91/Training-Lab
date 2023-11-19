package traininglab.controller.impl;

import traininglab.calculation.service.PercentageCalculationService;
import traininglab.controller.CalculationRestController;
import traininglab.controller.data.GetPercentageValuesFrom1RMValueResultDTO;

import java.math.BigDecimal;
import java.util.Map;

public class CalculationRestControllerImpl implements CalculationRestController {

	private final PercentageCalculationService percentageCalculationService;

	public CalculationRestControllerImpl(PercentageCalculationService percentageCalculationService) {
		this.percentageCalculationService = percentageCalculationService;
	}
	@Override
	public GetPercentageValuesFrom1RMValueResultDTO getPercentageValuesFrom1RMValue(String rm) {

		//TODO: INPUT VALIDATION

		Map<BigDecimal, BigDecimal> results = percentageCalculationService.calculateStandardPercentagesFrom1RM(new BigDecimal(rm));

		return GetPercentageValuesFrom1RMValueResultDTO.buildFromPercentageValuesMap(results);
	}

	@Override
	public BigDecimal getValueFromPercentage(String rm, String percentage) {

		//TODO: INPUT VALIDATION

		return percentageCalculationService.calculateValueGiven1RMValueAndPercentage(new BigDecimal(rm), new BigDecimal(percentage));
	}

	@Override
	public BigDecimal getPercentageFromValue(String rm, String value) {

		//TODO: INPUT VALIDATION

		return percentageCalculationService.calculatePercentageGiven1RMValueAndValue(new BigDecimal(rm), new BigDecimal(value));
	}
}
