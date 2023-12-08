package bg.softuni.stssoftuniproject.validation;

import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.service.UserService;
import bg.softuni.stssoftuniproject.validation.anotations.AssigneeExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AssigneeExistsValidator implements ConstraintValidator<AssigneeExists,String> {
    private final UserService userService;



    public AssigneeExistsValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userService.existsUserByEmail(value);
    }
}
