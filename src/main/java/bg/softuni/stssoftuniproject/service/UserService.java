package bg.softuni.stssoftuniproject.service;


import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;
import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    boolean existsUserByEmail(String email);

    void register(UserRegisterDTO userRegisterDTO);

    UserEntity findByEmail(String name);
    UserEntity getLoggedUser();

    AllUsersDTO getAllUsers();

//    UserDTO makeAdmin(Long id);

    Optional<UserDTO> findById(Long id);

    void makeAdmin(UserEntity user);

    Optional<UserEntity> getById(Long userId);
}
