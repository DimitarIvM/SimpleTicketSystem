package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void rolesInit();

    Role findByRoleName(RolesEnum employeeRoleEnum);

    List<Role> findAll();
}
