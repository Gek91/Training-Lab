package traininglab.personalrecord.domain.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.model.Record;
import traininglab.personalrecord.domain.repository.ExerciseRepository;
import traininglab.personalrecord.domain.service.data.CreateRecordData;
import traininglab.user.domain.model.User;
import traininglab.user.domain.repository.UserRepository;
import traininglab.user.domain.service.UserService;

import java.math.BigDecimal;

public class RecordValidator implements Validator {

	private ExerciseRepository exerciseRepository;
	private UserService userService;

	public RecordValidator(ExerciseRepository exerciseRepository, UserService userService) {
		this.exerciseRepository = exerciseRepository;
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return CreateRecordData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CreateRecordData data = (CreateRecordData) target;

//		if(data.getExerciseId() == null) {
//			errors.rejectValue("exerciseId", "required");
//		} else {
//			if(!exerciseRepository.getExerciseList().stream().map(Exercise::getId).anyMatch(id -> id.equals(data.getExerciseId()))) {
//				errors.rejectValue("exerciseId", "invalid value");
//			}
//		}
//
//		if(data.getUserId() == null) {
//			errors.rejectValue("userId", "required");
//		} else {
//			if(!userService.getUserList().stream().map(User::getId).anyMatch(id -> id.equals(data.getExerciseId()))) {
//				errors.rejectValue("userId", "invalid value");
//			}
//		}
//
//		if(data.getRecordDate() == null) {
//			errors.rejectValue("recordDate", "required");
//		}
//
//		if(data.getValue() == null) {
//			errors.rejectValue("value", "required");
//		} else {
//			if(data.getValue().compareTo(BigDecimal.ZERO) < 0) {
//				errors.rejectValue("value", "invalid value");
//			}
//		}

	}

}
