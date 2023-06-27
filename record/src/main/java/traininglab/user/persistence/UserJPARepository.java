package traininglab.user.persistence;

import traininglab.user.domain.model.User;
import traininglab.user.domain.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserJPARepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User getUserById(String id) {
		return this.entityManager.createQuery("FROM traininglab.user.domain.model.User WHERE id = :id", User.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<User> getUserList() {
		return this.entityManager.createQuery("FROM traininglab.user.domain.model.User", User.class).getResultList();
	}
}
