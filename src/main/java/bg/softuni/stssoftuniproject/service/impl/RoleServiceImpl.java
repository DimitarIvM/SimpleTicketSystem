package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.entity.Role;

import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.RoleRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
@Override
    public void rolesInit(){

        if (roleRepository.count()==0){
            Role user = new Role();
            Role admin = new Role();

            user.setRole(RolesEnum.USER);
            admin.setRole(RolesEnum.ADMIN);

            roleRepository.save(user);
            roleRepository.save(admin);

        }




    }

    @Override
    public Role findByRoleName(RolesEnum employeeRoleEnum) {
        return this.roleRepository.findByRole(employeeRoleEnum);
    }
}
