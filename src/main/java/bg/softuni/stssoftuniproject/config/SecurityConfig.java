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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests

                        .requestMatchers((PathRequest.toStaticResources().atCommonLocations())).permitAll()
                        .requestMatchers("/",
                                "/users/login",
                                "/users/register",
                                "/ticket-submit",
                                "/users/login-error",
                                "ticket/{id}",
                        "/error")
                                                 .permitAll()

                        .requestMatchers("/api/products-all",
                                "/promote-admin-role")
                                         .hasRole(RolesEnum.ADMIN.name())
                        .requestMatchers("/tickets/all",
                                "/products/all",
                                "/products/add",
                                "/ticket/answer/{id}",
                                "/users/all",
                                "/tickets-for-product",
                                "/api/tickets"
                                )
                                                    .hasRole(RolesEnum.ADMIN.name())
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->{
                    formLogin.loginPage("/users/login")
                            .failureUrl("/users/login?error")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .defaultSuccessUrl("/");
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

        return new UserDetailsServiceImpl(userRepository);
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


