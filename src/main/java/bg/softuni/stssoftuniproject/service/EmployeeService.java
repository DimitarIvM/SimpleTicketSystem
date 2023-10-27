package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.EmployeeRegisterDTO;

public interface EmployeeService {
    boolean existsUserByEmail(String email);

    void register(EmployeeRegisterDTO employeeRegisterDTO);
}
