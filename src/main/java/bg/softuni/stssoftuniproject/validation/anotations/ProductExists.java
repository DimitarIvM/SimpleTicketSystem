package bg.softuni.stssoftuniproject.validation.anotations;

import bg.softuni.stssoftuniproject.validation.ProductExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductExistsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductExists {
    String message() default "Product already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
