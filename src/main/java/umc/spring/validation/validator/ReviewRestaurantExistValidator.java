package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.validation.annotation.ExistReviewRestaurant;

@Component
@RequiredArgsConstructor
public class ReviewRestaurantExistValidator implements ConstraintValidator<ExistReviewRestaurant, Long> {

    private final RestaurantCommandService restaurantCommandService;

    @Override
    public void initialize(ExistReviewRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        boolean isValid = restaurantCommandService.ReviewRestaurantExistValidate(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
