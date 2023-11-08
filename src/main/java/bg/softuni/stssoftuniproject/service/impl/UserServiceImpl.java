package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository,
                           ModelMapper modelMapper,

                           PasswordEncoder passwordEncoder,
                           RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void register(UserRegisterDTO userRegisterDTO) {


        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        if (this.userRepository.count() == 0) {
            role = this.roleService.findByRoleName(RolesEnum.ADMIN);
            roles.add(role);

        }

        role = this.roleService.findByRoleName(RolesEnum.USER);
        roles.add(role);


        UserEntity user = modelMapper.map(userRegisterDTO, UserEntity.class);

        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        user.setRoles(roles);

        userRepository.save(user);

    }


}
