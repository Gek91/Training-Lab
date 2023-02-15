package traininglab.user.application;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import traininglab.user.domain.model.User;

public interface UserService extends UserDetailsService {

	User getCurrentUser();
}
