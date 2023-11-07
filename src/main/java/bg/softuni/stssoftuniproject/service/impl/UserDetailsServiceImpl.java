package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.entity.Employee;
import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public UserDetailsServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Employee employee = employeeRepository.findByEmail(username);

       UserDetails userDetails = modelMapper.map(employee, UserDetails.class);

       if (username == null){
           throw new UsernameNotFoundException("User " + username +"not found!");
       }
       return userDetails;


    }

    private static GrantedAuthority map(Role userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE" + userRoleEntity.getRole().name()
        );
    }
}
