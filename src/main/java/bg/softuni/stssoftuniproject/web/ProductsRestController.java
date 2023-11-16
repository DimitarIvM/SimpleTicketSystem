package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.ProductDTO;
import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products-all")
public class ProductsRestController {
    private final ProductService productService;

    public ProductsRestController( ProductService productService) {

        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllUsers(){

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id){

        Optional<ProductDTO> userDTO =   productService.findById(id);


        return userDTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
