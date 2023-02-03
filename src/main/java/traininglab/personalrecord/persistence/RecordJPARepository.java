package traininglab.personalrecord.persistence;

import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.repository.RecordRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RecordJPARepository implements RecordRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Record record) {

		entityManager.persist(record);
		entityManager.flush();
	}
}
