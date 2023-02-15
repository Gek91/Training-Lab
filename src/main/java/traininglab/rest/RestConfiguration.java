package traininglab.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import traininglab.core.service.MapperService;
import traininglab.personalrecord.PersonalRecordConfiguration;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.rest.impl.RecordRestApiImpl;


@Configuration
@Import(PersonalRecordConfiguration.class)
public class RestConfiguration {

	@Bean
	public RecordRestApiImpl recordRestApiImp(PersonalRecordApplicationService personalRecordApplicationService, MapperService mapperService) {
		return new RecordRestApiImpl(personalRecordApplicationService, mapperService);
	}

}
