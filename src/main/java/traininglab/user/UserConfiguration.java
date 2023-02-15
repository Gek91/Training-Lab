package traininglab.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import traininglab.core.CoreConfiguration;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.application.UserService;
import traininglab.user.application.impl.UserServiceImpl;
import traininglab.user.persistence.UserJPARepository;

@Configuration
@Import(CoreConfiguration.class)
public class UserConfiguration {

	@Bean
	public UserService userService() {
		return new UserServiceImpl(userRepository());
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return userService();
	}

	@Bean
	public UserRepository userRepository() {
		return new UserJPARepository();
	}
}
