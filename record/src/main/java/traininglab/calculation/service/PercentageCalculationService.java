package traininglab.calculation.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PercentageCalculationService {

	BigDecimal calculateValueGiven1RMValueAndPercentage(BigDecimal oneRMValue, BigDecimal percentage);

	BigDecimal calculatePercentageGiven1RMValueAndValue(BigDecimal oneRMValue, BigDecimal inputValue);

	//proportion inputPercentage : outputPercentage = InputValue : return
	BigDecimal calculateValueGivenInputPercentageAndValueAndOutputPercentage(BigDecimal inputPercentage, BigDecimal inputValue, BigDecimal outputPercentage);

	Map<BigDecimal, BigDecimal> calculateStandardPercentagesFrom1RM(BigDecimal oneRMValue);

	Map<BigDecimal, BigDecimal> calculateGivenPercentagesFrom1RM(BigDecimal oneRMValue, List<BigDecimal> percentages);

}
