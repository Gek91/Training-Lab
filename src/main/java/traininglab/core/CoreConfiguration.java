package traininglab.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import traininglab.core.service.Impl.MapperServiceImpl;
import traininglab.core.service.MapperService;

@Configuration
public class CoreConfiguration {

	@Bean
	public MapperService mapperService() {
		return new MapperServiceImpl();
	}
}
