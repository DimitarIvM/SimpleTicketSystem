package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByEmail(String email);



    Optional<UserEntity> findByEmail(String email);
}
