package percentage.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import percentage.calculation.CalculationConfiguration;

@Configuration
@Import({CalculationConfiguration.class})
public class ControllerConfiguration {

//	@Bean
//	public HTMLController htmlController() {
//		return new HTMLController();
//	}
}
