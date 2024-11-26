package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.validation.annotation.ChallengingMission;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ChallengingMission, Map<String, Long>> {

    private final RestaurantCommandService restaurantCommandService;

    @Override
    public void initialize(ChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Map<String, Long> value, ConstraintValidatorContext context) {

        boolean isValid = restaurantCommandService.MissionChallengeValidate(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
