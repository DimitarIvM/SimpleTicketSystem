package bg.softuni.stssoftuniproject.validation.anotations;

import bg.softuni.stssoftuniproject.validation.UniqueEmailValidator;
import bg.softuni.stssoftuniproject.validation.UniqueProductSerialNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueProductSerialNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueProductSerialNumber {
    String message() default "Product already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
