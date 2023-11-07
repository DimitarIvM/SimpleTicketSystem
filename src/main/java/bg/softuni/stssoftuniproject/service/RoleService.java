package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;

public interface RoleService {
    void rolesInit();

    Role findByRoleName(RolesEnum employeeRoleEnum);
}
