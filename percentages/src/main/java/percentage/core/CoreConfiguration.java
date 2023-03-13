package percentage.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import percentage.core.service.Impl.MapperServiceImpl;
import percentage.core.service.MapperService;

@Configuration
public class CoreConfiguration {

	@Bean
	public MapperService mapperService() {
		return new MapperServiceImpl();
	}

}
