//package umc.spring.validation.annotation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import umc.spring.validation.validator.PageCheckValidator;
//
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(validatedBy = PageCheckValidator.class)
//@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface CheckPage {
//
//    int value() default 1;
//
//    String message() default "페이지가 너무 작습니다.";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}
