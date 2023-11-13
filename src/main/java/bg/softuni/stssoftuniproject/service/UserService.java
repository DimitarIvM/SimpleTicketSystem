package bg.softuni.stssoftuniproject.service;


import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;
import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

public interface UserService {
    boolean existsUserByEmail(String email);

    void register(UserRegisterDTO userRegisterDTO);

    UserEntity findByEmail(String name);
    UserEntity getLoggedUser();

    AllUsersDTO getAllUsers();
}
