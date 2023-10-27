package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.CompanyRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Company;

import java.util.Optional;

public interface CompanyService {
    boolean existsUserByEmail(String companyName);

    void register(CompanyRegisterDTO companyRegisterDTO);

    Optional<Company> findByName(String companyName);
}
