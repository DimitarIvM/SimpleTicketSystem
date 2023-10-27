package bg.softuni.stssoftuniproject.validation;


import bg.softuni.stssoftuniproject.service.EmployeeService;
import bg.softuni.stssoftuniproject.validation.anotations.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  private final EmployeeService employeeService;

    public UniqueEmailValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
       return !this.employeeService.existsUserByEmail(email);
    }
}