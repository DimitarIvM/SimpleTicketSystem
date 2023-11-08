package bg.softuni.stssoftuniproject.config;

import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.UserRepository;
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
                        .requestMatchers("/","/users/login","/users/register","/ticket-submit","/login-error").permitAll()
                        .requestMatchers("/tickets/**").hasRole(RolesEnum.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->{
                    formLogin.loginPage("/users/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/ticket-submit")
                            .failureForwardUrl("/login-error");
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
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        // This service translates the mobilele users and roles
        // to representation which spring security understands.
        return new UserDetailsServiceImpl(userRepository);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


