package percentage.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import percentage.calculation.CalculationConfiguration;
import percentage.controller.impl.HTMLControllerImpl;

@Configuration
@Import({CalculationConfiguration.class})
public class ControllerConfiguration {


}
