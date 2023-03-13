package percentage.calculation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import percentage.calculation.service.PercentageCalculationService;
import percentage.calculation.service.impl.PercentageCalculationServiceImpl;
import percentage.core.CoreConfiguration;

@Configuration
@Import(CoreConfiguration.class)
public class CalculationConfiguration {

	@Bean
	public PercentageCalculationService percentageCalculationService() {
		return new PercentageCalculationServiceImpl();
	}

}
