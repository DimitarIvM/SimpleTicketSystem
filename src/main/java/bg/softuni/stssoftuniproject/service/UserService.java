package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.EmployeeRegisterDTO;

public interface UserService {
    boolean existsUserByEmail(String email);

    void register(EmployeeRegisterDTO employeeRegisterDTO);
}
