package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.EmployeeRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Company;
import bg.softuni.stssoftuniproject.model.entity.Employee;
import bg.softuni.stssoftuniproject.repository.EmployeeRepository;
import bg.softuni.stssoftuniproject.service.CompanyService;
import bg.softuni.stssoftuniproject.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private CompanyService companyService;

    private PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, CompanyService companyService, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public void register(EmployeeRegisterDTO employeeRegisterDTO) {

        Optional<Company> company = this.companyService.findByName(employeeRegisterDTO.getCompanyName());

        if (company.isPresent()){
            Employee employee = modelMapper.map(employeeRegisterDTO, Employee.class);

            employee.setPassword(passwordEncoder.encode(employeeRegisterDTO.getPassword()));
            employee.setCompany(company.get());

            employeeRepository.save(employee);

        }



    }

}
