package bg.softuni.stssoftuniproject.validation.anotations;

import bg.softuni.stssoftuniproject.validation.AssigneeExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AssigneeExistsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AssigneeExists {
    String message() default "User doesn't exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
