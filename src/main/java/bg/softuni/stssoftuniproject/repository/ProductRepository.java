package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllBySerialNumber(String serialNumber);

    boolean existsBySerialNumber(String value);

    Product findBySerialNumber(String testSN);
}
