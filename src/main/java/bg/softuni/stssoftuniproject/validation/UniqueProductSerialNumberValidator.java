package bg.softuni.stssoftuniproject.validation;


import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.validation.anotations.UniqueProductSerialNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueProductSerialNumberValidator implements ConstraintValidator<UniqueProductSerialNumber, String> {

    private final ProductService productService;

    public UniqueProductSerialNumberValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         return !this.productService.existsBySerialNumber(value);
    }
}
