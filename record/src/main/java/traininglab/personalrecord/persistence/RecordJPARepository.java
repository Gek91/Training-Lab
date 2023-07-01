package traininglab.personalrecord.persistence;

import traininglab.personalrecord.domain.model.RecordEntry;
import traininglab.personalrecord.domain.repository.RecordEntryRepository;
import traininglab.personalrecord.domain.repository.data.RecordListFilters;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordJPARepository implements RecordEntryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void add(RecordEntry entry) {

		entityManager.persist(entry);
		entityManager.flush();
	}

	@Override
	public RecordEntry getRecordById(Long id) {

		return entityManager.find(RecordEntry.class, id);
	}

	@Override
	public List<RecordEntry> getRecordList(RecordListFilters filters) {

		String query = "FROM RecordEntry WHERE 1=1 ";
		Map<String, Object> parameters = new HashMap<>();

		if(filters != null) {

			if(filters.getUserId() != null) {
				query += "AND user.id = :userId ";
				parameters.put("userId", filters.getUserId());
			}

			if(filters.getExerciseId() != null) {
				query += "AND exercise.id = :exerciseId ";
				parameters.put("exerciseId", filters.getExerciseId());
			}
		}

		query += "order By recordDate";

		TypedQuery<RecordEntry> typedQuery = this.entityManager.createQuery(query , RecordEntry.class);
		parameters.forEach((key, value) -> typedQuery.setParameter(key, value));

		return typedQuery.getResultList();
	}
}
