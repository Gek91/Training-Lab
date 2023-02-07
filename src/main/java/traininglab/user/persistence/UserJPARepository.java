package traininglab.user.persistence;

import traininglab.personalrecord.domain.model.Exercise;
import traininglab.user.domain.model.User;
import traininglab.user.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserJPARepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<User> getUserList() {
		return this.entityManager.createQuery("FROM traininglab.user.domain.model.User", User.class).getResultList();
	}
}
