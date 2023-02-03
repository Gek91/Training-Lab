package traininglab.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import traininglab.core.CoreConfiguration;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.domain.service.Impl.UserServiceImpl;
import traininglab.user.domain.service.UserService;
import traininglab.user.persistence.UserJPARepository;

@Configuration
@Import(CoreConfiguration.class)
public class UserConfiguration {

	@Bean
	public UserService userService() {
		return new UserServiceImpl(userRepository());
	}

	@Bean
	public UserRepository userRepository() {
		return new UserJPARepository();
	}
}
