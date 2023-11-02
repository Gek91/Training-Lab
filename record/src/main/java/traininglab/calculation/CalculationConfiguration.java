package traininglab.calculation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import traininglab.calculation.service.PercentageCalculationService;
import traininglab.calculation.service.impl.PercentageCalculationServiceImpl;
import traininglab.core.CoreConfiguration;

@Configuration
@Import(CoreConfiguration.class)
public class CalculationConfiguration {

	@Bean
	public PercentageCalculationService percentageCalculationService() {
		return new PercentageCalculationServiceImpl();
	}

}
