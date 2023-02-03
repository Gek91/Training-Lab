package traininglab.personalrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.RecordRestApi;
import traininglab.personalrecord.application.impl.RecordRestApiImpl;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.repository.RecordRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.impl.RecordServiceImpl;
import traininglab.personalrecord.domain.service.validator.RecordValidator;
import traininglab.personalrecord.persistence.ExerciseJPARepository;
import traininglab.personalrecord.persistence.RecordJPARepository;
import traininglab.user.UserConfiguration;
import traininglab.user.domain.service.UserService;

import javax.persistence.EntityManager;

@Configuration
@Import(UserConfiguration.class)
public class PersonalRecordConfiguration {

	@Bean
	public RecordValidator recordValidator(UserService userService) {
		return new RecordValidator(exerciseRepository(), userService);
	}

	@Bean
	public RecordRestApiImpl recordRestApiImp(UserService userService, MapperService mapperService) {
		return new RecordRestApiImpl(recordService(userService), mapperService);
	}

	@Bean
	public RecordService recordService(UserService userService) {
		return new RecordServiceImpl(exerciseRepository(), recordRepository(), userService, recordValidator(userService));
	}

	@Bean
	public ExerciseRepository exerciseRepository() {
		return new ExerciseJPARepository();
	}

	@Bean
	public RecordRepository recordRepository() {
	return new RecordJPARepository();
	}
}
