package bg.softuni.stssoftuniproject.service;


import bg.softuni.stssoftuniproject.model.dto.UserRegisterDTO;

public interface UserService {
    boolean existsUserByEmail(String email);

    void register(UserRegisterDTO userRegisterDTO);
}
