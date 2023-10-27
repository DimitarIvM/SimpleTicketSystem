package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.CompanyRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Company;
import bg.softuni.stssoftuniproject.repository.CompanyRepository;
import bg.softuni.stssoftuniproject.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public boolean existsUserByEmail(String companyName) {
        return this.companyRepository.existsByCompanyName(companyName);
    }

    @Override
    public void register(CompanyRegisterDTO companyRegisterDTO) {
        this.companyRepository.save(modelMapper.map(companyRegisterDTO, Company.class));
    }

    @Override
    public Optional<Company> findByName(String companyName) {
        return this.companyRepository.findByCompanyName(companyName);
    }
}
