package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AllUsersDTO;

import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceIT {



    private UserServiceImpl userService;
    @MockBean
    private UserRepository testUserRepo;
    @Mock
    private ModelMapper modelMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private RoleService roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        UserRepository userRepository;
        userService = new UserServiceImpl(testUserRepo, modelMapper, passwordEncoder, roleService);
    }
  @Test
    void testPromoteToAdmin(){
      UserEntity userEntity = createTestUser();

testUserRepo.save(userEntity);



        userService.makeAdmin(userEntity);

        assertEquals(2,userEntity.getRoles().size());

  }

    @Test
    public void testExistsUserByEmail() {

        String email = "test@example.com";
        when(testUserRepo.existsByEmail(email)).thenReturn(true);


        boolean exists = userService.existsUserByEmail(email);


        assertTrue(exists);
    }

    @Test
    public void testGetLoggedUser() {

        UserEntity mockUser = new UserEntity();
        mockUser.setEmail("test@example.com");
        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn("test@example.com");
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(testUserRepo.findByEmail("test@example.com")).thenReturn(Optional.of(mockUser));


        UserEntity loggedUser = userService.getLoggedUser();


        assertNotNull(loggedUser);
        assertEquals("test@example.com", loggedUser.getEmail());
    }

    @Test
    public void testGetAllUsers() {

        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        UserEntity user2 = new UserEntity();
        user2.setId(2L);
        List<UserEntity> userList = Arrays.asList(user1, user2);
        when(testUserRepo.findAll()).thenReturn(userList);

        AllUsersDTO allUsersDTO = userService.getAllUsers();


        assertNotNull(allUsersDTO);
        assertEquals(2, allUsersDTO.getUsers().size());
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


