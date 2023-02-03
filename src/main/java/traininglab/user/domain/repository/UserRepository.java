package traininglab.user.domain.repository;

import traininglab.user.domain.model.User;

import java.util.List;

public interface UserRepository {

	List<User> getUserList();
}
