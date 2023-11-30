package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AddProductDTO;
import bg.softuni.stssoftuniproject.model.entity.Product;
import bg.softuni.stssoftuniproject.repository.ProductRepository;
import bg.softuni.stssoftuniproject.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsServiceIT {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testAddProduct(){
        AddProductDTO addProductDTO = createProduct();

        productService.save(addProductDTO);

        Product testSN = productRepository.findBySerialNumber("testSN");
        String productName = testSN.getProductName();

        Assertions.assertTrue(productRepository.count()>0);
        Assertions.assertEquals(productName,addProductDTO.getProductName());
        Assertions.assertTrue(productRepository.existsBySerialNumber("testSN"));


    }


    private AddProductDTO createProduct() {

        AddProductDTO addProductDTO = new AddProductDTO();

        addProductDTO.setCreated(LocalDateTime.now());
        addProductDTO.setProductName("testProductName");
        addProductDTO.setPartNumber("testPartNum");
        addProductDTO.setSerialNumber("testSN");

        return addProductDTO;

    }

}
