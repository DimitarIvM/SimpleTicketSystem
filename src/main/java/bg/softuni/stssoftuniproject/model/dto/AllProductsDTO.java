package bg.softuni.stssoftuniproject.model.dto;

import java.util.Set;

public class AllProductsDTO {

    Set<ProductDTO> products;

    public Set<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDTO> products) {
        this.products = products;
    }
}
