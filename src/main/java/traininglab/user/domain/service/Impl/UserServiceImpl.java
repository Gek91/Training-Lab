package traininglab.user.domain.service.Impl;

import traininglab.user.domain.model.User;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.domain.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUserList() {
		return this.userRepository.getUserList();
	}

}
