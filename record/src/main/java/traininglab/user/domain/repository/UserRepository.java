package traininglab.user.domain.repository;

import traininglab.user.domain.model.User;

import java.util.List;

public interface UserRepository {

	User getUserById(String id);

	List<User> getUserList();
}
