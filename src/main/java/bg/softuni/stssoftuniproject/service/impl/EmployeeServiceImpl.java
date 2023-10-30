package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.EmployeeRegisterDTO;
import bg.softuni.stssoftuniproject.model.entity.Company;
import bg.softuni.stssoftuniproject.model.entity.Employee;
import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.enums.EmployeeRoleEnum;
import bg.softuni.stssoftuniproject.repository.EmployeeRepository;
import bg.softuni.stssoftuniproject.service.CompanyService;
import bg.softuni.stssoftuniproject.service.EmployeeService;
import bg.softuni.stssoftuniproject.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private CompanyService companyService;

    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, CompanyService companyService, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

    @Override
    public void register(EmployeeRegisterDTO employeeRegisterDTO) {

        Optional<Company> company = this.companyService.findByName(employeeRegisterDTO.getCompanyName());
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        if (company.isPresent()) {
            if (company.get().getEmployees().size() == 0) {
                role = this.roleService.findByRoleName(EmployeeRoleEnum.ADMIN);
                roles.add(role);
            }
            role = this.roleService.findByRoleName(EmployeeRoleEnum.USER);
            roles.add(role);

            Employee employee = modelMapper.map(employeeRegisterDTO, Employee.class);

            employee.setPassword(passwordEncoder.encode(employeeRegisterDTO.getPassword()));
            employee.setCompany(company.get());
            employee.setRoles(roles);

            employeeRepository.save(employee);

        }


    }

}
