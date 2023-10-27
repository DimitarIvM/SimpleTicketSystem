package bg.softuni.stssoftuniproject.validation.anotations;

import bg.softuni.stssoftuniproject.validation.UniqueCompanyNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueCompanyNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCompanyName{
    String message() default "Company already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
