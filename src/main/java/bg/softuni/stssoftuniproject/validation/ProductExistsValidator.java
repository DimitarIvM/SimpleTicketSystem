package bg.softuni.stssoftuniproject.validation;

import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.validation.anotations.ProductExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductExistsValidator implements ConstraintValidator<ProductExists,String> {

    private final ProductService productService;

    public ProductExistsValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productService.existsBySerialNumber(value);
    }
}
