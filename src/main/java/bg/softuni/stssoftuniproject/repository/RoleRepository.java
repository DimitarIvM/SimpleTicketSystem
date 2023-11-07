package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(RolesEnum employeeRoleEnum);
}
