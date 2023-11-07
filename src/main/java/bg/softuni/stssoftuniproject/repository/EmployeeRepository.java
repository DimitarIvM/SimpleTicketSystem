package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    boolean existsByEmail(String email);


    Employee findByEmail(String email);
}
