package bg.softuni.stssoftuniproject.config;

import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.EmployeeRepository;
import bg.softuni.stssoftuniproject.service.impl.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests
                        .requestMatchers((PathRequest.toStaticResources().atCommonLocations())).permitAll()
                        .requestMatchers("/","/login","/company/register","/employees/register").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->{
                    formLogin.loginPage("/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/")
                            .failureForwardUrl("/");
                }
        ).logout(
                logout ->{
                    logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true);
                }
        ).build();
    }

    @Bean
    public UserDetailsService userDetailsService(EmployeeRepository employeeRepository) {
        return new UserDetailsServiceImpl(employeeRepository);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


