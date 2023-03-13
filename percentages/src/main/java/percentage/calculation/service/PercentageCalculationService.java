package percentage.calculation.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PercentageCalculationService {

	BigDecimal calculatePercentageValueFrom1RMValue(BigDecimal oneRMValue, BigDecimal percentage);

	BigDecimal calculatePercentageOfValueFrom1RMValue(BigDecimal oneRMValue, BigDecimal inputValue);

	BigDecimal calculatePercentageValueFromPercentageValue(BigDecimal inputPercentage, BigDecimal inputValue, BigDecimal outputPercentage);

	Map<BigDecimal, BigDecimal> calculateStandardPercentagesFrom1RM(BigDecimal oneRMValue);

	Map<BigDecimal, BigDecimal> calculateGivenPercentagesFrom1RM(BigDecimal oneRMValue, List<BigDecimal> percentages);

}
