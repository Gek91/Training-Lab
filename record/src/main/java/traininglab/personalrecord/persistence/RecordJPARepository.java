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
	public void add(RecordEntry record) {

		entityManager.persist(record);
		entityManager.flush();
	}

	@Override
	public List<RecordEntry> getRecordList(RecordListFilters filters) {

		String query = "FROM Record WHERE TRUE ";
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

		TypedQuery<RecordEntry> typedQuery = this.entityManager.createQuery(query , RecordEntry.class);
		parameters.entrySet().forEach(entry -> typedQuery.setParameter(entry.getKey(), entry.getValue()));

		return typedQuery.getResultList();
	}
}
