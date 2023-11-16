package bg.softuni.stssoftuniproject.service;


import bg.softuni.stssoftuniproject.model.dto.UserDTO;
import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    boolean existsUserByEmail(String email);

    void register(UserRegisterDTO userRegisterDTO);

    UserEntity findByEmail(String name);
    UserEntity getLoggedUser();

    List<UserDTO> getAllUsers();

//    UserDTO makeAdmin(Long id);

    Optional<UserDTO> findById(Long id);
}
