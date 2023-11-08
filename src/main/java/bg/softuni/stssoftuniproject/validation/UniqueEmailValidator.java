package bg.softuni.stssoftuniproject.validation;


import bg.softuni.stssoftuniproject.service.UserService;
import bg.softuni.stssoftuniproject.validation.anotations.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  private final UserService userService;

    public UniqueEmailValidator(UserService employeeService) {
        this.userService = employeeService;
    }


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
       return !this.userService.existsUserByEmail(email);
    }
}