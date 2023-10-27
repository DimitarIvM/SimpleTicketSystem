package bg.softuni.stssoftuniproject.validation;

import bg.softuni.stssoftuniproject.service.CompanyService;
import bg.softuni.stssoftuniproject.validation.anotations.UniqueCompanyName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueCompanyNameValidator implements ConstraintValidator<UniqueCompanyName,String> {

private final CompanyService companyService;

    public UniqueCompanyNameValidator(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public boolean isValid(String companyName, ConstraintValidatorContext context) {
        return !this.companyService.existsUserByEmail(companyName);
    }
}
