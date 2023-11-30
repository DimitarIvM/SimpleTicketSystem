package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceIT {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository testUserRepo;

  @Test
    void testPromoteToAdmin(){
      UserEntity userEntity = createTestUser();

testUserRepo.save(userEntity);



        userService.makeAdmin(userEntity);

        Assertions.assertEquals(2,userEntity.getRoles().size());

  }


    private static UserEntity createTestUser() {
 UserEntity user = new UserEntity();
        Role role = new Role();
        role.setRole(RolesEnum.USER);

        Set<Role> roles = new HashSet<>();
        roles.add(role);
 user.setEmail("test@mail.com");
 user.setFirstName("testFirstName");
 user.setLastName("testLastName");
 user.setPassword("testpass");
 user.setRoles(roles);



 return user;
    }


}
