package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;
import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


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
    public UserEntity getLoggedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Optional<UserEntity> byEmail = this.userRepository.findByEmail(name);
        return byEmail.orElseThrow();
    }

    @Override
    public AllUsersDTO getAllUsers() {

        AllUsersDTO allUsersDTO = new AllUsersDTO();

        List<UserDTO> usersDTO = new ArrayList<>();

        List<UserEntity> all = this.userRepository.findAll();

        for (UserEntity userEntity : all) {

            usersDTO.add(modelMapper.map(userEntity, UserDTO.class));
        }

        allUsersDTO.setUsers(usersDTO);


        return allUsersDTO;


    }


    @Override
    public Optional<UserDTO> findById(Long id) {

        UserEntity user = userRepository.findById(id).get();


        return Optional.of(modelMapper.map(user,UserDTO.class));
    }

    @Override
    public void makeAdmin(UserEntity user) {

        Role role = this.roleService.findByRoleName(RolesEnum.ADMIN);

        user.getRoles().add(role);

        userRepository.save(user);

    }



    @Override
    public Optional<UserEntity> getById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<UserEntity> findByUsername(String testUser) {
        return this.userRepository.findByEmail(testUser);
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

    @Override
    public UserEntity findByEmail(String name) {
        return this.userRepository.findByEmail(name).get();
    }


}

