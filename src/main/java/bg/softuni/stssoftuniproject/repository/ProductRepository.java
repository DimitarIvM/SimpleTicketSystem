package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
