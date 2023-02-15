package traininglab.personalrecord;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import traininglab.core.service.MapperService;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.personalrecord.application.impl.PersonalRecordApplicationServiceImpl;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.repository.RecordEntryRepository;
import traininglab.personalrecord.domain.service.RecordService;
import traininglab.personalrecord.domain.service.impl.RecordServiceImpl;
import traininglab.personalrecord.persistence.ExerciseJPARepository;
import traininglab.personalrecord.persistence.RecordJPARepository;
import traininglab.user.UserConfiguration;
import traininglab.user.application.UserService;

@Configuration
@Import(UserConfiguration.class)
public class PersonalRecordConfiguration {

	@Bean
	public PersonalRecordApplicationService personalRecordApplicationService(MapperService mapperService, UserService userService) {
		return new PersonalRecordApplicationServiceImpl(exerciseRepository(), recordRepository(), recordService(), mapperService, userService);
	}
	@Bean
	public RecordService recordService() {
		return new RecordServiceImpl();
	}

	@Bean
	public ExerciseRepository exerciseRepository() {
		return new ExerciseJPARepository();
	}

	@Bean
	public RecordEntryRepository recordRepository() {
	return new RecordJPARepository();
	}
}
