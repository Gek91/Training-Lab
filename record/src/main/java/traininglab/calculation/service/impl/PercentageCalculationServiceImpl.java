package traininglab.calculation.service.impl;

import traininglab.calculation.service.PercentageCalculationService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PercentageCalculationServiceImpl implements PercentageCalculationService {
	@Override
	public BigDecimal calculateValueGiven1RMValueAndPercentage(BigDecimal oneRMValue, BigDecimal percentage) {

		validateWeightValue(oneRMValue, "oneRMValue");
		validatePercentageValue(percentage, "percentage");

		return oneRMValue.multiply(percentage).setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal calculatePercentageGiven1RMValueAndValue(BigDecimal oneRMValue, BigDecimal inputValue) {

		validateWeightValue(oneRMValue, "oneRMValue");
		validateWeightValue(inputValue, "inputValue");

		return inputValue.divide(oneRMValue,2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal calculate1RMValueGivenValueAndPercentage(BigDecimal inputValue, BigDecimal percentage) {

		validateWeightValue(inputValue, "inputValue");
		validatePercentageValue(percentage, "percentage");

		return inputValue.divide(percentage, 2, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal calculateValueGivenInputPercentageAndValueAndOutputPercentage(BigDecimal inputPercentage, BigDecimal inputValue, BigDecimal outputPercentage) {

		validateWeightValue(inputValue, "inputValue");
		validatePercentageValue(inputPercentage, "inputPercentage");
		validatePercentageValue(outputPercentage, "outputPercentage");

		return inputValue.multiply(outputPercentage).divide(inputPercentage,2 ,RoundingMode.HALF_UP);
	}

	private List<BigDecimal> STANDARD_PERCENTAGE_LIST = Arrays.asList(
			new BigDecimal("0.40"),
			new BigDecimal("0.45"),
			new BigDecimal("0.50"),
			new BigDecimal("0.55"),
			new BigDecimal("0.60"),
			new BigDecimal("0.65"),
			new BigDecimal("0.70"),
			new BigDecimal("0.75"),
			new BigDecimal("0.80"),
			new BigDecimal("0.85"),
			new BigDecimal("0.90"),
			new BigDecimal("0.95")
			);

	@Override
	public Map<BigDecimal, BigDecimal> calculateStandardPercentagesFrom1RM(BigDecimal oneRMValue) {

		return calculateGivenPercentagesFrom1RM(oneRMValue, STANDARD_PERCENTAGE_LIST);
	}

	@Override
	public Map<BigDecimal, BigDecimal> calculateGivenPercentagesFrom1RM(BigDecimal oneRMValue, List<BigDecimal> percentages) {

		//linked to keep insert order
		Map<BigDecimal, BigDecimal> result = new LinkedHashMap<>();

		validateWeightValue(oneRMValue, "oneRMValue");
		validatePercentagesValue(percentages);

		percentages.sort(BigDecimal::compareTo);

		for(BigDecimal percentage : percentages) {
			result.put(percentage, oneRMValue.multiply(percentage).setScale(2, RoundingMode.HALF_UP));
		}

		return result;
	}


	private void validateWeightValue(BigDecimal value, String fieldName) {
		if(value == null) {
			throw new IllegalArgumentException(fieldName+ " is null");
		}

		if(value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException(fieldName + " is less or equal zero");
		}
	}
	private void validatePercentagesValue(List<BigDecimal> percentages) {

		if(percentages.stream().anyMatch(x -> x == null)) {
			throw new IllegalArgumentException("one of percentages is null");
		}

		if(percentages.stream().anyMatch(x -> x.compareTo(BigDecimal.ZERO) <= 0)) {
			throw new IllegalArgumentException("one of percentages is less or equal zero");
		}

		if(percentages.stream().anyMatch(x -> x.scale() > 4)) {
			throw new IllegalArgumentException("percentages scale must be less than 5");
		}
	}

	private void validatePercentageValue(BigDecimal percentage, String fieldName) {

		if(percentage == null) {
			throw new IllegalArgumentException(fieldName + " is null");
		}

		if(percentage.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException(fieldName + " is less or equal zero");
		}

		if(percentage.scale() > 4) {
			throw new IllegalArgumentException(fieldName + " scale must be less than 5");
		}
	}

}
