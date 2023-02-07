package traininglab.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import traininglab.core.CoreConfiguration;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.persistence.UserJPARepository;

@Configuration
@Import(CoreConfiguration.class)
public class UserConfiguration {

	@Bean
	public UserRepository userRepository() {
		return new UserJPARepository();
	}
}
