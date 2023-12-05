package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.AddProductDTO;
import bg.softuni.stssoftuniproject.model.dto.AllProductsDTO;
import bg.softuni.stssoftuniproject.model.dto.ProductDTO;
import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.model.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Set<Product> findAllBySerialNumber(String serialNumber);

    boolean existsBySerialNumber(String value);

    void save(AddProductDTO addProductDTO);


    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> findById(Long id);
}
