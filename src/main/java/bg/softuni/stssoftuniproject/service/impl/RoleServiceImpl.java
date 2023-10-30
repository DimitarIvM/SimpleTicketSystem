package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.enums.EmployeeRoleEnum;
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

            user.setRole(EmployeeRoleEnum.USER);
            admin.setRole(EmployeeRoleEnum.ADMIN);

            roleRepository.save(user);
            roleRepository.save(admin);

        }




    }
}
