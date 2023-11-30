package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AddProductDTO;
import bg.softuni.stssoftuniproject.model.dto.AllProductsDTO;
import bg.softuni.stssoftuniproject.model.dto.ProductDTO;
import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.model.entity.Product;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.repository.ProductRepository;
import bg.softuni.stssoftuniproject.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Set<Product> findAllBySerialNumber(String serialNumber) {
        return productRepository.findAllBySerialNumber(serialNumber);
    }

    @Override
    public boolean existsBySerialNumber(String value) {
        return productRepository.existsBySerialNumber(value);
    }

    @Override
    public void save(AddProductDTO addProductDTO) {

        addProductDTO.setCreated(LocalDateTime.now());

        this.productRepository.save(modelMapper.map(addProductDTO,Product.class));

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product,ProductDTO.class))
                .toList();
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        Product product = productRepository.findById(id).get();


        return Optional.of(modelMapper.map(product,ProductDTO.class));
    }


}
